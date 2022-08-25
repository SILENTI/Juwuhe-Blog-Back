package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.PageResultDTO;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.common.exception.ExceptionEnum;
import com.example.juwuheback.domain.dto.ArticlesDTO;
import com.example.juwuheback.domain.dto.ArticlesQueryDTO;
import com.example.juwuheback.domain.entity.Articles;
import com.example.juwuheback.domain.vo.ArticlesVO;
import com.example.juwuheback.mapper.ArticlesMapper;
import com.example.juwuheback.service.IArticlesService;
import com.example.juwuheback.utils.SmartBeanUtil;
import com.example.juwuheback.utils.SmartPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements IArticlesService {

    @Autowired
    private ArticlesMapper articlesMapper;

    /**
     * 查询博客信息-包括其标签
     *
     * @param articlesQueryDTO
     * @return
     */
    @Override
    public ResponseDTO<PageResultDTO<ArticlesVO>> queryAll(ArticlesQueryDTO articlesQueryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(articlesQueryDTO);
        Page<ArticlesVO> result = articlesMapper.selectAllArticles(page, articlesQueryDTO);
        PageResultDTO resultDTO = SmartPageUtil.convert2PageResult(result);
        return ResponseDTO.success(resultDTO);
    }

    /**
     * 根据标签Id插叙，博文信息
     *
     * @param articlesQueryDTO
     * @return
     */
    @Override
    public ResponseDTO queryAllByLabel(ArticlesQueryDTO articlesQueryDTO) {
        return ResponseDTO.success(articlesMapper.selectAllByLabel(articlesQueryDTO));
    }

    /**
     * 保存博客文章
     *
     * @param articlesDTO
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResponseDTO saveArticles(ArticlesDTO articlesDTO) {

        //数据转化
        Articles articles = SmartBeanUtil.copy(articlesDTO, Articles.class);

        //保存文章信息
        articlesMapper.insert(articles);

        //保存分类和标签
        if (ObjectUtils.isEmpty(articles.getArticleId()) || articlesMapper.insertArticlesLabel(articles.getArticleId(), articlesDTO.getLabelList()) < 1 || articlesMapper.insertArticlesClassify(articles.getArticleId(), articlesDTO.getClassifyId()) < 1) {
            return ResponseDTO.fail(ExceptionEnum.DATABASE_OPERATION_ERROR);
        }
        return ResponseDTO.success();
    }
}
