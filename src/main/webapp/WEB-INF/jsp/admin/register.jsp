<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Admin Register</title>
    <style>
        .field { margin: 10px 0; }
        .error { color: #d00; margin: 8px 0; }
        .hint { color: #666; font-size: 12px; margin-top: 4px; }
        label { font-weight: 600; }
        input { padding: 6px 8px; width: 320px; max-width: 100%; }
        button { padding: 8px 14px; cursor: pointer; }
    </style>
</head>
<body>

<h1>관리자 등록</h1>

<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<p id="clientError" class="error" style="display:none;"></p>

<form id="regForm" method="post" action="<%=request.getContextPath()%>/admin/register" novalidate>
    <div class="field">
        <label for="adminId">관리자 ID</label><br/>
        <input id="adminId" name="adminId" type="text" maxlength="50" required
               autocomplete="username" />
        <div class="hint">영문/숫자/._- 4~20자 권장</div>
    </div>

    <div class="field">
        <label for="adminPassword">비밀번호</label><br/>
        <input id="adminPassword" name="inputPassword" type="password" maxlength="100" required
               autocomplete="new-password" />
        <div class="hint">최소 10자, 영문+숫자 필수, 특수문자 권장</div>
    </div>

    <div class="field">
        <label for="adminPassword2">비밀번호 확인</label><br/>
        <input id="adminPassword2" type="password" maxlength="100" required
               autocomplete="new-password" />
    </div>

    <div class="field">
        <label for="adminName">이름</label><br/>
        <input id="adminName" name="adminName" type="text" maxlength="50" />
    </div>

    <div class="field">
        <label for="adminGroup">그룹</label><br/>
        <input id="adminGroup" name="adminGroup" type="text" maxlength="50" value="SUPER" />
    </div>

    <div class="field">
        <label for="adminEmail">이메일</label><br/>
        <input id="adminEmail" name="adminEmail" type="email" maxlength="100" />
    </div>

    <button id="submitBtn" type="submit">등록</button>
</form>

<hr/>
<p><a href="<%=request.getContextPath()%>/admin/login">관리자 로그인</a></p>

<!-- ✅ 스크립트는 최하단 -->
<script>
    (function () {
        'use strict';

        var form = document.getElementById('regForm');
        var errBox = document.getElementById('clientError');

        var adminIdEl = document.getElementById('adminId');
        var pwEl = document.getElementById('adminPassword');
        var pw2El = document.getElementById('adminPassword2');
        var nameEl = document.getElementById('adminName');
        var groupEl = document.getElementById('adminGroup');
        var emailEl = document.getElementById('adminEmail');

        // 규칙
        var ID_RE = /^[a-zA-Z0-9._-]{4,20}$/;
        var HAS_LETTER_RE = /[A-Za-z]/;
        var HAS_NUMBER_RE = /[0-9]/;
        var HAS_SPECIAL_RE = /[^A-Za-z0-9]/;
        // 이메일은 브라우저 기본(type=email)도 체크하지만, 한번 더 엄격하게
        var EMAIL_RE = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        function showError(msg, focusEl) {
            errBox.textContent = msg;
            errBox.style.display = 'block';
            if (focusEl && typeof focusEl.focus === 'function') focusEl.focus();
        }

        function clearError() {
            errBox.textContent = '';
            errBox.style.display = 'none';
        }

        function trim(v) {
            return (v || '').replace(/^\s+|\s+$/g, '');
        }

        function validate() {
            clearError();

            var adminId = trim(adminIdEl.value);
            var pw = pwEl.value || '';
            var pw2 = pw2El.value || '';
            var adminName = trim(nameEl.value);
            var adminGroup = trim(groupEl.value);
            var email = trim(emailEl.value);

            // ID
            if (!adminId) return showError('관리자 ID는 필수입니다.', adminIdEl), false;
            if (!ID_RE.test(adminId)) {
                return showError('관리자 ID 형식이 올바르지 않습니다. (영문/숫자/._- 4~20자)', adminIdEl), false;
            }

            // Password
            if (!pw) return showError('비밀번호는 필수입니다.', pwEl), false;
            if (pw.length < 10) return showError('비밀번호는 최소 10자 이상이어야 합니다.', pwEl), false;
            if (!HAS_LETTER_RE.test(pw) || !HAS_NUMBER_RE.test(pw)) {
                return showError('비밀번호는 영문과 숫자를 반드시 포함해야 합니다.', pwEl), false;
            }
            // 특수문자 권장은 경고로만 (필수로 강제하려면 if로 막아도 됨)
            // if (!HAS_SPECIAL_RE.test(pw)) { ... }

            if (pw !== pw2) return showError('비밀번호 확인이 일치하지 않습니다.', pw2El), false;

            // Name (선택값이지만, 입력했으면 최소 2자 정도)
            if (adminName && adminName.length < 2) {
                return showError('이름은 2자 이상 입력해 주세요.', nameEl), false;
            }

            // Group (선택이지만, 공백이면 SUPER로 강제)
            if (!adminGroup) {
                groupEl.value = 'SUPER';
            } else {
                groupEl.value = adminGroup;
            }

            // Email (선택값이지만, 입력했으면 형식 체크)
            if (email) {
                if (email.length > 100) return showError('이메일은 100자 이하여야 합니다.', emailEl), false;
                if (!EMAIL_RE.test(email)) return showError('이메일 형식이 올바르지 않습니다.', emailEl), false;
                emailEl.value = email;
            }

            // trim 반영
            adminIdEl.value = adminId;
            nameEl.value = adminName;

            return true;
        }

        // 실시간 에러 지우기
        ['input', 'change'].forEach(function (evt) {
            form.addEventListener(evt, function () {
                if (errBox.style.display === 'block') clearError();
            });
        });

        form.addEventListener('submit', function (e) {
            if (!validate()) {
                e.preventDefault();
                return false;
            }
        });
    })();
</script>

</body>
</html>
