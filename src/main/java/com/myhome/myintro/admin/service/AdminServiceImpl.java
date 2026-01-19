package com.myhome.myintro.admin.service;

import com.myhome.myintro.admin.dto.AdminInsertDTO;
import com.myhome.myintro.admin.dto.AdminRegisterDTO;
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

    public AdminServiceImpl(AdminMapper adminMapper, AesGcmCrypto aes) {
        this.adminMapper = adminMapper;
        this.aes = aes;
    }

    @Transactional
    @Override
    public void register(AdminRegisterDTO req) {
        // 1) validation
        if (req.getAdminId() == null || req.getAdminId().trim().isEmpty()) {
            throw new IllegalArgumentException("adminId is required");
        }
        if (req.getAdminPassword() == null || req.getAdminPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("adminPassword is required");
        }

        // 2) duplicate check
        if (adminMapper.countByAdminId(req.getAdminId()) > 0) {
            throw new IllegalStateException("duplicate adminId");
        }

        // 3) build insert DTO
        AdminInsertDTO p = new AdminInsertDTO();
        p.setAdminId(req.getAdminId().trim());
        p.setAdminPassword(encoder.encode(req.getAdminPassword()));  // BCrypt

        // AES-GCM (nullable 허용)
        p.setAdminName(aes.encryptToBytes(emptyToNull(req.getAdminName())));
        p.setAdminEmail(aes.encryptToBytes(emptyToNull(req.getAdminEmail())));

        p.setAdminGroup(emptyToNull(req.getAdminGroup()));

        p.setUseYn("Y");
        p.setDelYn("N");

        // 최초 등록 시점은 로그인 전이므로 SYSTEM
        p.setRegId("SYSTEM");
        p.setRegName("SYSTEM");

        // 4) insert
        adminMapper.insertAdmin(p);
    }

    private String emptyToNull(String s) {
        if (s == null) return null;
        String t = s.trim();
        return t.isEmpty() ? null : t;
    }
}
