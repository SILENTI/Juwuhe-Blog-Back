package com.example.juwuheback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.LabelDTO;
import com.example.juwuheback.domain.entity.Label;

public interface ILabelsService extends IService<Label> {

    ResponseDTO saveLabel(LabelDTO labelDTO);

}
