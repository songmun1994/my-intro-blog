package com.myhome.myintro.admin.service;

import com.myhome.myintro.admin.dto.UserMenuDTO;

import java.util.List;

public interface UserMenuService {
    List<UserMenuDTO> getAdminMenuList(UserMenuDTO param);
    void registerMenu(UserMenuDTO param);
    void modifyMenu(UserMenuDTO param);
    void removeMenu(UserMenuDTO param);
    UserMenuDTO getMenuDetail(UserMenuDTO param);
}
