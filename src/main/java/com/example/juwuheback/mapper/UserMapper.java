package com.example.juwuheback.mapper;

import com.example.juwuheback.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 居無何
 * @since 2022-08-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
