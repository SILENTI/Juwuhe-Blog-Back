package com.example.juwuheback.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Data
@ApiModel(value = "Classify对象", description = "")
public class ClassifyVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类ID")
    private Integer classifyId;

    @ApiModelProperty("分类名称")
    private String classifyName;

    @ApiModelProperty("父分类ID")
    private Integer parentClassifyId;

    @ApiModelProperty("分类描述")
    private String classifyDescription;

    private List<ArticleVO> articleVOList;

    @ApiModelProperty("子类所属")
    private List<ClassifyVO> childrenClassify;

}
