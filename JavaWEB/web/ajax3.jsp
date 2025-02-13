<%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/2/13
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
省份：
<select id="provinceId">
    <option>---请选择省份--</option>
</select>
城市：
<select id="cityId">
    <option>---请选择城市--</option>
</select>
区县：
<select id="areaId">
    <option>---请选择区县--</option>
</select>

<script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
<script>
    $(function () {
        $.post(
            '/ajax3?method=selectProvince',
            function (jsonObj) {
                $(jsonObj).each(function () {
                    $('#provinceId').append('<option value = "' + this.id + '">' + this.name + '</option');
                })
                console.log(jsonObj);
            },
            'json'
        )
    })

    $("#provinceId").change(function () {
        $.post(
            '/ajax3?method=selectCity',
            {'provinceId': $(this).val()},
            function (jsonObj) {
                console.log(jsonObj);
                $('#cityId option:gt(0)').remove();
                $(jsonObj).each(function () {
                    $('#cityId').append('<option value = "' + this.id + '">' + this.name + '</option');
                });
            },
            'json'
        )
    })

    $("#cityId").change(function () {
        $.post(
            '/ajax3?method=selectArea',
            {'cityId': $(this).val()},
            function (jsonObj) {
                console.log(jsonObj);
                $('#areaId option:gt(0)').remove();
                $(jsonObj).each(function () {
                    $('#areaId').append('<option value = "' + this.id + '">' + this.name + '</option');
                });
            },
            'json'
        )
    })
</script>
</body>
</html>
