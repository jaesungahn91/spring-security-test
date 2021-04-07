<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>

    <%-- RSA --%>
    <script src="/resources/js/jsbn.js"></script>
    <script src="/resources/js/prng4.js"></script>
    <script src="/resources/js/rng.js"></script>
    <script src="/resources/js/rsa.js"></script>

    <title>로그인</title>
    <script>
        $(document).ready(function () {
            $("#goBtn").click(function () {

                /*var formData = $("#loginForm").serialize();*/
                var id = $("#memail").val();
                var pwd = $("#mpwd").val();

                /*console.log(formData);*/

                if(id == "" || pwd == ""){
                    alert("아이디 또는 패스워드를 입력하세요.");
                    return false;
                }

                $("#submit").click();

                /*$.ajax({
                    url: "/loginCheck",
                    type : "POST",
                    data : formData,
                    dataType : 'json',
                    success : function (result) {
                        if(result > 0){
                            alert("로그인 되었습니다.");
                        }else{
                            alert("아이디 또는 패스워드가 일치하지 않습니다.");
                        }
                    }
                });*/

            });
        });

    </script>
</head>
<body style="padding-top: 70px;">
    <jsp:include page="../top.jsp"></jsp:include>

    <div class="panel panel-info" style="width: 300px; margin: 200px auto 0 auto; border-color: #000000;">
        <div class="panel-heading" style="background-image: linear-gradient(to bottom,#000000 0,#4a4a4a 100%); color: #ffffff; background-color: #000000; border-color: #000000;">
            <h3 class="panel-title" style="text-align: center;">로그인</h3>
        </div>
        <div class="panel-body" style="text-align: center;">

            <form id="loginForm" action="/loginCheck" method="POST" style="margin: 0">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                아이디
                <input type="text" class="form-control" name="memail" id="memail" value="${loginfail}" style="margin-bottom: 15px;">
                비밀번호
                <input type="password" class="form-control" name="mpwd" id="mpwd" style="margin-bottom: 15px;">
                <c:if test="${not empty loginfail}">
                    <font color="red">
                        <p>아이디 또는 비밀번호가 <br>일치하지 않습니다. </p>
                    </font>
                </c:if>
                자동 로그인 <input type="checkbox" name="remember-me"><br>
                <a href="#">비밀번호를 잊으셨나요?</a><br>
                <button class="btn btn-warning btn-sm" type="button" id="goBtn" style="margin-top: 15px;">로그인</button>
                <button class="btn btn-success btn-sm" type="button" id="reg" onclick="location.href='/registerForm'" style="margin-top: 15px;">회원가입</button>
                <button style="display: none;" type="submit" id="submit"/>
            </form>

        </div>
    </div>

</body>
</html>