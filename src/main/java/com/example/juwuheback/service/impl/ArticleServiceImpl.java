package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.PageResultDTO;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.common.exception.ExceptionEnum;
import com.example.juwuheback.domain.dto.ArticleDTO;
import com.example.juwuheback.domain.dto.ArticleQueryDTO;
import com.example.juwuheback.domain.entity.Article;
import com.example.juwuheback.domain.vo.ArticleVO;
import com.example.juwuheback.mapper.ArticleMapper;
import com.example.juwuheback.mapper.ClassifyMapper;
import com.example.juwuheback.mapper.LabelMapper;
import com.example.juwuheback.service.IArticleService;
import com.example.juwuheback.utils.MarkdownUtils;
import com.example.juwuheback.utils.MdToHtmlUtils;
import com.example.juwuheback.utils.SmartBeanUtil;
import com.example.juwuheback.utils.SmartPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.java2d.pipe.BufferedRenderPipe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ClassifyMapper classifyMapper;

    @Autowired
    private LabelMapper labelMapper;

    /**
     * 查询博客信息-包括其标签
     *
     * @param articleQueryDTO
     * @return
     */
    @Override
    public ResponseDTO<PageResultDTO<ArticleVO>> queryAll(ArticleQueryDTO articleQueryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(articleQueryDTO);
        Page<ArticleVO> result = articleMapper.selectAllArticle(page, articleQueryDTO);
        PageResultDTO resultDTO = SmartPageUtil.convert2PageResult(result);
        return ResponseDTO.success(resultDTO);
    }

    /**
     * 获取文章详情-转HTML
     *
     * @param articleQueryDTO
     * @return
     */
    @Override
    public ResponseDTO queryDetail(ArticleQueryDTO articleQueryDTO) {

        Article article = articleMapper.selectById(articleQueryDTO.getArticleId());
        ArticleVO articleVO = SmartBeanUtil.copy(article, ArticleVO.class);

        //将MarkDown语法转化为HTMl
//        articleVO.setArticleContent(MdToHtmlUtils.convert(article.getArticleContent()));
        articleVO.setArticleContent(MarkdownUtils.markdownToHtmlExtensions(articleVO.getArticleContent()));

        return ResponseDTO.success(articleVO);
    }

    /**
     * 查询文章详情
     *
     * @param articleQueryDTO
     * @return
     */
    @Override
    public ResponseDTO queryArticleDetail(ArticleQueryDTO articleQueryDTO) {
        return ResponseDTO.success(articleMapper.selectById(articleQueryDTO.getArticleId()));
    }

    /**
     * 根据标签Id插叙，博文信息
     *
     * @param articleQueryDTO
     * @return
     */
    @Override
    public ResponseDTO queryAllByLabel(ArticleQueryDTO articleQueryDTO) {
        return ResponseDTO.success(articleMapper.selectAllByLabel(articleQueryDTO));
    }

    /**
     * 保存博客文章
     *
     * @param articleDTO
     * @return
     */

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDTO saveArticle(ArticleDTO articleDTO) {

        //数据转化
        Article article = SmartBeanUtil.copy(articleDTO, Article.class);

        //基本信息
        article.setArticleCreateDate(new Date());
        article.setArticleViews(0);
        article.setIsPublish(0);
        article.setArticleCommentCount(0);

        //保存文章信息
        articleMapper.insert(article);

        //保存分类和标签
        if (ObjectUtils.isEmpty(article.getArticleId()) || labelMapper.insertArticleLabel(article.getArticleId(), articleDTO.getLabelList()) < 1 || classifyMapper.insertArticleClassify(article.getArticleId(), articleDTO.getClassifyId()) < 1) {
            return ResponseDTO.fail(ExceptionEnum.DATABASE_OPERATION_ERROR);
        }

        return ResponseDTO.success();
    }

    /**
     * 删除文章-根据文章ID
     *
     * @param articleDTO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDTO removeArticle(ArticleDTO articleDTO) {
        //删除文章
        articleMapper.deleteById(articleDTO.getArticleId());
        //删除标签
        labelMapper.deleteArticleLabelByArticleId(articleDTO.getArticleId());
        //删除分类
        classifyMapper.deleteArticleClassifyByArticleId(articleDTO.getArticleId());
        return ResponseDTO.success();
    }

    /**
     * 编辑文章信息
     *
     * @param articleDTO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseDTO editArticle(ArticleDTO articleDTO) {

        //更新文章信息
        Article article = SmartBeanUtil.copy(articleDTO, Article.class);
        articleMapper.updateById(article);

        //删除所有标签、更新标签信息
        labelMapper.deleteArticleLabelByArticleId(articleDTO.getArticleId());

        //更新分类信息
        if (articleMapper.updateById(article) < 1 || labelMapper.insertArticleLabel(articleDTO.getArticleId(), articleDTO.getLabelList()) < 1) {
            return ResponseDTO.fail(ExceptionEnum.DATABASE_OPERATION_ERROR);
        }
        return ResponseDTO.success();
    }

    /**
     * 文章上传
     *
     * @param articleDTO
     * @return
     */
    @Override
    public ResponseDTO articleUpload(ArticleDTO articleDTO) {
        try {
            int len = 0;
            String line = null;
            StringBuffer str = new StringBuffer("");
            BufferedReader reader = new BufferedReader(new InputStreamReader(articleDTO.getArticleFile().getInputStream(), StandardCharsets.UTF_8));
            while ((line = reader.readLine()) != null) {
                if (len != 0) {
                    str.append("\r\n" + line);
                } else {
                    str.append(line);
                }
                len++;
            }
            reader.close();
            articleDTO.setArticleContent(str.toString());
            return this.saveArticle(articleDTO);
        } catch (
                Exception e) {
            e.printStackTrace();
            return ResponseDTO.fail(ExceptionEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 修改文章的状态
     *
     * @param articleId
     * @return
     */
    @Override
    public ResponseDTO publishAction(Integer articleId) {

        //先查询文章信息
        Article article = articleMapper.selectById(articleId);

        //判断并更新
        if (article.getIsPublish() == 0) {
            article.setIsPublish(1);
            articleMapper.updateById(article);
        } else {
            article.setIsPublish(0);
            articleMapper.updateById(article);
        }
        return ResponseDTO.success();
    }
}
