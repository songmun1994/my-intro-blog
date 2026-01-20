package com.myhome.myintro.admin.dto;

public class AdminLoginResultDTO {

    // 전부 String 규칙 유지
    // SUCCESS / FAIL / LOCKED
    private String status;

    // 성공 시만 세팅
    private AdminDTO admin;

    // 실패 메시지는 항상 동일하게 쓸 거라 옵션
    private String message;

    public static AdminLoginResultDTO success(AdminDTO admin) {
        AdminLoginResultDTO r = new AdminLoginResultDTO();
        r.status = "SUCCESS";
        r.admin = admin;
        return r;
    }

    public static AdminLoginResultDTO fail() {
        AdminLoginResultDTO r = new AdminLoginResultDTO();
        r.status = "FAIL";
        return r;
    }

    public static AdminLoginResultDTO locked() {
        AdminLoginResultDTO r = new AdminLoginResultDTO();
        r.status = "LOCKED";
        return r;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public AdminDTO getAdmin() { return admin; }
    public void setAdmin(AdminDTO admin) { this.admin = admin; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
