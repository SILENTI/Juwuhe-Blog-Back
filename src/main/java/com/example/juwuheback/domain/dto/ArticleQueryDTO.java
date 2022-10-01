package com.example.juwuheback.domain.dto;

import com.example.juwuheback.common.action.ArticleAction;
import com.example.juwuheback.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ArticleQueryDTO extends PageParamDTO {

    @NotNull(groups = {ArticleAction.queryDetail.class}, message = "文章ID不能为NULL")
    @ApiModelProperty("文章ID")
    private Integer articleId;

    @ApiModelProperty("文章标题")
    private String articleTitle;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("是否发表")
    private Integer isPublish;

    @NotNull(groups = {ArticleAction.queryLabel.class}, message = "标签Id不能为NULL")
    @ApiModelProperty("标签ID")
    private Integer labelId;

    @ApiModelProperty("标签名称")
    private String labelName;

}
