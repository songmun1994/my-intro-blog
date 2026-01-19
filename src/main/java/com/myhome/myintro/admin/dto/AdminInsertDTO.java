package com.myhome.myintro.admin.dto;

public class AdminInsertDTO {
    private String adminId;
    private String adminPassword; // BCrypt hash
    private byte[] adminName;     // AES-GCM bytes
    private String adminGroup;
    private byte[] adminEmail;    // AES-GCM bytes

    private String useYn;
    private String delYn;

    private String regId;
    private String regName;

    // getters/setters
    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }

    public String getAdminPassword() { return adminPassword; }
    public void setAdminPassword(String adminPassword) { this.adminPassword = adminPassword; }

    public byte[] getAdminName() { return adminName; }
    public void setAdminName(byte[] adminName) { this.adminName = adminName; }

    public String getAdminGroup() { return adminGroup; }
    public void setAdminGroup(String adminGroup) { this.adminGroup = adminGroup; }

    public byte[] getAdminEmail() { return adminEmail; }
    public void setAdminEmail(byte[] adminEmail) { this.adminEmail = adminEmail; }

    public String getUseYn() { return useYn; }
    public void setUseYn(String useYn) { this.useYn = useYn; }

    public String getDelYn() { return delYn; }
    public void setDelYn(String delYn) { this.delYn = delYn; }

    public String getRegId() { return regId; }
    public void setRegId(String regId) { this.regId = regId; }

    public String getRegName() { return regName; }
    public void setRegName(String regName) { this.regName = regName; }
}
