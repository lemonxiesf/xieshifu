<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 引入d标签 -->
<%@ taglib prefix="d" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>用户管理-用户查询</title>
    <link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resource/pagingplugin/css/style.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resource/pagingplugin/js/jquery-1.3.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        $(function () {
            //绑定全选按钮选中事件
            $("#all").click(function () {
                //获取所有多选框的checked属性
                var allChecked = this.checked;
                //获取所有name属性为ids的input标签
                $("input[name=ids]").each(function () {
                    this.checked = allChecked;
                });
            });

            //绑定点击删除按钮事件
            $("#del").click(function () {
                //获取所有已经选中的name属性为ids的input标签
                var cks = $("input[name=ids]:checked");

                if (cks.length < 1) {
                    alert("请选择要删除的用户");
                    return;
                }
                //confirm(arg) 点击确定时返回true,点击取消返回false
                if (confirm("确认要删除吗？")) {
                    //修改form表单的action属性
                    $("#f1").prop("action", "${pageContext.request.contextPath}/user/deleteUser");
                    $("#f1").prop("method","post");
                    //jquery提交form表单
                    $("#f1").submit();
                }
            });
        })

    </script>
</head>
<body>
<div>
    <ul class="breadcrumb" style="margin: 0px;">
        <li>系统管理</li>
        <li>用户管理</li>
        <li>用户查询</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/system/userQuery" id="f1" class="form-inline"
      method="get">
    <div class="row alert alert-info" style="margin: 0px; padding: 5px;">
        <div class="form-group">
            <label>用户编号:</label> <input type="text" class="form-control"
                                        name="userid" value="${user.userid}"
                                        placeholder="请输入用户编号"/> <label>用户姓名:</label>
            <input type="text"
                   class="form-control"
                   name="username"
                   value="${user.username}"
                   placeholder="请输入用户姓名"/>
        </div>
        <input type="submit" class="btn btn-danger" value="查询">
        <a href="${pageContext.request.contextPath}/user/addUser" class="btn btn-success">添加用户</a>
        <input type="button" class="btn btn-warning" id="del" value="删除用户">
    </div>

    <div class="row" style="padding: 15px;">
        <%--bootstarp表单样式--%>
        <table class="table table-hover table-condensed">
            <tr>
                <td><input type="checkbox" id="all"></td>
                <td>用户编号</td>
                <td>用户姓名</td>
                <td>用户性别</td>
                <td>用户年龄</td>
                <td>用户电话</td>
                <td>用户角色</td>
                <td>用户账户</td>
                <td>用户密码</td>
                <td>用户薪资</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${userList.list}" var="user">
                <tr>
                    <td><input type="checkbox" name="ids" value="${user.userid}"></td>
                    <td>${user.userid}</td>
                    <td>${user.username}</td>
                    <td>${user.usersex}</td>
                    <td>${user.userage}</td>
                    <td>${user.userphone}</td>
                    <td>${user.rolename}</td>
                    <td>${user.useraccount}</td>
                    <td>${user.userpwd}</td>
                    <td>${user.usersalary}</td>
                    <td><a href="${pageContext.request.contextPath}/user/updateUser/${user.userid}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="paginationDiv">
        当前第${userList.pageNum}页
        <a href="${pageContext.request.contextPath}/system/userQuery?pageNum=${userList.navigateFirstPage}&pageSize=${userList.pageSize}">首页</a>
        <a href="${pageContext.request.contextPath}/system/userQuery?pageNum=${userList.prePage}&pageSize=${userList.pageSize}">上一页</a>
        <a href="${pageContext.request.contextPath}/system/userQuery?pageNum=${userList.nextPage}&pageSize=${userList.pageSize}">下一页</a>
        <a href="${pageContext.request.contextPath}/system/userQuery?pageNum=${userList.navigateLastPage}&pageSize=${userList.pageSize}">尾页</a>
        总共${userList.pages}页
    </div>

</form>

</body>
