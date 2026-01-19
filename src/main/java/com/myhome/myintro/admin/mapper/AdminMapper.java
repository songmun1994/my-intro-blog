package com.myhome.myintro.admin.mapper;

import com.myhome.myintro.admin.dto.AdminInsertDTO;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByAdminId(@Param("adminId") String adminId);
    int insertAdmin(AdminInsertDTO param);
}
