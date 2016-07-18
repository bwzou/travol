package zy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class DealData {

	//用户登录的判读(这个应该在登陆时就要弄好了users)
	public String userLogin(String username,String othername,HttpSession session,ServletContext application){

		//如果密码正确就将用户名放入session
		session.setAttribute("username", username);       //游客的名字没有弄好

		//保存当前用户的想要交流的对象
		session.setAttribute(username+"other", othername);
		//获取在线用户列表                                 //这里可以改成单用户的，就是从用户那里直接获取到相应的pid，
		List<String> users=(List<String>)application.getAttribute("users");
		//获取被聊用户
		List<String> chatme=(List<String>)application.getAttribute("chatme");
		if(users==null){
			users=new ArrayList<String>();
		}
		if(chatme==null){
			chatme=new ArrayList<String>();
		}
		//将当前用户加入用户列表
		users.add(username);
		chatme.add(othername+username);
		//更新application中的对象
		application.setAttribute("users", users);
		application.setAttribute("chatme",chatme );
		return "True";

	}

	//添加消息
	public String addContent(String content,ServletContext application,HttpSession session){
		List<String> strList=(List<String>) application.getAttribute("MessageList");
		if(strList==null){
			strList=new ArrayList<String>();
		}
		//获取session中的用户名
		String username=(String)session.getAttribute("username");
		//获取时间
		Date date=new Date();
		content=content.replace("<:", "<img src='QQface/");
		content=content.replace(":>", ".gif' />");
		//组装消息
		String message=username+"于"+date.toLocaleString()+"说："+content;
		//添加到集合中
		strList.add(message);
		//放入application对象中
		application.setAttribute("MessageList", strList);
		return "True";
	}

	//获取所有的消息
	public String AllChatList(ServletContext application,HttpSession session){
		StringBuffer sb=new StringBuffer();
		List<String> strList=(List<String>) application.getAttribute("MessageList");

		//获取用户名
		String username=(String)session.getAttribute("username");
		//获取要交流的对象名字
		String othername=(String)session.getAttribute(username+"other");

		List<String> chat=new ArrayList<String>();   //存放用户信息的列表

		//获取被交流对象名字（首先遍历这张表）
		List<String> chatme=(List<String>)application.getAttribute("chatme");
		//获取在线用户列表                                 //这里可以改成单用户的，就是从用户那里直接获取到相应的pid，
		List<String> users=(List<String>)application.getAttribute("users");

		if(chatme!=null){
			for(String s:chatme){
				if(s.indexOf(username)>=0){   //看看有没有被聊天
					String str=s.replaceAll(username, "");
					//添加进来弄(最多就添加三个进来)
					chat.add(str);				
				}
			}
		} 
		chat.add(username);	


		if(chat!=null&&strList!=null){
			for(String s:strList){
				for(String cc:chat){
					if(s.indexOf(cc)>=0){
						sb.append(s+"<br />");   //全部打包到sb
					}
				}
			}
		}
		return sb.toString();
	}


	//获取在线用户列表
	public String GetOnlineUsers(ServletContext application,HttpSession session){
		StringBuffer sb=new StringBuffer();
		List<String> strList=(List<String>) application.getAttribute("users");

		//获取用户名
		String username=(String)session.getAttribute("username");
		//获取要交流的对象名字
		String othername=(String)session.getAttribute(username+"other");



		//获取被交流对象名字
		String otherchatme=null;
		//（首先遍历这张表）
		List<String> chatme=(List<String>)application.getAttribute("chatme"); 
		//获取在线用户列表                                 //这里可以改成单用户的，就是从用户那里直接获取到相应的pid，
		List<String> users=(List<String>)application.getAttribute("users");
		if(chatme!=null){
			for(String s:chatme){
				if(s.indexOf(username)>=0){   ////看看有没有被聊天
					String str=s.replaceAll(username, "");
					if(users!=null){
						for(String user:users){							
							/*System.out.println("开始比较");
							System.out.println(user);
							System.out.println(str); */
							if(user.equals(str)){          //字符串不能直接等,这里导致出错
								sb.append(str+"<br />");   //全部打包到sb
							}
						}
					}
				}
			}
		} 
		if(strList!=null){
			for(String s:strList){
				if(otherchatme!=null){
					if(s.indexOf(othername)>=0||s.indexOf(username)>=0){   //根据消息来进行传送
						sb.append(s+"<br />");   //全部打包到sb
					}
				}
				else{

					if(sb.indexOf(othername)>=0){
						if(s.indexOf(username)>=0){
							sb.append(s+"<br />");   //全部打包到sb
						}
					}else{
						if(s.indexOf(othername)>=0||s.indexOf(username)>=0){   //根据消息来进行传送
							sb.append(s+"<br />");   //全部打包到sb
						}
					}
				}
			}
		}	
		return sb.toString();
	}

	//下线
	public String OffLine(ServletContext application,HttpSession session){
		//先取出用户名
		String username=(String)session.getAttribute("username");
		//保存当前用户的想要交流的对象
		String othername=(String)session.getAttribute(username+"other");
		//移除session中的内容
		session.removeAttribute("username");
		
		//移除用户列表中的用户名
		List<String> chatme=(List<String>)application.getAttribute("chatme");
		List<String> strList=(List<String>) application.getAttribute("users");
		if(strList!=null){
			strList.remove(username);
			chatme.remove(othername+username);
		} 
		return "True";
	}
}
