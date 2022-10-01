package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.common.exception.ExceptionEnum;
import com.example.juwuheback.domain.dto.LabelDTO;
import com.example.juwuheback.domain.entity.Label;
import com.example.juwuheback.domain.vo.LabelVO;
import com.example.juwuheback.mapper.LabelMapper;
import com.example.juwuheback.service.ILabelsService;
import com.example.juwuheback.utils.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Service
public class LabelsServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelsService {

    @Autowired
    private LabelMapper labelMapper;

    /**
     * 添加标签信息
     *
     * @return
     */
    @Override
    public ResponseDTO saveLabel(LabelDTO labelDTO) {

        Label label = new Label();
        label.setLabelName(labelDTO.getLabelName());

        if (labelMapper.insert(label) != 1) {
            return ResponseDTO.fail(ExceptionEnum.DATABASE_OPERATION_ERROR);
        }

        LabelVO labelVO = SmartBeanUtil.copy(label, LabelVO.class);
        return ResponseDTO.success(labelVO);
    }
}
