package com.example.juwuheback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.common.exception.ExceptionEnum;
import com.example.juwuheback.domain.dto.UserDTO;
import com.example.juwuheback.domain.entity.User;
import com.example.juwuheback.domain.vo.UserVO;
import com.example.juwuheback.mapper.UserMapper;
import com.example.juwuheback.service.IUserService;
import com.example.juwuheback.utils.JWTUtil;
import com.example.juwuheback.utils.PESUtil;
import com.example.juwuheback.utils.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, userDTO.getUsername());
        User user = userMapper.selectOne(lambdaQueryWrapper);

        if (ObjectUtils.isEmpty(user)) {
            return ResponseDTO.fail(ExceptionEnum.USER_USERNAME_IS_NOT_EXIST_ERROR);
        }

        try {
            if (!PESUtil.isPESPassword(userDTO.getUsername(), userDTO.getPassword(), true).equals(user.getPassword())) {
                return ResponseDTO.fail(ExceptionEnum.USER_USERNAME_PASSWORD_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();//追踪抛出异常的位置
            log.error("用户登录时出现异常，详情内容：" + e.getMessage());
        }
        UserVO userVO = SmartBeanUtil.copy(userDTO, UserVO.class);
        //生成token
        userVO.setPassword(null);
        userVO.setToken(JWTUtil.getToken(userDTO));
        return ResponseDTO.success().setData(userVO);
    }

}
