<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/29
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${list.size()>0}">
        <c:forEach items="${list}" var="item" varStatus="i">
            <div class="panel panel-success">
                <div class="panel-heading" data-toggle="collapse" href="#flftcPanel${i.count}" style="cursor: pointer">
                    <h3 class="panel-title">法律法条No.${i.count}</h3>
                </div>
                <div class="panel-body collapse in" id="flftcPanel${i.count}">
                    <ul class="list-group">
                        <c:if test="${item.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.ftbh!=null}">
                            <li class="list-group-item">法条编号<span style="color: black;font:large bolder;margin-left: 2%">${item.ftbh}</span></li>
                        </c:if>
                        <c:if test="${item.ftmc!=null}">
                            <li class="list-group-item">法条名称<span style="color: black;font:large bolder;margin-left: 2%">${item.ftmc}</span></li>
                        </c:if>
                        <c:if test="${item.tk!=null}">
                            <li class="list-group-item">条款<span style="color: black;font:large bolder;margin-left: 2%">${item.tk}</span></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>无法律法条</p>
    </c:otherwise>
</c:choose>
