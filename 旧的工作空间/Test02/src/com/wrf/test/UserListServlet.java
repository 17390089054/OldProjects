package com.wrf.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����һ��list
		List<Map<String,Object>> userList = new ArrayList<Map<String,Object>>();
		Map<String,Object> m1 = new HashMap<>();
		m1.put("name", "����");
		m1.put("age", 23);
		Map<String,Object> m2 = new HashMap<>();
		m2.put("name", "����");
		m2.put("age", 55);
		Map<String,Object> m3 = new HashMap<>();
		m3.put("name", "����");
		m3.put("age", 65);
		userList.add(m1);
		userList.add(m2);
		userList.add(m3);
		request.setAttribute("userList",userList);
		
		//ת����jsp
		request.getRequestDispatcher("WEB-INF/jsp/Test02.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
