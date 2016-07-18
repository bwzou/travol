package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import po.Rating;
import biz.RsBiz;
import biz.impl.RsBizImpl;


/**
 * Servlet implementation class RsController
 */
@WebServlet("/RsController")
public class RsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RsBiz rsBiz = new RsBizImpl();  

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RsController() {
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
		PrintWriter out = response.getWriter();
		Rating rating = new Rating();
		int id = Integer.parseInt(request.getParameter("id"));
		int server = Integer.parseInt(request.getParameter("server"));
		int travel = Integer.parseInt(request.getParameter("travel"));
		int website = Integer.parseInt(request.getParameter("website"));
		System.out.println("id is "+id);
		rating.setServer(server);
		rating.setTravel(travel);
		rating.setWebsite(website);
//		System.out.println("rating number:"+id+"\n"+rating.getServer()+"\t"+rating.getTravel()+"\t"+rating.getWebsite());
		boolean flag = rsBiz.doRating(id,rating);
  		if(flag)
  		{
  			out.println("<script>alert('评价成功!感谢您的评价:)');location.href='index.jsp';</script>");
  		}
  		else
  		{
  			out.println("<script>alert('评价失败!请稍后再试:(');history.back();</script>");
  		}
	}

}
