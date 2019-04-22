<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//实现全选和全不选
	$("#all").click(function(){
		var checked = this.checked;
		$("input[name=ids]").each(function(){
			this.checked = checked;
		});
	});
	
	//普通按钮提交表单
	$("#del").click(function(){
			//获取选中的复选框
			var ids = $("input[name=ids]:checked");
			if(ids.length == 0){
				alert("请选择删除的费用!");
				return;
			}
			if(confirm("确认要删除！")){
                $("#f1").prop("action","${pageContext.request.contextPath}/cost/deleteMultiCost");
                $("#f1").prop("method","post");
                $("#f1").submit();//提交表单
			}
	});
	
})

</script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>费用管理</li>
			<li>费用查询</li>
		</ul>
	</div>
	<div class="alert alert-warning alert-dismissible fade in" role="alert"
		style="display:${info==null?'none':'block' };margin-bottom: 0px;">
		<h4 align="center" style="color: red">${tip }</h4>

	</div>
	<form action="${pageContext.request.contextPath}/system/costQuery" id="f1" method="get"
		class="form-inline" >
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>费用编号:</label> <input type="text" class="form-control"
					name="costid" value="${cost.costid==0?'':cost.costid }"
					placeholder="请输入费用编号" /> <label>费用名称:</label> <input type="text"
					class="form-control" name="costname" value="${cost.costname }"
					placeholder="请输入费用姓名" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询"> <a
				href="${pageContext.request.contextPath}/cost/addCost" class="btn btn-success">添加费用</a>
			<input type="button" class="btn btn-warning" id="del" value="删除费用">
		</div>

		<div class="row" style="padding: 15px;">
        <table class="table table-hover table-condensed">
            <tr>
                <td><input type="checkbox" id="all"></td>
                <td>费用编号</td>
                <td>费用姓名</td>
                <td>费用描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${costList.list}" var="cost">
                <tr>
                    <td><input type="checkbox" name="ids" value="${cost.costid}"></td>
                    <td>${cost.costid}</td>
                    <td>${cost.costname}</td>
                    <td>${cost.costdesc}</td>
                    <td><a href="${pageContext.request.contextPath}/cost/updateCost/${cost.costid}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
		</div>
        <div id="paginationDiv">
            当前第${costList.pageNum}页
            <a href="${pageContext.request.contextPath}/system/costQuery?pageNum=${costList.navigateFirstPage}&pageSize=${costList.pageSize}">首页</a>
            <a href="${pageContext.request.contextPath}/system/costQuery?pageNum=${costList.prePage}&pageSize=${costList.pageSize}">上一页</a>
            <a href="${pageContext.request.contextPath}/system/costQuery?pageNum=${costList.nextPage}&pageSize=${costList.pageSize}">下一页</a>
            <a href="${pageContext.request.contextPath}/system/costQuery?pageNum=${costList.navigateLastPage}&pageSize=${costList.pageSize}">尾页</a>
            总共${costList.pages}页
        </div>
	</form>
</body>
</html>