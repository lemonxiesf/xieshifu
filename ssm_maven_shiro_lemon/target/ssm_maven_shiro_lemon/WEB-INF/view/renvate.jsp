<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
parent.location.href='${pageContext.request.contextPath}/common/login';


/*  1、window.location.href=“url”：
当前页面打开URL页面，改变url地址，如果URL为空则重新打开当前页面。
（1）与self.location.href="url"，self.location.href="url"相同
（2）this.location.href="url"当前页面打开URL页面
（3）parent.location.href="url"在父页面打开新页面
（4）top.location.href="url" 在顶层页面打开新页面

2、window.location.replace(“url”)：
将地址替换成新url，该方法通过指定URL替换当前缓存在历史里（客户端）的项目，因此当使用replace方法之后，你不能通过“前进”和“后退”来访问已经被替换的URL，这个特点对于做一些过渡页面非常有用！

3、window.location.reload()：
强制刷新页面，从服务器重新请求！和F5功能一样。
（1）window.opener.document.location.reload();使用子窗口的 opener 对象来获得父窗口的对象；

4、window.location.reload()与window.location.href=“url”的异同：
（1）相同点：都是刷新当前页面，都会提交数据。
（2）不同点：reload()会提示是否提交数据，可以提交GET和POST方式提交的数据；
href()不会提示是否提交并且只会提交URL里面的数据，即GET方式提交的数据   */

</script>
<title>用于跳转</title>
</head>
<body>

</body>
</html>