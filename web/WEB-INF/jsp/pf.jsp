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
                        <c:if test="${item.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.fzbh!=null}">
                            <li class="list-group-item">分组编号<span style="color: black;font:large bolder;margin-left: 2%">${item.fzbh}</span></li>
                        </c:if>
                        <c:if test="${item.pfbh!=null}">
                            <li class="list-group-item">判罚编号<span style="color: black;font:large bolder;margin-left: 2%">${item.pfbh}</span></li>
                        </c:if>
                        <c:if test="${item.pflx!=null}">
                            <li class="list-group-item">判罚类型<span style="color: black;font:large bolder;margin-left: 2%">${item.pflx}</span></li>
                        </c:if>
                        <c:if test="${item.zm!=null}">
                            <li class="list-group-item">罪名<span style="color: black;font:large bolder;margin-left: 2%">${item.zm}</span></li>
                        </c:if>
                        <c:if test="${item.zmdm!=null}">
                            <li class="list-group-item">罪名代码<span style="color: black;font:large bolder;margin-left: 2%">${item.zmdm}</span></li>
                        </c:if>
                        <c:if test="${item.wzzm!=null}">
                            <li class="list-group-item">完整罪名<span style="color: black;font:large bolder;margin-left: 2%">${item.wzzm}</span></li>
                        </c:if>
                        <c:if test="${item.zxlb!=null}">
                            <li class="list-group-item">主刑类别<span style="color: black;font:large bolder;margin-left: 2%">${item.zxlb}</span></li>
                        </c:if>
                        <c:if test="${item.zxqx!=null}">
                            <li class="list-group-item">主刑期限<span style="color: black;font:large bolder;margin-left: 2%">${item.zxqx}</span></li>
                        </c:if>
                        <c:if test="${item.hxlb!=null}">
                            <li class="list-group-item">缓刑类别<span style="color: black;font:large bolder;margin-left: 2%">${item.hxlb}</span></li>
                        </c:if>
                        <c:if test="${item.hbqx!=null}">
                            <li class="list-group-item">缓刑期限<span style="color: black;font:large bolder;margin-left: 2%">${item.hbqx}</span></li>
                        </c:if>
                        <c:if test="${item.pjjglx!=null}">
                            <li class="list-group-item">判决结果类型<span style="color: black;font:large bolder;margin-left: 2%">${item.pjjglx}</span></li>
                        </c:if>
                        <c:if test="${item.yzszbf!=null}">
                            <li class="list-group-item">原罪数罪并罚<span style="color: black;font:large bolder;margin-left: 2%">${item.yzszbf}</span></li>
                        </c:if>
                        <li class="list-group-item list-group-item-warning" onclick="getFJX(${item.ajxh},${item.fzbh},${item.pfbh})" style="cursor: pointer">附加刑<span style="color: black;font:large bolder;margin-left: 2%">${item.yzszbf}</span></li>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>无判罚</p>
    </c:otherwise>
</c:choose>
