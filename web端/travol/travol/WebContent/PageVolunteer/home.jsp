<%@page import="po.Volunteer"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!-- JSP指令 -->
<%
	Volunteer volunteer = (Volunteer) session.getAttribute("volunteer");
	if (volunteer == null) {
		response.sendRedirect("/travol/VolunteerController?option=logout");
		return;
	}
	int id = volunteer.getId();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>主页</title>
<meta http-equiv="pragma" content="no-cache">
<!-- 告诉浏览器的 -->
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
	This is
	<%=volunteer.getUsername() + "'s"%>
	JSP page.
	<br>
	<a href="login.jsp">登录</a>
	<br />
	<a href="regist.jsp">注册</a>
	<a href="/travol/VolunteerController?option=changeInfo&method=forPage">更改个人信息</a>
	<a
		href="/travol/VolunteerController?option=changePassword&method=forPage">更改密码</a>
	<a href="/travol/VolunteerController?option=freeTimePage">空闲时间</a>
	<p>
		<a href="/travol/VolunteerController?option=logout">注销</a>
	</p>
</body>
</html>
