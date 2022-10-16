package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ClassifyDTO;
import com.example.juwuheback.domain.entity.Classify;
import com.example.juwuheback.domain.vo.ClassifyVO;
import com.example.juwuheback.mapper.ClassifyMapper;
import com.example.juwuheback.service.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

        //组装-树状分类信息
        List<ClassifyVO> levelOneMenus = new ArrayList<>();

        //根据parentId进行分组，组成Map集合
        Map<Integer, List<ClassifyVO>> CatalogueMap = classifyVOS.stream().collect(Collectors.groupingBy(ClassifyVO::getParentClassifyId, Collectors.toList()));

        //对集合进行分类组装
        CatalogueMap.forEach((parentId, collect) -> {

            //如果是第一序列分类，就直接加入集合
            if (Objects.equals(parentId, 0)) {
                levelOneMenus.addAll(collect);
            }

            collect.forEach(item -> {
                //根据id进行匹配
                item.setChildrenClassify(CatalogueMap.get(item.getClassifyId()));
            });
        });

        return ResponseDTO.success(levelOneMenus);
    }

    /**
     * 查询所有的文章及其分类信息
     *
     * @return
     */
    @Override
    public ResponseDTO<List<ClassifyVO>> queryArticleAndClassify() {

        List<ClassifyVO> classifyVOS = classifyMapper.selectArticleAndClassify();

        //组装-树状分类信息
        List<ClassifyVO> levelOneMenus = new ArrayList<>();

        //根据parentId进行分组，组成Map集合
        Map<Integer, List<ClassifyVO>> CatalogueMap = classifyVOS.stream().collect(Collectors.groupingBy(ClassifyVO::getParentClassifyId, Collectors.toList()));

        //对集合进行分类组装
        CatalogueMap.forEach((parentId, collect) -> {

            //如果是第一序列分类，就直接加入集合
            if (Objects.equals(parentId, 0)) {
                levelOneMenus.addAll(collect);
            }

            collect.forEach(item -> {
                //根据id进行匹配
                item.setChildrenClassify(CatalogueMap.get(item.getClassifyId()));
            });
        });

        return ResponseDTO.success(levelOneMenus);
    }


    /**
     * 删除分类信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public ResponseDTO removeClassify(List<Integer> classifyIdList) {

        //删除分类表中的信息
        classifyMapper.deleteBatchIds(classifyIdList);

        //删除文章和分类关联表中的信息
        classifyMapper.deleteBatchArticleClassifyIds(classifyIdList);

        return ResponseDTO.success();
    }
}
