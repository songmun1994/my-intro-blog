<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="admin-header">
    <ul class="nav">
        <li><a href="<c:url value='/admin/member/list'/>">관리자관리</a></li>
        <li><a href="<c:url value='/admin/menu/manage'/>">메뉴관리</a></li>
        <li><a href="#">게시판 관리</a></li>
        <li><a href="<c:url value='/admin/stats/login'/>">통계</a></li>
    </ul>
    <div class="user-info">
        <span>Super Admin</span>
    </div>
</header>
