<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    //获取绝对路径路径
    String path = request.getContextPath ();

    String basePath = request.getScheme () + "://" + request.getServerName () + ":" + request.getServerPort () + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath %>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>用户管理-个人信息</title>
    <link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- <link href="resource/css/main.css" rel="stylesheet" /> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resource/validation/jquery.validate.js"></script>
    <script type="text/javascript">
        $(function () {

            $("#f1").validate();


        })
    </script>

    <style type="text/css">
        .error {
            color: red;
        }

        /*.row {*/
        /*margin-top: 4px;*/
        /*margin-bottom: 4px;*/
        /*}*/
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div>
    <ul class="breadcrumb" style="margin: 0px;">
        <li>系统管理</li>
        <li>个人信息</li>
    </ul>
</div>
<div class="alert alert-warning alert-dismissible fade in" role="alert"
     style="display:${tip==null?'none':'block' };margin-bottom: 0px;">
    <h4 align="center" style="color: red">${tip }</h4>
</div>


<h5 class="page-header alert-info"
    style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
<input type="hidden" name="userId" value="${user.userid }"/>
<!-- 开始1 -->
<div class="row" style="margin-top: 5px;margin-bottom: 5px">
    <div class="col-xs-5">
        <div class="form-group ">
            <label class="col-xs-3 control-label">用户姓名</label>
            <div class="col-xs-9 ">
                <input type="text" class="form-control" required name="username"
                       value="${user.username }" placeholder="请输入用户姓名"/>
            </div>
        </div>
    </div>
    <div class="col-xs-5">
        <div class="form-group ">
            <label class="col-xs-3 control-label">用户年龄</label>
            <div class="col-xs-9 ">
                <input type="text" class="form-control" name="userage"
                       value="${user.userage }" placeholder="请输入用户年龄"/>
            </div>
        </div>
    </div>
</div>
<!--结束1 -->
<!-- 开始2 -->
<div class="row">
    <div class="col-xs-5">
        <div class="form-group ">
            <label class="col-xs-3 control-label">用户性别</label>
            <div class="col-xs-3 ">
                <select name="usersex" class="form-control">
                    <option ${user.usersex=='保密'?'selected':'' }>保密</option>
                    <option ${user.usersex=='男'?'selected':'' }>男</option>
                    <option ${user.usersex=='女'?'selected':'' }>女</option>
                </select>
            </div>
        </div>
    </div>
    <div class="col-xs-5">
        <div class="form-group ">
            <label class="col-xs-3 control-label">电话号码</label>
            <div class="col-xs-9 ">
                <input type="text" class="form-control" name="userphone" id="phone"
                       value="${user.userphone }" placeholder="请输入电话号码"/>
            </div>
        </div>
    </div>
</div>
<!--结束2 -->
<!-- 开始3 -->
<div class="row">
    <div class="col-xs-5">
        <div class="form-group ">

            <label class="col-xs-3 control-label">用户角色</label>

            <div class="col-xs-4 ">
                <c:if test="${user.roleid==1}">
                    <p class="form-control-static">超级管理员</p>
                </c:if>
                <c:if test="${user.roleid==2}">
                    <p class="form-control-static">财务人员</p>
                </c:if>
                <c:if test="${user.roleid==3}">
                    <p class="form-control-static">部门经理</p>
                </c:if>
                <c:if test="${user.roleid==4}">
                    <p class="form-control-static">普通员工</p>
                </c:if>
                <input type="hidden" name="roleId" value="${user.roleid}">
            </div>

        </div>
    </div>
    <div class="col-xs-5">
        <div class="form-group ">
            <label class="col-xs-3 control-label">用户薪资</label>
            <div class="col-xs-9 ">
                <p class="form-control-static">${user.usersalary}</p>
                <input type="hidden" name="usersalary"
                       value="${user.usersalary}">
            </div>
        </div>
    </div>
</div>
<!--结束3 -->

<h5 class="page-header alert-info"
    style="margin: 0px; padding: 10px; margin-bottom: 10px;">账号信息</h5>
<!-- 开始5 -->
<div class="row">
    <div class="col-xs-5">
        <div class="form-group ">
            <label class="col-xs-3 control-label">用户账号</label>
            <div class="col-xs-9">
                <p class="form-control-static">${user.useraccount}</p>
                <input type="hidden" name="useraccount"
                       value="${user.useraccount}">
            </div>
        </div>
    </div>
    <div class="col-xs-5">
        <div class="form-group ">
            <label class="col-xs-3 control-label">用户密码</label>
            <div class="col-xs-9 ">
                <input type="text" class="form-control"
                       value="${user.userpwd }" required name="userpwd"
                       placeholder="请输入用户密码"/>
            </div>
        </div>
    </div>
</div>
</div>

</body>
</html>