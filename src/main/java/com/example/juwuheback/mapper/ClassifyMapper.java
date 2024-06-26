package com.example.juwuheback.mapper;

import com.example.juwuheback.domain.entity.Classify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.juwuheback.domain.vo.ClassifyVO;
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
public interface ClassifyMapper extends BaseMapper<Classify> {

    /**
     * 保存文章分类信息
     *
     * @param articleId  文章ID
     * @param classifyId 分类ID
     * @return
     */
    Integer insertArticleClassify(@Param("articleId") Integer articleId, @Param("classifyId") Integer classifyId);


    /**
     * 删除文章管理的分类
     *
     * @param articleId
     * @return
     */
    Integer deleteArticleClassifyByArticleId(@Param("articleId") Integer articleId);

    /**
     * 更新文章分类信息
     *
     * @param articleId  文章ID
     * @param classifyId 分类ID
     * @return
     */
    Integer updateArticleClassify(@Param("articleId") Integer articleId, @Param("classifyId") Integer classifyId);

    /**
     * 查询所有的分类信息
     *
     * @return
     */
    List<ClassifyVO> selectAll();

    /**
     * 查询文章信息及其所属分类
     *
     * @return
     */
    List<ClassifyVO> selectArticleAndClassify();

    /**
     * 根据文章ID查询分类，文章所属分类信息
     *
     * @param articleId
     * @return
     */
    ClassifyVO selectByArticleId(@Param("articled") Integer articleId);

    /**
     * 批量删除文章关联的分类信息的内容
     *
     * @param classifyIdList
     * @return
     */
    Integer deleteBatchArticleClassifyIds(@Param("list") List<Integer> classifyIdList);
}
