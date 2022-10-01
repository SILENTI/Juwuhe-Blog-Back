package com.example.juwuheback.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleVO {

    @ApiModelProperty("博文ID")
    private Integer articleId;

    @ApiModelProperty("博文标题")
    private String articleTitle;

    @ApiModelProperty("博文封面")
    private String articleImg;

    @ApiModelProperty("博文描述")
    private String articleDescription;

    @ApiModelProperty("博文内容")
    private String articleContent;

    @ApiModelProperty("浏览量")
    private Integer articleViews;

    @ApiModelProperty("评论总数")
    private Integer articleCommentCount;

    @ApiModelProperty("发表时间")
    private Date articleDate;

    @ApiModelProperty("所属标签")
    private List<LabelVO> labelVOList;

    @ApiModelProperty("是否发布上线")
    private Integer isPublish;

}
