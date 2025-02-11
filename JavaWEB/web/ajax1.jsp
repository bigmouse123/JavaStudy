<%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/2/11
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="test1()">ajax get</button>
<button onclick="test2()">ajax post</button>
<button onclick="test3()">ajax</button>
<script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
<script>

    function ajaxGet() {
        //$.get(url, [data], [callback], [type])  后面三个是可选的可以没有
        $.get(
            'ajax1',
            {"name": "张三1"},
            function (jsonObj) { //回调函数
                console.log(jsonObj);
            },
            'json'
        );
    }

    function ajaxPost() {
        //$.post(url, [data], [callback], [type])  后面三个是可选的可以没有
        $.post(
            'ajax1',
            {"name": "张三2"},
            function (jsonObj) { //回调函数
                console.log(jsonObj);
            },
            'json'
        );
    }

    function ajax() {
        $.ajax(
            {
                async: true,
                type: 'post',
                url: 'ajax1',
                data: {'name': "张三"},
                success: function (jsonObj) {
                    console.log(jsonObj)
                },
                dataType: 'json'
            }
        )
    }

    function test1() {
        $.get(
            '/ajax1',
            {
                'name': '张三a',
                'age': 21
            },
            function (jsonObj) {
                console.log(jsonObj)
            },
            'json'
        )
    }

    function test2() {
        $.post(
            '/ajax1',
            {
                'name': '张三b',
                'age': 22
            },
            function (jsonObj) {
                console.log(jsonObj)
            },
            'json'
        )
    }

    function test3() {
        $.ajax(
            {
                async: true,
                type: 'post',
                url: '/ajax1',
                data: {'name': '张三c', 'age': 23},
                success(jsonObj) {
                    console.log(jsonObj);
                },
                dataType: 'json'
            }
        )
    }
</script>
</body>

</html>
