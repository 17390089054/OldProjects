package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.MyTools.Check;
import com.MyTools.DBTools;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String user="";
		if(request.getParameter("用户名")!=null)
		{
			user=request.getParameter("用户名");
			request.setAttribute("account", user);
		}
		
		String psw="";
		if(request.getParameter("密码")!=null)
		{
			psw=request.getParameter("密码");
		}
				
		if(user.trim().length()==0)
		{
			request.setAttribute("msg", "用户名不能为空!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(psw.trim().length()==0)
		{
			
			request.setAttribute("msg", "密码不能为空!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		
		if(user.equals("admin")&&psw.equals("admin"))
		{
			
			
			String sql="select user_id,user_name from user where account='admin'";
			Map<String,String> map=new HashMap<String,String>();
			
			map=(Map<String, String>) DBTools.executeQuery(sql).get(0);
			
			String user_id="";
			
			String user_name="";
			if(map!=null)
			{
				user_id=map.get("user_id");
				user_name=map.get("user_name");
			}
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date=df.format(new Date());// new Date()为获取当前系统时间
			
			 String sql2="insert into log (fk_user_id,log_create_time) values('"+user_id+"','"+date+"')";
			 
		
			 
			 session.setAttribute("user_name", "超级管理员"+user_name);
				session.setAttribute("account", "admin");
			 
			 int result=DBTools.executeUpdate(sql2);
			if(result>0)
			{
				response.sendRedirect("index");
				return;
			}
			else
			{
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('登录出错,请联系系统管理员');"
						+ "window.top.location.href='login.jsp';"
						+ "</script>");
				out.close();
			}
			
			
			
			
		
		}
	
		
		List<Map<String,String>>list= new ArrayList<Map<String,String>>();
		String sql="select * from user where account= '"+user+"'";
		System.out.println(sql);
		
		list=DBTools.executeQuery(sql);
		if(list!=null&&list.size()!=0)
		{
			if(list.get(0).get("user_status").equals("1"))
			{
				
				if(list.get(0).get("account").equals(user)&&list.get(0).get("password").equals(psw))
					
				{
					if(list.get(0).get("fk_department_id")!=null)
					{
						
						session.setAttribute("user_name", list.get(0).get("user_name"));
						session.setAttribute("account", list.get(0).get("account"));
						
				//登录成功运行LoginSevlet，记录操作日志
						
						String account=session.getAttribute("account").toString();
						
						String sql3="select user_id from user where account='"+account+"'";
						
						Map<String,String> map=new HashMap<String,String>();
						
						map=(Map<String, String>) DBTools.executeQuery(sql3).get(0);
						
						String user_id="";
						
						String user_name="";
						if(map!=null)
						{
							user_id=map.get("user_id");
						/*	user_name=map.get("user_name");*/
						}
						
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						 String date=df.format(new Date());// new Date()为获取当前系统时间
						
						 String sql2="insert into log (fk_user_id,log_create_time) values('"+user_id+"','"+date+"')";
						 
						 /*System.out.println(sql2);*/
						 
						 int result=DBTools.executeUpdate(sql2);
						if(result>0)
						{
							response.sendRedirect("index.jsp");
							return;
							
						}
						else
						{
							
							response.setContentType("text/html;charset=UTF-8");
							PrintWriter out=response.getWriter();
							out.print("<script>"
									+ "alert('登录出错,请联系系统管理员');"
									+ "window.top.location.href='login.jsp';"
									+ "</script>");
							out.close();
						}
						
						
						
					}
					
					else
					{
						request.setAttribute("msg", "尚未分配部门，请联系管理员");
						
						request.getRequestDispatcher("login.jsp").forward(request, response);
						return;
						
					}
					
					
				}
				else
				{
					
					request.setAttribute("msg", "账号或密码错误");
					
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
				
				
			}
			else
			{	
				request.setAttribute("msg", "账户不可用");
				

				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
				
			}
			
			
		}
		else
		{
			request.setAttribute("msg", "用户不存在!");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
			
		}
		
		
		
		
		
		
		
	
		
		
	
		
		
		
	}

}
