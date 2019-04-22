<%--suppress HtmlUnknownTarget --%>
<%--suppress CheckTagEmptyBody --%>
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

</head>
<body>
<div>
    <ul class="breadcrumb" style="margin: 0px;">
        <li>报销管理</li>
        <li>报销查询</li>
    </ul>
</div>
<div class="alert alert-warning alert-dismissible fade in" role="alert"
     style="display:${info==null?'none':'block' };margin-bottom: 0px;">
    <h4 align="center" style="color: red">${info }</h4>
</div>
<form action="${pageContext.request.contextPath}/expense/expenseQuery" id="f1"
      class="form-inline">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>报销人:</label> <input type="text" class="form-control"
                                       name="username" value="${poExpense.username }" placeholder="请输入报销人姓名"/>
            <label>开始时间:</label> <input type="Date" class="form-control "
                                        name="beginDate"
                                        value="${poExpense.beginDate}"/>
            <label>结束时间:</label> <input type="Date"
                                        class="form-control"
                                        name="endDate"
                                        value="${poExpense.endDate}"/>
            <label>报销原因:</label> <input type="text"
                                        class="form-control" name="expensename"
                                        value="${poExpense.expensename }" placeholder="请输入报销原因"/> <label>报销状态:</label>
            <select class="form-control" name="expensestate">
                <option value="" name="expensestate">请选择</option>
                <option value="1" ${poExpense.expensestate=='1'?'selected':'' }>经理待审核</option>
                <option value="2" ${poExpense.expensestate=='2'?'selected':'' }>经理审核通过</option>
                <option value="3" ${poExpense.expensestate=='3'?'selected':'' }>财务审核通过</option>
                <option value="-1" ${poExpense.expensestate=='-1'?'selected':'' }>经理审核未通过</option>
                <option value="-2" ${poExpense.expensestate=='-2'?'selected':''}>财务审核未通过</option>
            </select>
        </div>
        <input type="submit" class="btn btn-danger" value="查询">

    </div>
</form>
    <div class="row" style="padding: 15px;">
        <table class="table table-hover table-condensed">
            <tr>
                <td>报销编号</td>
                <td>报销人</td>
                <td>报销原因</td>
                <td>报销时间</td>
                <td>报销总金额</td>
                <td>审核状态</td>
                <td>操作</td>
                <td></td>
            </tr>
            <c:forEach items="${expenseList.list}" var="expense">
                <tr>
                    <td>${expense.expenseid}</td>
                    <td>${expense.username}</td>
                    <td>${expense.expensename}</td>
                    <td><fmt:formatDate value="${expense.expensedate}"
                                        pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
                    <td>${expense.expensetotal}</td>
                    <td class="bottom">
                        <c:if test="${expense.expensestate == 1}">
                            <button type="button" class="btn btn-info">经理待审核</button>

                        </c:if>
                        <c:if test="${expense.expensestate == 2}">
                                <button type="button" class="btn btn-success"> 经理审核通过</button>
                        </c:if>
                        <c:if test="${expense.expensestate == -1}">
                            <button type="button" class="btn btn-danger"> 经理审核未通过</button>
                        </c:if>
                        <c:if test="${expense.expensestate == 3}">
                                <button type="button" class="btn btn-success">  财务审核通过</button>

                        </c:if>
                        <c:if test="${expense.expensestate == -2}">
                            <button type="button" class="btn btn-danger"> 财务审核未通过</button>
                        </c:if>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/expense/expenseDetails/${expense.expenseid}">查看详情</a></td>
                </tr>
            </c:forEach>
        </table>
        <div id="paginationDiv">
            当前第${expenseList.pageNum}页
            <a href="${pageContext.request.contextPath}/expense/expenseQuery?pageNum=${expenseList.navigateFirstPage}&pageSize=${expenseList.pageSize}">首页</a>
            <a href="${pageContext.request.contextPath}/expense/expenseQuery?pageNum=${expenseList.prePage}&pageSize=${expenseList.pageSize}">上一页</a>
            <a href="${pageContext.request.contextPath}/expense/expenseQuery?pageNum=${expenseList.nextPage}&pageSize=${expenseList.pageSize}">下一页</a>
            <a href="${pageContext.request.contextPath}/expense/expenseQuery?pageNum=${expenseList.navigateLastPage}&pageSize=${expenseList.pageSize}">尾页</a>
            总共${expenseList.pages}页
        </div>
    </div>
</body>
</html>