package com.example.juwuheback.service;

import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ArticlesDTO;

public interface ArticlesService {

    ResponseDTO queryAll(ArticlesDTO articlesDTO);

}
