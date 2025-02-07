<%@ page import="com.situ.web.pojo.Teacher" %>
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
//    List<Teacher> list = (List<Teacher>) request.getAttribute("list");
    PageInfo<Teacher> pageInfo = (PageInfo<Teacher>) request.getAttribute("pageInfo");
%>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>ID</td>
        <td>名字</td>
        <td>年龄</td>
        <td>地址</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <%
        for (Teacher teacher : pageInfo.getList()) {
    %>
    <tr>
        <td><%=teacher.getId()%></td>
        <td><%=teacher.getName()%></td>
        <td><%=teacher.getAge()%></td>
        <td><%=teacher.getAddress()%></td>
<%--        <td><a href="/deleteTeacher?id=<%=teacher.getId()%>">删除</a></td>--%>
        <td><a href="javascript:void(0)" onclick="deleteById(<%=teacher.getId()%>)">删除</a></td>
        <td><a href="/teacher?method=toTeacherUpdate&id=<%=teacher.getId()%>">编辑</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="teacher_add.jsp" class="btn btn-success">添加</a>
<a href="/teacher?method=toTeacherAdd" class="btn btn-success">添加</a>
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
        <li><a href="/teacher?method=selectByPage&pageNo=<%=i%>&pageSize=5"><%=i%></a></li>
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
            location.href = "/teacher?method=deleteById&id=" + id;
        }
    }
</script>
</body>
</html>
