<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="po.Tourist"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	Tourist tourist = (Tourist) session.getAttribute("tourist");
	if (tourist == null) {
		response.sendRedirect("/travol/TouristController?option=logout");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%
	if (tourist.getGender() == null)
		tourist.setGender("男");
	if (tourist.getName() == null)
		tourist.setName("");
	if (tourist.getTelephoneNumber() == null)
		tourist.setTelephoneNumber("");
	if(tourist.getGender()==null)
		tourist.setGender("男");
%>
<script type="text/javascript" src="js/area.js"></script>

</head>
<body>
	<form method="post"
		action="/travol//TouristController?option=changeInfo&method=change">
		<table width="509" height="395" border="1" align="center">
			<tbody>
				<tr>
					<td width="93">真实姓名</td>
					<td width="240"><input type="text" name="name" id="textfield2"
						value="<%=tourist.getName()%>"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><p>
							<label> <input name="gender" type="radio" id="gender_0"
								value="男" <%if (tourist.getGender().equals("男")) {%>
								checked="checked" <%}%>> 男
							</label> <label> <input type="radio" name="gender" value="女"
								id="gender_1" <%if (tourist.getGender().equals("女")) {%>
								checked="checked" <%}%>> 女
							</label> <br>
						</p></td>
				</tr>
				<tr>
					<td>出生年月</td>
					<td><select name="birthyear">
							<%
								Date now = new Date();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
								int year = Integer.parseInt(sdf.format(now));
								System.out.println(sdf.format(now));
								if(tourist.getBirthday()==null)
									tourist.setBirthday(new java.sql.Date(now.getTime()));
								int vyear = Integer.parseInt(sdf.format(tourist.getBirthday()));
								sdf = new SimpleDateFormat("MM");
								int vmonth = Integer.parseInt(sdf.format(tourist.getBirthday()));
							%>
							<%
								for (int i = year - 60; i < year; i++) {
							%>
							<option value="<%=i%>"
								<%if (i == vyear)
					out.print("selected='selected'");%>><%=i%></option>
							<%
								}
							%>
					</select> 年 <select name="birthmonth">
							<%
								for (int j = 1; j <= 12; j++) {
							%>
							<option value="<%=j%>"
								<%if (vmonth == j)
					out.print("selected='selected'");%>><%=j%></option>
							<%
								}
							%>
					</select>月</td>
				</tr>
				<tr>
					<td>电话号码</td>
					<td><input type="text" name="telephoneNumber"
						id="telephoneNumber" value="<%=tourist.getTelephoneNumber()%>">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" name="submit" id="submit" value="提交"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>