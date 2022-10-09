package com.example.juwuheback.domain.dto;

import com.example.juwuheback.common.action.ClassifyAction;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClassifyDTO {

    @NotNull(groups = {ClassifyAction.update.class}, message = "分类的ID不能为NULL")
    @ApiModelProperty("分类ID")
    private Integer classifyId;

    @NotBlank(groups = {ClassifyAction.update.class, ClassifyAction.add.class}, message = "分类的名称不能为NULL")
    @ApiModelProperty("分类名称")
    private String classifyName;

    @NotNull(groups = {ClassifyAction.add.class}, message = "父类ID不能为NULL")
    @ApiModelProperty("父分类ID")
    private Integer parentClassifyId;

    @ApiModelProperty("分类描述")
    private String classifyDescription;

}
