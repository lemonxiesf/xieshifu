<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title></title>
    <link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resource/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        $(function () {


        })

    </script>
</head>
<body>
<div>
    <ul class="breadcrumb" style="margin: 0px;">
        <li>财务管理</li>
        <li>报销单查询</li>
    </ul>
</div>
<div class="alert alert-warning alert-dismissible fade in" role="alert"
     style="display:${info==null?'none':'block' };margin-bottom: 0px;">
</div>
<form action="${pageContext.request.contextPath}/finance/financeList" id="f1" method="get"
      class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>报销人:</label> <input type="text" class="form-control"
                                       name="username" value="${poExpense.username }" placeholder="请输入报销人姓名"/>
            <label>开始时间:</label> <input type="Date" class="form-control "
                                        name="beginDate"
                                        value="${poExpense.beginDate }"
                                        placeholder="请输入开始时间"/>
            <label>结束时间:</label> <input type="Date"
                                        class="form-control" name="endDate"
                                        value="${poExpense.endDate }"
                                        placeholder="请输入结束时间"/>
            <label>报销原因:</label> <input type="text"
                                        class="form-control" name="expensename"
                                        value="${poExpense.expensename }" placeholder="请输入报销原因"/>

        </div>
        <input type="submit" class="btn btn-danger" value="查询">
    </div>

    <div class="row" style="padding: 15px;">
        <table class="table table-hover table-condensed">
            <tr>
                <td>报销编号</td>
                <td>报销人</td>
                <td>报销原因</td>
                <td>报销时间</td>
                <td>报销总金额</td>
                <td>报销状态</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${expenseList.list}" var="expense">
                <tr>
                    <td>${expense.expenseid}</td>
                    <td>${expense.username}</td>
                    <td>${expense.expensename}</td>
                    <td><fmt:formatDate value="${expense.expensedate}"
                                        pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
                    <td>${expense.expensetotal}</td>
                    <td><button class="btn btn-success">经理审核通过</button></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/finance/financeAudit/${expense.expenseid}">审批</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div id="paginationDiv">
            当前第${expenseList.pageNum}页
            <a href="${pageContext.request.contextPath}/finance/financeList?pageNum=${expenseList.navigateFirstPage}&pageSize=${expenseList.pageSize}">首页</a>
            <a href="${pageContext.request.contextPath}/finance/financeList?pageNum=${expenseList.prePage}&pageSize=${expenseList.pageSize}">上一页</a>
            <a href="${pageContext.request.contextPath}/finance/financeList?pageNum=${expenseList.nextPage}&pageSize=${expenseList.pageSize}">下一页</a>
            <a href="${pageContext.request.contextPath}/finance/financeList?pageNum=${expenseList.navigateLastPage}&pageSize=${expenseList.pageSize}">尾页</a>
            总共${expenseList.pages}页
        </div>
    </div>
</form>
</body>
</html>