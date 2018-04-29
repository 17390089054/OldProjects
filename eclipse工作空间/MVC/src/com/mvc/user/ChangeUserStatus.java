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

import com.google.gson.Gson;
import com.mvc.Service.UserStatus;

@WebServlet("/ChangeUserStatus.do")
public class ChangeUserStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id=request.getParameter("user_id");
		String user_status=request.getParameter("user_status");
		System.out.println(user_id);
		System.out.println(user_status);
		Map<String,Object>map=new HashMap<>();
		UserStatus us=new UserStatus();
		try {
			us.ChnageUserStatus(Integer.parseInt(user_id), Integer.parseInt(user_status));
			map.put("msg", "ÐÞ¸Ä³É¹¦");
			map.put("flag", true);
					
			Gson gson=new Gson();
			String msg=gson.toJson(map);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(msg);
			out.flush();
			out.close();
		} catch (Exception e) {
			map.put("flag", false);
			map.put("msg", e.getMessage());		
		}
		
	}

}
