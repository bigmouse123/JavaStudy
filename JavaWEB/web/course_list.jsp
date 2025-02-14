<%--
  Created by IntelliJ IDEA.
  User: a1595
  Date: 2025/2/14
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="static/layui/css/layui.css">
</head>
<body>
<script src="/static/jquery-2.1.4.js" type="text/javascript" charset="utf-8"></script>
<script src="/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="/static/mylayer.js" type="text/javascript" charset="utf-8"></script>

<table class="layui-hide" id="tableId" lay-filter="tableId"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        <button class="layui-btn layui-btn-sm" lay-event="deleteAll">批量删除</button>
    </div>
</script>

<script type="text/html" id="toolDemo">
    <div class="layui-clear-space">
        <a class="layui-btn layui-btn-xs" lay-event="update">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="deleteById">删除</a>
    </div>
</script>

<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table;

        table.render({
            elem: '#tableId'
            , url: '/course'
            , toolbar: '#toolbarDemo'
            , cols:
                [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'id', title: 'ID', sort: true}
                    , {field: 'name', title: '课程名称'}
                    , {field: 'credit', title: '学分', sort: true}
                    , {fixed: 'right', title: '操作', width: 134, minWidth: 125, templet: '#toolDemo'}
                ]]
            , page:
                true
        });

        // 触发单元格工具事件
        table.on('tool(tableId)', function (obj) { // 双击 toolDouble
            var data = obj.data; // 获得当前行数据
            // {id:12,name:'Java',credit:3}
            console.log(data)
            if (obj.event === 'update') {
                layer.open({
                    title: '编辑 - id:' + data.id,
                    type: 1,
                    area: ['80%', '80%'],
                    content: '<div style="padding: 16px;">自定义表单元素</div>'
                });
            } else if (obj.event === 'deleteById') {
                layer.confirm('您确认要删除么?', function () {
                    $.post(
                        '/course?method=deleteById',
                        {'id': data.id},
                        function (result) {
                            console.log(result);
                            if (result.code == 0) {
                                mylayer.okMsg(result.msg);
                                //删除数据之后刷新表格，展示最新数据
                                table.reload('tableId');
                            } else {
                                mylayer.errorMsg(result.msg);
                            }
                        },
                        'json'
                    );
                });
            }
        });

        // 头部工具栏事件
        table.on('toolbar(tableId)', function (obj) {
            var id = obj.config.id;
            var checkStatus = table.checkStatus(id);
            var othis = lay(this);
            console.log(obj);
            // 根据不同的事件名进行相应的操作
            switch (obj.event) { // 对应模板元素中的 lay-event 属性值
                case 'add':
                    layer.open({
                        type: 2,
                        title: '添加数据',
                        area: ['90%', '90%'],
                        content: '/course_add.jsp'
                    });
                    break;
                case 'deleteAll':
                    layer.msg('删除');
                    break;
            }
        });
    });
</script>
</body>
</html>
