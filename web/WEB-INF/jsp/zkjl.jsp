<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/29
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${list.size()>0}">
        <c:forEach items="${list}" var="item" varStatus="i">
            <div class="panel panel-success">
                <div class="panel-heading" data-toggle="collapse" href="#zkjlcPanel${i.count}" style="cursor: pointer">
                    <h3 class="panel-title">指控记录No.${i.count}</h3>
                </div>
                <div class="panel-body collapse in" id="zkjlcPanel${i.count}">
                    <ul class="list-group">
                        <c:if test="${item.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.zkjlbh!=null}">
                            <li class="list-group-item">指控编号<span style="color: black;font:large bolder;margin-left: 2%">${item.zkjlbh}</span></li>
                        </c:if>
                        <c:if test="${item.xgr!=null}">
                            <li class="list-group-item">相关人<span style="color: black;font:large bolder;margin-left: 2%">${item.xgr}</span></li>
                        </c:if>
                        <c:if test="${item.zmbh!=null}">
                            <li class="list-group-item">罪名编号<span style="color: black;font:large bolder;margin-left: 2%">${item.zmbh}</span></li>
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
                    </ul>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>未提出指控</p>
    </c:otherwise>
</c:choose>