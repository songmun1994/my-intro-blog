<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>My Intro Blog</title>
</head>
<body>
    <%@ include file="/WEB-INF/jsp/front/include/header.jsp" %>
    
    <main class="front-main">
        <div class="page-container">
            <!-- 에디터로 작성한 HTML 콘텐츠 출력 ('escapeXml' 필수 false) -->
            <c:out value="${pageContent}" escapeXml="false" />
        </div>
    </main>
</body>
</html>
