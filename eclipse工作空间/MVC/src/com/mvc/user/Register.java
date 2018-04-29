package com.mvc.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.Service.RegisterService;

@WebServlet("/Register.do")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设置字符编码
		 * 接受前台数据判空
		 * 保存前台数据
		 */
		request.setCharacterEncoding("utf-8");
		String account=request.getParameter("account");	
		request.setAttribute("account", account);
		String password=request.getParameter("password");
		request.setAttribute("password", password);
		String password2=request.getParameter("password2");
		request.setAttribute("password2", password2);
		String user_name=request.getParameter("user_name");
		request.setAttribute("user_name", user_name);
		String age=request.getParameter("age");
		request.setAttribute("age", age);
		String sex=request.getParameter("sex");
		request.setAttribute("sex", sex);
		
		
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "账 号 不 能 为 空 ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
	
		
		if(password.trim().length()==0)
		{
			request.setAttribute("msg", " 密 码 不 能 为 空 ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
	
		if(password2.trim().length()==0)
		{
			request.setAttribute("msg", "请 确 认 密 码 ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
		
		
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg", "姓 名 不 能 为 空 ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
		
		if(age.trim().length()==0)
		{
			request.setAttribute("msg", "年 龄 不 能 为 空 ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		
		if(sex==null)
		{
			request.setAttribute("msg", " 请 选 择 性 别 ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
	
		if(!password2.equals(password))
		{
			request.setAttribute("msg", "前 后 密 码 不 一 致 ! ");
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
			return;
		}
		RegisterService rs=new RegisterService();
		try {
				rs.Register(account, password, user_name, age, sex);
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.write("<script>alert('注册成功!');window.location.href='Login.do'</script>");
				out.close();
				
		} catch (Exception e) {
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/Register.jsp").forward(request, response);
		
			
		}
		
		
		
	
		
		
	}

}
