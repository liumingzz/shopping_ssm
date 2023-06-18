<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>客户列表</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <style>
        .input_span{
            margin-right: 20px;
        }
    </style>
</head>
<body>
<div class="container">

    <%@include file="header.jsp" %>
    <form method="get" action="commentList">
        <span class="input_span">商品名称：<input name="goodname" type="text" class="input-group" style="display: inline"></span>
        <span class="input_span">用户名：<input name="username" type="text" class="input-group" style="display: inline"></span>
        <span><input type="submit" value="搜索" class="btn btn-success btn-sm"></span>
    </form>
    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="10%">商品名称</th>
            <th width="5%">用户名</th>
            <th width="15%">评论内容</th>
            <th width="10%">评论时间</th>
            <th width="5%">操作</th>
        </tr>

        <c:forEach var="evaluate" items="${evaluates}">
            <tr>
                <td><p>${evaluate.goodName}</p></td>
                <td><p>${evaluate.user.name}</p></td>
                <td><p>${evaluate.content}</p></td>
                <td><p>${evaluate.getDateString()}</p></td>
                <td>
                    <a class="btn btn-primary" href="commentEdit?gid=${evaluate.gid}&oid=${evaluate.oid}">修改</a>
                    <a class="btn btn-danger" href="deleteComment?gid=${evaluate.gid}&oid=${evaluate.oid}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <br>${pageTool}<br>
</div>
<script>
    var msg = null;
    msg = "${msg}"+"";
    if (msg != null && msg!=""){
        alert(msg);
    }
</script>
</body>
</html>