<%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/2/7
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user?method=login" method="post">
        用户名:<input type="text" name="name">
        <br>
        密码:<input type="password" name="password">
        <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
