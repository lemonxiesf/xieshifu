<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <base href="${pageContext.request.contextPath }/" /> --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>用户管理-用户添加</title>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet" />
<!-- <link href="resource/css/main.css" rel="stylesheet" /> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/validation/jquery.validate.js"></script>
<script type="text/javascript">


    $(function () {
        $("#f1").validate();
        //为输入框绑定鼠标移开事件
        $("#userAccount").blur(function () {
            //获取输入框的值
            var userAccount =$("#userAccount").val();
            if (userAccount == ''){
                $("#accountInfo").val('');
                return;
            }
            $.post("${pageContext.request.contextPath}/user/validateUser",
                {"account":userAccount},
                function (result) {
                    if (result.success == true) {
                        $("#accountInfo").html(result.massage);
                        $("#saveBtn").prop("disabled",false);//设置保存按钮可用
                    }else{
                        $("#accountInfo").html(result.massage);
                        $("#saveBtn").prop("disabled",true);//设置保存按钮不可用
                    }
                }
            )
        })
    })
</script>

    <script type="text/javascript">
        jQuery.validator.addMethod("isMobile", function (value, element) {
            var length = value.length;
            var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "请正确填写手机号码");

        $(function () {
            alert('........');
            $('#f1').validate({

                rules: {
                    phone: {
                        required: true,
                        minlength: 11,
                        isMobile: true
                    }
                },
                messages: {
                    phone: {
                        required: "请输入手机号",
                        minlength: "不能小于11个字符",
                        isMobile: "请正确填写手机号码"
                    }
                }
            })

        })
    </script>
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>用户管理</li>
			<li>用户添加</li>
		</ul>
	</div>
	<div class="alert alert-warning alert-dismissible fade in" role="alert"
		style="display:${tip==null?'none':'block' };margin-bottom: 0px;">
		<h4 align="center" style="color: red">${tip }</h4>
	</div>
	<form action="${pageContext.request.contextPath}/user/addUser" id="f1" method="post"
		class="form-horizontal">



		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户姓名</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" required name="username"
							value="${user.username }" placeholder="请输入用户姓名" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户年龄</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" name="userage"
							value="${user.userage }" required placeholder="请输入用户年龄" />
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
						<input type="text" required class="form-control" name="userphone"
							value="${user.userphone }" placeholder="请输入电话号码" />
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
						<select name="roleid" class="form-control">
							<option value="4">普通员工</option>
							<option value="2">财务人员</option>
							<option value="3">部门经理</option>
							<option value="1">超级管理员</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label" required >用户薪资</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" required name="usersalary"
							value="${user.usersalary}" placeholder="请输入薪资" />
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
						<input type="text" class="form-control" required
							name="useraccount" value="${user.useraccount }" id="userAccount"
							placeholder="请输入用户账号" /> <span
							style="display: inline; color: red" id="accountInfo"></span>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">用户密码</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" value="${user.userpwd }"
							required name="userpwd" placeholder="请输入用户密码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" id="saveBtn"
					value="保存用户" /> <input type="reset" class="btn btn-danger"
					value="重置信息" />
			</div>

		</div>

	</form>
</body>
</html>