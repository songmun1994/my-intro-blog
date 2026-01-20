<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Admin DashBoard</title>
</head>
<body>

<h1>✅ 로그인 성공 대시보드</h1>

<p>
    id : <%= (session.getAttribute("LOGIN_ADMIN_ID") == null ? "" : session.getAttribute("LOGIN_ADMIN_ID")) %><br/>
    name : <%= (session.getAttribute("LOGIN_ADMIN_NAME") == null ? "" : session.getAttribute("LOGIN_ADMIN_NAME")) %><br/>
    email : <%= (session.getAttribute("LOGIN_ADMIN_EMAIL") == null ? "" : session.getAttribute("LOGIN_ADMIN_EMAIL")) %>
</p>

</body>
</html>
