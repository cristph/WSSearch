<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/27
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>文书搜索结果</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/reset.css" rel="stylesheet">
    <link href="css/base.css" rel="stylesheet">
    <%--<link href="css/buttons.css" rel="stylesheet">--%>
</head>


<body>

<div class="home">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <p style="font-size: large;font-weight: bold;color: white">Dessert</p>
            </div>
            <div class="col-sm-9 home-links">
                <a href="${pageContext.request.contextPath}/login" id="login">Login</a>
                <a href="${pageContext.request.contextPath}/register" class="home-register" id="register">Sign up</a>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-10 col-sm-offset-1 text-center">
                <h1>大标题</h1>
                <h2>次标题</h2>

                <div class="input-group">
                    <input type="text" class="form-control input-lg" placeholder="输入案由、关键词、法院、当事人、律师" id="searchInput">
                    <span class="input-group-addon btn-lg join-btn" style="font-size: large;font-weight: bolder" id="searchBtn">搜索</span>
                </div>
                <p style="height: 100px"></p>
            </div>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 text-center">
                <a href="/">Home</a>
                <a href="/terms" target="_blank">Terms</a>
                <a href="/privacy" target="_blank">Privacy</a>
                <a href="https://twitter.com/wiplohq" target="_blank" rel="nofollow">Twitter</a>
                <a href="mailto:team@wiplo.com?subject=Hi Wiplo Team!" rel="nofollow">Contact</a>
                <small>Architect @ Cristph</small>
            </div>
        </div>
    </div>
</footer>



<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
