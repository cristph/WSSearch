<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/4/5
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-success">
    <div class="panel-heading" data-toggle="collapse" href="#jbqkcPanel" style="cursor: pointer">
        <h3 class="panel-title">
            案件基本情况
        </h3>
    </div>
    <div class="panel-body collapse" id="jbqkcPanel">
        <ul class="list-group">
            <c:choose>
                <c:when test="${cl eq 'msxz'}">
                    <c:if test="${item.ajxh!=null}">
                        <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                    </c:if>
                    <c:if test="${item.qsdl!=null}">
                        <li class="list-group-item">前审段落<span style="color: black;font:large bolder;margin-left: 2%">${item.qsdl}</span></li>
                    </c:if>
                    <c:if test="${item.qsygscd!=null}">
                        <li class="list-group-item">前审原告诉称段<span style="color: black;font:large bolder;margin-left: 2%">${item.qsygscd}</span></li>
                    </c:if>
                    <c:if test="${item.qsbgbcd!=null}">
                        <li class="list-group-item">前审被告辩称段<span style="color: black;font:large bolder;margin-left: 2%">${item.qsbgbcd}</span></li>
                    </c:if>
                    <c:if test="${item.qsdsryjd!=null}">
                        <li class="list-group-item">前审当事人意见段<span style="color: black;font:large bolder;margin-left: 2%">${item.qsdsryjd}</span></li>
                    </c:if>
                    <c:if test="${item.qsfsscd!=null}">
                        <li class="list-group-item">前审反诉诉称段<span style="color: black;font:large bolder;margin-left: 2%">${item.qsfsscd}</span></li>
                    </c:if>
                    <c:if test="${item.qspjd!=null}">
                        <li class="list-group-item">前审判决段<span style="color: black;font:large bolder;margin-left: 2%">${item.qspjd}</span></li>
                    </c:if>
                    <c:if test="${item.bsdl!=null}">
                        <li class="list-group-item">本审段落<span style="color: black;font:large bolder;margin-left: 2%">${item.bsdl}</span></li>
                    </c:if>
                    <c:if test="${item.ssrcsd!=null}">
                        <li class="list-group-item">上诉人诉称段<span style="color: black;font:large bolder;margin-left: 2%">${item.ssrcsd}</span></li>
                    </c:if>
                    <c:if test="${item.bsdsryjd!=null}">
                        <li class="list-group-item">本审第三人意见段<span style="color: black;font:large bolder;margin-left: 2%">${item.bsdsryjd}</span></li>
                    </c:if>
                    <c:if test="${item.ygscd!=null}">
                        <li class="list-group-item">原告诉称段<span style="color: black;font:large bolder;margin-left: 2%">${item.ygscd}</span></li>
                    </c:if>
                    <c:if test="${item.bgbcd!=null}">
                        <li class="list-group-item">被告辩称段<span style="color: black;font:large bolder;margin-left: 2%">${item.bgbcd}</span></li>
                    </c:if>
                    <c:if test="${item.dsryjd!=null}">
                        <li class="list-group-item">当事人意见段<span style="color: black;font:large bolder;margin-left: 2%">${item.dsryjd}</span></li>
                    </c:if>
                    <c:if test="${item.fsscd!=null}">
                        <li class="list-group-item">反诉诉称段<span style="color: black;font:large bolder;margin-left: 2%">${item.fsscd}</span></li>
                    </c:if>
                    <c:if test="${item.fsbcd!=null}">
                        <li class="list-group-item">反诉辩称段<span style="color: black;font:large bolder;margin-left: 2%">${item.fsbcd}</span></li>
                    </c:if>
                    <c:if test="${item.xzsszyd!=null}">
                        <li class="list-group-item">行政诉讼争议段<span style="color: black;font:large bolder;margin-left: 2%">${item.xzsszyd}</span></li>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${cl eq 'xses'}">
                            <c:if test="${item.ajxh!=null}">
                                <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                            </c:if>
                            <c:if test="${item.xsbssld!=null}">
                                <li class="list-group-item">刑事本审审理段<span style="color: black;font:large bolder;margin-left: 2%">${item.xsbssld}</span></li>
                            </c:if>
                            <c:if test="${item.xsqssld!=null}">
                                <li class="list-group-item">刑事前审审理段<span style="color: black;font:large bolder;margin-left: 2%">${item.xsqssld}</span></li>
                            </c:if>
                            <c:if test="${item.qscpyzypjjg!=null}">
                                <li class="list-group-item">前审裁判要旨与判决结果<span style="color: black;font:large bolder;margin-left: 2%">${item.qscpyzypjjg}</span></li>
                            </c:if>
                            <c:if test="${item.qscmssyzj!=null}">
                                <li class="list-group-item">前审查明事实与证据<span style="color: black;font:large bolder;margin-left: 2%">${item.qscmssyzj}</span></li>
                            </c:if>
                            <c:if test="${item.ssssbhyj!=null}">
                                <li class="list-group-item">上诉申诉辩护意见<span style="color: black;font:large bolder;margin-left: 2%">${item.ssssbhyj}</span></li>
                            </c:if>
                            <c:if test="${item.jcjgyj!=null}">
                                <li class="list-group-item">检查机关意见<span style="color: black;font:large bolder;margin-left: 2%">${item.jcjgyj}</span></li>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${item.ajxh!=null}">
                                <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                            </c:if>
                            <c:if test="${item.zkdl!=null}">
                                <li class="list-group-item">指控段落<span style="color: black;font:large bolder;margin-left: 2%">${item.zkdl}</span></li>
                            </c:if>
                            <c:if test="${item.bhdl!=null}">
                                <li class="list-group-item">辩护段落<span style="color: black;font:large bolder;margin-left: 2%">${item.bhdl}</span></li>
                            </c:if>
                            <c:if test="${item.xsbssld!=null}">
                                <li class="list-group-item">刑事本审审理段<span style="color: black;font:large bolder;margin-left: 2%">${item.xsbssld}</span></li>
                            </c:if>
                            <c:if test="${item.fdmsssqqd!=null}">
                                <li class="list-group-item">附带民事诉讼请求段<span style="color: black;font:large bolder;margin-left: 2%">${item.fdmsssqqd}</span></li>
                            </c:if>
                            <c:if test="${item.zkss!=null}">
                                <li class="list-group-item">指控事实<span style="color: black;font:large bolder;margin-left: 2%">${item.zkss}</span></li>
                            </c:if>
                            <c:if test="${item.zkzj!=null}">
                                <li class="list-group-item">指控证据<span style="color: black;font:large bolder;margin-left: 2%">${item.zkzj}</span></li>
                            </c:if>
                            <c:if test="${item.zkyj!=null}">
                                <li class="list-group-item">指控意见<span style="color: black;font:large bolder;margin-left: 2%">${item.zkyj}</span></li>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </ul>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#BGRBCPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    被告人辩称
                </h3>
            </div>
            <div class="panel-body collapse" id="BGRBCPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#BGRBHPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    辩护人辩护
                </h3>
            </div>
            <div class="panel-body collapse" id="BGRBHPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#BSSLDPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    本审审理段
                </h3>
            </div>
            <div class="panel-body collapse" id="BSSLDPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#BSSRBCDPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    被上诉人辩称段
                </h3>
            </div>
            <div class="panel-body collapse" id="BSSRBCDPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#BSZJDPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    本审证据段
                </h3>
            </div>
            <div class="panel-body collapse" id="BSZJDPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#CMSSDPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    查明事实段
                </h3>
            </div>
            <div class="panel-body collapse" id="CMSSDPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#QSSLDPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    前审审理段
                </h3>
            </div>
            <div class="panel-body collapse" id="QSSLDPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#QSZJDPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    前审证据段
                </h3>
            </div>
            <div class="panel-body collapse" id="QSZJDPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

        <div class="panel panel-success">
            <div class="panel-heading" data-toggle="collapse" href="#ZJDPanel" style="cursor: pointer">
                <h3 class="panel-title">
                    证据段
                </h3>
            </div>
            <div class="panel-body collapse" id="ZJDPanel">
                <ul class="list-group">

                </ul>
            </div>
        </div>

    </div>
</div>
