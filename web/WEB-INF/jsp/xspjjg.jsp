<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/29
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${list}" var="item" varStatus="i">
    <div class="panel panel-success">
        <div class="panel-heading" data-toggle="collapse" href="#xspjjgcPanel${i.count}" style="cursor: pointer">
            <h3 class="panel-title">刑事判决结果分组No.${i.count}</h3>
        </div>
        <div class="panel-body collapse" id="xspjjgcPanel${i.count}">
            <ul class="list-group">
                <c:if test="${item.ajxh!=null}">
                    <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                </c:if>
                <c:if test="${item.fzbh!=null}">
                    <li class="list-group-item">分组编号<span style="color: black;font:large bolder;margin-left: 2%">${item.fzbh}</span></li>
                </c:if>
                <c:if test="${item.sscyr!=null}">
                    <li class="list-group-item">诉讼参与人<span style="color: black;font:large bolder;margin-left: 2%">${item.sscyr}</span></li>
                </c:if>
                <c:if test="${item.pjjzm!=null}">
                    <li class="list-group-item">判决主罪名<span style="color: black;font:large bolder;margin-left: 2%">${item.pjjzm}</span></li>
                </c:if>
                <c:if test="${item.zmdm!=null}">
                    <li class="list-group-item">罪名代码<span style="color: black;font:large bolder;margin-left: 2%">${item.zmdm}</span></li>
                </c:if>
                <c:if test="${item.wzzm!=null}">
                    <li class="list-group-item">完整罪名<span style="color: black;font:large bolder;margin-left: 2%">${item.wzzm}</span></li>
                </c:if>
                <c:if test="${item.xqksrq!=null}">
                    <li class="list-group-item">刑期开始日期<span style="color: black;font:large bolder;margin-left: 2%">${item.xqksrq}</span></li>
                </c:if>
                <c:if test="${item.xqjsrq!=null}">
                    <li class="list-group-item">刑期结束日期<span style="color: black;font:large bolder;margin-left: 2%">${item.xqjsrq}</span></li>
                </c:if>
                <c:if test="${item.xqzdbf!=null}">
                    <li class="list-group-item">刑期折抵办法<span style="color: black;font:large bolder;margin-left: 2%">${item.xqzdbf}</span></li>
                </c:if>
                <c:if test="${item.mzhwfsf!=null}">
                    <li class="list-group-item">免罪或无罪释放<span style="color: black;font:large bolder;margin-left: 2%">${item.mzhwfsf}</span></li>
                </c:if>
                <c:if test="${item.szbf!=null}">
                    <li class="list-group-item">数罪并罚<span style="color: black;font:large bolder;margin-left: 2%">${item.szbf}</span></li>
                </c:if>
                <c:if test="${item.hblx!=null}">
                    <li class="list-group-item">合并量刑<span style="color: black;font:large bolder;margin-left: 2%">${item.hblx}</span></li>
                </c:if>
                <li class="list-group-item list-group-item-danger" onclick="getPF(${item.ajxh},${item.fzbh})" style="cursor: pointer"><span style="color: black;font:large bolder">判罚</span></li>
            </ul>
        </div>
    </div>
</c:forEach>

<div class="modal fade" id="PFModal" tabindex="-1" role="dialog" aria-labelledby="PFModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="PFModalLabel">判罚</h4>
            </div>
            <div class="modal-body" id="PFPanel">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>