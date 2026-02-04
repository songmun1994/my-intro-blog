<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/admin/include/title.jsp" %>
</head>
<body class="admin-login-body">

<div class="login-wrapper">
    <div class="login-card">
        <h1 class="login-title">MYHOME ADMIN</h1>
        <p class="login-sub">관리자 로그인</p>

        <form method="post" action="<%=request.getContextPath()%>/admin/login">
            <div class="login-field">
                <input type="text" name="adminId" placeholder="관리자 ID" required />
            </div>

            <div class="login-field">
                <input type="password" name="adminPassword" placeholder="비밀번호" required />
            </div>

            <button type="submit" class="login-btn">로그인</button>
        </form>
    </div>
</div>

</body>
</html>
