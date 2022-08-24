package com.example.juwuheback.service.impl;

import com.example.juwuheback.common.config.LoginConfig;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.common.exception.ExceptionEnum;
import com.example.juwuheback.domain.dto.UserDTO;
import com.example.juwuheback.domain.vo.AdminVO;
import com.example.juwuheback.domain.entity.User;
import com.example.juwuheback.mapper.UserMapper;
import com.example.juwuheback.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.utils.JWTUtil;
import com.example.juwuheback.utils.PESUtil;
import com.example.juwuheback.utils.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022-08-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * -参数：用户账号和密码
     *
     * @param userDTO
     * @return
     */
    @Override
    public ResponseDTO adminLogin(UserDTO userDTO) {
        try {
            if (!PESUtil.isPESPassword(userDTO.getUsername(), userDTO.getPassword(), true).equals(LoginConfig.PASSWORD)) {
                return new ResponseDTO().fail(ExceptionEnum.ADMIN_USERNAME_PASSWORD_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();//追踪抛出异常的位置
            log.error("用户登录时出现异常，详情内容：" + e.getMessage());
        }
        AdminVO adminVO = SmartBeanUtil.copy(userDTO, AdminVO.class);
        //生成token
        adminVO.setPassword(null);
        adminVO.setToken(JWTUtil.getToken(userDTO));
        return new ResponseDTO().success().setData(adminVO);
    }

}
