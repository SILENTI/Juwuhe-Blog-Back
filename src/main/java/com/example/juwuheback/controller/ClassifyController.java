package com.example.juwuheback.controller;

import com.example.juwuheback.common.action.ClassifyAction;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ClassifyDTO;
import com.example.juwuheback.domain.entity.Classify;
import com.example.juwuheback.domain.vo.ClassifyVO;
import com.example.juwuheback.service.IClassifyService;
import com.example.juwuheback.utils.SmartBeanUtil;
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

    @ApiOperation(value = "修改分类信息")
    @PostMapping("/update")
    public ResponseDTO updateClassify(@RequestBody @Validated(ClassifyAction.update.class) ClassifyDTO classifyDTO) {
        Classify classify = SmartBeanUtil.copy(classifyDTO, Classify.class);
        if (!classifyService.updateById(classify)) return ResponseDTO.fail();
        return ResponseDTO.success();
    }

    @ApiOperation(value = "添加分类信息")
    @PostMapping("/add")
    public ResponseDTO addClassify(@RequestBody @Validated(ClassifyAction.add.class) ClassifyDTO classifyDTO) {
        if (!classifyService.save(SmartBeanUtil.copy(classifyDTO, Classify.class))) return ResponseDTO.fail();
        return ResponseDTO.success();
    }

    @ApiOperation(value = "添加分类及分类其下的文章")
    @PostMapping("/queryInfo")
    public ResponseDTO<List<ClassifyVO>> queryArticleAndClassify() {
        return classifyService.queryArticleAndClassify();
    }

}
