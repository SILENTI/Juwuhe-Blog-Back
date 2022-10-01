package com.example.juwuheback.controller;

import com.example.juwuheback.common.action.LabelAction;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.LabelDTO;
import com.example.juwuheback.domain.entity.Label;
import com.example.juwuheback.domain.vo.LabelVO;
import com.example.juwuheback.service.ILabelsService;
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

@Api(tags = "标签模块")
@RestController
@RequestMapping("/label")
public class LabelsController {

    @Autowired
    private ILabelsService labelsService;

    @ApiOperation(value = "查询所有标签")
    @PostMapping("/queryAll")
    public ResponseDTO<List<LabelVO>> queryAll() {
        List<LabelVO> labelVOList = SmartBeanUtil.copyList(labelsService.list(), LabelVO.class);
        return ResponseDTO.success(labelVOList);
    }

    @ApiOperation(value = "添加标签")
    @PostMapping("/add")
    public ResponseDTO addLabel(@RequestBody @Validated(LabelAction.add.class) LabelDTO labelDTO) {
        return labelsService.saveLabel(labelDTO);
    }

    @ApiOperation(value = "删除标签")
    @PostMapping("/remove")
    public ResponseDTO removeLabel(@RequestBody @Validated(LabelAction.remove.class) LabelDTO labelDTO) {
        labelsService.removeById(labelDTO.getLabelId());
        return ResponseDTO.success();
    }

}