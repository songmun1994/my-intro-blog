package com.myhome.myintro.admin.dto;

/**
 * tb_admin 전용 DTO
 * - 모든 필드는 String
 * - inputPassword 같은 값은 DB 컬럼이 아닌 "부가 필드"로만 사용
 */
public class AdminDTO {

    // ===== PK =====
    private String adminIdx;

    // ===== 계정 기본 =====
    private String adminId;
    private String adminPassword;      // DB 저장용(해시)
    private String adminName;          // DB 저장용(암호문)
    private String adminGroup;
    private String adminEmail;         // DB 저장용(암호문)
    private String useYn;
    private String delYn;

    // ===== 등록/수정 메타 =====
    private String regDate;
    private String regIdx;
    private String regId;
    private String regName;

    private String modId;
    private String modDate;
    private String modName;
    private String modIdx;

    // ===== 로그인 보안 =====
    private String loginFailCnt;
    private String lastLoginDate;
    private String tryIp;

    // ===== 부가 필드(폼 입력/처리용, DB 컬럼 아님) =====
    private String inputPassword;

    // getters/setters
    public String getAdminIdx() { return adminIdx; }
    public void setAdminIdx(String adminIdx) { this.adminIdx = adminIdx; }

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

    public String getUseYn() { return useYn; }
    public void setUseYn(String useYn) { this.useYn = useYn; }

    public String getDelYn() { return delYn; }
    public void setDelYn(String delYn) { this.delYn = delYn; }

    public String getRegDate() { return regDate; }
    public void setRegDate(String regDate) { this.regDate = regDate; }

    public String getRegIdx() { return regIdx; }
    public void setRegIdx(String regIdx) { this.regIdx = regIdx; }

    public String getRegId() { return regId; }
    public void setRegId(String regId) { this.regId = regId; }

    public String getRegName() { return regName; }
    public void setRegName(String regName) { this.regName = regName; }

    public String getModId() { return modId; }
    public void setModId(String modId) { this.modId = modId; }

    public String getModDate() { return modDate; }
    public void setModDate(String modDate) { this.modDate = modDate; }

    public String getModName() { return modName; }
    public void setModName(String modName) { this.modName = modName; }

    public String getModIdx() { return modIdx; }
    public void setModIdx(String modIdx) { this.modIdx = modIdx; }

    public String getLoginFailCnt() { return loginFailCnt; }
    public void setLoginFailCnt(String loginFailCnt) { this.loginFailCnt = loginFailCnt; }

    public String getLastLoginDate() { return lastLoginDate; }
    public void setLastLoginDate(String lastLoginDate) { this.lastLoginDate = lastLoginDate; }

    public String getTryIp() { return tryIp; }
    public void setTryIp(String tryIp) { this.tryIp = tryIp; }

    public String getInputPassword() { return inputPassword; }
    public void setInputPassword(String inputPassword) { this.inputPassword = inputPassword; }
}
