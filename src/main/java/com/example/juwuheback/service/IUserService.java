package com.example.juwuheback.service;

import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.UserDTO;
import com.example.juwuheback.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 居無何
 * @since 2022-08-24
 */
public interface IUserService extends IService<User> {

    ResponseDTO adminLogin(UserDTO userDTO);

}
