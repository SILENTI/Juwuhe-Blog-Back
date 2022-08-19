package com.example.juwuheback.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 居無何
 * @since 2022-08-19
 */
@Getter
@Setter
@ApiModel(value = "Labels对象", description = "")
public class Labels implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签ID")
    @TableId(value = "label_id", type = IdType.AUTO)
    private Long labelId;

    @ApiModelProperty("标签名称")
    private String labelName;

    @ApiModelProperty("标签描述")
    private String labelDescription;


}
