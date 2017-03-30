<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/30
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${list}" var="item">
    <div class="AJ">
        <div class="row AJBiaoTi" onclick="showAj('${item.ajxh}')">
                ${item.spcx} ${item.wsmc}
        </div>
        <div class="row AJCiBiaoTi" onclick="showAj('${item.ajxh}')">
                ${item.jbfy} &nbsp;&nbsp;&nbsp;&nbsp; ${item.ah} &nbsp;&nbsp;&nbsp;&nbsp; ${item.pjsj}
        </div>
        <input type="hidden" value="${item.ajxh}">
    </div>
</c:forEach>