package com.example.juwuheback.controller;

import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.vo.ClassifyVO;
import com.example.juwuheback.service.IClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Api(tags = "分页模块")
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    @Autowired
    private IClassifyService classifyService;

    @ApiOperation(value = "查询所有分类")
    @PostMapping("/queryAll")
    public ResponseDTO<List<ClassifyVO>> queryAllClassify() {
        return classifyService.queryAllClassify();
    }

}
