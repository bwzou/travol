<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	System.out.println(session.getAttribute("loginUserRole"));
	if (session.getAttribute("loginUserName") == null)
		session.setAttribute("loginUserName", "");
	if (session.getAttribute("loginUserRole") == null)
		session.setAttribute("loginUserRole", 0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0064)http://www.17sucai.com/preview/137615/2015-01-15/demo/index.html -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">

<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<TITLE>登录页面</TITLE>
<SCRIPT src="js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>

<STYLE>
body {
	background: #ebebeb;
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		"\9ED1\4F53", Arial, sans-serif;
	color: #222;
	font-size: 12px;
}

* {
	padding: 0px;
	margin: 0px;
}

.top_div {
	background: #008ead;
	width: 100%;
	height: 200px;
}

.ipt {
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 290px;
	border-radius: 4px;
	padding-left: 35px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

.u_logo {
	background: url("images/username.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 43px;
	left: 40px;
}

.p_logo {
	background: url("images/password.png") no-repeat;
	padding: 10px 10px;
	position: absolute;
	top: 12px;
	left: 40px;
}

a {
	text-decoration: none;
}

.tou {
	background: url("images/tou.png") no-repeat;
	width: 97px;
	height: 92px;
	position: absolute;
	top: -87px;
	left: 140px;
}

.left_hand {
	background: url("images/left_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	left: 150px;
}

.right_hand {
	background: url("images/right_hand.png") no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	right: -64px;
}

.initial_left_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	left: 100px;
}

.initial_right_hand {
	background: url("images/hand.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	right: -112px;
}

.left_handing {
	background: url("images/left-handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -24px;
	left: 139px;
}

.right_handinging {
	background: url("images/right_handing.png") no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -21px;
	left: 210px;
}

body, td, th {
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		\9ED1\4F53, Arial, sans-serif;
}
</STYLE>

<SCRIPT type="text/javascript">
	$(function() {
		//得到焦点
		$("#password").focus(function() {
			$("#left_hand").animate({
				left : "150",
				top : " -38"
			}, {
				step : function() {
					if (parseInt($("#left_hand").css("left")) > 140) {
						$("#left_hand").attr("class", "left_hand");
					}
				}
			}, 2000);
			$("#right_hand").animate({
				right : "-64",
				top : "-38px"
			}, {
				step : function() {
					if (parseInt($("#right_hand").css("right")) > -70) {
						$("#right_hand").attr("class", "right_hand");
					}
				}
			}, 2000);
		});
		//失去焦点
		$("#password").blur(function() {
			$("#left_hand").attr("class", "initial_left_hand");
			$("#left_hand").attr("style", "left:100px;top:-12px;");
			$("#right_hand").attr("class", "initial_right_hand");
			$("#right_hand").attr("style", "right:-112px;top:-12px");
		});
	});
</SCRIPT>
<script type="text/javascript">
	function changeValidateCode(obj) {
		//获取当前的时间作为参数，无具体意义 
		var timenow = new Date().getTime();
		//每次请求需要一个不同的参数，否则可能会返回同样的验证码 
		//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
		//obj.src = "rand.action?d=" + timenow;
		obj.src = "/travol/PageTourist/randomPic.jsp?d="+timenow;
	}
</script>
<META name="GENERATOR" content="MSHTML 11.00.9600.17496">
</HEAD>
<BODY>
	<form method="post" action="/travol/TouristController?option=login">
		<DIV class="top_div"></DIV>
		<DIV
			style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 270px; text-align: center;">
			<DIV style="width: 165px; height: 96px; position: absolute;">
				<DIV class="tou"></DIV>
				<DIV class="initial_left_hand" id="left_hand"></DIV>
				<DIV class="initial_right_hand" id="right_hand"></DIV>
			</DIV>
			<P style="padding: 30px 0px 10px; position: relative;">
				<SPAN class="u_logo"></SPAN> <INPUT class="ipt" type="text"
					name="username" id="username" placeholder="请输入用户名"
					value="<%=session.getAttribute("loginUserName")%>" />
			</P>
			<P style="position: relative;">
				<SPAN class="p_logo"></SPAN> <INPUT class="ipt" name="password"
					id="password" type="password" placeholder="请输入密码" value="">
			</P>
					<P style="padding: 10px 0px 10px; position: relative;">
						<SPAN class="p_logo"></SPAN> <INPUT class="ipt" type="text"
							name="rand" placeholder="请输入验证码" size="5"> <img
							src="/travol/PageTourist/randomPic.jsp" onclick="changeValidateCode(this)" title="点击图片刷新验证码" />
					</P>
					<DIV
						style="height: 50px; line-height: 50px; margin-top: 10px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
						<P style="margin: 0px 35px 20px 45px;">
							<SPAN style="float: left;"><A
								style="color: rgb(204, 204, 204);" href="#">忘记密码?</A> </SPAN> <SPAN
								style="float: right;"><A
								style="color: rgb(204, 204, 204); margin-right: 10px;"
								href="regist.jsp">注册</A> <INPUT
								style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
								type="submit" value="提交"> </SPAN>
						</P>
					</DIV>
				</DIV>
			</div>
		</DIV>
	</form>
	<div align="center"></div>
</BODY>
</HTML>
