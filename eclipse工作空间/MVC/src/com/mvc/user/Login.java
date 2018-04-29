package com.mvc.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mvc.Service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account= request.getParameter("account");
		request.setAttribute("account", account);
		String password=request.getParameter("password");
		/*if(account.trim().length()==0)
		{
			
			request.setAttribute("msg", "账号不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
			return;
		}
		if(password.trim().length()==0)
		{
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
			return;
		}*/
		UserService us=new UserService();
		try {
			Map<String, Object> map = us.LoginService(account, password);	
			HttpSession session=request.getSession();
			session.setAttribute("user", map);
			//登录成功 跳转
			response.sendRedirect("Index.do");
		} catch (Exception e) {
			//登录失败
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
