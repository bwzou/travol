<%@page import="java.sql.Date"%>
<%@page import="po.FreeTime"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    List<FreeTime> list=(List<FreeTime>)request.getAttribute("freeTimeList");
    int id = Integer.parseInt(request.getParameter("vid"));
    Date date=new Date(new java.util.Date().getTime());
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="datepicker/css/datepicker.css" type="text/css" />
    <link rel="stylesheet" media="screen" type="text/css" href="datepicker/css/layout.css" />
    <title>DatePicker - jQuery plugin</title>
	<script type="text/javascript" src="datepicker/js/jquery.js"></script>
	<script type="text/javascript" src="datepicker/js/datepicker.js"></script>
    <script type="text/javascript" src="datepicker/js/eye.js"></script>
    <script type="text/javascript" src="datepicker/js/utils.js"></script>
    <script type="text/javascript" src="datepicker/js/layout.js?ver=1.0.2"></script>
</head>

<body>
<form method="post" action="VolunteerController?option=addFreeTime">
<input   class="dates" name="dates" id="dates" type="text" value="<%=date %>" />
    <script>
$('#dates').DatePicker({
	format:'m/d/Y',
	date: $('#dates').val(),
	current: $('#dates').val(),
	starts: 1,
	mode: 'multiple',
	format: 'Y-m-d',
	position: 'bottom',
	onBeforeShow: function(){
		$('#dates').DatePickerSetDate($('#dates').val(), true);
	},
	onChange: function(formated, dates){
		$('#dates').val(formated);
		if ($('#closeOnSelect input').attr('checked')) {
			$('#dates').DatePickerHide();
		}
	}
});
</script>
<input	type="submit" name="submit" id="submit" value="添加">
<input type="reset" name="reset" value="清除">
</form>
<br/>
<table width="200" border="1" align="center">
  <tbody>
   <tr>
      <td>id</td>
      <td>时间</td>
      <td>操作</td>
    </tr>
    <%for(FreeTime f:list) {%>
    <tr>
      <td><%=f.getVid() %></td>
      <td><%=f.getFreeDate() %></td>
      <td><a href="VolunteerController?option=deleteFreeTime&id=<%=f.getId()%>">删除</a></td>
    </tr>
    <%} %>
  </tbody>
</table>
<!-- <p align="center"><a href="/travol/PageVolunteer/home.jsp">返回主页</a></p> -->
<p align="center"><a href="VolunteerController?option=getpage">返回主页</a></p>
</body>
</html>