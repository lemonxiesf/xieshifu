<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>报销管理-报销单详情</title>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet" />
<!-- <link href="resource/css/main.css" rel="stylesheet" /> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/validation/jquery.validate.js"></script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>报销管理</li>
			<li>报销单详情</li>
		</ul>
	</div>
	<div class="alert alert-warning alert-dismissible fade in" role="alert"
		style="display:${info==null?'none':'block' };margin-bottom: 0px;">
		<h4 align="center" style="color: red">${info }</h4>
	</div>
	<form action="expense/axpenseAdd" id="f1" method="post"
		class="form-horizontal">
		<input type="hidden" name="expenseState" id="expenseState" value="1" />
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销原因</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${expense.expensename }</p>

					</div>
				</div>
			</div>
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销总金额</label>
					<div class="col-xs-5 ">
						<p class="form-control-static">${expense.expensetotal}</p>

					</div>
				</div>
			</div>
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销详情</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${expense.expensedesc}</p>
					</div>
				</div>
			</div>
            <div class="col-xs-7">
                <div class="form-group ">
                    <label class="col-xs-3 control-label">报销凭证</label>
                    <div class="col-xs-9 ">
                        <img class="img-rounded" style="width: 200px;height: 200px" src="http://127.0.0.1:8080/images/${expense.imagePath}" alt="报销凭证"/>
                    </div>
                </div>
            </div>
		</div>
		<!--结束1 -->

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">报销单明细</h5>
		<table class="table" id="tab">
			<tr>
				<th>明细编号</th>
				<th>费用名称</th>
				<th>具体金额</th>
				<th>费用说明</th>

			</tr>

			<c:forEach items="${detailList}" var="detail">
				<tr>
					<td>${detail.detailid }</td>
					<td>${detail.costname }</td>
					<td>${detail.detailmoney }</td>
					<td>${detail.detaildesc }</td>
				</tr>

			</c:forEach>

		</table>
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">审核历史记录
		</h5>
		<table class="table" id="tab1">
			<tr>
				<th>历史记录编号</th>
				<th>审核人</th>
				<th>审核状态</th>
				<th>审核时间</th>
				<th>审核描述</th>
			</tr>
			<c:forEach items="${auditList}" var="record">
				<tr>
					<td>${record.auditid }</td>
					<td>${record.username }</td>
                    <td class="bottom">
                        <c:if test="${record.auditstate == 1}">
                            <button type="button" class="btn btn-info">经理待审核</button>

                        </c:if>
                        <c:if test="${record.auditstate == 2}">
                            <button type="button" class="btn btn-success"> 经理审核通过</button>
                        </c:if>
                        <c:if test="${record.auditstate == -1}">
                            <button type="button" class="btn btn-danger"> 经理审核未通过</button>
                        </c:if>
                        <c:if test="${record.auditstate == 3}">
                            <button type="button" class="btn btn-success">  财务审核通过</button>

                        </c:if>
                        <c:if test="${record.auditstate == -2}">
                            <button type="button" class="btn btn-danger"> 财务审核未通过</button>
                        </c:if>
                    </td>
					<td><fmt:formatDate value="${record.auditdate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${record.auditsugg }</td>
				</tr>

			</c:forEach>
		</table>

	</form>

</body>
</html>