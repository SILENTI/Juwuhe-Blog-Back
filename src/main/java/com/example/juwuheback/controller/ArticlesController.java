package com.example.juwuheback.controller;

import com.example.juwuheback.common.domain.PageResultDTO;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ArticlesDTO;
import com.example.juwuheback.domain.dto.ArticlesQueryDTO;
import com.example.juwuheback.domain.vo.ArticlesVO;
import com.example.juwuheback.service.IArticlesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(tags = "博文模块")
@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private IArticlesService articlesService;

    @PostMapping("/queryArticlesPage")
    @ApiOperation(value = "分页模糊查询-所有博文包括标签")
    public ResponseDTO<PageResultDTO<ArticlesVO>> queryAllArticles(@RequestBody @Validated ArticlesQueryDTO articlesQueryDTO) {
        return articlesService.queryAll(articlesQueryDTO);
    }

    @PostMapping("/queryArticlesLabel")
    @ApiOperation(value = "根据标签ID查询-博文信息")
    public ResponseDTO<List<ArticlesVO>> queryArticlesByLabel(@RequestBody ArticlesQueryDTO articlesQueryDTO) {
        return articlesService.queryAllByLabel(articlesQueryDTO);
    }

    @PostMapping("/saveArticles")
    @ApiOperation(value = "保存文章")
    public ResponseDTO saveArticles(@RequestBody @Validated ArticlesDTO articlesDTO) {
        return articlesService.saveArticles(articlesDTO);
    }

}
