package com.example.juwuheback.domain.dto;

import com.example.juwuheback.common.action.LabelAction;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LabelDTO {

    @NotNull(groups = {LabelAction.remove.class}, message = "标签ID不能为NULL")
    @ApiModelProperty("标签ID")
    private Integer labelId;

    @NotBlank(groups = {LabelAction.add.class}, message = "标签名称不能为NULL")
    @ApiModelProperty("标签名称")
    private String labelName;

    @ApiModelProperty("标签描述")
    private String labelDescription;
}
