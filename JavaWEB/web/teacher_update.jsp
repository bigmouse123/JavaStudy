<%@ page import="com.situ.web.pojo.Teacher" %><%--
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
    Teacher teacher = (Teacher) request.getAttribute("teacher");
%>
    <form action="/teacher?method=update" method="post">
        <input type="hidden" name="id" value="<%=teacher.getId()%>">
        用户名:<input type="text" name="name" value="<%=teacher.getName()%>"><br>
        年龄:<input type="text" name="age" value="<%=teacher.getAge()%>"><br>
        性别:<input type="text" name="address" value="<%=teacher.getAddress()%>"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
