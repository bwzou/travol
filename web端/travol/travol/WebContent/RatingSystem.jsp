<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int id = Integer.parseInt(request.getParameter("id"));%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评测系统</title>
<link rel="stylesheet" type="text/css" href="nkzsy.css" />
<style type="text/css">
<!--
body {
	background-color: #00DDFF;
}
.style2 {font-size: 50px}
.style3 {
	font-size: 30px;
	font-family: "Microsoft YaHei UI";
	color: #00CCCC;
	font-weight: bold;
}
.style8 {font-family: "Microsoft YaHei UI"; font-size: 24; }
.style9 {font-size: 24}
.style11 {font-family: "Microsoft YaHei UI"; font-size: large; }
.style12 {font-size: medium}
.style13 {font-size: large}
-->
</style></head>

<body>
<div id="container"><!--页面层容器-->
　　<div id="Header"><!--页面头部--><img src="background.PNG" width="800" />
　　</div>
　　<div id="PageBody"><span class="style2">　<span class="style3">评分页面</span>　</span>　　
		<form action="RsController?id=<%=id%>" method="post" name="rating">
		  <table width="700" height="450" border="0">
            <tr>
              <td height="66"><span class="style11">1.总体而言，你对志愿者服务的满意程度是（请输入0~5）：
                <input name="server" type="text" id="server">
              </span></td>
            </tr>
            <tr>
              <td height="50"></td>
            </tr>
            <tr>
              <td height="80"><span class="style8"><span class="style13">2.你对本次旅行的满意程度是（请输入0~5）：</span>              
              <input name="travel" type="text" id="travel" />
              </span></td>
            </tr>
            <tr>
              <td height="50"><span class="style9"></span></td>
            </tr>
            <tr>
              <td height="71" ><span class="style8"><span class="style13">3.你对我们网站的评分是（请输入0~5）：</span>              
              <input name="website" type="text" id="website" />
              </span></td>
            </tr>
			<tr>
			<td height="50"></td>
			</tr>
			<tr>
			<td><div align="center">
  <input type="submit" name="Submit" value="提交" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" name="Submit" value="重置" />
			  </div></td>
			</tr>
          </table>
		</form>
　　</div>
　　<div id="Footer"></div>
</div>
</body>
</html>