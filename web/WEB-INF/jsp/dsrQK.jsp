<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/28
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${WsDsrQkList.size()>0}">
        <c:forEach items="${WsDsrQkList}" var="item" varStatus="i">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">当事人前科No.${i.count}</h3>
                </div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:if test="${item.ajxh!=null}">
                            <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                        </c:if>
                        <c:if test="${item.qkbh!=null}">
                            <li class="list-group-item">前科编号<span style="color: black;font:large bolder;margin-left: 2%">${item.qkbh}</span></li>
                        </c:if>
                        <c:if test="${item.dsrbh!=null}">
                            <li class="list-group-item">当事人编号<span style="color: black;font:large bolder;margin-left: 2%">${item.dsrbh}</span></li>
                        </c:if>
                        <c:if test="${item.qklb!=null}">
                            <li class="list-group-item">前科类别<span style="color: black;font:large bolder;margin-left: 2%">${item.qklb}</span></li>
                        </c:if>
                        <c:if test="${item.cftime!=null}">
                            <li class="list-group-item">处罚时间<span style="color: black;font:large bolder;margin-left: 2%">${item.cftime}</span></li>
                        </c:if>
                        <c:if test="${item.cfyy!=null}">
                            <li class="list-group-item">处罚原因<span style="color: black;font:large bolder;margin-left: 2%">${item.cfyy}</span></li>
                        </c:if>
                        <c:if test="${item.cfdw!=null}">
                            <li class="list-group-item">处罚单位<span style="color: black;font:large bolder;margin-left: 2%">${item.cfdw}</span></li>
                        </c:if>
                        <c:if test="${item.cfxs!=null}">
                            <li class="list-group-item">处罚形式<span style="color: black;font:large bolder;margin-left: 2%">${item.cfxs}</span></li>
                        </c:if>
                        <c:if test="${item.cfxq!=null}">
                            <li class="list-group-item">处罚刑期<span style="color: black;font:large bolder;margin-left: 2%">${item.cfxq}</span></li>
                        </c:if>
                        <c:if test="${item.xmsfsj!=null}">
                            <li class="list-group-item">刑满释放日期<span style="color: black;font:large bolder;margin-left: 2%">${item.xmsfsj}</span></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>无犯罪前科</p>
    </c:otherwise>
</c:choose>


