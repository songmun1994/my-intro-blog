package com.myhome.myintro.admin.service;

import com.myhome.myintro.admin.dto.AdminDTO;
import com.myhome.myintro.admin.dto.AdminLoginResultDTO;

public interface AdminService {

    // 관리자 등록(회원가입)
    void registerAdmin(AdminDTO req);

    // 관리자 로그인
    AdminLoginResultDTO login(AdminDTO req);
}
