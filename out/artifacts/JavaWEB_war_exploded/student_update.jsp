<%@ page import="com.situ.web.pojo.Student" %><%--
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
    Student student = (Student) request.getAttribute("student");
%>
    <form action="/student?method=update" method="post">
        <input type="hidden" name="id" value="<%=student.getId()%>">
        用户名:<input type="text" name="name" value="<%=student.getName()%>"><br>
        年龄:<input type="text" name="age" value="<%=student.getAge()%>"><br>
        性别:<input type="text" name="gender" value="<%=student.getGender()%>"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
