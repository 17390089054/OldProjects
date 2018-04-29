package com.test.dh;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(!Check.check(request, response))
		{
			
			return;
		}
							
		request.setCharacterEncoding("UTF-8");
	//获取当前用户id a标签传值
		/*String id="";
		if(request.getParameter("id")!=null)
		{
			 id=request.getParameter("id");
		}*/
		String id=request.getParameter("id");
		String sql="select * from user where id ="+id;
		System.out.println(sql);
	//一条记录相当于一个map 传值顺利	
	Map<String,String>map= (Map<String, String>) DBTools.executeQuery(sql).get(0);
		request.setAttribute("map", map);
		
		
		
		
		
		
		
		//doPost(request, response);
		request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//接收request请求中的数据
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String  account=request.getParameter("account");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		//回显数据存入request
		request.setAttribute("name", name);
		request.setAttribute("account", account);
		request.setAttribute("sex", sex);
		request.setAttribute("age", age);
		request.setAttribute("id", id);
		
		//判断传回的更新数值是否为空 并回显
		if(name!=null&&name.trim().length()==0)
		{
			request.setAttribute("msg", "姓名不能为空!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		if(sex!=null&&sex.trim().length()==0)
		{
			request.setAttribute("msg", "性别不能为空!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		if(age!=null&&age.trim().length()==0)
		{
			request.setAttribute("msg", "年龄不能为空!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		if(account!=null&&account.trim().length()==0)
		{
			request.setAttribute("msg", "账号不能为空!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		String sql="update user set name ='"+name+"',account ='"+account+"',age ="+age+",sex='"+sex+"' where id="+id;
		System.out.println(sql);
		int result=DBTools.executeUpdate(sql);
		if(result>0)
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('编辑成功');"
					+ "windows.top.location.href='ManagerMent.jsp';"
					+ "</script>");
			out.close();
			
		}
		else
		{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('编辑失败。请联系网站管理员');"
					+ "windows.top.location.href='MainView.jsp';"
					+ "</script>");
			out.close();
			
		}
	
		
		
		
	
	}

}
