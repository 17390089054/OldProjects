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


@WebServlet("/Restfall")
public class Restfall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!Check.Check(request, response))
		{
			
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//接受前台和数据并回显
		String rest_id="";
		String user_name="";
		String start_date="";
		String end_date="";
		String reason="";
		String reply="";
		if(request.getParameter("rest_id")!=null)
		{			
			rest_id=request.getParameter("rest_id");
			request.setAttribute("rest_id", rest_id);
		}
		if(request.getParameter("user_name")!=null)
		{
			user_name=request.getParameter("user_name");
			request.setAttribute("user_name", user_name);
		}
		
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
		
		if(request.getParameter("reply")!=null)
		{
			reply=request.getParameter("reply");
			request.setAttribute("reply", reply);
		}
		
		//数据判空
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg","姓 名 不 能 为 空");
			request.getRequestDispatcher("RestCheck.jsp").forward(request, response);
			return;
		}
		

		if(start_date.trim().length()==0)
		{
			request.setAttribute("msg","起 始 日 期 不 能 为 空");
			request.getRequestDispatcher("RestCheck.jsp").forward(request, response);
			return;
		}
		

		if(end_date.trim().length()==0)
		{
			request.setAttribute("msg","结 束 日 期  不 能 为 空");
			request.getRequestDispatcher("RestCheck.jsp").forward(request, response);
			return;
		}
		

		if(reason.trim().length()==0)
		{
			request.setAttribute("msg","请 假 原 因  不 能 为 空");
			request.getRequestDispatcher("RestCheck.jsp").forward(request, response);
			return;
		}
		

		if(reply.trim().length()==0)
		{
			request.setAttribute("msg"," 回 复 不 能 为 空");
			request.getRequestDispatcher("RestCheck.jsp").forward(request, response);
			return;
		}
		
		if(end_date.compareTo(start_date)<0)
		{
			request.setAttribute("msg", "截至日期不得早于起始日期");
			request.getRequestDispatcher("RestCheck.jsp").forward(request, response);
			return;
			
		}
	
		
		String sql="select fk_user_id from rest where rest_id= '"+rest_id+"'";
		
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		String user_id="";
		if(map!=null)
		{
		user_id=map.get("fk_user_id");	
			
			String sql2="update rest set fk_user_id='"+user_id+"',start_date='"+start_date+"',end_date='"+end_date+"',rest_reason='"+
			reason+"',reply='"+reply+"',rest_status=2 where rest_id='"+rest_id+"'";
			
			
			int result=DBTools.executeUpdate(sql2);
			 if(result>0)
				{
					HttpSession session=request.getSession();
					String account=session.getAttribute("account").toString();
					String name=session.getAttribute("user_name").toString();
				 	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String date2=df.format(new Date());
					String action="审批且不予通过一条请假信息";				
					
					 LoginTools.AddLog(account, name, action, date2);
					 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('审批成功');"
							+ "window.location.href='DealRest';"
							+ "</script>");
					out.close();
					
				}
				else
				{

					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('审批失败。请联系网站管理员');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
				}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
