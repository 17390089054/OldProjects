package com.test.dh;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ManagerMent
 */
@WebServlet("/ManagerMent")
public class ManagerMent extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(!Check.check(request, response))
		{
			return;
		}
		String sql="select * from user";
		List<Map<String,String>>list=DBTools.executeQuery(sql);
		request.setAttribute("list", list);
		request.getRequestDispatcher("ManagerMent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
