package com.myhome.myintro.admin.service;

import com.myhome.myintro.admin.dto.AdminDTO;
import com.myhome.myintro.admin.dto.AdminLoginLogDTO;
import com.myhome.myintro.admin.dto.AdminLoginResultDTO;
import com.myhome.myintro.admin.mapper.AdminMapper;
import com.myhome.myintro.common.crypto.AesGcmCrypto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;
    private final AesGcmCrypto aes;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 타이밍 완화용 더미 bcrypt
    private static final String DUMMY_BCRYPT =
            "$2a$10$7q6qvUeH8pZtHkUq0rQq0e2w7t6e9bK2oHq5v7iQm3lHqJg0dQf4S";

    public AdminServiceImpl(AdminMapper adminMapper, AesGcmCrypto aes) {
        this.adminMapper = adminMapper;
        this.aes = aes;
    }

    private String nvl(String v) { return v == null ? "" : v; }
    private String trim(String v) { return nvl(v).trim(); }
    private String emptyToNull(String v) {
        String t = trim(v);
        return t.isEmpty() ? null : t;
    }
    private int toInt(String v) {
        try { return Integer.parseInt(v); } catch (Exception e) { return 0; }
    }

    private void insertLoginLog(String adminId, String ip, String successYn, String failReason) {
        AdminLoginLogDTO log = new AdminLoginLogDTO();
        log.setAdminId(adminId);
        log.setTryIp(ip);
        log.setSuccessYn(successYn);
        log.setFailReason(failReason);
        adminMapper.insertLoginLog(log);
    }

    @Transactional
    @Override
    public void registerAdmin(AdminDTO req) {

        String adminId = trim(req.getAdminId());
        if (adminId.isEmpty()) throw new IllegalArgumentException("adminId required");

        int dup = adminMapper.countByAdminId(adminId);
        if (dup > 0) throw new IllegalStateException("duplicate adminId");

        // 비밀번호: 단방향(BCrypt)
        String rawPw = nvl(req.getInputPassword());
        if (rawPw.isEmpty()) throw new IllegalArgumentException("password required");

        AdminDTO p = new AdminDTO();
        p.setAdminId(adminId);
        p.setAdminPassword(encoder.encode(rawPw));

        // 이름/이메일: AES-GCM -> Base64 문자열로 저장 (DTO는 String 유지)
        p.setAdminName(aes.encryptToBase64(emptyToNull(req.getAdminName())));
        p.setAdminEmail(aes.encryptToBase64(emptyToNull(req.getAdminEmail())));

        p.setAdminGroup(trim(req.getAdminGroup()));
        p.setUseYn("Y");

        // reg 세트 (필요한 값만 세팅)
        p.setRegIdx(req.getRegIdx());
        p.setRegId(req.getRegId());
        p.setRegName(req.getRegName());

        adminMapper.insertAdmin(p);
    }

    @Transactional
    @Override
    public AdminLoginResultDTO login(AdminDTO req) {

        String adminId = trim(req.getAdminId());
        String inputPw = nvl(req.getInputPassword());
        String ip = trim(req.getTryIp());
        if (ip.isEmpty()) ip = "0.0.0.0";

        if (adminId.isEmpty() || inputPw.isEmpty()) {
            insertLoginLog(adminId, ip, "N", "EMPTY");
            return AdminLoginResultDTO.fail();
        }

        AdminDTO db = adminMapper.selectLoginInfo(req);

        if (db == null) {
            encoder.matches(inputPw, DUMMY_BCRYPT);
            insertLoginLog(adminId, ip, "N", "NO_USER");
            return AdminLoginResultDTO.fail();
        }

        if (!"Y".equals(db.getUseYn()) || "Y".equals(db.getDelYn())) {
            encoder.matches(inputPw, DUMMY_BCRYPT);
            insertLoginLog(adminId, ip, "N", "DISABLED");
            return AdminLoginResultDTO.fail();
        }

        int failCnt = toInt(db.getLoginFailCnt());
        if (failCnt >= 5) {
            insertLoginLog(adminId, ip, "N", "LOCKED");
            return AdminLoginResultDTO.locked();
        }

        boolean ok = encoder.matches(inputPw, nvl(db.getAdminPassword()));
        if (!ok) {
            adminMapper.increaseLoginFail(req);

            AdminDTO again = adminMapper.selectLoginInfo(req);
            int againCnt = (again == null) ? 0 : toInt(again.getLoginFailCnt());

            if (againCnt >= 5) {
                insertLoginLog(adminId, ip, "N", "LOCKED");
                return AdminLoginResultDTO.locked();
            }

            insertLoginLog(adminId, ip, "N", "BAD_PW");
            return AdminLoginResultDTO.fail();
        }

        // 성공
        adminMapper.resetLoginFail(req);
        adminMapper.updateLastLoginDate(req);
        insertLoginLog(adminId, ip, "Y", null);

        return AdminLoginResultDTO.success(db);
    }
}
