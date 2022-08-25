package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.domain.entity.Label;
import com.example.juwuheback.mapper.LabelsMapper;
import com.example.juwuheback.service.ILabelsService;
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
public class LabelsServiceImpl extends ServiceImpl<LabelsMapper, Label> implements ILabelsService {

    @Autowired
    private LabelsMapper labelsMapper;


}
