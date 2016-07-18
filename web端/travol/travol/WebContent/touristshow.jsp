<%@page import="po.Service"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 从请求对象中（request）中取出数据
List<Service> services = (List<Service>)request.getAttribute("TouristShow");
%>



<!DOCTYPE html>
<html>
<head>
<title>Practical CSS3 tables with rounded corners - demo</title>
<script type="text/javascript">
    function deleteBook(bid){
	if(window.confirm("是否撤销请求？")){
		location.href = "ServiceController?option=deleterequest&bid=" + bid;  //跳转大该处理页面
	}
}
</script>
<link href="button.css" rel="stylesheet" style="text/css">
<style>
body {
	width: 600px;
	margin: 40px auto;
	font-family: 'trebuchet MS', 'Lucida sans', Arial;
	font-size: 14px;
	color: #444;
}

table {
	*border-collapse: collapse; /* IE7 and lower */
	border-spacing: 0;
	width: 100%;
}

.bordered {
	border: solid #ccc 1px;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0 1px 1px #ccc;
	-moz-box-shadow: 0 1px 1px #ccc;
	box-shadow: 0 1px 1px #ccc;
}

.bordered tr:hover {
	background: #fbf8e9;
	-o-transition: all 0.1s ease-in-out;
	-webkit-transition: all 0.1s ease-in-out;
	-moz-transition: all 0.1s ease-in-out;
	-ms-transition: all 0.1s ease-in-out;
	transition: all 0.1s ease-in-out;
}

.bordered td, .bordered th {
	border-left: 1px solid #ccc;
	border-top: 1px solid #ccc;
	padding: 10px;
	text-align: left;
}

.bordered th {
	background-color: #dce9f9;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc),
		to(#dce9f9));
	background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: linear-gradient(top, #ebf3fc, #dce9f9);
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	border-top: none;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
}

.bordered td:first-child, .bordered th:first-child {
	border-left: none;
}

.bordered th:first-child {
	-moz-border-radius: 6px 0 0 0;
	-webkit-border-radius: 6px 0 0 0;
	border-radius: 6px 0 0 0;
}

.bordered th:last-child {
	-moz-border-radius: 0 6px 0 0;
	-webkit-border-radius: 0 6px 0 0;
	border-radius: 0 6px 0 0;
}

.bordered th:only-child {
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
	-moz-border-radius: 0 0 0 6px;
	-webkit-border-radius: 0 0 0 6px;
	border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
	-moz-border-radius: 0 0 6px 0;
	-webkit-border-radius: 0 0 6px 0;
	border-radius: 0 0 6px 0;
}

/*----------------------*/
.zebra td, .zebra th {
	padding: 10px;
	border-bottom: 1px solid #f2f2f2;
}

.zebra tbody tr:nth-child(even) {
	background: #f5f5f5;
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
}

.zebra th {
	text-align: left;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
	border-bottom: 1px solid #ccc;
	background-color: #eee;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5),
		to(#eee));
	background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
	background-image: -moz-linear-gradient(top, #f5f5f5, #eee);
	background-image: -ms-linear-gradient(top, #f5f5f5, #eee);
	background-image: -o-linear-gradient(top, #f5f5f5, #eee);
	background-image: linear-gradient(top, #f5f5f5, #eee);
}

.zebra th:first-child {
	-moz-border-radius: 6px 0 0 0;
	-webkit-border-radius: 6px 0 0 0;
	border-radius: 6px 0 0 0;
}

.zebra th:last-child {
	-moz-border-radius: 0 6px 0 0;
	-webkit-border-radius: 0 6px 0 0;
	border-radius: 0 6px 0 0;
}

.zebra th:only-child {
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.zebra tfoot td {
	border-bottom: 0;
	border-top: 1px solid #fff;
	background-color: #f1f1f1;
}

.zebra tfoot td:first-child {
	-moz-border-radius: 0 0 0 6px;
	-webkit-border-radius: 0 0 0 6px;
	border-radius: 0 0 0 6px;
}

.zebra tfoot td:last-child {
	-moz-border-radius: 0 0 6px 0;
	-webkit-border-radius: 0 0 6px 0;
	border-radius: 0 0 6px 0;
}

.zebra tfoot td:only-child {
	-moz-border-radius: 0 0 6px 6px;
	-webkit-border-radius: 0 0 6px 6px border-radius: 0 0 6px 6px
}
</style>
</head>

<body>

	<h2>欢迎到来！</h2>
	<table width="102%" height="133" class="bordered">
		<thead>

			<tr>
				<th width="8%">编号</th>
				<th width="12%">志愿者名</th>
				<th width="8%">时间</th>
				<th width="12%">我的评分</th>
				<th width="12%">我的评价</th>
				<th width="12%">达成时间</th>
				<th width="7%">状态</th>
				<th width="29%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作</th>
			</tr>
		</thead>
		<%
			for (Service service : services) {
		%>
		<tr onMouseOver="this.bgColor='#FF9933'"
			onMouseOut="this.bgColor='#FFFFFF'">
			<td><%=service.getId()%>&nbsp;</td>
			<td><%=service.getV_id()%>&nbsp;</td>
			<td><%=service.getDate()%>&nbsp;</td>
			<td><%=service.getRating()%>&nbsp;</td>
			<td><%=service.getEvaluation()%>&nbsp;</td>
			<td><%=service.getOpp_date()%>&nbsp;</td>
			<td><%=service.getState()%>&nbsp;</td>
		
			
			<td>
			    <a href="javascript:void(0)"
				onClick="deleteBook(<%=service.getId()%>)"
				class="button button-tiny button-glow button-rounded button-raised button-primary">撤销</a>
			   <a href="ServiceController?option=getone&bid=<%=service.getId()%>"
				class="button button-tiny button-glow button-border button-rounded button-primary">评价</a>
			</td>
		
		</tr>
		<%
			}
		%>

	</table>

	<br>
	<br>
	<p align="center">
		<a href="login.jsp"
			class="button  button-glow button-border button-rounded button-primary">返回主页</a>
	</p>


</body>
</html>





