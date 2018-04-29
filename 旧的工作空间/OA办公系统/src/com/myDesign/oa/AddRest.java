package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyTools.Check;
import com.MyTools.DBTools;
import com.MyTools.LoginTools;


@WebServlet("/AddRest")
public class AddRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		
		request.getRequestDispatcher("AddRest.jsp").forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//接受数据并回显
		String start_date="";
		String end_date="";
		String reason="";
		
		if(request.getParameter("start_date")!=null)
		{
			start_date=request.getParameter("start_date");
			request.setAttribute("start_date", start_date);
		}
		
		if(request.getParameter("end_date")!=null)
		{
			end_date=request.getParameter("end_date");
			request.setAttribute("end_date", end_date);
		}
		
		if(request.getParameter("reason")!=null)
		{
			reason=request.getParameter("reason");
			request.setAttribute("reason", reason);
		}
		
		
		if(start_date.trim().length()==0)
		{
			request.setAttribute("msg", "开始时间不能为空!");
			request.getRequestDispatcher("AddRest.jsp").forward(request, response);
			return;
		}
		
		if(end_date.trim().length()==0)
		{
			request.setAttribute("msg", "结束时间不能为空!");
			request.getRequestDispatcher("AddRest.jsp").forward(request, response);
			return;
		}
		
		if(reason.trim().length()==0)
		{
			request.setAttribute("msg", "原因不能为空!");
			request.getRequestDispatcher("AddRest.jsp").forward(request, response);
			return;
		}
		
		if(end_date.compareTo(start_date)<0)
		{
			request.setAttribute("msg", "截至日期不得早于起始日期");
			request.getRequestDispatcher("AddRest.jsp").forward(request, response);
			return;
			
		}
		
		
		HttpSession session=request.getSession();
		String name=session.getAttribute("user_name").toString();
		String account=session.getAttribute("account").toString();
		Map<String,String> map=new HashMap<String,String>();
		String sql="select user_id from user where account='"+account+"'";
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		String user_id="";
		if(map!=null)
		{
			user_id=map.get("user_id");
			String sql2="insert into rest (fk_user_id,start_date,end_date,rest_reason,rest_status) values('"+
			user_id+"','"+start_date+"','"+end_date+"','"+reason+"',0)";
			
			
			int result=DBTools.executeUpdate(sql2);
			if(result>0)
			{
				
				String action="提交了一条请假申请";
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				 String date=df.format(new Date());// new Date()为获取当前系统时间
				 LoginTools.AddLog(account, name, action, date);
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('申请已提交');"
						+ "window.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
			else
			{

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('提交失败。请联系网站管理员');"
						+ "window.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
