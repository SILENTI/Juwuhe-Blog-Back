package com.example.juwuheback.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.juwuheback.domain.entity.Articles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.juwuheback.domain.dto.ArticlesDTO;
import com.example.juwuheback.domain.vo.ArticlesVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * @return
     */
    Page<ArticlesVO> selectAllArticles(@Param("page") Page page, @Param("articlesDTO") ArticlesDTO articlesDTO);

}
