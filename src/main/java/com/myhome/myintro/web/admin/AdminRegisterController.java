package com.myhome.myintro.web.admin;

import com.myhome.myintro.admin.common.utils.AdminLoginUtil;
import com.myhome.myintro.admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.myhome.myintro.admin.dto.AdminDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminRegisterController {

    private final AdminService adminService;

    public AdminRegisterController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/member/register")
    public String form(Model model, HttpSession session, HttpServletRequest request) {
        if (!AdminLoginUtil.isLogin(session)) {
            model.addAttribute("msg", "로그인 후 이용해주세요.");
            model.addAttribute("redirectUrl", request.getContextPath() + "/admin/login");
            return "common/alert";
        }

        model.addAttribute("currentMenu", "MEMBER");

        return "admin/member/register";
    }

    @PostMapping("/admin/register")
    public String register(@ModelAttribute AdminDTO dto, Model model, HttpSession session, HttpServletRequest request) {
        try {

            if (!AdminLoginUtil.isLogin(session)) {
                model.addAttribute("msg", "로그인 후 이용해주세요.");
                model.addAttribute("redirectUrl", request.getContextPath() + "/admin/login");
                return "common/alert";
            }
            model.addAttribute("currentMenu", "MEMBER");
            adminService.registerAdmin(dto);
            return "redirect:/admin/member/list";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("currentMenu", "MEMBER");
            return "admin/member/register";
        }
    }
}
