package com.myhome.myintro.admin.mapper;

import com.myhome.myintro.admin.dto.UserMenuDTO;
import java.util.List;

public interface UserMenuMapper {



    // 관리자 메뉴 목록
    List<UserMenuDTO> selectAdminMenuList(UserMenuDTO param);

    // 등록 / 수정 / 삭제
    int registerMenu(UserMenuDTO param);
    int modifyMenu(UserMenuDTO param);
    int deleteUserMenu(UserMenuDTO param);

    UserMenuDTO selectMenuDetail(UserMenuDTO param);

}
