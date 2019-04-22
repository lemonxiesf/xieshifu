<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>报销管理-报销单添加</title>

<!-- <link href="resource/css/main.css" rel="stylesheet" /> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/validation/jquery.validate.js"></script>
<%--<link href="${pageContext.request.contextPath}/resource/bootstrap-fileinput/css/fileinput.min.css" />--%>
<link href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css" rel="stylesheet" />
    <%--<link href="../css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="${pageContext.request.contextPath}/resource/bootstrap-fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/resource/bootstrap-fileinput/js/jquery-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/resource/bootstrap-fileinput/js/fileinput.js" type="text/javascript"></script>
    <%--<script src="../js/fileinput_locale_de.js" type="text/javascript"></script>--%>
    <%--<script src="../js/bootstrap.min.js" type="text/javascript"></script>--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/resource/bootstrap-fileinput/js/fileinput.min.js"></script>--%>

    <script type="text/javascript">
	$(function(){
		//选择费用明细
		$("#selected").click(function(){
			//获取第一个表格
			var tab1 = $("#tab1");
			//获取选中复选框  数组
			var costIds = $("input[id=costId]:checked");
			//总金额
			var expenseTotal = $("#expenseTotal");
			//遍历数组
			costIds.each(function(){
				//$(this) 当前复选框 
				//$(this).parent().parent() 找到tr
				//.find("td"); 找到tr下面td
				//数组
				var td = $(this).parent().parent().find("td");
				
				tab1.append("<tr>"+
								"<td>"+td[1].innerHTML+"<input type='hidden' name='costid' value='"+td[1].innerHTML+"' ></td>"+
								"<td>"+td[2].innerHTML+"</td>"+
								"<td><input type='text' value='0' required id='money' name='detailmoney'  class='form-control' style='width:100px'></td>"+
								"<td><input type='text' name='detaildesc'  required class='form-control'></td>"+
								"<td><a href='javascript:void(0)' class='btn btn-danger' onclick='del(this)' >删除</a></td>"+
							" </tr>");
				
				//给文本框绑定事件 只能定义在这个地方
				$("input[id=money]").blur(function(){
					var sum = 0;
					$("input[id=money]").each(function(){
						
						sum+=parseFloat($(this).val());
					});
					expenseTotal.val(sum);
				});
			});
			//隐藏
			$("#myModal").modal("hide");
		});
	})
	
	function del(obj){
		if(confirm("确定要删除该费用")){
			//获取tr
			var tr = $(obj).parent().parent();
			//删除tr包括tr里面td
			tr.remove();
		}
	}


</script>

    <script type="text/javascript">
        $('#f1').validate();

    </script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>报销管理</li>
			<li>报销单</li>
		</ul>
	</div>
	<div class="alert alert-warning alert-dismissible fade in" role="alert"
		style="display:${tip==null?'none':'block' };margin-bottom: 0px;">
		<h4 align="center" style="color: red">${tip }</h4>
	</div>
	<form action="${pageContext.request.contextPath}/expense/addExpense" id="f1" method="post"
		class="form-horizontal" enctype="multipart/form-data">

		<input type="hidden" name="userid" id="userId" required
			value="${userInfo.userid }" /> <input type="hidden"
			name="expensestate" id="expenseState" value="1" />
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销原因</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" required
							name="expensename" value="${expense.expensename }"
							placeholder="请输入报销原因" />
					</div>
				</div>
			</div>
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销总金额</label>
					<div class="col-xs-5 ">
						<input type="text" class="form-control" readonly="readonly"
							id="expenseTotal" name="expensetotal"
							value="${expense.expensetotal==null?'0':expense.expensetotal }"
							placeholder="请输入报销总金额" />
					</div>
				</div>
			</div>
			<div class="col-xs-7">
				<div class="form-group ">
					<label class="col-xs-3 control-label">报销详情</label>
					<div class="col-xs-9 ">
			<textarea rows="10"  class="form-control" required name="expensedesc" cols="" placeholder="请输入报销详情">${expense.expensedesc}</textarea>
					</div>
				</div>
			</div>
            <div class="col-xs-7">
                <div class="form-group ">
                    <label class="col-xs-3 control-label">上传报销凭证</label>
                    <div class="col-xs-9 ">
                        <div class="row" >
                            <input id="file-Portrait" name="file" type="file">
                        </div>
                    </div>
                </div>
            </div>
		</div>
		<!--结束1 -->

		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">
			报销单明细
			<button type="button" class="btn btn-primary btn-xs"
				data-toggle="modal" data-target="#myModal" required>选择费用明细</button>
		</h5>
		<table class="table" id="tab1">
			<tr>
				<th>费用编号</th>
				<th>费用名称</th>
				<th>具体金额</th>
				<th>费用说明</th>
				<th>删除</th>
			</tr>

		</table>
		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="提交" />
			</div>

		</div>

	</form>

	<!-- 弹出框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">费用明细</h4>
                    <table class="table table-hover table-condensed">
                        <tr>
                            <td></td>
                            <td>费用编号</td>
                            <td>费用姓名</td>
                            <td>费用描述</td>
                        </tr>
                        <c:forEach items="${costList}" var="cost">
                            <tr>
                                <td><input type="checkbox" id="costId" value="${cost.costid}"></td>
                                <td>${cost.costid}</td>
                                <td>${cost.costname}</td>
                                <td>${cost.costdesc}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="selected">选择</button>
				</div>
			</div>
		</div>
	</div>

    <script type="text/javascript">

    </script>

    <script type="text/javascript">
        //初始化fileinput控件（第一次初始化）
        $('#file-Portrait').fileinput({
            language: 'zh', //设置语言
            //uploadUrl: "/FileUpload/Upload", 上传的地址
            allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
            maxFileCount: 100,
            enctype: 'multipart/form-data',
            showUpload: false, //是否显示上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        });
    </script>
    <!--bootstarp文件上传-->

</body>
</html>