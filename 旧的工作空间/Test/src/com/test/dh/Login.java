package com.test.dh;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
			
	}

		
		
		
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取前台数据
				//先判断获取数据是否为null
			
				request.setCharacterEncoding("UTF-8");
				String  account="";
				
				String msg=null;
				if(request.getParameter("account")!=null)
				{
					account=request.getParameter("account");
				}
				
				String password="";
				if(request.getParameter("password")!=null)
				{
					password=request.getParameter("password");
				}
				//判空
				if(account.trim().length()==0)
				{
					msg="账号不能为空!";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					
//					msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//					response.sendRedirect("NewFile.jsp?msg="+msg);
				}
				else if(password.trim().length()==0)
				{
					msg="密码不能为空!";
					request.setAttribute("msg", msg);
					request.setAttribute("account",account);
					request.getRequestDispatcher("Login.jsp").forward(request, response);

//					msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//					response.sendRedirect("NewFile.jsp?msg="+msg);
					
				}
				else 
				{
					if(account.trim().equals("admin")||password.trim().equals("admin"))
					{
						if(account.trim().equals("admin")&&password.trim().equals("admin"))
						{
							msg="登录成功";
							
							//获取session对象
//							msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//							response.sendRedirect("NewFile.jsp?msg="+msg);
//							request.setAttribute("msg", msg);
//							request.getRequestDispatcher("NewFile.jsp").forward(request, response);
							String sql="select * from user where account='"+account+"'";
							Map<String,String>map=(Map<String, String>) DBTools.executeQuery(sql).get(0);
							if(map!=null)
							{
								HttpSession session=request.getSession();
								//存入seesion
								session.setAttribute("user",map);
							}

							response.sendRedirect("MainView");
					
						}		
						else
						{
						if(account.trim().equals("admin"))
						{
							msg="密码错误";
							//request.setAttribute("password", password);
							request.setAttribute("msg", msg);
							request.getRequestDispatcher("Login.jsp").forward(request, response);
//							msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//							response.sendRedirect("NewFile.jsp?msg="+msg);
						}
							
							if(password.trim().equals("admin"))
							{
								msg="账号错误";
								request.setAttribute("msg", msg);
								request.getRequestDispatcher("Login.jsp").forward(request, response);
//								msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//								response.sendRedirect("NewFile.jsp?msg="+msg);
							}
							
						}
							
			
					}
					else
					{
						msg="登录失败!";
						request.setAttribute("msg", msg);
						request.setAttribute("account",account);
						request.getRequestDispatcher("Login.jsp").forward(request, response);
//						msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//						response.sendRedirect("NewFile.jsp?msg="+msg);
					}
				}
			
				
}
}
