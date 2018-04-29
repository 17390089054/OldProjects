package com.wrf.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register.do")
public class Register extends HttpServlet {
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				
				
				req.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(req, resp);
			}
			
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String account=req.getParameter("account");
			System.out.println("’À∫≈:"+account);
			String password=req.getParameter("password");
			System.out.println("√‹¬Î:"+password);
			String age=req.getParameter("age");
			System.out.println("ƒÍ¡‰:"+age);
			String user_name=req.getParameter("user_name");
			System.out.println("–’√˚:"+user_name);
			
			
			
			
		}
}
