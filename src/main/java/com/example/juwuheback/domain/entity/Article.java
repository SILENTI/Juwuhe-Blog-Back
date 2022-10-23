package com.example.juwuheback.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Data
@TableName("article")
@ApiModel(value = "Articles对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("博文ID")
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    @ApiModelProperty("博文标题")
    private String articleTitle;

    @ApiModelProperty("博文内容")
    private String articleContent;

    @ApiModelProperty("博文封面")
    private String articleImg;

    @ApiModelProperty("博文描述")
    private String articleDescription;

    @ApiModelProperty("浏览量")
    private Integer articleViews;

    @ApiModelProperty("评论总数")
    private Integer articleCommentCount;

    @ApiModelProperty("发表时间")
    private Date articlePublishDate;

    @ApiModelProperty("发表时间")
    private Date articleCreateDate;

    @ApiModelProperty("是否发表")
    private Integer isPublish;


}
