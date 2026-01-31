package com.myhome.myintro.admin.common.utils;

import javax.servlet.http.HttpSession;

public class AdminLoginUtil {

    public static final String LOGIN_ADMIN_ID = "LOGIN_ADMIN_ID";

    public static boolean isLogin(HttpSession session) {
        return session != null && session.getAttribute(LOGIN_ADMIN_ID) != null;
    }
}
