<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/admin/include/title.jsp" %>
    <!-- Summernote CSS/JS via CDN -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/lang/summernote-ko-KR.js"></script>
</head>
<body>
    <div class="admin-wrapper">
        <%@ include file="/WEB-INF/jsp/admin/include/left.jsp" %>

        <div class="admin-main">
            <%@ include file="/WEB-INF/jsp/admin/include/header.jsp" %>

            <main class="admin-content">
            <h1>메뉴 콘텐츠 작성 (메뉴ID: ${menuId})</h1>
            
            <form action="${cxt}/admin/content/save" method="post" id="editorForm">
                <input type="hidden" name="menuId" value="${menuId}">
                
                <div style="margin-bottom: 20px;">
                    <textarea id="summernote" name="htmlContent">${content.htmlContent}</textarea>
                </div>
                
                <button type="submit" style="padding: 10px 20px; cursor: pointer;">저장하기</button>
                <a href="${cxt}/admin/menu/manage" style="margin-left: 10px; display: inline-block;">취소 및 목록으로</a>
            </form>
            </main>
            <%@ include file="/WEB-INF/jsp/admin/include/footer.jsp" %>
        </div>
    </div>

    <script>
        $(document).ready(function() {
            $('#summernote').summernote({
                placeholder: '이곳에 페이지 내용을 자유롭게 작성해주세요...',
                tabsize: 2,
                height: 500,
                lang: 'ko-KR',
                toolbar: [
                  ['style', ['style']],
                  ['font', ['bold', 'underline', 'clear']],
                  ['color', ['color']],
                  ['para', ['ul', 'ol', 'paragraph']],
                  ['table', ['table']],
                  ['insert', ['link', 'picture', 'video']],
                  ['view', ['fullscreen', 'codeview', 'help']]
                ]
            });
        });
    </script>
</body>
</html>
