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
		//��ȡǰ̨����
				//���жϻ�ȡ�����Ƿ�Ϊnull
			
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
				//�п�
				if(account.trim().length()==0)
				{
					msg="�˺Ų���Ϊ��!";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("Login.jsp").forward(request, response);
					
//					msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//					response.sendRedirect("NewFile.jsp?msg="+msg);
				}
				else if(password.trim().length()==0)
				{
					msg="���벻��Ϊ��!";
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
							msg="��¼�ɹ�";
							
							//��ȡsession����
//							msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//							response.sendRedirect("NewFile.jsp?msg="+msg);
//							request.setAttribute("msg", msg);
//							request.getRequestDispatcher("NewFile.jsp").forward(request, response);
							String sql="select * from user where account='"+account+"'";
							Map<String,String>map=(Map<String, String>) DBTools.executeQuery(sql).get(0);
							if(map!=null)
							{
								HttpSession session=request.getSession();
								//����seesion
								session.setAttribute("user",map);
							}

							response.sendRedirect("MainView");
					
						}		
						else
						{
						if(account.trim().equals("admin"))
						{
							msg="�������";
							//request.setAttribute("password", password);
							request.setAttribute("msg", msg);
							request.getRequestDispatcher("Login.jsp").forward(request, response);
//							msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//							response.sendRedirect("NewFile.jsp?msg="+msg);
						}
							
							if(password.trim().equals("admin"))
							{
								msg="�˺Ŵ���";
								request.setAttribute("msg", msg);
								request.getRequestDispatcher("Login.jsp").forward(request, response);
//								msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//								response.sendRedirect("NewFile.jsp?msg="+msg);
							}
							
						}
							
			
					}
					else
					{
						msg="��¼ʧ��!";
						request.setAttribute("msg", msg);
						request.setAttribute("account",account);
						request.getRequestDispatcher("Login.jsp").forward(request, response);
//						msg=new String(msg.getBytes("UTF-8"),"ISO-8859-1");
//						response.sendRedirect("NewFile.jsp?msg="+msg);
					}
				}
			
				
}
}
