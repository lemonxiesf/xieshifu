<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>工作台</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
    <!-- 1.引入 highcharts.js和highchartTable.js文件-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/highcharts.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resource/js/jquery.highchartTable.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            //3.初始化，将那个一个table转换为图表
            $('table.salaryChart').highchartTable();
        });
    </script>
</head>
<body>
<div style="padding: 0px; margin: 0px;">
    <ul class="breadcrumb" style="padding: 0px; padding-left: 20px;">
        <li>首页</li>
        <li>工作台</li>
    </ul>
</div>
<div class="row">
    <div class="col-xs-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-refresh"></span>我的薪资与提成
            </div>
            <div class="panel-body">
                <!-- 2.定义一个数据表格
              数据表格必须有thead,tbody
              data-graph-container-before="1" 定义一个数据报表容器
              data-graph-height="250" 报表的高度       可以不设置
              data-graph-type="column" 报表的类型，column 柱形图，pie 饼状图，line 折现图，spline曲线图
               -->

                <table class="salaryChart" style="display: none;"
                       data-graph-container-before="1" data-graph-height="500"
                       data-graph-type="line" series-animation="true">
                    <thead>
                    <tr>
                        <th>月份</th>
                        <th>底薪</th>
                        <th>提成</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${salaryList.list}" var="sc">
                        <tr>
                            <td><fmt:formatDate value="${sc.salarymonth }" type="both"
                                                pattern="yyyy-MM" /></td>
                            <td>${sc.salarybasic }</td>
                            <td>${sc.salarycomm }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-xs-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                <span class="glyphicon glyphicon-refresh"></span>我的提成
            </div>
            <div class="panel-body">
                <table class="salaryChart" style="display: none;"
                       data-graph-container-before="1" data-graph-height="500"
                       data-graph-type="pie" >
                    <thead>
                    <tr>
                        <th>月份</th>
                        <th>提成</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${salaryList.list}" var="sc">
                        <tr>
                            <td><fmt:formatDate value="${sc.salarymonth}" type="both"
                                                pattern="yyyy-MM" /></td>
                            <td>${sc.salarycomm}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</div>
</body>
</html>