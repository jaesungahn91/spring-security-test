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

    <title>Home</title>
</head>
<body style="padding-top: 70px;">
<jsp:include page="top.jsp"></jsp:include>

<a href="/test">테스트</a>
${pageContext.request.contextPath}@@@@<br>
${pageContext.request.requestURL}@@@<br>
${pageContext.request.requestURI}@@<br>
${pageContext.request.contextPath}@<br>
${contextPath}!!!
<sec:authorize access="isAnonymous()">
    <a href="/login">로그인</a> / <a href="/registerForm">회원가입</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <form action="/logout" method="POST">
        <input type="submit" value="로그아웃">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</sec:authorize>


</body>
</html>