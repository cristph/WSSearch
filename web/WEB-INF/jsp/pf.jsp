<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/29
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${list.size()>0}">
        <c:forEach items="${list}" var="item" varStatus="i">
            <div class="panel panel-success">
                <div class="panel-heading" data-toggle="collapse" href="#pfcPanel${i.count}" style="cursor: pointer">
                    <h3 class="panel-title">判罚No.${i.count}</h3>
                </div>
                <div class="panel-body collapse in" id="pfcPanel${i.count}">
                    <ul class="list-group">
                        <c:if test="${item.pf.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.pf.fzbh!=null}">
                            <li class="list-group-item">分组编号<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.fzbh}</span></li>
                        </c:if>
                        <c:if test="${item.pf.pfbh!=null}">
                            <li class="list-group-item">判罚编号<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.pfbh}</span></li>
                        </c:if>
                        <c:if test="${item.pf.pflx!=null}">
                            <li class="list-group-item">判罚类型<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.pflx}</span></li>
                        </c:if>
                        <c:if test="${item.pf.zm!=null}">
                            <li class="list-group-item">罪名<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.zm}</span></li>
                        </c:if>
                        <c:if test="${item.pf.zmdm!=null}">
                            <li class="list-group-item">罪名代码<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.zmdm}</span></li>
                        </c:if>
                        <c:if test="${item.pf.wzzm!=null}">
                            <li class="list-group-item">完整罪名<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.wzzm}</span></li>
                        </c:if>
                        <c:if test="${item.pf.zxlb!=null}">
                            <li class="list-group-item">主刑类别<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.zxlb}</span></li>
                        </c:if>
                        <c:if test="${item.pf.zxqx!=null}">
                            <li class="list-group-item">主刑期限<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.zxqx}</span></li>
                        </c:if>
                        <c:if test="${item.pf.hxlb!=null}">
                            <li class="list-group-item">缓刑类别<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.hxlb}</span></li>
                        </c:if>
                        <c:if test="${item.pf.hbqx!=null}">
                            <li class="list-group-item">缓刑期限<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.hbqx}</span></li>
                        </c:if>
                        <c:if test="${item.pf.pjjglx!=null}">
                            <li class="list-group-item">判决结果类型<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.pjjglx}</span></li>
                        </c:if>
                        <c:if test="${item.pf.yzszbf!=null}">
                            <li class="list-group-item">原罪数罪并罚<span style="color: black;font:large bolder;margin-left: 2%">${item.pf.yzszbf}</span></li>
                        </c:if>
                        <%--<li class="list-group-item list-group-item-warning" onclick="getFJX(${item.ajxh},${item.fzbh},${item.pfbh})" style="cursor: pointer">附加刑<span style="color: black;font:large bolder;margin-left: 2%">${item.yzszbf}</span></li>--%>
                    </ul>
                    <c:choose>
                        <c:when test="${item.fjxList.size()>0}">
                            <c:forEach items="${item.fjxList}" var="fjx" varStatus="j">
                                <div class="panel panel-danger">
                                    <div class="panel-heading" data-toggle="collapse" href="#fjxcPanel${j.count}" style="cursor: pointer">
                                        <h3 class="panel-title">附加刑No.${j.count}</h3>
                                    </div>
                                    <div class="panel-body collapse" id="fjxcPanel${j.count}">
                                        <ul class="list-group">
                                            <c:if test="${fjx.ajxh!=null}">
                                                <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${fjx.ajxh}</span></li>
                                            </c:if>
                                            <c:if test="${fjx.fjxbh!=null}">
                                                <li class="list-group-item">附加刑编号<span style="color: black;font:large bolder;margin-left: 2%">${fjx.fjxbh}</span></li>
                                            </c:if>
                                            <c:if test="${fjx.fzbh!=null}">
                                                <li class="list-group-item">分组编号<span style="color: black;font:large bolder;margin-left: 2%">${fjx.fzbh}</span></li>
                                            </c:if>
                                            <c:if test="${fjx.pfbh!=null}">
                                                <li class="list-group-item">判罚编号<span style="color: black;font:large bolder;margin-left: 2%">${fjx.pfbh}</span></li>
                                            </c:if>
                                            <c:if test="${fjx.lb!=null}">
                                                <li class="list-group-item">类别<span style="color: black;font:large bolder;margin-left: 2%">${fjx.lb}</span></li>
                                            </c:if>
                                            <c:if test="${fjx.se!=null}">
                                                <li class="list-group-item">数额<span style="color: black;font:large bolder;margin-left: 2%">${fjx.se}</span></li>
                                            </c:if>
                                            <c:if test="${fjx.bz!=null}">
                                                <li class="list-group-item">备注<span style="color: black;font:large bolder;margin-left: 2%">${fjx.bz}</span></li>
                                            </c:if>
                                            <c:if test="${fjx.qx!=null}">
                                                <li class="list-group-item">期限<span style="color: black;font:large bolder;margin-left: 2%">${fjx.qx}</span></li>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div class="panel panel-danger">
                                <div class="panel-heading" style="cursor: pointer">
                                    <h3 class="panel-title">无附加刑</h3>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>无判罚</p>
    </c:otherwise>
</c:choose>
