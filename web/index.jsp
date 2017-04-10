<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/24
  Time: 14:06
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

  <title>文书搜索</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/reset.css" rel="stylesheet">
  <link href="css/base.css" rel="stylesheet">
  <link href="css/zTreeStyle.css" rel="stylesheet">
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
                  <%--<option value="赔偿案件">赔偿案件</option>--%>
                  <%--<option value="执行案件">执行案件</option>--%>
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
  </div>
</div>

<footer class="footer">
  <div class="container">
    <div class="row">
      <div class="col-sm-12 text-center">
        <a href="javascript:void(0)">Home</a>
        <a href="javascript:void(0)" target="_blank">Terms</a>
        <a href="javascript:void(0)" target="_blank">Privacy</a>
        <a href="javascript:void(0)" target="_blank" rel="nofollow">Twitter</a>
        <a href="javascript:void(0)" rel="nofollow">Contact</a>
        <small>Architect @ Cristph</small>
      </div>
    </div>
  </div>
</footer>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
<script src="js/jquery.ztree.all.min.js"></script>
<script>
  function close(){
    event.stopPropagation();
  }


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
    }
  };

  var zNodes =[
    { id:1, pId:0, name:"按关键字筛选", open:true},
//    { id:11, pId:1, name:"父节点11 - 折叠"},
//    { id:111, pId:11, name:"叶子节点111"},
//    { id:112, pId:11, name:"叶子节点112"},
//    { id:113, pId:11, name:"叶子节点113"},
//    { id:114, pId:11, name:"叶子节点114"},
//    { id:12, pId:1, name:"父节点12 - 折叠"},
//    { id:121, pId:12, name:"叶子节点121"},
//    { id:122, pId:12, name:"叶子节点122"},
//    { id:123, pId:12, name:"叶子节点123"},
//    { id:124, pId:12, name:"叶子节点124"},
//    { id:13, pId:1, name:"父节点13 - 没有子节点", isParent:true},
    { id:2, pId:0, name:"按案由筛选"},
//    { id:21, pId:2, name:"父节点21 - 展开", open:true},
//    { id:211, pId:21, name:"叶子节点211"},
//    { id:212, pId:21, name:"叶子节点212"},
//    { id:213, pId:21, name:"叶子节点213"},
//    { id:214, pId:21, name:"叶子节点214"},
//    { id:22, pId:2, name:"父节点22 - 折叠"},
//    { id:221, pId:22, name:"叶子节点221"},
//    { id:222, pId:22, name:"叶子节点222"},
//    { id:223, pId:22, name:"叶子节点223"},
//    { id:224, pId:22, name:"叶子节点224"},
//    { id:23, pId:2, name:"父节点23 - 折叠"},
//    { id:231, pId:23, name:"叶子节点231"},
//    { id:232, pId:23, name:"叶子节点232"},
//    { id:233, pId:23, name:"叶子节点233"},
//    { id:234, pId:23, name:"叶子节点234"},
    { id:3, pId:0, name:"按法院层级筛选", isParent:true},
    { id:31, pId:3, name:"最高法院"},
    { id:32, pId:3, name:"高级法院"},
    { id:33, pId:3, name:"中级法院"},
    { id:34, pId:3, name:"低级法院"},
    { id:35, pId:3, name:"基层法院"},
    { id:4, pId:0, name:"按裁判年份筛选", isParent:true},
    { id:5, pId:0, name:"按审判程序筛选", isParent:true},
    { id:6, pId:0, name:"按文书类型筛选", isParent:true}
  ];

  function showIconForTree(treeId, treeNode) {
    return !treeNode.isParent;
  };

  $(document).ready(function(){
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
  });
</script>
</body>
</html>