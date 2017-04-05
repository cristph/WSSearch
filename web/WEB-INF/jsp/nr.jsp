<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/4/5
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="list-group">
    <c:choose>
        <c:when test="${list.size()>0}">
            <c:forEach items="${list}" var="item">
                <li class="list-group-item"><span style="color: black;font:large bolder;margin-left: 2%">${item.nr}</span></li>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <li class="list-group-item"><span style="color: black;font:large bolder;margin-left: 2%">无内容</span></li>
        </c:otherwise>
    </c:choose>
</ul>