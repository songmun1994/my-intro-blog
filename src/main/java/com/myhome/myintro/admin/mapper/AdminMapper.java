package com.myhome.myintro.admin.mapper;

import com.myhome.myintro.admin.dto.AdminDTO;
import com.myhome.myintro.admin.dto.AdminLoginLogDTO;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    // 중복체크
    int countByAdminId(@Param("adminId") String adminId);

    // admin Insert
    int insertAdmin(AdminDTO param);

    // ====== 로그인용 ======
    AdminDTO selectLoginInfo(AdminDTO param);

    int increaseLoginFail(AdminDTO param);

    int resetLoginFail(AdminDTO param);

    int updateLastLoginDate(AdminDTO param);

    // ====== 로그인 시도 로그 ======
    int insertLoginLog(AdminLoginLogDTO param);
}
