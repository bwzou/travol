<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="po.Tourist"%>
<%@page import="po.Volunteer"%>
<%@page import="vo.PageBean"%>

<%
if(session.getAttribute("volunteer")==null){
	response.sendRedirect("login.jsp");    //查看是否登陆了
	return;
}
Volunteer volunteer = (Volunteer)session.getAttribute("volunteer");    //传游客过来
PageBean pageBean = (PageBean)request.getAttribute("pageBean");
List<Tourist> tourists = pageBean.getData();
        //传志愿者过来
 
%>

<!DOCTYPE html>
<!-- saved from url=(0032)http://www.csszengarden.com/118/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<title>志愿者导游</title>
    <script language="javascript" type="text/javascript" src="PageVolunteer/js/jquery-1.8.0.min.js"></script>
    
	<link rel="stylesheet" media="screen" href="PageVolunteer/css/root.css">
	<link rel="alternate" type="application/rss+xml" title="RSS" href="http://www.csszengarden.com/zengarden.xml">
    <script language="javascript" type="text/javascript" src="jquery-1.8.0.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="author" content="Dave Shea">
	<meta name="description" content="A demonstration of what can be accomplished visually through CSS-based design.">
	<meta name="robots" content="all">


	<!--[if lt IE 9]>
	<script src="script/html5shiv.js"></script>
	<![endif]-->
	<script language="javascript" type="text/javascript">
                function UserLogin(username,othername){
                    $.ajax({
                        type:"POST",
                        url:"DealData.jsp",
                        data:"action=login&d="+new Date()+"&username="+username+"&othername="+othername,
                        success:function(data){
                            if(data.indexOf("True")>0){   //注释：indexOf() 方法对大小写敏感！
                                window.location="ChatMain.html";
                            }else{
                                alert("用户名或者密码错误");
                                $("#spnMsg").hide();
                                return false;
                            }
                        }
                    });
                }                
        </script>
<style type="text/css">#yddContainer{display:block;font-family:Microsoft YaHei;position:relative;width:100%;height:100%;top:-4px;left:-4px;font-size:12px;border:1px solid}#yddTop{display:block;height:22px}#yddTopBorderlr{display:block;position:static;height:17px;padding:2px 28px;line-height:17px;font-size:12px;color:#5079bb;font-weight:bold;border-style:none solid;border-width:1px}#yddTopBorderlr .ydd-sp{position:absolute;top:2px;height:0;overflow:hidden}.ydd-icon{left:5px;width:17px;padding:0px 0px 0px 0px;padding-top:17px;background-position:-16px -44px}.ydd-close{right:5px;width:16px;padding-top:16px;background-position:left -44px}#yddKeyTitle{float:left;text-decoration:none}#yddMiddle{display:block;margin-bottom:10px}.ydd-tabs{display:block;margin:5px 0;padding:0 5px;height:18px;border-bottom:1px solid}.ydd-tab{display:block;float:left;height:18px;margin:0 5px -1px 0;padding:0 4px;line-height:18px;border:1px solid;border-bottom:none}.ydd-trans-container{display:block;line-height:160%}.ydd-trans-container a{text-decoration:none;}#yddBottom{position:absolute;bottom:0;left:0;width:100%;height:22px;line-height:22px;overflow:hidden;background-position:left -22px}.ydd-padding010{padding:0 10px}#yddWrapper{color:#252525;z-index:10001;background:url(chrome-extension://eopjamdnofihpioajgfdikhhbobonhbb/ab20.png);}#yddContainer{background:#fff;border-color:#4b7598}#yddTopBorderlr{border-color:#f0f8fc}#yddWrapper .ydd-sp{background-image:url(chrome-extension://eopjamdnofihpioajgfdikhhbobonhbb/ydd-sprite.png)}#yddWrapper a,#yddWrapper a:hover,#yddWrapper a:visited{color:#50799b}#yddWrapper .ydd-tabs{color:#959595}.ydd-tabs,.ydd-tab{background:#fff;border-color:#d5e7f3}#yddBottom{color:#363636}#yddWrapper{min-width:250px;max-width:400px;}</style></head>
<link rel="stylesheet" href="PageVolunteer/css/site.css" />


