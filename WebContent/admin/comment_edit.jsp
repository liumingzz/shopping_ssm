<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>评论编辑</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <style>
        textarea{
            padding: 6px 8px;
            border-radius: 5px;
            width: 300px;
            height: 50px;

        }
        textarea:focus {
            outline:0;
            border:1px solid #999;
        }
    </style>
</head>
<body>
<div class="container">

    <%@include file="header.jsp" %>

    <br><br>

    <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/commentUpdate" method="post">
        <input hidden type="number" name="gid" value="${evaluate.gid}">
        <input hidden type="number" name="oid" value="${evaluate.oid}">
        <div class="form-group">
            <label  class="col-sm-1 control-label">商品名称</label>
            <div class="col-sm-6">
                <span>${evaluate.goodName}</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">用户名</label>
            <div class="col-sm-6">
                <span>${evaluate.user.username}</span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">评论内容</label>
            <div class="col-sm-6">
                <textarea name="content"  required  placeholder="谈谈您对该商品的看法吧" >${evaluate.content}</textarea>
            </div>
        </div>
<%--        <div class="form-group">--%>
<%--            <label class="col-sm-1 control-label">评论时间</label>--%>
<%--            <div class="col-sm-6">--%>
<%--                <input type="datetime-local" class="form-control" id="time" name="systime" required="required">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="form-group">
            <div class="col-sm-offset-1 col-sm-10">
                <input type="submit" class="btn btn-success" value="提交修改"></input>
            </div>
        </div>

    </form>

<%--    <span style="color:red;">${msg}</span>--%>

</div>
<script>
    <%--//自动填充评论时间--%>
    <%--var d = new Date(${evaluate.systime.getTime()});--%>
    <%--var day = ("0" + d.getDate()).slice(-2);--%>
    <%--var month = ("0" + (d.getMonth() + 1)).slice(-2);--%>
    <%--var realTime= d.getFullYear() + "-" + (month) + "-" + (day);--%>
    <%--$('#time').val(realTime);--%>
</script>
</body>
</html>