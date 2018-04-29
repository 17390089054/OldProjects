package com.mvc.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.Service.RegisterService;

@WebServlet("/Register.do")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * �����ַ�����
		 * ����ǰ̨�����п�
		 * ����ǰ̨����
		 */
		request.setCharacterEncoding("utf-8");
		String account=request.getParameter("account");	
		request.setAttribute("account", account);
		String password=request.getParameter("password");
		request.setAttribute("password", password);
		String password2=request.getParameter("password2");
		request.setAttribute("password2", password2);
		String user_name=request.getParameter("user_name");
		request.setAttribute("user_name", user_name);
		String age=request.getParameter("age");
		request.setAttribute("age", age);
		String sex=request.getParameter("sex");
		request.setAttribute("sex", sex);
		
		
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� Ϊ �� ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
	
		
		if(password.trim().length()==0)
		{
			request.setAttribute("msg", " �� �� �� �� Ϊ �� ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
	
		if(password2.trim().length()==0)
		{
			request.setAttribute("msg", "�� ȷ �� �� �� ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
		
		
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� Ϊ �� ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
		
		if(age.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� Ϊ �� ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
		if(sex==null)
		{
			request.setAttribute("msg", " �� ѡ �� �� �� ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
	
		if(!password2.equals(password))
		{
			request.setAttribute("msg", "ǰ �� �� �� �� һ �� ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		RegisterService rs=new RegisterService();
		try {
				rs.Register(account, password, user_name, age, sex);
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.write("<script>alert('ע��ɹ�!');window.location.href='Login.do'</script>");
				out.close();
				
		} catch (Exception e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
		
			
		}
		
		
		
	
		
		
	}

}
