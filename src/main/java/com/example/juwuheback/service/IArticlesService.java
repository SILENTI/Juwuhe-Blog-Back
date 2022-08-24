package com.example.juwuheback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ArticlesDTO;
import com.example.juwuheback.domain.entity.Articles;

public interface IArticlesService extends IService<Articles> {

    ResponseDTO queryAll(ArticlesDTO articlesDTO);

    ResponseDTO queryAllByLabel(ArticlesDTO articlesDTO);

}
