<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>类目编辑</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container">

    <%@include file="header.jsp" %>

    <br><br>

    <form class="form-horizontal" action="typeUpdate" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${type.id}">
        <div class="form-group">
            <label for="name" class="col-sm-1 control-label">名称</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="name" name="name" value="${type.name}"
                       required="required">
            </div>
        </div>
        <div class="form-group">
            <label for="num" class="col-sm-1 control-label">序号</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="num" name="num" value="${type.num}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <button type="submit" class="btn btn-success">提交修改</button>
            </div>
        </div>
    </form>

    <span style="color:red;">${msg}</span>

</div>
</body>
</html>