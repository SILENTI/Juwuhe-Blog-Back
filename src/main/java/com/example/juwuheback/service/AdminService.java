package com.example.juwuheback.service;

import com.example.juwuheback.common.domain.ResponseDTO;
import com.example.juwuheback.domain.dto.AdminDTO;

public interface AdminService {

    ResponseDTO adminLogin(AdminDTO adminDTO);

}
