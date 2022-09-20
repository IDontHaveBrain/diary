<%--
  Created by IntelliJ IDEA.
  User: SQI
  Date: 2022-09-20
  Time: 오전 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원가입</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script src="/jquery-3.6.1.min.js"></script>
</head>
<body>
<script>
    function signup() {
        if ($("#pw").val() != $("#pw2").val()) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }
        $('form').submit();
    }

    function checkEmail() {
        $.ajax({
            url: "/checkEmail",
            type: "post",
            data: {
                email: $("#email").val()
            },
            success: function (data) {
                console.log(data);
                if (data == false) {
                    alert("사용 가능한 이메일입니다.");
                } else {
                    alert("이미 사용중인 이메일입니다.");
                }
            }
        })
    }
</script>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h1>회원가입</h1>
            <form action="/signup" method="post">
                <label for="email">Email</label>
                <div class="input-group">
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}" placeholder="Email">
                    <button type="button" class="btn btn btn-outline-secondary" onclick="checkEmail()">Check</button>
                </div>
                <span class="text-danger">${errors.email}</span>
                <div class="form-group">
                    <label for="pw">비밀번호</label>
                    <input type="password" class="form-control" id="pw" name="pw" placeholder="Password">
                    <span class="text-danger">${errors.pw}</span>
                </div>
                <div class="form-group">
                    <label for="pw2">비밀번호 확인</label>
                    <input type="password" class="form-control" id="pw2" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="nick">닉네임</label>
                    <input type="text" class="form-control" id="nick" name="nick" placeholder="Nickname">
                    <span class="text-danger">${errors.nick}</span>
                </div>
                <button type="button" class="btn btn-primary" onclick="signup();">Sign up</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
