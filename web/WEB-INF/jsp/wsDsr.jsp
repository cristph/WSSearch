<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/28
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${list}" var="item" varStatus="i">
    <div class="panel panel-success">
        <div class="panel-heading" data-toggle="collapse" href="#dsrPanel${i.count}" style="cursor: pointer">
            <h3 class="panel-title">当事人No.${i.count}</h3>
        </div>
        <div class="panel-body collapse" id="dsrPanel${i.count}">
            <ul class="list-group">
                <c:if test="${item.ajxh!=null}">
                    <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
                </c:if>
                <c:if test="${item.dsrbh!=null}">
                    <li class="list-group-item">当事人编号<span style="color: black;font:large bolder;margin-left: 2%">${item.dsrbh}</span></li>
                </c:if>
                <c:if test="${item.ssdw!=null}">
                    <li class="list-group-item">诉讼地位<span style="color: black;font:large bolder;margin-left: 2%">${item.ssdw}</span></li>
                </c:if>
                <c:if test="${item.ysssdw!=null}">
                    <li class="list-group-item">原审诉讼地位<span style="color: black;font:large bolder;margin-left: 2%">${item.ysssdw}</span></li>
                </c:if>
                <c:if test="${item.dsrlb!=null}">
                    <li class="list-group-item">当事人类别<span style="color: black;font:large bolder;margin-left: 2%">${item.dsrlb}</span></li>
                </c:if>
                <c:if test="${item.xm!=null}">
                    <li class="list-group-item">姓名<span style="color: black;font:large bolder;margin-left: 2%">${item.xm}</span></li>
                </c:if>
                <c:if test="${item.xb!=null}">
                    <li class="list-group-item">性别<span style="color: black;font:large bolder;margin-left: 2%">${item.xb}</span></li>
                </c:if>
                <c:if test="${item.mz!=null}">
                    <li class="list-group-item">民族<span style="color: black;font:large bolder;margin-left: 2%">${item.mz}</span></li>
                </c:if>
                <c:if test="${item.gj!=null}">
                    <li class="list-group-item">国籍<span style="color: black;font:large bolder;margin-left: 2%">${item.gj}</span></li>
                </c:if>
                <c:if test="${item.whcd!=null}">
                    <li class="list-group-item">文化程度<span style="color: black;font:large bolder;margin-left: 2%">${item.whcd}</span></li>
                </c:if>
                <c:if test="${item.zjlx!=null}">
                    <li class="list-group-item">证件类型<span style="color: black;font:large bolder;margin-left: 2%">${item.zjlx}</span></li>
                </c:if>
                <c:if test="${item.zjhm!=null}">
                    <li class="list-group-item">证件号码<span style="color: black;font:large bolder;margin-left: 2%">${item.zjhm}</span></li>
                </c:if>
                <c:if test="${item.zw!=null}">
                    <li class="list-group-item">职务<span style="color: black;font:large bolder;margin-left: 2%">${item.zw}</span></li>
                </c:if>
                <c:if test="${item.dz!=null}">
                    <li class="list-group-item">地址<span style="color: black;font:large bolder;margin-left: 2%">${item.dz}</span></li>
                </c:if>
                <c:if test="${item.sfzh!=null}">
                    <li class="list-group-item">是否再婚<span style="color: black;font:large bolder;margin-left: 2%">${item.sfzh}</span></li>
                </c:if>
                <c:if test="${item.tshy!=null}">
                    <li class="list-group-item">特殊行业<span style="color: black;font:large bolder;margin-left: 2%">${item.tshy}</span></li>
                </c:if>
                <c:if test="${item.jgdbr!=null}">
                    <li class="list-group-item">机关代表人<span style="color: black;font:large bolder;margin-left: 2%">${item.jgdbr}</span></li>
                </c:if>
                <c:if test="${item.dwxz!=null}">
                    <li class="list-group-item">单位性质<span style="color: black;font:large bolder;margin-left: 2%">${item.dwxz}</span></li>
                </c:if>
                <c:if test="${item.xzflgxzt!=null}">
                    <li class="list-group-item">行政法律关系主体<span style="color: black;font:large bolder;margin-left: 2%">${item.xzflgxzt}</span></li>
                </c:if>
                <c:if test="${item.xzglfw!=null}">
                    <li class="list-group-item">行政管理范围<span style="color: black;font:large bolder;margin-left: 2%">${item.xzglfw}</span></li>
                </c:if>
                <c:if test="${item.bglx!=null}">
                    <li class="list-group-item">被告类型<span style="color: black;font:large bolder;margin-left: 2%">${item.bglx}</span></li>
                </c:if>
                <c:if test="${item.zzjgdm!=null}">
                    <li class="list-group-item">组织机构代码<span style="color: black;font:large bolder;margin-left: 2%">${item.zzjgdm}</span></li>
                </c:if>
                <c:if test="${item.sfbhr!=null}">
                    <li class="list-group-item">是否被害人<span style="color: black;font:large bolder;margin-left: 2%">${item.sfbhr}</span></li>
                </c:if>
                <c:if test="${item.zrrsf!=null}">
                    <li class="list-group-item">自然人身份<span style="color: black;font:large bolder;margin-left: 2%">${item.zrrsf}</span></li>
                </c:if>
                <c:if test="${item.hjszd!=null}">
                    <li class="list-group-item">户籍所在地<span style="color: black;font:large bolder;margin-left: 2%">${item.hjszd}</span></li>
                </c:if>
                <c:if test="${item.xjycs!=null}">
                    <li class="list-group-item">现羁押场所<span style="color: black;font:large bolder;margin-left: 2%">${item.xjycs}</span></li>
                </c:if>
                <c:if test="${item.xszrnl!=null}">
                    <li class="list-group-item">刑事责任能力<span style="color: black;font:large bolder;margin-left: 2%">${item.xszrnl}</span></li>
                </c:if>
                <c:if test="${item.sfct!=null}">
                    <li class="list-group-item">是否出庭<span style="color: black;font:large bolder;margin-left: 2%">${item.sfct}</span></li>
                </c:if>
                <c:if test="${item.xw!=null}">
                    <li class="list-group-item">学位<span style="color: black;font:large bolder;margin-left: 2%">${item.xw}</span></li>
                </c:if>
                <c:if test="${item.zzmm!=null}">
                    <li class="list-group-item">政治面貌<span style="color: black;font:large bolder;margin-left: 2%">${item.zzmm}</span></li>
                </c:if>
                <li class="list-group-item list-group-item-danger" onclick="getQK(${item.ajxh},${item.dsrbh})" style="cursor: pointer"><span style="color: black;font:large bolder">犯罪前科</span></li>
                <li class="list-group-item list-group-item-warning" onclick="getQZCS(${item.ajxh},${item.dsrbh})" style="cursor: pointer"><span style="color: black;font:large bolder">强制措施</span></li>
            </ul>
        </div>
    </div>
</c:forEach>

<div class="modal fade" id="QKModal" tabindex="-1" role="dialog" aria-labelledby="QKModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="QKModalLabel">当事人前科</h4>
            </div>
            <div class="modal-body" id="QKPanel">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="QZCSModal" tabindex="-1" role="dialog" aria-labelledby="QZCSModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="QZCSModalLabel">当事人强制措施</h4>
            </div>
            <div class="modal-body" id="QZCSPanel">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

