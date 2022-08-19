package com.example.juwuheback.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {

    @NotBlank(message = "账号不能为NULL")
    @ApiModelProperty("账号")
    private String username;

    @NotBlank(message = "密码不能为NULL")
    @ApiModelProperty("密码")
    private String password;

}
