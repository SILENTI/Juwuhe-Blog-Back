package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.PageResultDTO;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ArticlesDTO;
import com.example.juwuheback.domain.entity.Articles;
import com.example.juwuheback.domain.vo.ArticlesVO;
import com.example.juwuheback.mapper.ArticlesMapper;
import com.example.juwuheback.service.IArticlesService;
import com.example.juwuheback.utils.SmartPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param articlesDTO
     * @return
     */
    @Override
    public ResponseDTO<PageResultDTO<ArticlesVO>> queryAll(ArticlesDTO articlesDTO) {
        Page page = SmartPageUtil.convert2QueryPage(articlesDTO);
        Page<ArticlesVO> result = articlesMapper.selectAllArticles(page, articlesDTO);
        PageResultDTO resultDTO = SmartPageUtil.convert2PageResult(result);
        return ResponseDTO.success(resultDTO);
    }

    /**
     * 根据标签Id插叙，博文信息
     *
     * @param articlesDTO
     * @return
     */
    @Override
    public ResponseDTO queryAllByLabel(ArticlesDTO articlesDTO) {
        return ResponseDTO.success(articlesMapper.selectAllByLabel(articlesDTO));
    }

}
