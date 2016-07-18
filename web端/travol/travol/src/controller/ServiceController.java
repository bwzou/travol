package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Service;
import biz.ServiceBiz;
import biz.TouristBiz;
import biz.impl.ServiceBizImpl;
import biz.impl.TouristBizImpl;

/**
 * Servlet implementation class ServiceController
 */
public class ServiceController extends HttpServlet {  //移植时要考虑配置servlet
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		ServiceBiz serviceBiz=new ServiceBizImpl();
		//要不要重新设置对象
		String option = request.getParameter("option");
		String method = request.getParameter("method");
		
		//添加
		if(option.equals("addService")){
			int t_id=1;                //先默认为1
			int v_id=2;
			Service service=new Service();
			service.setDate(new Date());    //增加一个时间
			service.setT_id(t_id);;
			service.setV_id(v_id);
			boolean flag =serviceBiz.insertService(service);
			if(flag){
				out.println("<script>alert('请求已经发送，请等候回复');location.href='login.jsp';</script>");
			}else {
				out.println("<script>alert('请求失败');history.back();</script>");
			}
		}
		//查找志愿者相关
		if(option.equals("SelectVolunteer")){
			int v_id=2;
			List<Service> services= serviceBiz.findByVolunteerId(v_id);
			request.setAttribute("VolunteerShow", services);
			
			  for(Service service:services){
				  System.out.println(service.getId()+"fr");
			  }
			  
			System.out.println("kkkkkkkkkkkkkkkkk");
			request.getRequestDispatcher("volunteershow.jsp").forward(request,
					response);
		}
		//查找志愿者的state操作
		if(option.equals("stateVolunteer")){
			int id = Integer.parseInt(request.getParameter("bid"));
			int state=Integer.parseInt(request.getParameter("state"));
			Service service=serviceBiz.findOneById(id);	
			service.setState(state);    //这里的状态没有设
			boolean flag=serviceBiz.updateStateById(id, service);
			if (flag) {
				out.println("<script>alert('操作成功');location.href='ServiceController?option=SelectVolunteer';</script>");
			} else {
				out.println("<script>alert('操作失败');location.href='ServiceController?option=SelectVolunteer';</script>");
			}
			//response.sendRedirect("ServiceController?option=SelectVolunteer");
		}
		//查找游客相关
		if(option.equals("SelectTourist")){
			//int id=Integer.parseInt(request.getParameter("bid"));
			int t_id=1;   //只是这个
			List<Service> services= serviceBiz.findByTouristId(t_id);
			request.setAttribute("TouristShow", services);
			request.getRequestDispatcher("touristshow.jsp").forward(request,
					response);
		}
		//查找游客的评价操作
		if(option.equals("evaluation")){				
			int id=Integer.parseInt(request.getParameter("bid"));
			String evalue=request.getParameter("publisher");
			float rating=Float.parseFloat(request.getParameter("price"));
			//先找到再说
			Service service=serviceBiz.findOneById(id);
			service.setEvaluation(evalue);
			service.setRating(rating);
			boolean flag=serviceBiz.updateStateById(id, service);
			if(flag){
				out.println("<script>alert('评价成功');location.href='ServiceController?option=SelectTourist';</script>");
			}else {
				out.println("<script>alert('评价失败');location.href='ServiceController?option=SelectTourist';</script>");
			}
		}
		//游客取消请求
		if(option.equals("deleterequest")){
			int id=Integer.parseInt(request.getParameter("bid"));
			
			boolean flag = serviceBiz.deleteServiceById(id);
			if (flag) {
				out.println("<script>alert('删除成功');location.href='ServiceController?option=SelectTourist';</script>");
			} else {
				out.println("<script>alert('删除失败');location.href='ServiceController?option=SelectTourist';</script>");
			}
		}
		if(option.equals("getone")){
			int id = Integer.parseInt(request.getParameter("bid"));
			Service service=serviceBiz.findOneById(id);
			request.setAttribute("service", service);
			request.getRequestDispatcher("evaluation.jsp").forward(request,
					response);
		}
	}

}
