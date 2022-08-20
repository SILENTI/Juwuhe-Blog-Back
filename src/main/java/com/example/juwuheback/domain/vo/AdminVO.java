package com.example.juwuheback.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminVO {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("token")
    private String token;

}
