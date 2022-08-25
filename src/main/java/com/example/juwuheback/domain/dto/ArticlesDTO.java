package com.example.juwuheback.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
public class ArticlesDTO {

    @NotBlank(message = "博文标题不能为NULL")
    @ApiModelProperty("博文标题")
    private String articleTitle;

    @NotBlank(message = "博文内容不能为NULL")
    @ApiModelProperty("博文内容")
    private String articleContent;

    @NotBlank(message = "博文封面不能为NULL")
    @ApiModelProperty("博文封面")
    private String articleImg;

    @NotBlank(message = "博文描述不能为NULL")
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

    @NotBlank(message = "博文分类不能为NULL")
    @ApiModelProperty("所属分类")
    private Integer classifyId;

    @NotEmpty(message = "博文所属标签不能为NULL")
    @ApiModelProperty("所属标签ID")
    private List<Integer> labelList;

}
