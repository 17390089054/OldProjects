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
import com.mvc.Service.UserService;

@WebServlet("/CheckAccountValid.do")
public class CheckAccountValid extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String account=request.getParameter("account");
		 String password=request.getParameter("password");
		 UserService us=new UserService();
		 Map<String,Object>map=new HashMap<>();
		 try {
			us.LoginService(account, password);
			map.put("flag", true);
		} catch (Exception e) {
			map.put("msg",e.getMessage());
			map.put("flag", false);
			Gson gson=new Gson();
			String result=gson.toJson(map);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(result);
			out.flush();
			out.close();
		}
		 
			
		 
	}

}
