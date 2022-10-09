package com.example.juwuheback.mapper;

import com.example.juwuheback.JuwuheBackApplicationTest;
import com.example.juwuheback.domain.vo.ClassifyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ClassifyMapperTest extends JuwuheBackApplicationTest {

    @Autowired
    private ClassifyMapper classifyMapper;

    @Test
    void insertArticleClassify() {
    }

    @Test
    void deleteArticleClassifyByArticleId() {
    }

    @Test
    void updateArticleClassify() {
    }

    @Test
    void selectAll() {
    }

    @Test
    void selectArticleAndClassify() {
        List<ClassifyVO> classifyVOS = classifyMapper.selectArticleAndClassify();
        log.error(classifyVOS.toString());

    }
}