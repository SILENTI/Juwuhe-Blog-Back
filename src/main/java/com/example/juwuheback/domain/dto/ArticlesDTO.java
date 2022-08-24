package com.example.juwuheback.domain.dto;

import com.example.juwuheback.common.action.ArticlesAction;
import com.example.juwuheback.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class ArticlesDTO extends PageParamDTO implements Serializable {

    private static final long serialVersionUID = -4757888911683594030L;

    @ApiModelProperty("博文ID")
    private Integer articleId;

    @ApiModelProperty("博文标题")
    private String articleTitle;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @NotNull(groups = {ArticlesAction.queryArticlesLabel.class}, message = "标签Id不能为NULL")
    @ApiModelProperty("标签ID")
    private Integer labelId;

    @ApiModelProperty("标签名称")
    private String labelName;

}
