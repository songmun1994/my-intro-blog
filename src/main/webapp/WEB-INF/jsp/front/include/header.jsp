<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String currentContext = request.getContextPath();
    request.setAttribute("cxt", currentContext);
%>
<header style="background-color: #f8f9fa; padding: 15px 30px; border-bottom: 1px solid #ddd; display: flex; justify-content: space-between; align-items: center;">
    <div>
        <h2 style="margin: 0;"><a href="${cxt}/" style="text-decoration: none; color: #333;">My Intro Blog</a></h2>
    </div>
    <nav>
        <ul style="list-style: none; margin: 0; padding: 0; display: flex; gap: 20px;">
            <c:forEach var="menu" items="${globalMenuList}">
                <li>
                    <c:choose>
                        <c:when test="${menu.menuType eq 'HTML'}">
                            <a href="${cxt}/page/${menu.menuId}" style="text-decoration: none; color: #555; font-weight: bold;">${menu.menuName}</a>
                        </c:when>
                        <c:when test="${menu.menuType eq 'BOARD'}">
                            <a href="${cxt}/board/${menu.menuId}" style="text-decoration: none; color: #555; font-weight: bold;">${menu.menuName}</a>
                        </c:when>
                        <c:when test="${menu.menuType eq 'URL'}">
                            <a href="${menu.menuUrl}" style="text-decoration: none; color: #555; font-weight: bold;">${menu.menuName}</a>
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
