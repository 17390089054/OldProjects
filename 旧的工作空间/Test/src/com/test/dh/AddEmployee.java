package com.test.dh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.check(request, response))
		{
			
			return;
		}
		
		
		
		request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
		//doPost(request,response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//接收post请求传送的数据
		//数据回显至请求页面
		String name="";
		if(request.getParameter("name")!=null)
		{
			name=request.getParameter("name");
			request.setAttribute("name", name);
		}
		String sex="";
		if(request.getParameter("sex")!=null)
		{
			sex=request.getParameter("sex");
			request.setAttribute("sex", sex);
		}
		
		String age="";
		if(request.getParameter("age")!=null)
		{
			age=request.getParameter("age");
			request.setAttribute("age", age);
		}
		String account="";
		if(request.getParameter("account")!=null)
		{
			account=request.getParameter("account");
			request.setAttribute("account", account);
		}
		
		String password="";
		if(request.getParameter("password")!=null)
		{
			password=request.getParameter("password");
			request.setAttribute("password", password);
		}
		

		
		
		
		
	
		
		
		

		

		//判断数据是否为空，为空回显至用户
		if(name.trim().length()==0)
		{
			request.setAttribute("msg", "请输入用户名");
			
			request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
			
			return;
		}
		
			if(sex.trim().length()==0)
			{
				request.setAttribute("msg", "请选择性别");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
			
			if(age.trim().length()==0)
			{
				request.setAttribute("msg", "请输入年龄");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
		
		
			if(account.trim().length()==0)
			{
				request.setAttribute("msg", "请输入账号");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
		
				if(password.trim().length()==0)
			{
				request.setAttribute("msg", "请输入密码");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
			//检测账号是否重复
			String sql1="select count(*)   as num  from user where account='"+ account+"'";
			List<Map<String,String>> list=DBTools.executeQuery(sql1);
			int repeat=Integer.parseInt(list.get(0).get("num"));
			if(repeat>0)
			{
				request.setAttribute("msg", "账号已被注册!");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
		
	
		String sql="insert into user (name,account,password,age,sex) values ('"+name +"','"+account +"','"+password +"',"+age +",'"+sex+"')";
 		System.out.println(sql);
		int result=DBTools.executeUpdate(sql);
		if(result>0)
		{
			//弹窗提示
			//引用out对象
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write("<script>alert('添加成功!');"
					+"windows.top.location.href='MainView.jsp';"
					+ "</script>");
			out.close();
		}
		else
		{
			//添加失败跳回注册页面
			request.setAttribute("msg", "添加失败，请联系管理员");
			request.getRequestDispatcher("AddEmployee.jsp").forward(request,response);
			return;
			
		}
		
		
	
	}

}
