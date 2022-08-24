package com.example.juwuheback.domain.entity;

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
 * @since 2022-08-24
 */
@Getter
@Setter
@ApiModel(value = "Gallery对象", description = "")
public class Gallery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图片ID")
    @TableId(value = "gallery_id", type = IdType.AUTO)
    private Integer galleryId;

    @ApiModelProperty("图片路径")
    private String galleryPath;

    @ApiModelProperty("图片描述")
    private String galleryDescription;


}
