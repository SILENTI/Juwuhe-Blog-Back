package com.example.juwuheback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.entity.Classify;
import com.example.juwuheback.domain.vo.ClassifyVO;

import java.util.List;

public interface IClassifyService extends IService<Classify> {

    ResponseDTO<List<ClassifyVO>> queryAllClassify();

}
