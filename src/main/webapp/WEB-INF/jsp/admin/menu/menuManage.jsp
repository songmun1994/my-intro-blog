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
            <h1>사용자 메뉴 관리</h1>

            <div class="page-actions">
                <a href="${cxt}/admin/menu/form" class="btn btn-primary">
                    최상위 메뉴 등록
                </a>
            </div>


            <table class="admin-table">
                <thead>
                <tr>
                    <th>메뉴명</th>
                    <th>메뉴 ID</th>
                    <th>뎁스</th>
                    <th>타입</th>
                    <th>노출</th>
                    <th>관리</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="m" items="${menuList}">
                    <tr>
                        <td>
                            <c:if test="${m.menuDepth eq 2}">└ </c:if>
                            <c:if test="${m.menuDepth eq 3}">&nbsp;&nbsp;└ </c:if>
                                ${m.menuName}
                        </td>
                        <td>${m.menuId}</td>
                        <td>${m.menuDepth}</td>
                        <td>${m.menuType}</td>
                        <td>${m.exposeYn}</td>
                        <td>
                            <div class="btn-group">
                                <a href="${cxt}/admin/menu/form?menuIdx=${m.menuIdx}"
                                   class="btn btn-edit">수정</a>
                                <c:if test="${m.menuType eq 'HTML'}">
                                    <a href="${cxt}/admin/content/edit?menuId=${m.menuId}"
                                       class="btn btn-primary">내용작성</a>
                                </c:if>
                                <a href="${cxt}/admin/menu/form?parentMenuIdx=${m.menuIdx}&menuDepth=${m.menuDepth + 1}"
                                   class="btn btn-sub">하위추가</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            </main>
            <%@ include file="/WEB-INF/jsp/admin/include/footer.jsp" %>
        </div>
    </div>
</body>
</html>
