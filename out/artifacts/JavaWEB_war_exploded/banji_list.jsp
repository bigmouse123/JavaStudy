<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap-3.4.1-dist/css/bootstrap.css">
</head>
<body>
<table class="table table-striped table-bordered table-hover table-condensed">
    <tr>
        <td>ID</td>
        <td>班级</td>
        <td>地址</td>
        <td>删除</td>
        <td>编辑</td>
    </tr>
        <c:forEach items="${pageInfo.list}" var="banji">
            <tr>
                <td>${banji.id}</td>
                <td>${banji.name}</td>
                <td>${banji.address}</td>
                <td><a href="javascript:void(0)" onclick="deleteById(${banji.id})">删除</a></td>
                <td><a href="/banji?method=toBanjiUpdate&id=${banji.id}">编辑</a></td>
            </tr>
        </c:forEach>
</table>
<a href="banji_add.jsp" class="btn btn-success">添加</a>
<a href="/banji?method=toBanjiAdd" class="btn btn-success">添加</a>
<nav aria-label="Page navigation">
    <ul class="pagination">
        <c:if test="${1==pageInfo.pageNo}">
            <li class="disabled">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${1!=pageInfo.pageNo}">
            <li>
                <a href="/banji?method=selectByPage&pageNo=${pageInfo.pageNo-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${pageInfo.totalPage}" var="i" step="1">
            <c:if test="${i==pageInfo.pageNo}">
                <li class="active"><a href="#">${i}</a></li>
            </c:if>
            <c:if test="${i!=pageInfo.pageNo}">
                <li><a href="/banji?method=selectByPage&pageNo=${i}&pageSize=5">${i}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${pageInfo.totalPage==pageInfo.pageNo}">
            <li class="disabled">
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageInfo.totalPage!=pageInfo.pageNo}">
            <li>
                <a href="/banji?method=selectByPage&pageNo=${pageInfo.pageNo+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>
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
