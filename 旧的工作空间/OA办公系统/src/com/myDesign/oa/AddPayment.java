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


@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.getRequestDispatcher("AddPayment.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String p_reason="";
		String p_type="";
		String p_place="";
		String p_money="";
		
		//接受前台数据并判空
		if(request.getParameter("place")!=null)
		{
			p_place=request.getParameter("place");
			request.setAttribute("place", p_place);
			
		}
		
		if(request.getParameter("type")!=null)
		{
			p_type=request.getParameter("type");
			request.setAttribute("type", p_type);
			
		}
		
		if(request.getParameter("reason")!=null)
		{
			p_reason=request.getParameter("reason");
			request.setAttribute("reason", p_reason);
			
		}
		
		if(request.getParameter("money")!=null)
		{
			p_money=request.getParameter("money");
			request.setAttribute("money", p_money);
			
		}
		
	if(p_place.trim().length()==0)
	{
		request.setAttribute("msg", "地点不能为空!");
		request.getRequestDispatcher("AddPayment.jsp").forward(request,response);
		return;
	}
		
	if(p_type.trim().length()==0)
	{
		request.setAttribute("msg", "类型不能为空!");
		request.getRequestDispatcher("AddPayment.jsp").forward(request,response);
		return;
	}
	
	if(p_reason.trim().length()==0)
	{
		request.setAttribute("msg", "原因不能为空!");
		request.getRequestDispatcher("AddPayment.jsp").forward(request,response);
		return;
	}
	
	if(p_money.trim().length()==0)
	{
		request.setAttribute("msg", "金额不能为空!");
		request.getRequestDispatcher("AddPayment.jsp").forward(request,response);
		return;
	}
	
	HttpSession session=request.getSession();
	String account=session.getAttribute("account").toString();
	String sql="select user_id from user where account='"+account+"'";
	Map<String,String>map=new HashMap<String,String>();
	map=(Map<String,String>)DBTools.executeQuery(sql).get(0);	
	String user_id="";	
	if(map!=null)
		{
			user_id=map.get("user_id");
			String sql2="insert into payment (fk_user_id,p_reason,p_type,p_place,p_status,p_money)values('"+
			user_id+"','"+p_reason+"','"+p_type+"','"+p_place+"',0,'"+p_money+"')";
			
			int result=DBTools.executeUpdate(sql2);
			
			String name=session.getAttribute("user_name").toString();
			String action="提交了一条报销申请";				
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date2=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account, name, action, date2);
			 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('发布成功');"
					+ "window.location.href='PaymentHistory';"
					+ "</script>");
			out.close();
			
		}
		else
		{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('发布失败。请联系网站管理员');"
					+ "window.top.location.href='index';"
					+ "</script>");
			out.close();
			
		}
			
			
		}
		
		
		
	}


