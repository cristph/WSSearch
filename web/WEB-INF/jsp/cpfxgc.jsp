<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2017/3/29
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-success">
    <div class="panel-heading" data-toggle="collapse" href="#cpfxgccPanel" style="cursor: pointer">
        <h3 class="panel-title">裁判分析过程</h3>
    </div>
    <div class="panel-body collapse" id="cpfxgccPanel">
        <ul class="list-group">
            <c:if test="${item.ajxh!=null}">
                <li class="list-group-item">案件序号<span style="color: black;font:large bolder;margin-left: 2%">${item.ajxh}</span></li>
            </c:if>
            <c:if test="${item.jafslx!=null}">
                <li class="list-group-item">结案方式类型<span style="color: black;font:large bolder;margin-left: 2%">${item.jafslx}</span></li>
            </c:if>
            <c:if test="${item.xzpc!=null}">
                <li class="list-group-item">行政赔偿，行政案件特有<span style="color: black;font:large bolder;margin-left: 2%">${item.xzpc}</span></li>
            </c:if>
            <c:if test="${item.ysajly!=null}">
                <li class="list-group-item">一审案件来源，一审案件特有<span style="color: black;font:large bolder;margin-left: 2%">${item.ysajly}</span></li>
            </c:if>
            <c:if test="${item.sfjgxzfy!=null}">
                <li class="list-group-item">是否经过行政复议<span style="color: black;font:large bolder;margin-left: 2%">${item.sfjgxzfy}</span></li>
            </c:if>
            <c:if test="${item.xzxwwfbj!=null}">
                <li class="list-group-item">行政行为违法补救<span style="color: black;font:large bolder;margin-left: 2%">${item.xzxwwfbj}</span></li>
            </c:if>
            <c:if test="${item.ktqsqchss!=null}">
                <li class="list-group-item">开庭前申请撤诉<span style="color: black;font:large bolder;margin-left: 2%">${item.ktqsqchss}</span></li>
            </c:if>
            <c:if test="${item.gtfz!=null}">
                <li class="list-group-item">共同犯罪<span style="color: black;font:large bolder;margin-left: 2%">${item.gtfz}</span></li>
            </c:if>
            <c:if test="${item.bgrtyrzcx!=null}">
                <li class="list-group-item">被告人同意认罪程序<span style="color: black;font:large bolder;margin-left: 2%">${item.bgrtyrzcx}</span></li>
            </c:if>
            <li class="list-group-item list-group-item-warning" onclick="getFLFT(${item.ajxh})" style="cursor: pointer"><span style="color: black;font:large bolder">法律法条</span></li>
            <li class="list-group-item list-group-item-danger" onclick="getLXQJ(${item.ajxh})" style="cursor: pointer"><span style="color: black;font:large bolder">量刑情节</span></li>
        </ul>
    </div>
</div>

<div class="modal fade" id="FLFTModal" tabindex="-1" role="dialog" aria-labelledby="FLFTModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="FLFTModalLabel">法律法条</h4>
            </div>
            <div class="modal-body" id="FLFTPanel">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="LXQJModal" tabindex="-1" role="dialog" aria-labelledby="LXQJModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="LXQJModalLabel">量刑情节</h4>
            </div>
            <div class="modal-body" id="LXQJPanel">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>