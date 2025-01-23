<%@ page import="java.util.LinkedList" %>
<%@ page import="com.situ.web.pojo.Teacher" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/1/23
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<%
    List<Teacher> list = (List<Teacher>) request.getAttribute("list");
%>
    <table class="table table-striped table-bordered table-hover table-condensed">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>地址</td>
            <td>删除</td>
        </tr>
        <%
            for (Teacher teacher : list) {
        %>
        <tr>
            <td><%=teacher.getId()%></td>
            <td><%=teacher.getName()%></td>
            <td><%=teacher.getAge()%></td>
            <td><%=teacher.getAddress()%></td>
            <td>
                <a href="javascript:void(0)" onclick="deleteById(<%=teacher.getId()%>)">
                    删除
                </a>
            </td>
        </tr>
        <%
            }
        %>

    </table>
<script>
    function deleteById(id) {
        var isDelete = confirm("您确定要删除吗?")
        if (isDelete) {
            location.href = "/teacher?method=deleteById&id=" + id;
        }
    }
</script>
</body>
</html>
