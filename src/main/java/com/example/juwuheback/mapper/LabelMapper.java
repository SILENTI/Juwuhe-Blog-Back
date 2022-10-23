package com.example.juwuheback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.juwuheback.domain.entity.Label;
import com.example.juwuheback.domain.vo.LabelVO;
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
public interface LabelMapper extends BaseMapper<Label> {

    /**
     * 保存文章标签信息
     *
     * @param articleId 文章ID
     * @param labelList 标签ID集合
     * @return
     */
    Integer insertArticleLabel(@Param("articleId") Integer articleId, @Param("list") List<Integer> labelList);

    /**
     * 删除文章关联的标签
     *
     * @param articlesId 文章ID
     * @return
     */
    Integer deleteArticleLabelByArticleId(@Param("articleId") Integer articlesId);

    /**
     * 更具文章Id查询文章所有标签信息
     *
     * @param articleId 文章ID
     * @return
     */
    List<LabelVO> selectLabelsByArticleId(@Param("articleId") Integer articleId);


}
