package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Tourist;
import po.Volunteer;
import vo.PageBean;
import biz.TouristBiz;
import biz.VolunteerBiz;
import biz.impl.TouristBizImpl;
import biz.impl.VolunteerBizImpl;

/**
 * Servlet implementation class TouristController
 */
public class TouristController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TouristController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		TouristBiz touristBiz=new TouristBizImpl();
		
		String option = request.getParameter("option");
		String method = request.getParameter("method");
		
		if (option.equals("regist")) {
			boolean validate = true;
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String passwordConfirm = request.getParameter("passwordConfirm");
			String random = (String) session.getAttribute("random");
			String rand = (String) request.getParameter("rand");

			if (username.equals("") || email.equals("") || password.equals("")
					|| passwordConfirm.equals(""))
				validate = false;

			String msg = new String("");
			if (validate) {
				if (!random.equals(rand))
					msg = "验证码错误";
				else if (password.equals(passwordConfirm))
					msg = touristBiz.registUser(username, email, password);
				else
					msg = "两次密码不一致";
			} else
				msg = "请填完表单";

			if (!msg.equals("success")) {
				out.println("<script>alert('" + msg
						+ "');history.back();</script>");
			} else {
				out.println("<script>alert('注册成功');location.href='/travol/PageTourist/login.jsp'</script>");
			}
		}
		if (option.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String random = (String) session.getAttribute("random");
			String rand = (String) request.getParameter("rand");
			
			// System.out.println(random+"  "+rand);
			if (random.equals(rand)) {
				Tourist tourist = touristBiz
						.userLogin(username, password);
				if (tourist != null) {
					request.getSession().setAttribute("tourist", tourist);
					
					int pagesize = 5;
					//第一步先判断有没有页
					int currpage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
					VolunteerBiz volunteerBiz = new VolunteerBizImpl();
					PageBean pageBean = volunteerBiz.getVolunteerByPage(pagesize, currpage);
					request.setAttribute("pageBean", pageBean);
					//请求转发
					request.getRequestDispatcher("PageTourist/Tourists.jsp").forward(request, response);
					//response.sendRedirect("PageTourist/home.jsp");
				} else {
					out.println("<script>alert('不存在该用户名');history.back();</script>");
				}
			} else {
				out.println("<script>alert('验证码错误');history.back();</script>");
			}
			
			
		}
		if (option.equals("logout")) {
			session.removeAttribute("tourist");
			response.sendRedirect("PageTourist/login.jsp");
		}
		if (option.equals("changeInfo")) {
			if (method.equals("forPage")) {
				response.sendRedirect("PageTourist/changeInfo.jsp");
			}
			if (method.equals("change")) {
				Tourist tourist = (Tourist) session
						.getAttribute("tourist");
				 System.out.println("email"+tourist.getEmail());
				String name = request.getParameter("name");
				String gender = request.getParameter("gender");
				String telephoneNumber = request
						.getParameter("telephoneNumber");
				
				int birthyear = Integer.parseInt(request
						.getParameter("birthyear"));
				int birthmonth = Integer.parseInt(request
						.getParameter("birthmonth"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date udate;

				Date birthday = null;
				try {
					udate = sdf.parse(birthyear + "-" + birthmonth + "-01");
					birthday = new Date(udate.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					System.out.println("parse error");
					e.printStackTrace();
				}
				System.out.println(birthyear + " " + birthmonth + " "
						+ birthday);
				tourist.setName(name);
				tourist.setGender(gender);
				tourist.setTelephoneNumber(telephoneNumber);
				tourist.setBirthday(birthday);
				touristBiz.updateById(tourist.getId(), tourist);
				//out.println("<script>alert('修改成功');location.href='/travol/PageTourist/home.jsp'</script>");
				out.println("<script>alert('修改成功');location.href='TouristController?option=getpage'</script>");
			}
		}
		if (option.equals("changePassword")) {
			if (method.equals("forPage")) {
				response.sendRedirect("PageTourist/changePassword.jsp");
			}
			if (method.equals("change")) {
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				String newPasswordConfirm = request
						.getParameter("newPasswordConfirm");

				Tourist tourist = (Tourist) session
						.getAttribute("tourist");
				if (oldPassword.equals(tourist.getPassword())) {
					if (newPassword.equals(newPasswordConfirm)) {
						tourist.setPassword(newPassword);
						touristBiz.updateById(tourist.getId(), tourist);
						//out.println("<script>alert('修改成功');location.href='/travol/PageTourist/home.jsp'</script>");
						out.println("<script>alert('修改成功');location.href='TouristController?option=getpage'</script>");
					} else {
						out.println("<script>alert('新密码不一致');history.back();</script>");
					}
				} else {
					out.println("<script>alert('旧密码错误');history.back();</script>");
				}
			}
		}
		
		if(option.equals("getpage")){
			int pagesize = 5;
			
			//第一步先判断有没有页
			int currpage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			//进一步查证志愿者
			VolunteerBiz volunteerBiz = new VolunteerBizImpl();
			PageBean pageBean = volunteerBiz.getVolunteerByPage(pagesize, currpage);
			request.setAttribute("pageBean", pageBean);
			//请求转发
			request.getRequestDispatcher("PageTourist/Tourists.jsp").forward(request, response);
		}
		
		if(option.equals("selectvol"))
	       {	
				String city=request.getParameter("city");
				String scenic=request.getParameter("scenic");
				String gender=request.getParameter("gender");
								
				String joinDate=request.getParameter("joinDate");   //这个时间比较难转
				
				System.out.println(city+" "+joinDate+" "+scenic+" "+gender+" ");
				
				VolunteerBiz volunteerBiz=new VolunteerBizImpl();
				//这个date改为String
				List<Volunteer> volunteers =volunteerBiz.getVolunteerByCondition(city, scenic, gender,joinDate);
				//其实这里我可以跳转到另外一个页面了这一就可以改写key映射了
				request.setAttribute("volunteers",volunteers);	
				System.out.println("这个查询没有问题吧");
				//请求转发
				request.getRequestDispatcher("PageTourist/Tourist.jsp").forward(request, response);
			}
	}
}