<body id="css-zen-garden">
<div class="page-wrapper">

	<section class="intro" id="zen-intro">
		<header role="banner">
			<h1>志愿者世界</h1>
			<h2>The Beauty of <abbr title="Cascading Style Sheets">Sight</abbr> In China</h2>
		</header>

		<!-- 这一块想用来做查询-->
		<div class="summary" id="zen-summary" role="article">
			<p> Volunteers Make World Better!<!--  <abbr title="Cascading Style Sheets">CSS</abbr>--></p>
			<p>我们的存在，是为了让这个世界多一份爱，用自己闲暇的时间，带他人去观赏美妙世界！ <a href="http://www.csszengarden.com/examples/style.css" title="This page&#39;s sample CSS, the file you may modify.">联系我们</a></p>
		</div>

		<div class="preamble" id="zen-preamble" role="article">
			<h3>志愿者们</h3>
			<p> 尽自己所能，给别人一份帮助！</p>
			<p>做一次导游，结交一个朋友，给一生留下美好！</p>
			<p>下面为新注册的游客，他们或许正需要像你这样的志愿者作为导游，带领 他们去参观，你愿意帮助他们吗？</p>
		</div>
	</section>

	
<%
  for(Tourist tou:tourists){
%>
		<div class="preamble" id="zen-preamble" role="article"><!-- 这里网页div的id也要考虑 -->
			<h3>游客<%=tou.getId() %></h3>  <!--这个我们也要弄好-->
			
			<table width="450" height="100">
				<tr>
					<td width="100" height="100" rowspan="5"><img src="1.jpg" alt="上海鲜花港 - 郁金香"  class="header" style="width:200px;height:200px;"/></td>
					<td width="284" height="25" >名字：<%=tou.getUsername() %></td>
				</tr>
				<tr>
					<td height="10">性别：<%=tou.getGender() %></td>
				</tr>
				<tr>
					<td height="20">职业：</td>
				</tr>
				<tr>
					<td height="20">电话号码：
						<%=tou.getTelephoneNumber() %>
					</td>
				</tr>
				<tr>
					<td height="25"><a href="javascript:void(0)" onClick="UserLogin('<%=volunteer.getUsername() %>','<%=tou.getUsername() %>')">联系他</a></td>
				</tr>
			</table>
		</div>	

 <%
  }
  %>
