package com.wrf.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		if(account.equals("admin")&&password.equals("123"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("user",account);
			response.sendRedirect("Index.do");
		}
		else
		{
			request.setAttribute("msg","’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("WEB-INF/jsp/Login.jsp").forward(request, response);
			
			
		}
		
	}

}
