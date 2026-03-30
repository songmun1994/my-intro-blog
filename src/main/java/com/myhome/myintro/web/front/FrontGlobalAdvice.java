package com.myhome.myintro.web.front;

import com.myhome.myintro.admin.dto.UserMenuDTO;
import com.myhome.myintro.admin.mapper.UserMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(basePackages = "com.myhome.myintro.web.front")
public class FrontGlobalAdvice {

    @Autowired
    private UserMenuMapper userMenuMapper;

    @ModelAttribute("globalMenuList")
    public List<UserMenuDTO> loadGlobalMenus() {
        // exposeYn = 'Y' 인 메뉴들만 가져오는 쿼리를 임시로 여기서 필터링하거나, 
        // 매퍼에서 가져오는 방식을 쓸 수 있으나, 현재 selectAdminMenuList는 조회 용도이므로
        // Front용 별도 쿼리를 만들어야 하지만 편의상 전체 조회 후 필터링 처리합니다.
        
        List<UserMenuDTO> allMenus = userMenuMapper.selectAdminMenuList(new UserMenuDTO());
        // exposeYn 'Y'인 것만 반환
        allMenus.removeIf(m -> !"Y".equals(m.getExposeYn()));
        return allMenus;
    }
}
