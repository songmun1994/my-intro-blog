package com.myhome.myintro.web.admin;

import com.myhome.myintro.admin.dto.AdminDTO;
import com.myhome.myintro.admin.dto.AdminLoginResultDTO;
import com.myhome.myintro.admin.service.AdminService;
import com.myhome.myintro.common.crypto.AesGcmCrypto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminLoginController {

    private final AdminService adminService;
    private final AesGcmCrypto aes;

    public AdminLoginController(AdminService adminService, AesGcmCrypto aes) {
        this.adminService = adminService;
        this.aes = aes;
    }

    @GetMapping("/admin/login")
    public String loginForm() {

        String t = "홍길동";
        String enc = aes.encryptToBase64(t);
        String dec = aes.decryptFromBase64(enc);
        System.out.println("t=" + t);
        System.out.println("enc=" + enc);
        System.out.println("dec=" + dec);

        return "admin/login";


    }

    private String getClientIp(HttpServletRequest request) {
        String xff = request.getHeader("X-Forwarded-For");
        if (xff != null && !xff.trim().isEmpty()) {
            return xff.split(",")[0].trim(); // 첫 번째가 원 IP
        }
        String realIp = request.getHeader("X-Real-IP");
        if (realIp != null && !realIp.trim().isEmpty()) return realIp.trim();
        return request.getRemoteAddr();
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam("adminId") String adminId,
                        @RequestParam("adminPassword") String adminPassword,
                        HttpServletRequest request,
                        HttpSession session,
                        Model model) {

        AdminDTO req = new AdminDTO();
        req.setAdminId(adminId);
        req.setInputPassword(adminPassword);
        req.setTryIp(getClientIp(request));

        AdminLoginResultDTO result = adminService.login(req);

        if ("SUCCESS".equals(result.getStatus())) {
            AdminDTO admin = result.getAdmin();
            session.setAttribute("LOGIN_ADMIN_ID", admin.getAdminId());
            session.setAttribute("LOGIN_ADMIN_IDX", admin.getAdminIdx());
            session.setAttribute("LOGIN_ADMIN_GROUP", admin.getAdminGroup());

            System.err.println(aes.decryptFromBase64(admin.getAdminName()));
            session.setAttribute("LOGIN_ADMIN_NAME", aes.decryptFromBase64(admin.getAdminName()));
            session.setAttribute("LOGIN_ADMIN_EMAIL", aes.decryptFromBase64(admin.getAdminEmail()));

            return "redirect:/admin/dashboard";
        }

        model.addAttribute("error", "로그인에 실패했습니다.");
        model.addAttribute("locked", "LOCKED".equals(result.getStatus()));
        return "admin/login";
    }

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }
}
