package com.example.juwuheback.model.service.impl;

import com.example.juwuheback.model.entity.Comments;
import com.example.juwuheback.mapper.CommentsMapper;
import com.example.juwuheback.model.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022-08-19
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
