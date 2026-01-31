<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>메뉴 ${empty menu.menuIdx ? '등록' : '수정'}</h1>

<form method="post" action="${cxt}/admin/menu/save" id="menuForm">

    <input type="hidden" name="menuIdx" value="${menu.menuIdx}">
    <input type="hidden" name="parentMenuIdx" value="${menu.parentMenuIdx}">
    <input type="hidden" name="menuDepth" value="${menu.menuDepth}">

    <div>
        <label>메뉴 ID</label><br>
        <input name="menuId" value="${menu.menuId}"
               required pattern="[a-z0-9_]+">
    </div>

    <div>
        <label>메뉴명</label><br>
        <input name="menuName" value="${menu.menuName}" required>
    </div>

    <div>
        <label>메뉴 설명</label><br>
        <input name="menuDesc" value="${menu.menuDesc}">
    </div>

    <div>
        <label>페이지 타입</label><br>
        <select name="menuType" id="menuType">
            <option value="BOARD">BOARD</option>
            <option value="HTML">HTML</option>
            <option value="URL">URL</option>
        </select>
    </div>

    <div id="urlBox" style="display:none;">
        <label>URL</label><br>
        <input name="menuUrl" value="${menu.menuUrl}">
    </div>

    <div>
        <label>노출 여부</label>
        <select name="exposeYn">
            <option value="Y">노출</option>
            <option value="N">숨김</option>
        </select>
    </div>

    <button type="submit">저장</button>
    <a href="${cxt}/admin/menu/manage">목록</a>

</form>

<script>
    (function(){
        const type = document.getElementById('menuType');
        const urlBox = document.getElementById('urlBox');

        function toggleUrl(){
            urlBox.style.display = (type.value === 'URL') ? 'block' : 'none';
        }

        type.addEventListener('change', toggleUrl);
        toggleUrl();
    })();
</script>
