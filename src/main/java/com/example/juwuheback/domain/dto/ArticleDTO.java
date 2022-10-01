package com.example.juwuheback.domain.dto;

import com.example.juwuheback.common.action.ArticleAction;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class ArticleDTO {

    @NotNull(groups = {ArticleAction.remove.class, ArticleAction.edit.class, ArticleAction.upload.class}, message = "文章ID不能为NULL")
    private Integer articleId;

    @NotBlank(groups = {ArticleAction.save.class, ArticleAction.edit.class, ArticleAction.upload.class}, message = "文章标题不能为NULL")
    @ApiModelProperty("文章标题")
    private String articleTitle;

    @NotBlank(groups = {ArticleAction.save.class, ArticleAction.edit.class}, message = "文章内容不能为NULL")
    @ApiModelProperty("文章内容")
    private String articleContent;

    @NotBlank(groups = {ArticleAction.save.class, ArticleAction.edit.class, ArticleAction.upload.class}, message = "文章封面不能为NULL")
    @ApiModelProperty("文章封面")
    private String articleImg;

    @NotBlank(groups = {ArticleAction.save.class, ArticleAction.edit.class, ArticleAction.upload.class}, message = "文章描述不能为NULL")
    @ApiModelProperty("文章描述")
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

    @NotNull(groups = {ArticleAction.save.class, ArticleAction.edit.class, ArticleAction.upload.class}, message = "文章分类不能为NULL")
    @ApiModelProperty("所属分类")
    private Integer classifyId;

    @NotEmpty(groups = {ArticleAction.save.class, ArticleAction.edit.class, ArticleAction.upload.class}, message = "文章所属标签不能为NULL")
    @ApiModelProperty("所属标签ID")
    private List<Integer> labelList;

    @NotNull(groups = {ArticleAction.upload.class}, message = "上传文件不能为NULL")
    @ApiModelProperty("上传的文件")
    private MultipartFile articleFile;

}
