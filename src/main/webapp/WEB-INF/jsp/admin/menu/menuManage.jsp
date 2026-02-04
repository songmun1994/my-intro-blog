<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/admin/include/title.jsp" %>
</head>
<body>
    <%@ include file="/WEB-INF/jsp/admin/include/header.jsp" %>

    <div class="admin-container">

        <main class="admin-content">
            <h1>사용자 메뉴 관리</h1>

            <div style="margin-bottom:15px;">
                <a href="${pageContext.request.contextPath}/admin/menu/form"
                   class="btn">➕ 최상위 메뉴 등록</a>
            </div>

            <ul>
                <c:forEach var="m1" items="${menuList}">
                    <c:if test="${m1.menuDepth eq '1'}">
                        <li>
                            <strong>
                                <a href="${cxt}/admin/menu/form?menuIdx=${m1.menuIdx}">
                                        ${m1.menuName}
                                </a>
                            </strong>
                            <a href="${cxt}/admin/menu/form?parentMenuIdx=${m1.menuIdx}&menuDepth=2">
                                [하위메뉴 추가]
                            </a>

                            <ul>
                                <c:forEach var="m2" items="${menuList}">
                                    <c:if test="${m2.parentMenuIdx eq m1.menuIdx}">
                                        <li>
                                            <a href="${cxt}/admin/menu/form?menuIdx=${m2.menuIdx}">
                                                    ${m2.menuName}
                                            </a>
                                            <a href="${cxt}/admin/menu/form?parentMenuIdx=${m2.menuIdx}&menuDepth=3">
                                                [하위메뉴 추가]
                                            </a>

                                            <ul>
                                                <c:forEach var="m3" items="${menuList}">
                                                    <c:if test="${m3.parentMenuIdx eq m2.menuIdx}">
                                                        <li>
                                                            <a href="${cxt}/admin/menu/form?menuIdx=${m3.menuIdx}">
                                                                    ${m3.menuName}
                                                            </a>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>

                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </main>
    </div>
    <%@ include file="/WEB-INF/jsp/admin/include/footer.jsp" %>
</body>
</html>
