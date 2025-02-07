<%@ page import="com.situ.web.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.situ.web.utils.PageInfo" %><%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/1/23
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<%--${list}--%>
<%
    //JSP页面可以嵌套java代码
    //JSP脚本：在这里可以任意写java代码
    //request、response Jsp页面的内置对象
//    List<Student> list = (List<Student>) request.getAttribute("list");
    PageInfo<Student> pageInfo = (PageInfo<Student>) request.getAttribute("pageInfo");
%>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>ID</td>
        <td>名字</td>
        <td>年龄</td>
        <td>性别</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <%
        for (Student student : pageInfo.getList()) {
    %>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getAge()%></td>
        <td><%=student.getGender()%></td>
<%--        <td><a href="/deleteStudent?id=<%=student.getId()%>">删除</a></td>--%>
        <td><a href="javascript:void(0)" onclick="deleteById(<%=student.getId()%>)">删除</a></td>
        <td><a href="/student?method=toStudentUpdate&id=<%=student.getId()%>">编辑</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="student_add.jsp" class="btn btn-success">添加</a>
<a href="/student?method=toStudentAdd" class="btn btn-success">添加</a>
<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <%
            for (int i = 1; i <= pageInfo.getTotalPage(); i++) {
        %>
        <li><a href="/student?method=selectByPage&pageNo=<%=i%>&pageSize=5"><%=i%></a></li>
        <%
            }
        %>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
<script>
    function deleteById(id) {
        var isDelete = confirm("您真的要删除吗?");
        if(isDelete) {
            location.href = "/student?method=deleteById&id=" + id;
        }
    }
</script>
</body>
</html>
