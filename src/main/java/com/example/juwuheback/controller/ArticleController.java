package com.example.juwuheback.controller;

import com.example.juwuheback.common.action.ArticleAction;
import com.example.juwuheback.common.domain.PageResultDTO;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ArticleDTO;
import com.example.juwuheback.domain.dto.ArticleQueryDTO;
import com.example.juwuheback.domain.vo.ArticleVO;
import com.example.juwuheback.service.IArticleService;
import com.example.juwuheback.service.ILabelsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Api(tags = "文章模块")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/queryPage")
    @ApiOperation(value = "前后台-分页模糊查询-所有文章")
    public ResponseDTO<PageResultDTO<ArticleVO>> queryAllArticle(@RequestBody @Validated ArticleQueryDTO articleQueryDTO) {
        return articleService.queryAll(articleQueryDTO);
    }

    @PostMapping("/queryLabel")
    @ApiOperation(value = "前台-根据标签ID查询-文章信息")
    public ResponseDTO<List<ArticleVO>> queryArticleByLabel(@RequestBody @Validated(ArticleAction.queryLabel.class) ArticleQueryDTO articleQueryDTO) {
        return articleService.queryAllByLabel(articleQueryDTO);
    }

    @PostMapping("/queryArticle")
    @ApiOperation(value = "前后台-查询文章详情")
    public ResponseDTO queryArticleDetail(@RequestBody @Validated(ArticleAction.queryDetail.class) ArticleQueryDTO articleQueryDTO) {
        return articleService.queryDetail(articleQueryDTO);
    }

    @PostMapping("/save")
    @ApiOperation(value = "后台-保存文章")
    public ResponseDTO saveArticle(@RequestBody @Validated(ArticleAction.save.class) ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }

    @PostMapping("/saveEdit")
    @ApiOperation(value = "后台-保存文航编辑")
    public ResponseDTO saveEdit(@RequestBody @Validated(ArticleAction.saveEdit.class) ArticleDTO articleDTO) {
        return articleService.saveEditArticle(articleDTO);
    }

    @PostMapping("/remove")
    @ApiOperation(value = "后台-删除文章")
    public ResponseDTO removeArticle(@RequestBody @Validated(ArticleAction.remove.class) ArticleDTO articleDTO) {
        return articleService.removeArticle(articleDTO);
    }

    @PostMapping("/edit")
    @ApiOperation(value = "后台-编辑文章")
    public ResponseDTO editArticle(@RequestBody @Validated(ArticleAction.edit.class) ArticleDTO articleDTO) {
        return articleService.editArticle(articleDTO);
    }

    @PostMapping("/upload")
    @ApiOperation(value = "后台-文章上传")
    public ResponseDTO articleUpload(@Validated(ArticleAction.upload.class) ArticleDTO articleDTO) {
        return articleService.articleUpload(articleDTO);
    }

    @GetMapping("/publishAction/{articleId}")
    @ApiOperation(value = "后台-文章上线和下线")
    public ResponseDTO publishAction(@PathVariable("articleId") @Validated @NotNull Integer articleId) {
        return articleService.publishAction(articleId);
    }

}
