<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理</title>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <style>
        #mycenter{
            font-family: Arial;
            width: 100%;
            height: 400px;
            background: white;
        }
        .items{
            width: 100%;
            padding: 20px 10px;
        }
        .title{
            width: 100%;
            height: 40px;
            background: lightblue;
            font-size: 18px;
        }
        .item{
            margin-bottom: 25px;
        }
        .title center{
            line-height: 40px;
        }
        .item input{
            border: 0.2px solid lightgrey;
            border-radius: 3px;
        }
        .item input[name='password']{
            border: none;
            outline: none;
        }

    </style>
</head>
<body class="rebackgroundimg1">
<div class="container">

    <%@include file="header.jsp" %>

    <br><br>

    <div class="alert alert-success" role="alert">恭喜你! 登录成功了</div>

    <div class="panel panel-success" style="border: none">
        <div class="panel-heading">
            <h3 class="panel-title">个人账户</h3>
        </div>
        <div class="panel-body">
            <div class="items">
                <div class="item">
                    <form action="${pageContext.request.contextPath}/admin/updateUsername" method="post">
                        <input hidden name="id" value="${admin.id}">
                        <span>账户名：</span><input type="text" name="username" value="${sessionScope.get("admin").username}">
                        <button type="submit" class="btn btn-success btn-sm" >修改用户名</button>
                    </form>
                </div>
                <div class="item">
                    <span>密码：</span><input readonly type="password" style="border: none" name="password" value="${sessionScope.get("admin").password}">
                    <a type="submit" class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/admin/adminRe?id=${admin.id}">重置密码</a>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    $("input[name='username']").blur(function () {
        $("input[name='username']").css('border-color:white');
    });
</script>
</body>
</html>