<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">

    <link rel="stylesheet" type="text/css" href="css/login.css">

</head>

<!-- 设置背景图片 -->
<body class="rebackgroundimg">

<a style="float: right;margin: 10px ;color: white;font-weight: bold;padding: 5px" class="label label-success" href="${pageContext.servletContext.contextPath}">进入前台</a>
<div class="container">

    <c:if test="${msg!=null}">
        <div class="alert alert-danger text-center">${msg}</div>
    </c:if>


    <form class="form-horizontal" action="login" method="post" style="margin-top:15%;">
        <h2 class="text-center" style="color: white">登录后台</h2>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-4">
                <input type="text" class="form-control" value="admin" style="height:auto;padding:10px;" placeholder="输入用户名"
                       name="username">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-4">
                <input type="password" class="form-control" value="admin" style="height:auto;padding:10px;" placeholder="输入密码"
                       name="password">
            </div>
        </div>
        <div class="col-md-4 col-md-offset-4">
            <button class="btn btn-lg btn-success btn-block" type="submit">登录</button>
        </div>
    </form>

</div>

</body>
</html>
