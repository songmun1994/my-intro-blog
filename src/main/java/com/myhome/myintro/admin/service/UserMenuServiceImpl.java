package com.myhome.myintro.admin.service;
import com.myhome.myintro.admin.dto.UserMenuDTO;
import com.myhome.myintro.admin.mapper.UserMenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMenuServiceImpl implements UserMenuService {

    private final UserMenuMapper userMenuMapper;

    public UserMenuServiceImpl(UserMenuMapper userMenuMapper) {
        this.userMenuMapper = userMenuMapper;
    }

    @Override
    public List<UserMenuDTO> getAdminMenuList(UserMenuDTO param) {
        return userMenuMapper.selectAdminMenuList(param);
    }

    @Override
    public void registerMenu(UserMenuDTO param) {
        userMenuMapper.registerMenu(param);
    }

    @Override
    public void modifyMenu(UserMenuDTO param) {
        userMenuMapper.modifyMenu(param);
    }

    @Override
    public void removeMenu(UserMenuDTO param) {
        userMenuMapper.deleteUserMenu(param);
    }

    @Override
    public UserMenuDTO getMenuDetail(UserMenuDTO param) {
        return userMenuMapper.selectMenuDetail(param);
    }
}
