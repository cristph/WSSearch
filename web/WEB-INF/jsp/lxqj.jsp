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
                <div class="panel-heading" data-toggle="collapse" href="#lxqjcPanel${i.count}" style="cursor: pointer">
                    <h3 class="panel-title">量刑情节No.${i.count}</h3>
                </div>
                <div class="panel-body collapse in" id="lxqjcPanel${i.count}">
                    <ul class="list-group">
                        <c:if test="${item.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.lxqjbh!=null}">
                            <li class="list-group-item">量刑情节编号<span style="color: black;font:large bolder;margin-left: 2%">${item.lxqjbh}</span></li>
                        </c:if>
                        <c:if test="${item.lxqjzl!=null}">
                            <li class="list-group-item">量刑情节种类<span style="color: black;font:large bolder;margin-left: 2%">${item.lxqjzl}</span></li>
                        </c:if>
                        <c:if test="${item.xgr!=null}">
                            <li class="list-group-item">相关人<span style="color: black;font:large bolder;margin-left: 2%">${item.xgr}</span></li>
                        </c:if>
                        <c:if test="${item.qj!=null}">
                            <li class="list-group-item">情节<span style="color: black;font:large bolder;margin-left: 2%">${item.qj}</span></li>
                        </c:if>
                        <c:if test="${item.lxzl!=null}">
                            <li class="list-group-item">量刑种类<span style="color: black;font:large bolder;margin-left: 2%">${item.lxzl}</span></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>无量刑情节r</p>
    </c:otherwise>
</c:choose>