<div class="preamble" id="zen-preamble" role="article"><!-- 这里网页div的id也要考虑 -->
<form name="frmGo" id="frmGO" action="TouristController?action=getpage" method="post">
	<p align="center">
		[<%=pageBean.getCurrpage()%>/<%=pageBean.getPagecount()%>] <a
			href="VolunteerController?option=getpage&page=1">首页</a> | <a
			href="VolunteerController?option=getpage&page=<%=pageBean.getCurrpage() - 1%>">上一页</a>
		| <a
			href="VolunteerController?option=getpage&page=<%=pageBean.getCurrpage() + 1%>">下一页</a>
		| <a
			href="VolunteerController?option=getpage&page=<%=pageBean.getPagecount()%>">末页</a>
		<input type="text" size="5" name="page" /><input type="submit" value="GO" />
	</p>
	</form>
	</div>	

		<footer>
			<a href="http://validator.w3.org/check/referer" title="Check the validity of this site’s HTML" class="zen-validate-html">志愿者</a>
			<a href="http://jigsaw.w3.org/css-validator/check/referer" title="Check the validity of this site’s CSS" class="zen-validate-css">导游</a>
			<a href="http://creativecommons.org/licenses/by-nc-sa/3.0/" title="View the Creative Commons license of this site: Attribution-NonCommercial-ShareAlike." class="zen-license">带领</a>
			<a href="http://mezzoblue.com/zengarden/faq/#aaa" title="Read about the accessibility of this site" class="zen-accessibility">游客</a>
			<a href="https://github.com/mezzoblue/csszengarden.com" title="Fork this site on Github" class="zen-github">去观光</a>
		</footer>



	<aside class="sidebar" role="complementary">
		<div class="wrapper">

			<div class="design-selection" id="design-selection">
				<h3 class="select">个人信息:<%=volunteer.getName() %></h3>
				<a  href="">
					<img src="image/2.jpg" alt="上海鲜花港 - 郁金香"  class="header"/>
				    <span class="edit_person_pic"></span>
				</a>
				<dl class="person_info" >
				 <dd class="focus_num">
					<b>
						<a href="" target="_blank"> 0 </a>
					</b>
					朋友
				 </dd>
				 <dd class="fans_num">
					<b>
						<a href="" target="_blank"> 0 </a>
					</b>
					游客
				 </dd>
				</dl>
				<nav role="navigation">
					<ul>
					<li>
						<a href="http://www.csszengarden.com/220/" class="design-name">我的导游</a>   
					</li>					<li>
						<a href="http://www.csszengarden.com/219/" class="design-name">我的得分：</a>  
					</li>					<li>
						<a href="http://www.csszengarden.com/218/" class="design-name">我的评价 </a>  
					</li>			     <li>
						<a href="/travol/VolunteerController?option=changeInfo&method=forPage">更改个人信息 </a>  
					</li>				 <li>
						<a href="/travol/VolunteerController?option=changePassword&method=forPage">更改密码</a>  
					</li>				<li>
						<a href="/travol/VolunteerController?option=freeTimePage">空闲时间</a>  
					</li>				
								
				</ul>
				</nav>
				<input type="submit"  value="修改个人信息" /> <!-- 这里也应该有action -->
			</div>

			<div class="design-archives" id="design-archives">
				<h3 class="archives">天气链接</h3>
				<nav role="navigation">
					<ul>
						<li class="next">
							<a href="http://m.weather.com.cn/">
								天津天气 <span class="indicator">›</span>
							</a>
						</li>
						<li class="viewall">
							<a href="http://www.weather.com.cn/" title="View every submission to the Zen Garden.">
								中国天气网							</a>
						</li>
					</ul>
				</nav>
			</div>

			<div class="zen-resources" id="zen-resources">
				<h3 class="resources">景点链接:</h3>
				<ul>
					<li class="view-css">
						<a href="http://www.cssn.com.cn/" title="View the source CSS file of the currently-viewed design.">
							中国景点网					</a>
					</li>
					<li class="css-resources">
						<a href="http://www.cncn.com/paihang/" title="Links to great sites with information on using CSS.">
							欣欣旅游				</a>
					</li>
					<li class="zen-faq">
						<a href="http://www.ctrip.com/" title="A list of Frequently Asked Questions about the Zen Garden.">
							携程					</a>
					</li>
					<li class="zen-submit">
						<a href="http://www.traveler365.com/" title="Send in your own CSS file.">
							驴友网					</a>
					</li>
					<li class="zen-translations">
						<a href="http://www.mezzoblue.com/zengarden/translations/" title="View translated versions of this page.">
							Translations						</a>
					</li>
				</ul>
			</div>
		</div>
	</aside>


</div>

<!--

	These superfluous divs/spans were originally provided as catch-alls to add extra imagery.
	These days we have full ::before and ::after support, favour using those instead.
	These only remain for historical design compatibility. They might go away one day.
		
-->
<div class="extra1" role="presentation"></div><div class="extra2" role="presentation"></div><div class="extra3" role="presentation"></div>
<div class="extra4" role="presentation"></div><div class="extra5" role="presentation"></div><div class="extra6" role="presentation"></div>


</body></html>