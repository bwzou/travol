<%@page import="po.Volunteer"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	Volunteer volunteer = (Volunteer) session.getAttribute("volunteer");
	if (volunteer == null) {
		response.sendRedirect("/travol/VolunteerController?option=logout");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//out.println("当前Id:" + id);
	%>
	<form name="form1" method="post"
		action="/travol/VolunteerController?option=changePassword&method=change">
		<table width="304" height="200" border="1" align="center">
			<tbody>
				<tr>
					<td width="47">旧密码</td>
					<td width="137"><input type="password" name="oldPassword"
						id="oldPassword"></td>
				</tr>
				<tr>
					<td>新密码</td>
					<td><input type="password" name="newPassword" id="newPassword">
					</td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td><input type="password" name="newPasswordConfirm"
						id="newPasswordConfirm"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" name="submit" id="submit" value="修改"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<div align="center"></div>
</body>
</html>