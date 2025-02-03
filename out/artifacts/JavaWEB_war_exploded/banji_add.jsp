<%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/1/24
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/banji?method=add" method="post">
        班级名:<input type="text" name="name"><br>
        地址:<input type="text" name="address"><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
