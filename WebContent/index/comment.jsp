<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
    <title>我的订单</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/public.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/reclassify.css">
    <link rel="stylesheet" type="text/css" href="css/order.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <style type="text/css">
        #textarea{
            text-align: left;
            border-radius: 5px;
            width: 300px;
            height: 50px;
            padding-left: 5px;
            border-width: 1.5px;

        }
        #textarea:focus {
            border-color: #66afe9;
            outline: 0;
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102,175,233,.6);
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 8px rgba(102,175,233,.6);
        }
        #contentdiv{
            display: flex;
            align-items: flex-start;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="main">
    <c:if test="${itemList.size()==0}">
        <center>暂无需要提交的评论</center>
    </c:if>
    <c:forEach items="${itemList}" var="item">
        <div style="border-bottom: 0.6px solid darkgrey;margin-bottom: 20px; padding-bottom: 3px">
            <form method="post" action="../index/addComment">
                <div><span style="display: block">商品图片：</span><img width="320px" height="250px" src="${item.good.cover}"></div>
                <div><span>商品名称：${item.good.name}</span></div>
                <div><span>订单价格：${item.price}</span></div>
                <input name="oid" hidden value="${item.orderId}">
                <input name="gid" hidden value="${item.goodId}">
                <input name="uid" hidden value="${user.id}">
                <div>
                    评论状态：
                    <c:if test="${item.evaluateFlag}"><span style="color: dodgerblue; font-weight: bold">已评论</span></c:if>
                    <c:if test="${!item.evaluateFlag}"><span style="color: orangered; font-weight: bold">未评论</span></c:if>
                </div>
                <div id="contentdiv">
                    <span >评论内容：</span>
                    <textarea name="content" id="textarea" <c:if test="${item.evaluateFlag}">readonly</c:if> required placeholder="谈谈您对该商品的看法吧" ><c:if test="${item.evaluateFlag}">${item.evaluates.content}</c:if></textarea>
                    <c:if test="${!item.evaluateFlag}"><input type="submit" class="btn btn-success" style="margin-left: 10px;margin-top: 8px" value="提交评论"></c:if>
                </div>
            </form>
        </div>

    </c:forEach>
    <div><i class="bi bi-arrow-return-left"></i>

        <a href="${pageContext.request.contextPath}/index/order" class="btn btn-default" style="align-items: center;horiz-align: center;vertical-align: center">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-reply" viewBox="0 0 16 16">
                <path d="M6.598 5.013a.144.144 0 0 1 .202.134V6.3a.5.5 0 0 0 .5.5c.667 0 2.013.005 3.3.822.984.624 1.99 1.76 2.595 3.876-1.02-.983-2.185-1.516-3.205-1.799a8.74 8.74 0 0 0-1.921-.306 7.404 7.404 0 0 0-.798.008h-.013l-.005.001h-.001L7.3 9.9l-.05-.498a.5.5 0 0 0-.45.498v1.153c0 .108-.11.176-.202.134L2.614 8.254a.503.503 0 0 0-.042-.028.147.147 0 0 1 0-.252.499.499 0 0 0 .042-.028l3.984-2.933zM7.8 10.386c.068 0 .143.003.223.006.434.02 1.034.086 1.7.271 1.326.368 2.896 1.202 3.94 3.08a.5.5 0 0 0 .933-.305c-.464-3.71-1.886-5.662-3.46-6.66-1.245-.79-2.527-.942-3.336-.971v-.66a1.144 1.144 0 0 0-1.767-.96l-3.994 2.94a1.147 1.147 0 0 0 0 1.946l3.994 2.94a1.144 1.144 0 0 0 1.767-.96v-.667z"/>
            </svg>
            返回我的订单
        </a>
    </div>


</div>

<jsp:include page="footer.jsp"/>

</body>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
</html>