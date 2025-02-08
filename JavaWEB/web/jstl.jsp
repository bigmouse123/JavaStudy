<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.situ.web.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/2/8
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1、向域对象放数据--%>
<%
    pageContext.setAttribute("age", 23);
    session.setAttribute("gender", "男");
%>
<c:set var="age" value="25" scope="request"></c:set>
<c:set var="gender" value="女" scope="request"></c:set>
${age} <br/>
${requestScope.age}<br>
<%--2、条件判断--%>
<c:if test="${requestScope.gender == '女'}"> women</c:if><br>
<c:if test="${sessionScope.gender == '男'}"> men</c:if><br>
${gender}<br>
<%--3、多条件判断--%>
<c:set var="score" value="78"></c:set>
<c:choose>
    <c:when test="${score >=90 && score <= 100}">
        优秀
    </c:when>
    <c:when test="${score >=80 && score < 90}">
        良好
    </c:when>
    <c:when test="${score >=70 && score < 80}">
        一般
    </c:when>
    <c:when test="${score >=60 && score < 70}">
        及格
    </c:when>
    <c:otherwise>
        不及格
    </c:otherwise>
</c:choose>
<hr/>
<%--4、集合遍历
    List<Student>
    Map<String, String>
    Map<String, Student>
--%>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>
<br/>
<%
    List<Student> list = new ArrayList<>();
    Student student1 = new Student(1, "zhangsan1", 23, "男");
    Student student2 = new Student(2, "zhangsan2", 23, "男");
    Student student3 = new Student(3, "zhangsan3", 23, "男");
    list.add(student1);
    list.add(student2);
    list.add(student3);
    application.setAttribute("list", list);
%>
<c:forEach items="${list}" var="student">
    ${student.id}--${student.name}--${student.age}--${student.gender}<br>
</c:forEach>

<%--Map<String, String>--%>
<%
    Map<String, String> map = new HashMap<>();
    map.put("cn", "中国");
    map.put("us", "美国");
    request.setAttribute("map", map);
%>
<c:forEach items="${map}" var="entry">
    ${entry.key}--${entry.value}<br>
</c:forEach>

<%--Map<String, Student>--%>
<%
    Map<String, Student> studentMap = new HashMap<>();
    studentMap.put("student1", student1);
    studentMap.put("student2", student2);
    studentMap.put("student3", student3);
    request.setAttribute("studentMap", studentMap);
%>
<c:forEach items="${studentMap}" var="entry">
    ${entry.value.id}--${entry.value.name}--${entry.value.age}--${entry.value.gender}<br>
</c:forEach>

</body>
</html>
