<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/admin/include/title.jsp" %>
</head>
<body>

<div class="admin-wrapper">
    <%@ include file="/WEB-INF/jsp/admin/include/left.jsp" %>
    
    <div class="admin-main">
        <%@ include file="/WEB-INF/jsp/admin/include/header.jsp" %>
        
        <main class="admin-content">
        <h1>관리자 대시보드</h1>
        <p>환영합니다, ${sessionScope.LOGIN_ADMIN_ID} 님</p>

        <div class="dashboard-box">
            <p>로그인 통계 요약 (예정)</p>
            <p>최근 관리자 활동 로그 (예정)</p>
        </div>
        </main>
        
        <%@ include file="/WEB-INF/jsp/admin/include/footer.jsp" %>
    </div>
</div>

</body>
</html>
