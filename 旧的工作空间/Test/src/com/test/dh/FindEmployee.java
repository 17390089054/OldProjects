package com.test.dh;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Employee")
public class FindEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!Check.check(request, response))
		{
			
			return;
		}
		
		String sql="select * from user ";
		
		List<Map<String,String>> userlist=DBTools.executeQuery(sql);
		
		
		request.setAttribute("userlist", userlist);
		
		request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
		
		
		String sql1="select *from user where id=1 ";
		
		List<Map<String,String>> user=DBTools.executeQuery(sql1);
		request.setAttribute("user", user);
		request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
		
		//request.getRequestDispatcher("Employee.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String account=request.getParameter("account");
		String sql="select * from user where name like%"+name+"%and account like %"+account+"%";
		List<Map<String,String>>user=DBTools.executeQuery(sql);
		request.setAttribute("user1", user);
		request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
	}

}
