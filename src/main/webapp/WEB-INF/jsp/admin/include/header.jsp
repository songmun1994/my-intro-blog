<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="admin-header navbar navbar-dark bg-dark px-4">
    <a class="navbar-brand text-white" href="<c:url value='/admin/dashboard'/>">
        MYHOME ADMIN
    </a>

    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value='/admin/member/list'/>">관리자관리</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value='/admin/menu/manage'/>">메뉴관리</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-white" href="#">게시판 관리</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-white" href="<c:url value='/admin/stats/login'/>">통계</a>
        </li>
    </ul>
</nav>
