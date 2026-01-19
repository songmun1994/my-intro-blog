package com.myhome.myintro.admin.dto;

public class AdminRegisterDTO {
    private String adminId;
    private String adminPassword;
    private String adminName;
    private String adminGroup;
    private String adminEmail;

    // getters/setters
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }

    public String getAdminPassword() { return adminPassword; }
    public void setAdminPassword(String adminPassword) { this.adminPassword = adminPassword; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }

    public String getAdminGroup() { return adminGroup; }
    public void setAdminGroup(String adminGroup) { this.adminGroup = adminGroup; }

    public String getAdminEmail() { return adminEmail; }
    public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }
}
