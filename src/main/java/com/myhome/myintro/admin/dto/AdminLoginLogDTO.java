package com.myhome.myintro.admin.dto;

/**
 * tb_admin_login_log 전용 DTO
 * - 모든 필드는 String
 */
public class AdminLoginLogDTO {

    private String idx;

    private String adminId;
    private String tryIp;
    private String successYn;     // Y/N
    private String failReason;    // 내부용: LOCKED / FAIL / NO_USER / BAD_PW / DISABLED 등
    private String regDate;

    // 선택(원하면 로그에 추가)
    private String userAgent;

    public String getIdx() { return idx; }
    public void setIdx(String idx) { this.idx = idx; }

    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }

    public String getTryIp() { return tryIp; }
    public void setTryIp(String tryIp) { this.tryIp = tryIp; }

    public String getSuccessYn() { return successYn; }
    public void setSuccessYn(String successYn) { this.successYn = successYn; }

    public String getFailReason() { return failReason; }
    public void setFailReason(String failReason) { this.failReason = failReason; }

    public String getRegDate() { return regDate; }
    public void setRegDate(String regDate) { this.regDate = regDate; }

    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }
}
