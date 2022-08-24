package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.entity.Labels;
import com.example.juwuheback.domain.vo.LabelsVO;
import com.example.juwuheback.mapper.LabelsMapper;
import com.example.juwuheback.service.ILabelsService;
import com.example.juwuheback.utils.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022-08-20
 */
@Service
public class LabelsServiceImpl extends ServiceImpl<LabelsMapper, Labels> implements ILabelsService {

    @Autowired
    private LabelsMapper labelsMapper;


}
