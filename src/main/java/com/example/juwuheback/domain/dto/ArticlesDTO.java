package com.example.juwuheback.domain.dto;

import com.example.juwuheback.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ArticlesDTO extends PageParamDTO {

    @ApiModelProperty("博文ID")
    private Integer articleId;

    @ApiModelProperty("博文标题")
    private String articleTitle;

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

}
