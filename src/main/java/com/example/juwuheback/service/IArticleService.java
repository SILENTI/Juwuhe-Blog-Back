package com.example.juwuheback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.ArticleDTO;
import com.example.juwuheback.domain.dto.ArticleQueryDTO;
import com.example.juwuheback.domain.entity.Article;

public interface IArticleService extends IService<Article> {

    ResponseDTO queryAll(ArticleQueryDTO articleQueryDTO);

    ResponseDTO queryDetail(ArticleQueryDTO articleQueryDTO);

    ResponseDTO queryArticleDetail(ArticleQueryDTO articleQueryDTO);

    ResponseDTO queryAllByLabel(ArticleQueryDTO articleQueryDTO);

    ResponseDTO saveArticle(ArticleDTO articleDTO);

    ResponseDTO removeArticle(ArticleDTO articleDTO);

    ResponseDTO editArticle(ArticleDTO articleDTO);

    ResponseDTO articleUpload(ArticleDTO articleDTO);

    ResponseDTO publishAction(Integer articleId);


}
