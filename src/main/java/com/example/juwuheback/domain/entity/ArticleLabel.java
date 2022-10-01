package com.example.juwuheback.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Getter
@Setter
@TableName("article_label")
@ApiModel(value = "ArticlesLabels对象", description = "")
public class ArticleLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章ID")
    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    private Long labelId;


}
