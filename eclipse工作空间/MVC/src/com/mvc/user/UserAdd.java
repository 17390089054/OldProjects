package com.mvc.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.Service.RegisterService;
import com.mvc.Tools.User;

@WebServlet("/UserAdd.do")
public class UserAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//接受前台数据
		String account=request.getParameter("account");
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String user_age=request.getParameter("user_age");
		String user_sex=request.getParameter("user_sex");
		String user_status="1";
		//数据存入User类
		User user=new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setUser_name(user_name);
		user.setUser_age(user_age);
		user.setUser_sex(user_sex);
		user.setUser_status(user_status);
		request.setAttribute("password2", password2);
		request.setAttribute("user", user);
		System.out.println(user);
		//数据判空
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "账号不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			return;
		}
		
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg", "姓名不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			return;
		}
		if(password.trim().length()==0)
		{
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			return;
		}
		
		if(password2.trim().length()==0)
		{
			request.setAttribute("msg", "请确认密码");
			request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			return;
		}
		
		if(user_age.trim().length()==0)
		{
			request.setAttribute("msg", "年龄不能为空");
			request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			return;
		}
		
		if(user_sex.trim().length()==0)
		{
			request.setAttribute("msg", "请选择性别");
			request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			return;
		}
		
		
		
		if(!password.equals(password2))
		{
			request.setAttribute("msg", "前后密码不一致");
			request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			return;
		}
		
		try {
			RegisterService.Register(user);
			request.setAttribute("msg", "添加成功!");
			request.setAttribute("url", request.getContextPath()+"/UserList.do");
			request.getRequestDispatcher("WEB-INF/jsp/Message.jsp").forward(request, response);
		} catch (Exception e) {
		request.setAttribute("msg", e.getMessage());
		request.getRequestDispatcher("WEB-INF/jsp/UserAdd.jsp").forward(request, response);
			
		}
		
		
		
		
		
		
		
		
	}

}
