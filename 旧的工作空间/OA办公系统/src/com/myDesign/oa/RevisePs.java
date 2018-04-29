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


@WebServlet("/RevisePs")
public class RevisePs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("RevisePs.jsp").forward(request, response);
	return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String password="";
		String password1="";
		String password2="";
		//数据判空
		if(request.getParameter("password")!=null)
		{
			password=request.getParameter("password");
			request.setAttribute("password", password);
		}
		
		if(request.getParameter("password1")!=null)
		{
			password1=request.getParameter("password1");
			request.setAttribute("password1", password1);
		}
		if(request.getParameter("password2")!=null)
		{
			password2=request.getParameter("password2");
			request.setAttribute("password2", password2);
		}
		
		if(password.trim().length()==0)
		{
			request.setAttribute("msg", "原密码不能为空!");
			request.getRequestDispatcher("RevisePs.jsp").forward(request,response);
			return;
		}
		
		if(password1.trim().length()==0)
		{
			request.setAttribute("msg", "新密码不能为空!");
			request.getRequestDispatcher("RevisePs.jsp").forward(request,response);
			return;
		}
		
		if(password2.trim().length()==0)
		{
			request.setAttribute("msg", "请再次确认密码!");
			request.getRequestDispatcher("RevisePs.jsp").forward(request,response);
			return;
		}
		
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String sql="select password from user where account='"+account+"'";
		/*System.out.println(sql);*/
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		
		String passwordReal="";
		if(map!=null)
		{
			passwordReal=map.get("password");	
			
		}
		
		if(!password.equals(passwordReal))
		{/*
			System.out.println(password);
			System.out.println(passwordReal);
			System.out.println(password.equals(passwordReal));*/
			
			request.setAttribute("msg", "原密码不正确!");
			request.getRequestDispatcher("RevisePs.jsp").forward(request,response);
			return;
		}
		
		else
		{
			
			if(!password1.equals(password2))
			{
				request.setAttribute("msg", "确认密码前后不一致!");
				request.getRequestDispatcher("RevisePs.jsp").forward(request, response);
				return;
			}
			
			else
			{
				String sql2="update user set password='"+password1+"' where account='"+account+"'";
				int result=DBTools.executeUpdate(sql2);
				
				if(result>0)
				 {
				
					String name=session.getAttribute("user_name").toString();
				 	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String date2=df.format(new Date());
					String action="修改了密码";				
					
					 LoginTools.AddLog(account, name, action, date2);
					 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('修改成功');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
				}
				else
				{

					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('修改失败。请联系网站管理员');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
				}
				 
				
			}
			
		}
		
		
		
	}

}
