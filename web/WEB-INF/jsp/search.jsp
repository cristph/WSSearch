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
                    <span class="input-group-addon btn-lg join-btn dropdown-toggle"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="font-size: large;font-weight: bolder">高级检索</span>
                    <div class="dropdown-menu" style="min-width: 700px;border-radius: 0px;padding:2%;">
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6">
                                <span >全文检索:</span>
                                <input type="text" style="width: 45%" id="qwjsInput">
                                <select id="qwjs" class="input-md form-control" style="display: inline;float:right;margin-right:10%;width: 60px;height:27px;font-size: 12px;padding: 0;border-radius: 0">
                                    <option value="全文">全文</option>
                                    <option value="首部">首部</option>
                                    <option value="事实">事实</option>
                                    <option value="理由">理由</option>
                                    <option value="判决结果">判决结果</option>
                                    <option value="尾部">尾部</option>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <span>案由：</span><input type="text" id="ay">
                                <%--<div class="input-group">--%>
                                <%--&lt;%&ndash;<input type="text" class="form-control">&ndash;%&gt;--%>
                                <%--<span class="input-group-addon btn-lg join-btn dropdown-toggle"  data-toggle="dropdown2" aria-haspopup="true" aria-expanded="false" style="font-size: large;font-weight: bolder">^</span>--%>
                                <%--<div class="dropdown2-menu" style="min-width: 300px;border-radius: 0px;padding:2%;">--%>
                                <%--<div id="treeDemo" class="ztree"></div>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6">
                                <span>案件名称：</span><input type="text" id="ajmc">
                            </div>
                            <div class="col-sm-6">
                                <span>案号：</span><input type="text" id="ah">
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6">
                                <span>法院名称：</span><input type="text" id="fymc">
                            </div>
                            <div class="col-sm-6">
                                <span>法院层级：</span>
                                <select id="fycj" class="input-md form-control" style="display: inline;float: right;margin-right:20%;width: 180px;height:27px;font-size: 12px;padding: 0;border-radius: 0">
                                    <option value="0">全部</option>
                                    <option value="1">最高法院</option>
                                    <option value="2">高级法院</option>
                                    <option value="3">中级法院</option>
                                    <option value="4">低级法院</option>
                                    <option value="5">基层法院</option>
                                </select>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6">
                                <span>案件类型：</span>
                                <select id="ajlx" class="input-md form-control" style="display: inline;float: right;margin-right:20%;width: 180px;height:27px;font-size: 12px;padding: 0;border-radius: 0">
                                    <option value="刑事案件">刑事案件</option>
                                    <option value="民事案件">民事案件</option>
                                    <option value="行政案件">行政案件</option>
                                    <option value="赔偿案件">赔偿案件</option>
                                    <option value="执行案件">执行案件</option>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <span>审判程序：</span>
                                <select id="spcx" class="input-md form-control" style="display: inline;float: right;margin-right:20%;width: 180px;height:27px;font-size: 12px;padding: 0;border-radius: 0">
                                    <option value="一审案件">一审案件</option>
                                    <option value="二审案件">二审案件</option>
                                    <option value="再审案件">再审案件</option>
                                    <option value="再审复查与审判监督案">再审复查与审判监督案</option>
                                </select>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6">
                                <span>文书类型：</span>
                                <select id="wslx" class="input-md form-control" style="display: inline;float: right;margin-right:20%;width: 180px;height:27px;font-size: 12px;padding: 0;border-radius: 0">
                                    <option value="判决书">判决书</option>
                                    <option value="裁判文书">裁判文书 </option>
                                    <option value="调解书">调解书</option>
                                    <option value="决定书">决定书</option>
                                    <option value="通知书">通知书</option>
                                    <%--<option value="批复">批复</option>--%>
                                    <%--<option value="答复">答复</option>--%>
                                    <%--<option value="函">函</option>--%>
                                    <%--<option value="令">令</option>--%>
                                    <%--<option value="其他">其他</option>--%>
                                </select>
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="col-sm-3" style="padding: 0">
                                        <span>裁判日期：</span>
                                    </div>
                                    <div class="col-sm-4" style="padding: 0">
                                        <input type="date" style="width: 100%" id="cprqbegin">
                                    </div>
                                    <div class="col-sm-4" style="padding: 0">
                                        <input type="date" style="width: 100%" id="cprqend">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6">
                                <span>裁判人员：</span><input type="text" id="cpry">
                            </div>
                            <div class="col-sm-6">
                                <span>当事人：</span><input type="text" id="dsr">
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6">
                                <span>律所：</span><input type="text" id="lvsuo">
                            </div>
                            <div class="col-sm-6">
                                <span>律师：</span><input type="text" id="lvshi">
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-11">
                                <span>裁判年份：</span><input type="text" style="width: 70%;" id="cpnf">
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-11">
                                <span>法律依据：</span><input type="text" style="width: 70%;" id="flyj">
                            </div>
                        </div>
                        <div class="row" style="margin-bottom: 2%">
                            <div class="col-sm-6" ><button id="complexSearch">检索</button></div>
                            <div class="col-sm-6"><button id="resetSearch">重置</button></div>
                        </div>
                    </div>
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
                <div class="title-box" id="condBox">检索条件：
                    <c:if test="${ay!=''}">
                        <span class="label label-primary">案由:${ay} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('ay')"></span></span>
                    </c:if>
                    <c:if test="${ah!=''}">
                        <span class="label label-primary">案号:${ah} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('ah')"></span></span>
                    </c:if>
                    <c:if test="${ajmc!=''}">
                        <span class="label label-primary">案件名称:${ajmc} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('ajmc')"></span></span>
                    </c:if>
                    <c:if test="${fymc!=''}">
                        <span class="label label-primary">法院名称:${fymc} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fymc')"></span></span>
                    </c:if>
                    <c:if test="${fycj!=''}">
                        <c:if test="${fycj==0}">
                            <span class="label label-primary">法院层级:全部法院 <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fycj')"></span></span>
                        </c:if>
                        <c:if test="${fycj==1}">
                            <span class="label label-primary">法院层级:最高法院 <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fycj')"></span></span>
                        </c:if>
                        <c:if test="${fycj==2}">
                            <span class="label label-primary">法院层级:高级法院 <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fycj')"></span></span>
                        </c:if>
                        <c:if test="${fycj==3}">
                            <span class="label label-primary">法院层级:中级法院 <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fycj')"></span></span>
                        </c:if>
                        <c:if test="${fycj==4}">
                            <span class="label label-primary">法院层级:低级法院 <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fycj')"></span></span>
                        </c:if>
                        <c:if test="${fycj==5}">
                            <span class="label label-primary">法院层级:基层法院 <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fycj')"></span></span>
                        </c:if>
                        <%--<span class="label label-primary">法院层级:${fycj} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('fycj')"></span></span>--%>
                    </c:if>
                    <c:if test="${ajlx!=''}">
                        <span class="label label-primary">案件类型:${ajlx} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('ajlx')"></span></span>
                    </c:if>
                    <c:if test="${spcx!=''}">
                        <span class="label label-primary">审判程序:${spcx} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('spcx')"></span></span>
                    </c:if>
                    <c:if test="${wslx!=''}">
                        <span class="label label-primary">文书类型:${wslx} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('wslx')"></span></span>
                    </c:if>
                    <c:if test="${cpry!=''}">
                        <span class="label label-primary">裁判人员:${cpry} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('cpry')"></span></span>
                    </c:if>
                    <c:if test="${lvsuo!=''}">
                        <span class="label label-primary">律所:${lvsuo} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('lvsuo')"></span></span>
                    </c:if>
                    <c:if test="${lvshi!=''}">
                        <span class="label label-primary">律师:${lvshi} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('lvshi')"></span></span>
                    </c:if>
                    <c:if test="${flyj!=''}">
                        <span class="label label-primary">法律依据:${flyj} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('flyj')"></span></span>
                    </c:if>
                    <c:if test="${cpnf!=''}">
                        <span class="label label-primary" >裁判年份:${cpnf} <span class="glyphicon glyphicon-remove scondition" aria-hidden="true" onclick="removeLabel('cpnf')"></span></span>
                    </c:if>
                </div>
                <div id="searchConditions">
                    <input type="hidden" id="viewName" value="">
                    <input type="hidden" id="cond_ay" value="${ay}">
                    <input type="hidden" id="cond_ah" value="${ah}">
                    <input type="hidden" id="cond_ajmc" value="${ajmc}">
                    <input type="hidden" id="cond_fymc" value="${fymc}">
                    <input type="hidden" id="cond_fycj" value="${fycj}">
                    <input type="hidden" id="cond_ajlx" value="${ajlx}">
                    <input type="hidden" id="cond_spcx" value="${spcx}">
                    <input type="hidden" id="cond_wslx" value="${wslx}">
                    <input type="hidden" id="cond_cprqbegin" value="${cprqbegin}">
                    <input type="hidden" id="cond_cprqend" value="${cprqend}">
                    <input type="hidden" id="cond_cpry" value="${cpry}">
                    <input type="hidden" id="cond_dsr" value="${dsr}">
                    <input type="hidden" id="cond_lvsuo" value="${lvsuo}">
                    <input type="hidden" id="cond_lvshi" value="${lvshi}">
                    <input type="hidden" id="cond_flyj" value="${flyj}">
                    <input type="hidden" id="cond_cpnf" value="${cpnf}">

                    <input type="hidden" id="SortClass" value="${SortClass}">
                    <input type="hidden" id="SortType" value="${SortType}">
                </div>
                <div class="row" style="margin: 2% 0 2% 0">
                    <input type="hidden" id="fycjOrder" value="desc">
                    <input type="hidden" id="cprqOrder" value="desc">
                    <input type="hidden" id="spcxOrder" value="desc">
                    <span class="sortBtn" onclick="changeSortOrder('fycj')">法院层级 <span class="glyphicon glyphicon-arrow-down" aria-hidden="true" id="fycjArrow"></span></span>
                    <span class="sortBtn" onclick="changeSortOrder('cprq')">裁判日期 <span class="glyphicon glyphicon-arrow-down" aria-hidden="true" id="cprqArrow"></span></span>
                    <span class="sortBtn" onclick="changeSortOrder('spcx')">审判程序 <span class="glyphicon glyphicon-arrow-down" aria-hidden="true" id="spcxArrow"></span></span>
                    <span style="font-weight: bolder;color: white">共得到<span id="AJC">${AjCount}</span>条记录</span><span style="width: 100px;height: 2px"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                    <input type="checkbox" style="margin:5px 0 0;border:1px solid #006600;" id="downloadAll">
                    <span style="border:1px solid #006600;border-radius: 2px;background-color: whitesmoke;color: black;cursor: pointer;padding: 0.5%" onclick="downloadXml()">批量下载xml</span>
                    <span style="border:1px solid #006600;border-radius: 2px;background-color: whitesmoke;color: black;cursor: pointer;padding: 0.5%" onclick="downloadDoc()">批量下载doc</span>
                </div>
                <div>
                    <div id="AjDiv">
                        <c:forEach items="${list}" var="item">
                        <div class="AJ">
                            <input type="checkbox" value="${item.xmlPath}" style="margin:5px 0 0;border:1px solid #006600;">
                            <div class="row AJBiaoTi" onclick="showAj('${item.wsah}')">
                                    ${item.spcx} ${item.wsmc}
                            </div>
                            <div class="row AJCiBiaoTi" onclick="showAj('${item.wsah}')">
                                    ${item.gymc}${item.zymc}${item.jcymc} &nbsp;&nbsp;&nbsp;&nbsp; ${item.wsah} &nbsp;&nbsp;&nbsp;&nbsp; ${item.cprq}
                            </div>
                            <div style="padding: 0 0 20px 0;">
                                <span class="glyphicon glyphicon-save scondition" aria-hidden="true" onclick="downloadSingleXML('${item.wsmc}')" style="float: right;margin-right: 80px;color: #b806f9">XML</span>
                                <span class="glyphicon glyphicon-save scondition" aria-hidden="true" onclick="downloadSingleDOC('${item.wsmc}')" style="float: right;margin-right: 80px;color: #1143fe">DOC</span>
                            </div>
                            <input type="hidden" value="${item.wsah}">
                            <input type="hidden" value="${item.xmlPath}" id="xml${item.wsmc}">
                            <input type="hidden" value="${item.docPath}" id="doc${item.wsmc}">
                        </div>
                        </c:forEach>
                    </div>
                    <nav aria-label="Page navigation">
                        <input type="hidden" id="maxPageNum" value="${maxPageNum}">
                        <input type="hidden" id="currentPageIndex" value="1">
                        <input type="hidden" id="firstPageIndex" value="1">
                        <input type="hidden" id="endPageIndex" value="5">
                        <ul class="pagination" id="PP">
                            <li>
                                <a href="javascript:void(0)" aria-label="Previous" onclick="goPrevious()">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>

                            <%--<c:forEach var="i" begin="${beginPageIndex}" end="${endPageIndex}" step="1">--%>
                                <%--<c:choose>--%>
                                    <%--<c:when test="${i==1}">--%>
                                        <%--<li class="active"><a href="javascript:void(0)" onclick="goPage('${SortClass}','${SortType}','${i}')">${i}</a></li>--%>
                                    <%--</c:when>--%>
                                    <%--<c:otherwise>--%>
                                        <%--<li class=""><a href="javascript:void(0)" onclick="goPage('${SortClass}','${SortType}','${i}')">${i}</a></li>--%>
                                    <%--</c:otherwise>--%>
                                <%--</c:choose>--%>
                            <%--</c:forEach>--%>
                            <c:choose>
                                <c:when test="${maxPageNum>5}">
                                    <c:forEach var="i" begin="1" end="5" step="1">
                                        <c:choose>
                                            <c:when test="${i==1}">
                                                <li id="page${i}" class="active"><a href="javascript:void(0)" onclick="goPage('${i}')">${i}</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li id="page${i}" class=""><a href="javascript:void(0)" onclick="goPage('${i}')">${i}</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="i" begin="1" end="${maxPageNum}" step="1">
                                        <c:choose>
                                            <c:when test="${i==1}">
                                                <li id="page${i}" class="active"><a href="javascript:void(0)" onclick="goPage('${i}')">${i}</a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li id="page${i}" class=""><a href="javascript:void(0)" onclick="goPage('${i}')">${i}</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>

                            <%--<li class="active"><a href="javascript:void(0)" onclick="goPage('${SortClass}','${SortType}',1)">1</a></li>--%>
                            <%--<li class=""><a href="javascript:void(0)" onclick="goPage('${SortClass}','${SortType}',2)">2</a></li>--%>
                            <%--<li class=""><a href="javascript:void(0)" onclick="goPage('${SortClass}','${SortType}',3)">3</a></li>--%>
                            <%--<li class=""><a href="javascript:void(0)" onclick="goPage('${SortClass}','${SortType}',4)">4</a></li>--%>
                            <%--<li class=""><a href="javascript:void(0)" onclick="goPage('${SortClass}','${SortType}',5)">5</a></li>--%>
                            <li>
                                <a href="javascript:void(0)" aria-label="Next" onclick="goNext()">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                        <span style="color: white;font-size: larger;font-weight: bolder;margin-bottom: 20px">共<span id="PN">${maxPageNum}</span>页</span>
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
<script src="js/search.js" type="text/javascript" charset="GBK"></script>
<script src="js/jquery.ztree.all.min.js"></script>
<script>

    $('#qwjs').click(function(e){
        e.stopPropagation();
    });

    $('#ay').click(function(e){
        e.stopPropagation();
    });

    $('#treeDemo').click(function(e){
        e.stopPropagation();
    });

    $('#fycj').click(function(e){
        e.stopPropagation();
    });

    $('#wslx').click(function(e){
        e.stopPropagation();
    });

    $('#ajlx').click(function(e){
        e.stopPropagation();
    });

    $('#spcx').click(function(e){
        e.stopPropagation();
    });

    var setting = {
        view: {
            showIcon: showIconForTree
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback:{
            onClick:zTreeOnClick
        }
    };

    function showIconForTree(treeId, treeNode) {
        return !treeNode.isParent;
    };

    function zTreeOnClick(event, treeId, treeNode){
//        alert(treeId+"|"+treeNode.tId+"|"+treeNode.name);
        var parent=treeNode.getParentNode();
//        alert(parent.tId+"|"+parent.name);
        if(parent.name=='按裁判年份筛选'){
            var cpnf=treeNode.name.split('年')[0];
            addLabel('裁判年份', cpnf, 'cpnf');
            addSearchCondition('cpnf',cpnf);
        }else if(parent.name=='按关键字筛选'){

        }else if(parent.name=='按法院层级筛选'){
            var fy=treeNode.name.split('(')[0];
            var fycj=0;
            if(fy=='最高法院'){
                fycj=1;
            }else if(fy=='高级法院'){
                fycj=2;
            }else if(fy=='中级级法院'){
                fycj=3;
            }else if(fy=='低级法院'){
                fycj=4;
            }else if(fy=='基层法院'){
                fycj=5;
            }
            addLabel('法院层级', fycj, 'fycj');
            addSearchCondition('fycj',fycj);
        }else if(parent.name=='按审判程序筛选'){
            var spcx=treeNode.name.split('(')[0];
            addLabel('审判程序', spcx, 'spcx');
            addSearchCondition('spcx',spcx);
        }else if(parent.name=='按文书类型筛选'){
            var wslx=treeNode.name.split('(')[0];
            addLabel('文书类型', wslx, 'wslx');
            addSearchCondition('wslx',wslx);
        }else if(parent.name=='按案由筛选'){

        }
    }

    function addLabel(conditionName, conditionValue, conditionEngName){
        var span=document.createElement('span');
        span.classList.add('label');
        span.classList.add('label-primary');
        span.innerHTML=conditionName+":"+conditionValue+" <span class=\"glyphicon glyphicon-remove scondition\" aria-hidden=\"true\" onclick=\"removeLabel('"+conditionEngName+"')\"></span>";
        document.getElementById('condBox').appendChild(span);
    }


    function addSearchCondition(conditionName, conditionValue){
        $('#cond_'+conditionName).val(conditionValue);
        var sorts=[];
        var orders=[];
        sorts.push('fycj');
        orders.push($('#fycjOrder').val());
        sorts.push('cprq');
        orders.push($('#cprqOrder').val());
        sorts.push('spcx');
        orders.push($('#spcxOrder').val());
        showPage(sorts,orders,1);
        resetNum();
    }

    $(function(){
        var nodes =[
            { id:1, pId:0, name:"按关键字筛选",  isParent:true,open:true},
            { id:2, pId:0, name:"按案由筛选", isParent:true},
            { id:3, pId:0, name:"按法院层级筛选", isParent:true},
            { id:4, pId:0, name:"按裁判年份筛选", isParent:true},
            { id:5, pId:0, name:"按审判程序筛选", isParent:true},
            { id:6, pId:0, name:"按文书类型筛选", isParent:true}
        ];
        $.fn.zTree.init($("#treeDemo"), setting, nodes);

        var createViewPost=$.post(
                "/createView",
                {
                    "ay":encodeURIComponent($('#cond_ay').val()),
                    "ah":encodeURIComponent($('#cond_ah').val()),
                    "ajmc":encodeURIComponent($('#cond_ajmc').val()),
                    "fymc":encodeURIComponent($('#cond_fymc').val()),
                    "fycj":encodeURIComponent($('#cond_fycj').val()),
                    "ajlx":encodeURIComponent($('#cond_ajlx').val()),
                    "spcx":encodeURIComponent($('#cond_spcx').val()),
                    "wslx":encodeURIComponent($('#cond_wslx').val()),
                    "cprqbegin":encodeURIComponent($('#cond_cprqbegin').val()),
                    "cprqend":encodeURIComponent($('#cond_cprqend').val()),
                    "cpry":encodeURIComponent($('#cond_cpry').val()),
                    "dsr":encodeURIComponent($('#cond_dsr').val()),
                    "lvsuo":encodeURIComponent($('#cond_lvsuo').val()),
                    "lvshi":encodeURIComponent($('#cond_lvshi').val()),
                    "flyj":encodeURIComponent($('#cond_flyj').val()),
                    "cpnf":encodeURIComponent($('#cond_cpnf').val())
                },
                function(data){
                    $('#viewName').val(data);
                }
        );


        createViewPost.done(function(){
            var p1=new Promise(function (resolve){
                $.post(
                        "/groupStatistics",
                        {
                            "groupName": "AYCJ",
                            "viewName": $('#viewName').val()
                        },
                        function(map){
                            var i=1;
                            for(var key in map){
                                var value=map[key];
                                var entry={id:2*10+i, pId:2, name:"案由层级"+key+"("+value+")"};
                                nodes.push(entry);
                                i++;
                            }
                            resolve('p1 done');
                        }
                );
            });

            var p2=new Promise(function (resolve){
                $.post(
                        "/groupStatistics",
                        {
                            "groupName": "FYCJ",
                            "viewName": $('#viewName').val()
                        },
                        function(map){
                            var i=1;
                            var fycjArray=["全部","最高法院","高级法院","中级法院","低级法院","基层法院"];
                            for(var key in map){
                                var value=map[key];
                                var entry={id:3*10+i, pId:3, name:fycjArray[key]+"("+value+")"};
                                nodes.push(entry);
                                i++;
                            }
                            resolve("p2 done");
                        }
                );
            });

            var p3=new Promise(function (resolve){
                $.post(
                        "/groupStatistics",
                        {
                            "groupName": "CPNF",
                            "viewName": $('#viewName').val()
                        },
                        function(map){
                            var i=1;
                            for(var key in map){
                                var value=map[key];
                                var entry={id:4*10+i, pId:4, name:key+"年("+value+")"};
                                nodes.push(entry);
                                i++;
                            }
                            resolve('p3 done');
                        }
                );
            });

            var p4=new Promise(function (resolve){
                $.post(
                        "/groupStatistics",
                        {
                            "groupName": "SPCX",
                            "viewName": $('#viewName').val()
                        },
                        function(map){
                            var i=1;
                            for(var key in map){
                                var value=map[key];
                                var entry={id:5*10+i, pId:5, name:key+"("+value+")"};
                                nodes.push(entry);
                                i++;
                            }
                            resolve('p4 done');
                        }
                );
            });

            var p5=new Promise(function (resolve){
                $.post(
                        "/groupStatistics",
                        {
                            "groupName": "WSLX",
                            "viewName": $('#viewName').val()
                        },
                        function(map){
                            var i=1;
                            for(var key in map){
                                var value=map[key];
                                var entry={id:6*10+i, pId:6, name:key+"("+value+")"};
                                nodes.push(entry);
                                i++;
                            }
                            resolve('p5 done');
                        }
                );
            });

            Promise.all([p1,p2,p3,p4,p5]).then(function(result){
                console.log(result);
                $.fn.zTree.init($("#treeDemo"), setting, nodes);
            });
        });
    });

</script>

</body>
