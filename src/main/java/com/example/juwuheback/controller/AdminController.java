package com.example.juwuheback.controller;

import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.AdminDTO;
import com.example.juwuheback.service.impl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 居無何
 * @since 2022-08-19
 */
@Api(tags = "管理模块")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResponseDTO adminLogin(@RequestBody @Validated AdminDTO adminDTO) {
        return adminServiceImpl.adminLogin(adminDTO);
    }

}
