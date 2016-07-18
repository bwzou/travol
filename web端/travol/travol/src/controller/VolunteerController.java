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

import po.FreeTime;
import po.Volunteer;
import vo.PageBean;
import biz.FreeTimeBiz;
import biz.TouristBiz;
import biz.VolunteerBiz;
import biz.impl.FreeTimeBizImpl;
import biz.impl.TouristBizImpl;
import biz.impl.VolunteerBizImpl;

/**
 * Servlet implementation class VolunteerController
 */
public class VolunteerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VolunteerController() {
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
		VolunteerBiz volunteerBiz = new VolunteerBizImpl();
		FreeTimeBiz freeTimeBiz = new FreeTimeBizImpl();

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
					msg = volunteerBiz.registUser(username, email, password);
				else
					msg = "两次密码不一致";
			} else
				msg = "请填完表单";

			if (!msg.equals("success")) {
				out.println("<script>alert('" + msg
						+ "');history.back();</script>");
			} else {
				out.println("<script>alert('注册成功');location.href='/travol/PageVolunteer/login.jsp'</script>");
			}
		}
		if (option.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String random = (String) session.getAttribute("random");
			String rand = (String) request.getParameter("rand");
			// System.out.println(random+"  "+rand);
			if (random.equals(rand)) {
				Volunteer volunteer = volunteerBiz
						.userLogin(username, password);
				if (volunteer != null) {
					request.getSession().setAttribute("volunteer", volunteer);
					
					int pagesize = 5;
					//第一步先判断有没有页
					int currpage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
					TouristBiz touristBiz = new TouristBizImpl();
					PageBean pageBean = touristBiz.getTouristByPage(pagesize, currpage);
					request.setAttribute("pageBean", pageBean);
					//请求转发
					request.getRequestDispatcher("PageVolunteer/Volunteers.jsp").forward(request, response);
					//response.sendRedirect("PageVolunteer/home.jsp");
				} else {
					out.println("<script>alert('不存在该用户名');history.back();</script>");
				}
			} else {
				out.println("<script>alert('验证码错误');history.back();</script>");
			}
		}
		if (option.equals("logout")) {
			session.removeAttribute("volunteer");
			response.sendRedirect("PageVolunteer/login.jsp");
		}
		if (option.equals("changeInfo")) {
			if (method.equals("forPage")) {
				response.sendRedirect("PageVolunteer/changeInfo.jsp");
			}
			if (method.equals("change")) {
				Volunteer volunteer = (Volunteer) session
						.getAttribute("volunteer");
				// System.out.println("email"+volunteer.getEmail());
				String name = request.getParameter("name");
				String IdCard = request.getParameter("IdCard");
				String gender = request.getParameter("gender");
				String telephoneNumber = request
						.getParameter("telephoneNumber");
				String self_intro = request.getParameter("self_introduction");
				String province=request.getParameter("province");
				String city=request.getParameter("city");
				String county=request.getParameter("county");
				boolean placechanged=true;
				if(province.equals("省份")||city.equals("地级市")||county.equals("市、县级市、县"))
					placechanged=false;
				
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
				volunteer.setName(name);
				volunteer.setIdCard(IdCard);
				volunteer.setGender(gender);
				volunteer.setTelephoneNumber(telephoneNumber);
				volunteer.setBirthday(birthday);
				volunteer.setSelfIntroduction(self_intro);
				if(placechanged)
				volunteer.setPlace(province+"-"+city+"-"+county);
				volunteerBiz.updateById(volunteer.getId(), volunteer);
					
				//out.println("<script>alert('修改成功');location.href='/travol/PageVolunteer/Volunteers.jsp'</script>");
				out.println("<script>alert('修改成功');location.href='VolunteerController?option=getpage'</script>");
			}
		}
		if (option.equals("changePassword")) {
			if (method.equals("forPage")) {
				response.sendRedirect("PageVolunteer/changePassword.jsp");
			}
			if (method.equals("change")) {
				String oldPassword = request.getParameter("oldPassword");
				String newPassword = request.getParameter("newPassword");
				String newPasswordConfirm = request
						.getParameter("newPasswordConfirm");

				Volunteer volunteer = (Volunteer) session
						.getAttribute("volunteer");
				if (oldPassword.equals(volunteer.getPassword())) {
					if (newPassword.equals(newPasswordConfirm)) {
						volunteer.setPassword(newPassword);
						volunteerBiz.updateById(volunteer.getId(), volunteer);
						//这里要设置pagebean
						out.println("<script>alert('修改成功');location.href='VolunteerController?option=getpage'</script>");
						//out.println("<script>alert('修改成功');location.href='/travol/PageVolunteer/home.jsp'</script>");
					} else {
						out.println("<script>alert('新密码不一致');history.back();</script>");
					}
				} else {
					out.println("<script>alert('旧密码错误');history.back();</script>");
				}
			}
		}
		if (option.equals("freeTimePage")) {
			Volunteer volunteer = (Volunteer) session.getAttribute("volunteer");
			int vid = volunteer.getId();
			List<FreeTime> list = freeTimeBiz.findAllByVid(vid);
			request.setAttribute("freeTimeList", list);
			request.getRequestDispatcher(
					"PageVolunteer/freeTime.jsp?vid=" + vid).forward(request,
					response);
		    
		}
		if (option.equals("addFreeTime")) {
			Volunteer volunteer = (Volunteer) session.getAttribute("volunteer");
			int vid = volunteer.getId();
			String freeList = request.getParameter("dates");
			freeTimeBiz.addFreeTimeList(vid, freeList);
			response.sendRedirect("VolunteerController?option=freeTimePage");
		}
		if (option.equals("deleteFreeTime")) {
			Volunteer volunteer = (Volunteer) session.getAttribute("volunteer");
			int id = Integer.parseInt(request.getParameter("id"));
			freeTimeBiz.deleteFreeTimeById(id);
			response.sendRedirect("VolunteerController?option=freeTimePage");
		}
		if(option.equals("getpage")){
			int pagesize = 5;
			//第一步先判断有没有页
			int currpage = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			TouristBiz touristBiz = new TouristBizImpl();
			PageBean pageBean = touristBiz.getTouristByPage(pagesize, currpage);
			request.setAttribute("pageBean", pageBean);
			//请求转发
			request.getRequestDispatcher("PageVolunteer/Volunteers.jsp").forward(request, response);
		}
		
	}
}
