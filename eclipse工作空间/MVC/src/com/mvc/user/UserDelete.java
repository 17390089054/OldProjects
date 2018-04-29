package com.mvc.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.Service.UpdateService;

@WebServlet("/UserDelete.do")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id=request.getParameter("user_id");
		try {
			UpdateService.DeleteUser(user_id);
			request.setAttribute("msg", "É¾³ý³É¹¦!");
			request.setAttribute("url", request.getContextPath()+"/UserList.do");
			request.getRequestDispatcher("WEB-INF/jsp/Message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg",e.getMessage());
			request.setAttribute("url", request.getContextPath()+"/UserList.do");
			request.getRequestDispatcher("WEB-INF/jsp/Message.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
