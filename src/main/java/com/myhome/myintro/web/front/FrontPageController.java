package com.myhome.myintro.web.front;

import com.myhome.myintro.admin.dto.MenuContentDTO;
import com.myhome.myintro.admin.mapper.MenuContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FrontPageController {

    @Autowired
    private MenuContentMapper menuContentMapper;

    @GetMapping("/page/{menuId}")
    public String viewPage(@PathVariable("menuId") String menuId, Model model) {
        MenuContentDTO content = menuContentMapper.selectContentByMenuId(menuId);
        
        if (content != null) {
            model.addAttribute("pageContent", content.getHtmlContent());
        } else {
            model.addAttribute("pageContent", "<p>등록된 콘텐츠가 없습니다.</p>");
        }
        
        return "front/page"; // page.jsp 로 포워딩
    }
}
