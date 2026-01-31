package com.myhome.myintro.web.admin;

import com.myhome.myintro.admin.common.utils.AdminLoginUtil;
import com.myhome.myintro.admin.dto.UserMenuDTO;
import com.myhome.myintro.admin.service.UserMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminMenuController {

    private final UserMenuService userMenuService;

    public AdminMenuController(UserMenuService userMenuService) {
        this.userMenuService = userMenuService;
    }

    @GetMapping("/admin/menu/manage")
    public String menuManage(HttpServletRequest request,
                             HttpSession session,
                             UserMenuDTO param,
                             Model model) {
        if (!AdminLoginUtil.isLogin(session)) {
            model.addAttribute("msg", "로그인 후 이용해주세요.");
            model.addAttribute("redirectUrl", request.getContextPath() + "/admin/login");
            return "common/alert";
        }

        List<UserMenuDTO> list = userMenuService.getAdminMenuList(new UserMenuDTO());
        model.addAttribute("menuList", list);
        return "admin/menu/menuManage";
    }

    @GetMapping("/admin/menu/form")
    public String menuForm(UserMenuDTO param, Model model) {
        if (param.getMenuIdx() != null) {
            model.addAttribute("menu", userMenuService.getMenuDetail(param));
        } else {
            model.addAttribute("menu", param);
        }
        return "admin/menu/menuForm";
    }

    @PostMapping("/admin/menu/save")
    public String saveMenu(UserMenuDTO dto, HttpSession session) {

        dto.setRegId((String)session.getAttribute("LOGIN_ADMIN_ID"));
        dto.setRegIdx((String)session.getAttribute("LOGIN_ADMIN_IDX"));

        if (dto.getMenuIdx() == null || "".equals(dto.getMenuIdx())) {
            userMenuService.registerMenu(dto);
        } else {
            userMenuService.modifyMenu(dto);
        }
        return "redirect:/admin/menu/manage";
    }



}
