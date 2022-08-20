package com.example.juwuheback.controller;

import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ArticlesDTO;
import com.example.juwuheback.service.impl.ArticlesServiceImpl;
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
 * @since 2022-08-20
 */
@Api("博文模块")
@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesServiceImpl articlesServiceImpl;

    @PostMapping("/query")
    @ApiOperation(value = "分页模糊查询-所有博文")
    public ResponseDTO queryAllArticles(@RequestBody @Validated ArticlesDTO articlesDTO) {
        return articlesServiceImpl.queryAll(articlesDTO);
    }

}
