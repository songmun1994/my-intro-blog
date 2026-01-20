package com.myhome.myintro.web.admin;

import com.myhome.myintro.admin.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.myhome.myintro.admin.dto.AdminDTO;

@Controller
public class AdminRegisterController {

    private final AdminService adminService;

    public AdminRegisterController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/register")
    public String form() {
        return "admin/register";
    }

    @PostMapping("/admin/register")
    public String register(@ModelAttribute AdminDTO dto, Model model) {
        try {
            adminService.registerAdmin(dto);
            return "redirect:/admin/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "admin/register";
        }
    }
}
