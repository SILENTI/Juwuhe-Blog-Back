package com.example.juwuheback.service.impl;

import com.example.juwuheback.common.config.LoginConfig;
import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.common.exception.ExceptionEnum;
import com.example.juwuheback.domain.dto.AdminDTO;
import com.example.juwuheback.domain.vo.AdminVO;
import com.example.juwuheback.service.AdminService;
import com.example.juwuheback.utils.JWTUtil;
import com.example.juwuheback.utils.PESUtil;
import com.example.juwuheback.utils.SmartBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

    /**
     * 用户登录
     * -参数：用户账号和密码
     *
     * @param adminDTO
     * @return
     */
    @Override
    public ResponseDTO adminLogin(AdminDTO adminDTO) {
        try {
            if (!PESUtil.isPESPassword(adminDTO.getUsername(), adminDTO.getPassword(), true).equals(LoginConfig.PASSWORD)) {
                return new ResponseDTO().fail(ExceptionEnum.ADMIN_USERNAME_PASSWORD_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();//追踪抛出异常的位置
            log.error("用户登录时出现异常，详情内容：" + e.getMessage());
        }
        AdminVO adminVO = SmartBeanUtil.copy(adminDTO, AdminVO.class);
        //生成token
        adminVO.setPassword(null);
        adminVO.setToken(JWTUtil.getToken(adminDTO));
        return new ResponseDTO().success().setData(adminVO);
    }

}
