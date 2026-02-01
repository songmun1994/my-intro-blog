<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="admin-left">
  <ul class="list-group list-group-flush">

    <!-- 관리자관리 -->
    <c:if test="${currentMenu eq 'MEMBER'}">
      <li class="list-group-item ${currentSubMenu eq 'ADMIN_LIST' ? 'active' : ''}">
        <a href="<c:url value='/admin/admin/list'/>">관리자 목록</a>
      </li>
    </c:if>

    <!-- 메뉴관리 -->
    <c:if test="${currentMenu eq 'MENU'}">
      <li class="list-group-item ${currentSubMenu eq 'MENU_LIST' ? 'active' : ''}">
        <a href="<c:url value='/admin/menu/list'/>">사용자 메뉴 관리</a>
      </li>
    </c:if>

    <!-- 통계 -->
    <c:if test="${currentMenu eq 'STATS'}">
      <li class="list-group-item ${currentSubMenu eq 'LOGIN_STATS' ? 'active' : ''}">
        <a href="<c:url value='/admin/stats/login'/>">로그인 통계</a>
      </li>
    </c:if>

  </ul>
</div>

