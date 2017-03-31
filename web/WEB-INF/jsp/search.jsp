<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/24
  Time: 19:50
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
    <link href="css/zTreeStyle.css" rel="stylesheet">
    <link href="css/search.css" rel="stylesheet">
    <link href="css/cikonss.css" rel="stylesheet"/>
    <%--<link href="css/buttons.css" rel="stylesheet">--%>
</head>


<body>

<div class="home">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <p style="font-size: large;font-weight: bold;color: white">WSSearch</p>
            </div>
            <div class="col-sm-9 home-links">
                <a href="${pageContext.request.contextPath}/login" id="login">Login</a>
                <a href="${pageContext.request.contextPath}/register" class="home-register" id="register">Sign up</a>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-10 col-sm-offset-1 text-center">
                <h1>文书搜索</h1>
                <h2>文书搜索</h2>

                <div class="input-group">
                    <input type="text" class="form-control input-lg" placeholder="输入案由、关键词、法院、当事人、律师" id="searchInput">
                    <span class="input-group-addon btn-lg join-btn" style="font-size: large;font-weight: bolder" id="searchBtn">搜索</span>
                </div>
                <p style="height: 100px"></p>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3 treeBox">
                <div id="treeDemo" class="ztree"></div>
            </div>
            <div class="col-sm-9">
                <div class="title-box">检索条件：
                    <span class="label label-primary">案号：${AH} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true"></span></span>
                </div>
                <div class="row" style="margin: 2% 0 2% 0">
                    <span class="sortBtn">法院层级 <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></span>
                    <span class="sortBtn">裁判日期 <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></span>
                    <span class="sortBtn">审判程序 <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></span>
                    <span style="font-weight: bolder;color: white">共得到${AjCount}条记录</span>
                </div>
                <div>
                    <div id="AjDiv">
                        <c:forEach items="${list}" var="item">
                        <div class="AJ">
                            <div class="row AJBiaoTi" onclick="showAj('${item.ajxh}')">
                                    ${item.spcx} ${item.wsmc}
                            </div>
                            <div class="row AJCiBiaoTi" onclick="showAj('${item.ajxh}')">
                                    ${item.jbfy} &nbsp;&nbsp;&nbsp;&nbsp; ${item.ah} &nbsp;&nbsp;&nbsp;&nbsp; ${item.pjsj}
                            </div>
                            <input type="hidden" value="${item.ajxh}">
                        </div>
                    </c:forEach>
                    </div>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="active"><a href="javascript:void(0)" onclick="goPage('${AH}','${SortClass}','${SortType}',1)">1</a></li>
                            <li class=""><a href="javascript:void(0)" onclick="goPage('${AH}','${SortClass}','${SortType}',2)">2</a></li>
                            <li class=""><a href="javascript:void(0)" onclick="goPage('${AH}','${SortClass}','${SortType}',3)">3</a></li>
                            <li class=""><a href="javascript:void(0)" onclick="goPage('${AH}','${SortClass}','${SortType}',4)">4</a></li>
                            <li class=""><a href="javascript:void(0)" onclick="goPage('${AH}','${SortClass}','${SortType}',5)">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
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
<script src="js/search.js"></script>
<script src="js/jquery.ztree.all.min.js"></script>
<script>
    var setting = {
        view: {
            showIcon: showIconForTree
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes =[
        { id:1, pId:0, name:"父节点1 - 展开", open:true},
        { id:11, pId:1, name:"父节点11 - 折叠"},
        { id:111, pId:11, name:"叶子节点111"},
        { id:112, pId:11, name:"叶子节点112"},
        { id:113, pId:11, name:"叶子节点113"},
        { id:114, pId:11, name:"叶子节点114"},
        { id:12, pId:1, name:"父节点12 - 折叠"},
        { id:121, pId:12, name:"叶子节点121"},
        { id:122, pId:12, name:"叶子节点122"},
        { id:123, pId:12, name:"叶子节点123"},
        { id:124, pId:12, name:"叶子节点124"},
        { id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true},
        { id:2, pId:0, name:"父节点2 - 折叠"},
        { id:21, pId:2, name:"父节点21 - 展开", open:true},
        { id:211, pId:21, name:"叶子节点211"},
        { id:212, pId:21, name:"叶子节点212"},
        { id:213, pId:21, name:"叶子节点213"},
        { id:214, pId:21, name:"叶子节点214"},
        { id:22, pId:2, name:"父节点22 - 折叠"},
        { id:221, pId:22, name:"叶子节点221"},
        { id:222, pId:22, name:"叶子节点222"},
        { id:223, pId:22, name:"叶子节点223"},
        { id:224, pId:22, name:"叶子节点224"},
        { id:23, pId:2, name:"父节点23 - 折叠"},
        { id:231, pId:23, name:"叶子节点231"},
        { id:232, pId:23, name:"叶子节点232"},
        { id:233, pId:23, name:"叶子节点233"},
        { id:234, pId:23, name:"叶子节点234"},
        { id:3, pId:0, name:"父节点3 - 没有子节点", isParent:true}
    ];

    function showIconForTree(treeId, treeNode) {
        return !treeNode.isParent;
    };

    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });
</script>

</body>
