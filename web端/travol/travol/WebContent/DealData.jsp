<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="zy.DealData" %>
<%! String TOURIST;   //定义一个全局变量 %>
<%
	String action=request.getParameter("action");  //这个action是获取JavaScript传过来的Action
	DealData dd=new DealData();
	//String TOURIST;   //定义一个全局变量
	
	//用户登录
	if("login".equals(action)){
		String username=request.getParameter("username");
		String othername=request.getParameter("othername");  //寻找游客名字
		out.println(dd.userLogin(username,othername,session,application));   //这个可以了
	}
	//获取所有聊天消息
	else if("ChatList".equals(action)){
		String usernameInSession=(String)session.getAttribute("username");
		if(usernameInSession==null){
			out.print("unLogin");
		}else{     //应该是这里传session导致出错了被覆盖了，所以我们可以另外在开一个浏览器
			out.print(dd.AllChatList(application,session));    //根据用户来获取用户的
		}
	}
	//发送消息
	else if("SendContent".equals(action)){
		String content=request.getParameter("content");
		out.println(dd.addContent(content,application,session));	//out把信息回传给客户端界面，JavaScript通过data:接受	
	}
	//获取在线人员列表
	else if("onLineList".equals(action)){
		out.println(dd.GetOnlineUsers(application,session));
	}
	//下线
	else if("OffLine".equals(action)){
		out.print(dd.OffLine(application,session));
	}
%>
