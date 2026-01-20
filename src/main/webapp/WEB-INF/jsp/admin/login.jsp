<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Admin Login</title>
</head>
<body>
<h1>✅ Admin Login</h1>
<p>관리자 로그인부터 시작</p>

<form method="post" action="<%=request.getContextPath()%>/admin/login">
    <input name="adminId" placeholder="아이디" />
    <input type="password" name="adminPassword" placeholder="비밀번호" />
    <button type="submit">로그인</button>
</form>
</body>
</html>
