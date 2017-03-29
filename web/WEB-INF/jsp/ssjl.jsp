<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/29
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-success">
    <div class="panel-heading" data-toggle="collapse" href="#ssjlcPanel" style="cursor: pointer">
        <h3 class="panel-title">诉讼记录</h3>
    </div>
    <div class="panel-body collapse" id="ssjlcPanel">
        <ul class="list-group">
            <c:if test="${item.ajxh!=null}">
                <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
            </c:if>
            <c:if test="${item.ay!=null}">
                <li class="list-group-item">案由<span style="color: black;font:large bolder;margin-left: 2%">${item.ay}</span></li>
            </c:if>
            <c:if test="${item.wzay!=null}">
                <li class="list-group-item">完整案由<span style="color: black;font:large bolder;margin-left: 2%">${item.wzay}</span></li>
            </c:if>
            <c:if test="${item.ajly!=null}">
                <li class="list-group-item">案件来源<span style="color: black;font:large bolder;margin-left: 2%">${item.ajly}</span></li>
            </c:if>
            <c:if test="${item.ajsj!=null}">
                <li class="list-group-item">案件涉及<span style="color: black;font:large bolder;margin-left: 2%">${item.ajsj}</span></li>
            </c:if>
            <c:if test="${item.ktsl!=null}">
                <li class="list-group-item">开庭审理<span style="color: black;font:large bolder;margin-left: 2%">${item.ktsl}</span></li>
            </c:if>
            <c:if test="${item.aydm!=null}">
                <li class="list-group-item">案由代码<span style="color: black;font:large bolder;margin-left: 2%">${item.aydm}</span></li>
            </c:if>
            <c:if test="${item.ktrq!=null}">
                <li class="list-group-item">开庭日期<span style="color: black;font:large bolder;margin-left: 2%">${item.ktrq}</span></li>
            </c:if>
            <c:if test="${item.qsah!=null}">
                <li class="list-group-item">前审案号<span style="color: black;font:large bolder;margin-left: 2%">${item.qsah}</span></li>
            </c:if>
            <c:if test="${item.qsfy!=null}">
                <li class="list-group-item">前审法院<span style="color: black;font:large bolder;margin-left: 2%">${item.qsfy}</span></li>
            </c:if>
            <c:if test="${item.ktslxx!=null}">
                <li class="list-group-item">开庭审理信息<span style="color: black;font:large bolder;margin-left: 2%">${item.ktslxx}</span></li>
            </c:if>
            <c:if test="${item.bgkslyy!=null}">
                <li class="list-group-item">不公开审理原因<span style="color: black;font:large bolder;margin-left: 2%">${item.bgkslyy}</span></li>
            </c:if>
            <c:if test="${item.larq!=null}">
                <li class="list-group-item">立案日期<span style="color: black;font:large bolder;margin-left: 2%">${item.larq}</span></li>
            </c:if>
            <c:if test="${item.ysajsycx!=null}">
                <li class="list-group-item">一审案件适用程序<span style="color: black;font:large bolder;margin-left: 2%">${item.ysajsycx}</span></li>
            </c:if>
            <c:if test="${item.jyzpt!=null}">
                <li class="list-group-item">简易转普通<span style="color: black;font:large bolder;margin-left: 2%">${item.jyzpt}</span></li>
            </c:if>
            <c:if test="${item.ysajly!=null}">
                <li class="list-group-item">一审案件来源<span style="color: black;font:large bolder;margin-left: 2%">${item.ysajly}</span></li>
            </c:if>
            <c:if test="${item.slrq!=null}">
                <li class="list-group-item">受理日期<span style="color: black;font:large bolder;margin-left: 2%">${item.slrq}</span></li>
            </c:if>
            <c:if test="${item.spzz!=null}">
                <li class="list-group-item">审判组织<span style="color: black;font:large bolder;margin-left: 2%">${item.spzz}</span></li>
            </c:if>
            <c:if test="${item.drsp!=null}">
                <li class="list-group-item">独任审判<span style="color: black;font:large bolder;margin-left: 2%">${item.drsp}</span></li>
            </c:if>
            <c:if test="${item.sqcsrq!=null}">
                <li class="list-group-item">申请撤诉日期<span style="color: black;font:large bolder;margin-left: 2%">${item.sqcsrq}</span></li>
            </c:if>
            <c:if test="${item.qsrq!=null}">
                <li class="list-group-item">起诉日期<span style="color: black;font:large bolder;margin-left: 2%">${item.qsrq}</span></li>
            </c:if>
            <c:if test="${item.bgzyldct!=null}">
                <li class="list-group-item">被告主要领导出庭<span style="color: black;font:large bolder;margin-left: 2%">${item.bgzyldct}</span></li>
            </c:if>
            <c:if test="${item.xzxwzl!=null}">
                <li class="list-group-item">行政行为种类<span style="color: black;font:large bolder;margin-left: 2%">${item.xzxwzl}</span></li>
            </c:if>
            <c:if test="${item.xzqqxwzl!=null}">
                <li class="list-group-item">行政侵权行为种类<span style="color: black;font:large bolder;margin-left: 2%">${item.xzqqxwzl}</span></li>
            </c:if>
            <c:if test="${item.jysyjycx!=null}">
                <li class="list-group-item">建议适用简易程序<span style="color: black;font:large bolder;margin-left: 2%">${item.jysyjycx}</span></li>
            </c:if>
            <c:if test="${item.msbfjxsl!=null}">
                <li class="list-group-item">附带民事部分继续审理<span style="color: black;font:large bolder;margin-left: 2%">${item.msbfjxsl}</span></li>
            </c:if>
            <c:if test="${item.ssxz!=null}">
                <li class="list-group-item">诉讼性质<span style="color: black;font:large bolder;margin-left: 2%">${item.ssxz}</span></li>
            </c:if>
            <c:if test="${item.jcy!=null}">
                <li class="list-group-item">检察员<span style="color: black;font:large bolder;margin-left: 2%">${item.jcy}</span></li>
            </c:if>
            <c:if test="${item.js!=null}">
                <li class="list-group-item">检察员角色<span style="color: black;font:large bolder;margin-left: 2%">${item.js}</span></li>
            </c:if>
            <c:if test="${item.qszay!=null}">
                <li class="list-group-item"> 起诉主案由<span style="color: black;font:large bolder;margin-left: 2%">${item.qszay}</span></li>
            </c:if>
            <c:if test="${item.gsjg!=null}">
                <li class="list-group-item">公诉机关<span style="color: black;font:large bolder;margin-left: 2%">${item.gsjg}</span></li>
            </c:if>
            <c:if test="${item.gsah!=null}">
                <li class="list-group-item">公诉案号<span style="color: black;font:large bolder;margin-left: 2%">${item.gsah}</span></li>
            </c:if>
            <c:if test="${item.slztqfdmsss!=null}">
                <li class="list-group-item">审理中提起附带民事诉讼<span style="color: black;font:large bolder;margin-left: 2%">${item.slztqfdmsss}</span></li>
            </c:if>
            <c:if test="${item.jcyjyyqsl!=null}">
                <li class="list-group-item">检察院建议延期审理<span style="color: black;font:large bolder;margin-left: 2%">${item.jcyjyyqsl}</span></li>
            </c:if>
            <c:if test="${item.snft!=null}">
                <li class="list-group-item">少年法庭<span style="color: black;font:large bolder;margin-left: 2%">${item.snft}</span></li>
            </c:if>
            <c:if test="${item.xzesqsah!=null}">
                <li class="list-group-item">行政二审前审案号<span style="color: black;font:large bolder;margin-left: 2%">${item.xzesqsah}</span></li>
            </c:if>
            <c:if test="${item.qsland!=null}">
                <li class="list-group-item">前审立案年度<span style="color: black;font:large bolder;margin-left: 2%">${item.qsland}</span></li>
            </c:if>
            <c:if test="${item.qsfyjc!=null}">
                <li class="list-group-item">前审法院简称<span style="color: black;font:large bolder;margin-left: 2%">${item.qsfyjc}</span></li>
            </c:if>
            <c:if test="${item.fyjb!=null}">
                <li class="list-group-item">前审法院级别<span style="color: black;font:large bolder;margin-left: 2%">${item.fyjb}</span></li>
            </c:if>
            <c:if test="${item.qsahsxh!=null}">
                <li class="list-group-item">前审案号顺序号<span style="color: black;font:large bolder;margin-left: 2%">${item.qsahsxh}</span></li>
            </c:if>
            <c:if test="${item.qscpsj!=null}">
                <li class="list-group-item">前审裁判时间<span style="color: black;font:large bolder;margin-left: 2%">${item.qscpsj}</span></li>
            </c:if>
            <c:if test="${item.qswszl!=null}">
                <li class="list-group-item">前审文书种类<span style="color: black;font:large bolder;margin-left: 2%">${item.qswszl}</span></li>
            </c:if>
            <c:if test="${item.qsajyl!=null}">
                <li class="list-group-item">前审案件由来<span style="color: black;font:large bolder;margin-left: 2%">${item.qsajyl}</span></li>
            </c:if>
            <c:if test="${item.qsjafs!=null}">
                <li class="list-group-item">前审结案方式<span style="color: black;font:large bolder;margin-left: 2%">${item.qsjafs}</span></li>
            </c:if>
            <c:if test="${item.qssj!=null}">
                <li class="list-group-item">前审审级<span style="color: black;font:large bolder;margin-left: 2%">${item.qssj}</span></li>
            </c:if>
            <c:if test="${item.sshksfw!=null}">
                <li class="list-group-item">上诉或抗诉范围<span style="color: black;font:large bolder;margin-left: 2%">${item.sshksfw}</span></li>
            </c:if>
            <c:if test="${item.qspj!=null}">
                <li class="list-group-item">前审判决<span style="color: black;font:large bolder;margin-left: 2%">${item.qspj}</span></li>
            </c:if>
            <c:if test="${item.xsesqsah!=null}">
                <li class="list-group-item">刑事二审前审案号<span style="color: black;font:large bolder;margin-left: 2%">${item.xsesqsah}</span></li>
            </c:if>
            <c:if test="${item.bzfymc!=null}">
                <li class="list-group-item">标准法院名称<span style="color: black;font:large bolder;margin-left: 2%">${item.bzfymc}</span></li>
            </c:if>
            <c:if test="${item.qsgsjg!=null}">
                <li class="list-group-item">原公诉机关<span style="color: black;font:large bolder;margin-left: 2%">${item.qsgsjg}</span></li>
            </c:if>
            <li class="list-group-item list-group-item-warning" onclick="getCTR(${item.ajxh})" style="cursor: pointer"><span style="color: black;font:large bolder">缺席人</span></li>
            <li class="list-group-item list-group-item-danger" onclick="getZKJL(${item.ajxh})" style="cursor: pointer"><span style="color: black;font:large bolder">指控记录</span></li>
        </ul>
    </div>
</div>

<div class="modal fade" id="CTRModal" tabindex="-1" role="dialog" aria-labelledby="CTRModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="CTRModalLabel">缺席人</h4>
            </div>
            <div class="modal-body" id="CTRPanel">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="ZKJLModal" tabindex="-1" role="dialog" aria-labelledby="ZKJLModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="ZKJLModalLabel">指控记录</h4>
            </div>
            <div class="modal-body" id="ZKJLPanel">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
