package com.example.juwuheback.controller;

import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.LoginDTO;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 居無何
 * @since 2022-08-19
 */
@Api(tags = "登录模块")
@RestController
@RequestMapping("/admin")
public class LoginController {

    public ResponseDTO adminLogin(@RequestBody @Validated LoginDTO loginDTO){

        return null;
    }

}
