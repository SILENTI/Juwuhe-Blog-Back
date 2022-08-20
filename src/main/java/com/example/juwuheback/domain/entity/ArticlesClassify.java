package com.example.juwuheback.domain.entity;

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
@TableName("articles_classify")
@ApiModel(value = "ArticlesClassify对象", description = "")
public class ArticlesClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章ID")
    private Integer articleId;

    @ApiModelProperty("分类ID")
    private Integer classifyId;


}
