<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/28
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${WsDsrQzcsList.size()>0}">
        <c:forEach items="${WsDsrQzcsList}" var="item" varStatus="i">
            <div class="panel panel-success">
                <div class="panel-heading" data-toggle="collapse" href="#dsrqzcsPanel${i.count}" style="cursor: pointer;">
                    <h3 class="panel-title">当事人强制措施No.${i.count}</h3>
                </div>
                <div class="panel-body collapse in" id="dsrqzcsPanel${i.count}">
                    <ul class="list-group">
                        <c:if test="${item.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.qzcsbh!=null}">
                            <li class="list-group-item">强制措施编号<span style="color: black;font:large bolder;margin-left: 2%">${item.qzcsbh}</span></li>
                        </c:if>
                        <c:if test="${item.dsrbh!=null}">
                            <li class="list-group-item">当事人编号<span style="color: black;font:large bolder;margin-left: 2%">${item.dsrbh}</span></li>
                        </c:if>
                        <c:if test="${item.zl!=null}">
                            <li class="list-group-item">种类<span style="color: black;font:large bolder;margin-left: 2%">${item.zl}</span></li>
                        </c:if>
                        <c:if test="${item.zxsj!=null}">
                            <li class="list-group-item">执行时间<span style="color: black;font:large bolder;margin-left: 2%">${item.zxsj}</span></li>
                        </c:if>
                        <c:if test="${item.dw!=null}">
                            <li class="list-group-item">执行单位<span style="color: black;font:large bolder;margin-left: 2%">${item.dw}</span></li>
                        </c:if>
                        <c:if test="${item.yy!=null}">
                            <li class="list-group-item">强制措施原因<span style="color: black;font:large bolder;margin-left: 2%">${item.yy}</span></li>
                        </c:if>
                        <c:if test="${item.sfdb!=null}">
                            <li class="list-group-item">是否逮捕<span style="color: black;font:large bolder;margin-left: 2%">${item.sfdb}</span></li>
                        </c:if>
                        <c:if test="${item.dbrq!=null}">
                            <li class="list-group-item">逮捕日期<span style="color: black;font:large bolder;margin-left: 2%">${item.dbrq}</span></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        未采取强制措施
    </c:otherwise>
</c:choose>


