<%@ page import="com.situ.web.pojo.Banji" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<%--${list}--%>
<%
    List<Banji> list = (List<Banji>) request.getAttribute("list");
%>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>ID</td>
        <td>班级</td>
        <td>地址</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
    <%
        for (Banji banji : list) {
    %>
    <tr>
        <td><%=banji.getId()%></td>
        <td><%=banji.getName()%></td>
        <td><%=banji.getAddress()%></td>
<%--        <td><a href="/deleteBanji?id=<%=banji.getId()%>">删除</a></td>--%>
        <td><a href="javascript:void(0)" onclick="deleteById(<%=banji.getId()%>)">删除</a></td>
        <td><a href="/banji?method=selectById&id=<%=banji.getId()%>">编辑</a></td>
    </tr>
    <%
        }
    %>
</table>
<a href="banji_add.jsp" class="btn btn-success">添加</a>
<a href="/banji?method=toBanjiAdd" class="btn btn-success">添加</a>
<script>
    function deleteById(id) {
        var isDelete = confirm("您真的要删除吗?");
        if(isDelete) {
            location.href = "/banji?method=deleteById&id=" + id;
        }
    }
</script>
</body>
</html>
