package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.entity.Classify;
import com.example.juwuheback.domain.vo.ClassifyVO;
import com.example.juwuheback.mapper.ClassifyMapper;
import com.example.juwuheback.service.IClassifyService;
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
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements IClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    /**
     * 查询所有的分类信息
     *
     * @return
     */
    @Override
    public ResponseDTO<List<ClassifyVO>> queryAllClassify() {

        //查询到所有的信息

        List<ClassifyVO> classifyVOS = classifyMapper.selectAll();

        log.debug(classifyVOS.toString());

        //组装-树状分类信息

        return ResponseDTO.success(classifyVOS);
    }
}
