package com.example.juwuheback.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.juwuheback.domain.entity.Articles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.juwuheback.domain.dto.ArticlesDTO;
import com.example.juwuheback.domain.vo.ArticlesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Mapper
public interface ArticlesMapper extends BaseMapper<Articles> {

    /**
     * 查询博文
     * 查询条件：博文ID，博文标题（模糊查询），起始时间
     *
     * @param page
     * @param articlesDTO
     * @return 博文信息及博文所属标签信息
     */
    Page<ArticlesVO> selectAllArticles(@Param("page") Page page, @Param("articlesDTO") ArticlesDTO articlesDTO);

    /**
     * 查询博文
     * 查询条件：标签Id、标签名称
     *
     * @param articlesDTO
     * @return 博文信息及博文所属标签信息
     */
    List<ArticlesVO> selectAllByLabel(@Param("articlesDTO") ArticlesDTO articlesDTO);
}
