package com.example.juwuheback.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ArticlesVO {

    @ApiModelProperty("博文ID")
    private Integer articleId;

    @ApiModelProperty("博文标题")
    private String articleTitle;

    @ApiModelProperty("博文内容")
    private String articleContent;

    @ApiModelProperty("浏览量")
    private Integer articleViews;

    @ApiModelProperty("评论总数")
    private Integer articleCommentCount;

    @ApiModelProperty("发表时间")
    private Date articleDate;

}
