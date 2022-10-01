package com.example.juwuheback.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.juwuheback.domain.dto.ArticleQueryDTO;
import com.example.juwuheback.domain.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.juwuheback.domain.vo.ArticleVO;
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
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 查询文章
     * 查询条件：文章ID，文章标题（模糊查询），起始时间
     *
     * @param page
     * @param articleQueryDTO
     * @return 文章信息及文章所属标签信息
     */
    Page<ArticleVO> selectAllArticle(@Param("page") Page page, @Param("articleQueryDTO") ArticleQueryDTO articleQueryDTO);

    /**
     * 查询文章
     * 查询条件：标签Id、标签名称
     *
     * @param articleQueryDTO
     * @return 文章信息及文章所属标签信息
     */
    List<ArticleVO> selectAllByLabel(@Param("articleQueryDTO") ArticleQueryDTO articleQueryDTO);

}
