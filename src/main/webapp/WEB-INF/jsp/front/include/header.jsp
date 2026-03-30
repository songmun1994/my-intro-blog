<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String currentContext = request.getContextPath();
    request.setAttribute("cxt", currentContext);
%>
<link rel="stylesheet" href="${cxt}/resources/css/front.css?v=2">
<header class="front-header">
    <div class="front-logo">
        <a href="${cxt}/">MY INTRO BLOG</a>
    </div>
    <nav>
        <ul class="front-nav">
            <c:forEach var="menu" items="${globalMenuList}">
                <li>
                    <c:choose>
                        <c:when test="${menu.menuType eq 'HTML'}">
                            <a href="${cxt}/page/${menu.menuId}">${menu.menuName}</a>
                        </c:when>
                        <c:when test="${menu.menuType eq 'BOARD'}">
                            <a href="${cxt}/board/${menu.menuId}">${menu.menuName}</a>
                        </c:when>
                        <c:when test="${menu.menuType eq 'URL'}">
                            <a href="${menu.menuUrl}">${menu.menuName}</a>
                        </c:when>
                        <c:otherwise>
                            <span>${menu.menuName}</span>
                        </c:otherwise>
                    </c:choose>
                </li>
            </c:forEach>
        </ul>
    </nav>
</header>
