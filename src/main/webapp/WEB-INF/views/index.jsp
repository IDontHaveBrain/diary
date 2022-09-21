<%--
  Created by IntelliJ IDEA.
  User: SQI
  Date: 2022-09-21
  Time: 오후 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인된 계정 정보</h1>
<h3>${user.id}</h3>
<h3>${user.nick}</h3>
<h3>${user.email}</h3>

</body>
</html>
