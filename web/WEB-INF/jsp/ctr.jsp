<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/29
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${list.size()>0}">
        <c:forEach items="${list}" var="item" varStatus="i">
            <div class="panel panel-success">
                <div class="panel-heading" data-toggle="collapse" href="#ctrcPanel${i.count}" style="cursor: pointer">
                    <h3 class="panel-title">缺席人No.${i.count}</h3>
                </div>
                <div class="panel-body collapse in" id="ctrcPanel${i.count}">
                    <ul class="list-group">
                        <c:if test="${item.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.ctrbh!=null}">
                            <li class="list-group-item">出庭人编号<span style="color: black;font:large bolder;margin-left: 2%">${item.ctrbh}</span></li>
                        </c:if>
                        <c:if test="${item.ctlx!=null}">
                            <li class="list-group-item">出庭类型<span style="color: black;font:large bolder;margin-left: 2%">${item.ctlx}</span></li>
                        </c:if>
                        <c:if test="${item.xm!=null}">
                            <li class="list-group-item">姓名<span style="color: black;font:large bolder;margin-left: 2%">${item.xm}</span></li>
                        </c:if>
                        <c:if test="${item.sssf!=null}">
                            <li class="list-group-item">诉讼身份<span style="color: black;font:large bolder;margin-left: 2%">${item.sssf}</span></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>无人缺席</p>
    </c:otherwise>
</c:choose>
