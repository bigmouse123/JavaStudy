<%@ page import="com.situ.web.pojo.Banji" %><%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/1/24
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Banji banji = (Banji) request.getAttribute("banji");
%>
    <form action="/banji?method=update" method="post">
        <input type="hidden" name="id" value="<%=banji.getId()%>">
        班级名:<input type="text" name="name" value="<%=banji.getName()%>"><br>
        地址:<input type="text" name="address" value="<%=banji.getAddress()%>"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
