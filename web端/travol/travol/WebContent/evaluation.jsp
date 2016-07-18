<%@page import="po.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Service service = (Service) request.getAttribute("service");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="white.css" rel="stylesheet" style="text/css">
<title>Insert title here</title>
</head>
<body>
	<form name="form1" method="post"
		action="ServiceController?option=evaluation&bid=<%=service.getId()%>"
		class="bootstrap-frm">
		<h1>
			Evaluation<span>Please fill all the texts in the fields.</span>
		</h1>
  <table width="419" border="1" align="center" cellpadding="5" cellspacing="0">
  <label><span>服务编号</span>
      <input type="text" name="bname" id="bname" value="<%=service.getV_id()%>" disabled="value">
  <label>
  <span>请求时间</span>
<input type="text" name="author" id="author" value="<%=service.getDate()%>" disabled="value">
</label>
  <label>
<span>我的评分</span>
<input type="text" name="price" id="price" value="<%=service.getRating()%>" >
</label>
<label>
<span>达成时间</span>
<input type="text" name="pubdate" id="pubdate" value="<%=service.getOpp_date()%>" disabled="value">
</label>
<label>
<span>我的评价</span>
<!-- <input type="text" name="publisher" id="publisher" value="<%=service.getEvaluation()%>"> -->
<!-- 试试这个看可不可弄！ -->
<textarea type="text" name="publisher" id="publisher" value="<%=service.getEvaluation()%>"></textarea>
</label>
<label>
<span>&nbsp;</span>
<input type="submit" class="button" name="button" id="button" value="提交"> <input type="reset" class = "button" value="重置" />
</label>
</form>
</body>
</html>