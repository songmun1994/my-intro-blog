package com.myhome.myintro.common.crypto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class AesGcmCrypto {

    private static final String ALGO = "AES";
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final int IV_LEN = 12;
    private static final int TAG_LEN_BIT = 128;

    private final byte[] key;

    public AesGcmCrypto(@Value("${crypto.aes.keyBase64}") String keyBase64) {
        System.out.println(">>> keyBase64 raw = [" + keyBase64 + "]");
        this.key = Base64.getDecoder().decode(keyBase64);

        if (this.key.length != 32) {
            throw new IllegalArgumentException("AES key must be 32 bytes (256-bit) in Base64");
        }
    }

    public String encryptToBase64(String plain) {
        if (plain == null) return null;
        byte[] enc = encryptToBytes(plain);   // 기존 메서드(byte[]) 재사용
        return Base64.getEncoder().encodeToString(enc);
    }

    public String decryptFromBase64(String cipherBase64) {
        if (cipherBase64 == null) return null;
        byte[] enc = Base64.getDecoder().decode(cipherBase64);
        return decryptFromBytes(enc);         // 기존 메서드(String) 또는 bytes->String 복호 메서드 사용
    }

    /** 결과 포맷: [IV(12)][CIPHERTEXT+TAG] */
    public byte[] encryptToBytes(String plainText) {
        if (plainText == null) return null;
        try {
            byte[] iv = new byte[IV_LEN];
            new SecureRandom().nextBytes(iv);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec keySpec = new SecretKeySpec(key, ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new GCMParameterSpec(TAG_LEN_BIT, iv));

            byte[] cipherBytes = cipher.doFinal(plainText.getBytes(java.nio.charset.StandardCharsets.UTF_8));

            byte[] out = new byte[IV_LEN + cipherBytes.length];
            System.arraycopy(iv, 0, out, 0, IV_LEN);
            System.arraycopy(cipherBytes, 0, out, IV_LEN, cipherBytes.length);
            return out;
        } catch (Exception e) {
            throw new RuntimeException("AES-GCM encrypt failed", e);
        }
    }

    public String decryptFromBytes(byte[] encrypted) {
        if (encrypted == null) return null;
        if (encrypted.length <= IV_LEN) throw new IllegalArgumentException("Invalid encrypted data");
        try {
            byte[] iv = new byte[IV_LEN];
            byte[] cipherBytes = new byte[encrypted.length - IV_LEN];
            System.arraycopy(encrypted, 0, iv, 0, IV_LEN);
            System.arraycopy(encrypted, IV_LEN, cipherBytes, 0, cipherBytes.length);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec keySpec = new SecretKeySpec(key, ALGO);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new GCMParameterSpec(TAG_LEN_BIT, iv));

            byte[] plain = cipher.doFinal(cipherBytes);
            return new String(plain, java.nio.charset.StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("AES-GCM decrypt failed", e);
        }
    }
}
