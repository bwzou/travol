<%@page import="po.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页面</title>
</head>
<body>
<p align="center"><strong>图书管理系统</strong></p>
<hr>
<p align="center"><hr>你好，欢迎来到本站！[<a href="ServiceController?option=addService">添加请求</a>]</p>

<p align="center"><a href="ServiceController?option=SelectTourist">游客查看请求</a></p>
<p align="center"><a href="ServiceController?option=SelectVolunteer">志愿者查看请求</a></p>
<p></p>
</body>
</html>
