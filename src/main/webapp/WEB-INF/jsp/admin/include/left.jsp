<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="admin-left">
    <div class="admin-logo">
        <a href="<c:url value='/admin/dashboard'/>" style="text-decoration:none; color:inherit;">
            Dashboard
        </a>
    </div>
    <ul>
        <!-- 관리자관리 -->
        <!-- 관리자관리 -->
        <c:if test="${currentMenu eq 'MEMBER'}">
            <li class="${currentSubMenu eq 'ADMIN_LIST' ? 'active' : ''}">
                <a href="<c:url value='/admin/member/list'/>">관리자 목록</a>
            </li>
        </c:if>

        <!-- 메뉴관리 -->
        <c:if test="${currentMenu eq 'MENU'}">
            <li class="${currentSubMenu eq 'MENU_LIST' ? 'active' : ''}">
                <a href="<c:url value='/admin/menu/manage'/>">사용자 메뉴 관리</a>
            </li>
        </c:if>

        <!-- 통계 -->
        <c:if test="${currentMenu eq 'STATS'}">
            <li class="${currentSubMenu eq 'LOGIN_STATS' ? 'active' : ''}">
                <a href="<c:url value='/admin/stats/login'/>">로그인 통계</a>
            </li>
        </c:if>
    </ul>
</aside>
