<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%//<%@taglib prefix="s" uri="/struts-tags"  %>
<%@page import="po.Tourist"%>
<%@page import="po.Volunteer"%>
<%@page import="vo.PageBean"%>

<%
if(session.getAttribute("tourist")==null){//查看游客是否登陆了
	response.sendRedirect("login.jsp");    
	return;
}
Tourist tourist = (Tourist)session.getAttribute("tourist");    //传游客过来
	// 从请求对象中（request）中取出数据
List<Volunteer> volunteers= (List<Volunteer>)request.getAttribute("volunteers");

        //传志愿者过来
%>

<!DOCTYPE html>
<!-- saved from url=(0032)http://www.csszengarden.com/118/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>游客天堂</title>
    <script language="javascript" type="text/javascript" src="jquery-1.8.0.min.js"></script>
     
	<link rel="stylesheet" media="screen" href="root.css">
	<link rel="alternate" type="application/rss+xml" title="RSS" href="http://www.csszengarden.com/zengarden.xml">

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
<link rel="stylesheet" href="site.css" />
<!--



	View source is a feature, not a bug. Thanks for your curiosity and
	interest in participating!

	Here are the submission guidelines for the new and improved csszengarden.com:

	- CSS3? Of course! Prefix for ALL browsers where necessary.
	- go responsive; test your layout at multiple screen sizes.
	- your browser testing baseline: IE9+, recent Chrome/Firefox/Safari, and iOS/Android
	- Graceful degradation is acceptable, and in fact highly encouraged.
	- use classes for styling. Don't use ids.
	- web fonts are cool, just make sure you have a license to share the files. Hosted 
	  services that are applied via the CSS file (ie. Google Fonts) will work fine, but
	  most that require custom HTML won't. TypeKit is supported, see the readme on this
	  page for usage instructions: https://github.com/mezzoblue/csszengarden.com/

	And a few tips on building your CSS file:

	- use :first-child, :last-child and :nth-child to get at non-classed elements
	- use ::before and ::after to create pseudo-elements for extra styling
	- use multiple background images to apply as many as you need to any element
	- use the Kellum Method for image replacement, if still needed. http://goo.gl/GXxdI
	- don't rely on the extra divs at the bottom. Use ::before and ::after instead.

		
-->

<body id="css-zen-garden">
<div class="page-wrapper">

	<section class="intro" id="zen-intro">
		<header role="banner">
			<h1>游客天堂</h1>
			<h2>The Beauty of <abbr title="Cascading Style Sheets">Sight</abbr> In China</h2>
		</header>

		<!-- 这一块想用来做查询-->
		<div class="summary" id="zen-summary" role="article">
			<form id="user_form" action="VolunteerController?action=selectvol" method="post">  <!-- 查找游客 -->
			   景点： <input type="text" name="scenic" />  &nbsp; 城市：
				<select name="city">
				<option value="beijing">北京</option>
				<option value="tianjng">天津</option>
				<option value="shanghai">上海</option>
				<option value="xian">西安</option>
				</select> <br />
				时间： <input type="text" name="joinDate" />   &nbsp;  性别：<input type="radio" name="gender" value="male"/>男   &nbsp;<input type="radio" name="gender" value="female" />女 <br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="Submit" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"  value="Reset" />
				<br />

			</form>
			<!--
			<p>A demonstration of what can be accomplished through <abbr title="Cascading Style Sheets">CSS</abbr>-based design. Select any style sheet from the list to load it into this page.</p>
			<p>Download the example <a href="http://www.csszengarden.com/examples/index" title="This page&#39;s source HTML code, not to be modified.">html file</a> and <a href="http://www.csszengarden.com/examples/style.css" title="This page&#39;s sample CSS, the file you may modify.">css file</a></p>
		       -->
		</div>
</section>

<%
  for(Volunteer vol:volunteers){
%>
		<div class="preamble" id="zen-preamble" role="article"><!-- 这里网页div的id也要考虑 -->
			<h3>志愿者<%=vol.getId() %></h3>  <!--这个我们也要弄好-->
			
			<table width="450" height="100">
				<tr>
					<td width="100" height="100" rowspan="5"><img src="1.jpg" alt="上海鲜花港 - 郁金香"  class="header" style="width:200px;height:200px;"/></td>
					<td width="284" height="15" >名字：<%=vol.getUsername() %></td>
				</tr>
				<tr>
					<td height="10">性别：</td>
				</tr>
				<tr>
					<td height="10">职业：</td>
				</tr>
				<tr>
					<td height="50">个人简介：
						
					</td>
				</tr>
				<tr>
					<td height="15"><a href="javascript:void(0)" onClick="UserLogin('<%=tourist.getUsername() %>','<%=vol.getUsername() %>')">联系他</a></td>
				</tr>
			</table>
		</div>	
 <%
  }
  %>
  
 <!-- <div class="participation" id="zen-participation" role="article">
	<form name="frmGo" id="frmGO" action="VolunteerController?action=getpage" method="post">
	 <p align="center">
		[<%//=pageBean.getCurrpage()%>/<%//=pageBean.getPagecount()%>] <a
			href="VolunteerController?action=getpage&page=1">首页</a> | <a
			href="VolunteerController?action=getpage&page=<%//=pageBean.getCurrpage() - 1%>">上一页</a>
		| <a
			href="VolunteerController?action=getpage&page=<%//=pageBean.getCurrpage() + 1%>">下一页</a>
		| <a
			href="VolunteerController?action=getpage&page=<%//=pageBean.getPagecount()%>">末页</a>
		<input type="text" size="5" name="page" /><input type="submit" value="GO" />
	</p>
	</form>
</div> -->
		
	
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
				<h3 class="select">个人信息:<%=tourist.getName() %></h3>
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
						<a href="http://www.csszengarden.com/220/" class="design-name">我的导游</a>   <!-- by		<a href="http://danielmall.com/" class="designer-name">Dan Mall</a>       -->
					</li>					<li>
						<a href="http://www.csszengarden.com/219/" class="design-name">我的得分：</a>  <!-- by  	<a href="http://steffen-knoeller.de/" class="designer-name">Steffen Knoeller</a>     -->
					</li>					<li>
						<a href="http://www.csszengarden.com/218/" class="design-name">我的评价 </a>  <!-- by		<a href="http://trentwalton.com/" class="designer-name">Trent Walton</a>     -->
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