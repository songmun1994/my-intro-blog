package com.myhome.myintro.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminEntryController {

    // /admin 또는 /admin/ 로 들어오면 로그인으로 보냄
    @GetMapping({"/admin", "/admin/"})
    public String adminRoot() {
        return "redirect:/admin/login";
    }
}
