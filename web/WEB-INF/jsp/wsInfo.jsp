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
    <link href="css/wsInfo.css" rel="stylesheet">
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
            <div class="col-xs-12 col-sm-10 col-sm-offset-1">
                <div class="text-center">
                    <h1>大标题</h1>
                    <h2>次标题</h2>
                </div>
                <div class="title-box">基本信息</div>
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">案件基本信息</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="list-group">
                            <input type="hidden" id="Ajxh" value="${item.ajxh}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                            <li class="list-group-item">案号 <span style="color: black;font:large bolder;margin-left: 2%">${item.ah}</span></li>
                            <li class="list-group-item">案件性质 <span style="color: black;font:large bolder;margin-left: 2%">${item.ajxz}</span></li>
                            <li class="list-group-item">审判程序<span style="color: black;font:large bolder;margin-left: 2%"> ${item.spcx}</span></li>
                            <li class="list-group-item">文书名称 <span style="color: black;font:large bolder;margin-left: 2%">${item.wsmc}</span></li>
                            <li class="list-group-item">文书种类 <span style="color: black;font:large bolder;margin-left: 2%">${item.wszl}</span></li>
                            <li class="list-group-item">文书制作单位 <span style="color: black;font:large bolder;margin-left: 2%">${item.wszzdw}</span></li>
                            <li class="list-group-item">经办法院 <span style="color: black;font:large bolder;margin-left: 2%">${item.jbfy}</span></li>
                            <li class="list-group-item">法院级别 <span style="color: black;font:large bolder;margin-left: 2%">${item.fyjb}</span></li>
                            <li class="list-group-item">行政区划 省 <span style="color: black;font:large bolder;margin-left: 2%">${item.xzqhsh}</span></li>
                            <li class="list-group-item">行政区划 市 <span style="color: black;font:large bolder;margin-left: 2%">${item.xzqhs}</span></li>
                            <li class="list-group-item">立案年度 <span style="color: black;font:large bolder;margin-left: 2%">${item.land}</span></li>
                            <li class="list-group-item">是否提出管辖权异议<span style="color: black;font:large bolder;margin-left: 2%">${item.tcgxqyy}</span></li>
                            <li class="list-group-item">结案方式 <span style="color: black;font:large bolder;margin-left: 2%">${item.jafs}</span></li>
                            <li class="list-group-item">判决时间 <span style="color: black;font:large bolder;margin-left: 2%">${item.pjsj}</span></li>
                            <li class="list-group-item">结案年度 <span style="color: black;font:large bolder;margin-left: 2%">${item.jand}</span></li>
                            <li class="list-group-item">结案月份 <span style="color: black;font:large bolder;margin-left: 2%">${item.jayf}</span></li>
                            <li class="list-group-item">可上诉至 <span style="color: black;font:large bolder;margin-left: 2%">${item.kssz}</span></li>
                            <li class="list-group-item">上诉期限 <span style="color: black;font:large bolder;margin-left: 2%">${item.ssqx}</span></li>
                            <li class="list-group-item">上诉提交材料 <span style="color: black;font:large bolder;margin-left: 2%">${item.sstjcl}</span></li>
                            <li class="list-group-item">是否发回重审 <span style="color: black;font:large bolder;margin-left: 2%">${item.sffhcs}</span></li>
                            <li class="list-group-item">发回重审原因 <span style="color: black;font:large bolder;margin-left: 2%">${item.fhccyy}</span></li>
                            <li class="list-group-item">结案总标的 <span style="color: black;font:large bolder;margin-left: 2%">${item.jazbd}</span></li>
                        </ul>
                    </div>
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
<script src="js/wsInfo.js"></script>

</body>
