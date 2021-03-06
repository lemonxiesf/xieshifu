<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>我的薪资查询</li>

		</ul>
	</div>
	<div class="alert alert-warning alert-dismissible fade in" role="alert"
		style="display:${info==null?'none':'block' };margin-bottom: 0px;">
		<h4 align="center" style="color: red">${info }</h4>
	</div>


    <div class="row" style="padding: 15px;">
        <table class="table table-hover table-condensed">
            <tr>
                <td>薪资发放编号</td>
                <td>领取人姓名</td>
                <td>发放月份</td>
                <td>基本薪资</td>
                <td>薪资提成</td>
                <td>发放时间</td>
            </tr>
            <c:forEach items="${salaryList.list}" var="salary">
                <tr>
                    <td>${salary.salaryid}</td>
                    <td>${salary.username}</td>
                    <td><fmt:formatDate value="${salary.salarymonth}" pattern="yyyy-MM"/></td>
                    <td>${salary.salarybasic}</td>
                    <td>${salary.salarycomm}</td>
                    <td><fmt:formatDate value="${salary.salarydate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="paginationDiv">
        当前第${salaryList.pageNum}页
        <a href="${pageContext.request.contextPath}/system/mySalary?pageNum=${salaryList.navigateFirstPage}&pageSize=${salaryList.pageSize}">首页</a>
        <a href="${pageContext.request.contextPath}/system/mySalary?pageNum=${salaryList.prePage}&pageSize=${salaryList.pageSize}">上一页</a>
        <a href="${pageContext.request.contextPath}/system/mySalary?pageNum=${salaryList.nextPage}&pageSize=${salaryList.pageSize}">下一页</a>
        <a href="${pageContext.request.contextPath}/system/mySalary?pageNum=${salaryList.navigateLastPage}&pageSize=${salaryList.pageSize}">尾页</a>
        总共${salaryList.pages}页
    </div>
</body>
</html>