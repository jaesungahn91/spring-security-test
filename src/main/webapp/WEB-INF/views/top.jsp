<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <%-- bootstrapk --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">

            <div class="navbar-header">
                <a class="navbar-brand" href="/home">TEST</a>
            </div>

            <sec:authorize access="isAnonymous()">
                <button type="submit" class="btn btn-warning navbar-btn btn-sm navbar-right" style="margin-right: -5px" onclick="location.href='/login'">로그인</button>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <form action="/logout" method="POST" class="navbar-right" style="margin: 0;">
                    <input type="submit" class="btn btn-warning navbar-btn btn-sm" value="로그아웃">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
                <p class="navbar-text navbar-right" style="color: #ffffff; margin-right: 10px;"><sec:authentication property="principal.mname" /> 님 <a href="#" class="navbar-link">[ MYPAGE ]</a></p>
            </sec:authorize>
        </div>

    </nav>
</body>
</html>