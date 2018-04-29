package com.test.dh;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/SelectEmployee")
public class SelectEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.check(request, response))
		{
			
			return;
		}
		request.getRequestDispatcher("ManagerMent.jsp").forward(request, response);
		doGet(request, response);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//接收数据作为查询参数
		//设置数据回显
		String sql="select * from user where 1=1 ";
		//String sql2="";
		String name=request.getParameter("name");
		String account=request.getParameter("account");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		if(name!=null&&name.trim().length()>0)
		{
			sql=sql+"and name like '%"+name +"%'";
			request.setAttribute("name", name);
			//request.getRequestDispatcher("ManagerMent.jsp").forward(request, response);
		}
		if(account!=null&&account.trim().length()>0)
		{
			sql=sql+"and account like '%"+account +"%'";
			request.setAttribute("account", account);
		}
		if(age!=null&&age.trim().length()>0)
		{
			sql=sql+"and age like '%"+age+"%'";
			request.setAttribute("age", age);
		}
		if(sex!=null&&sex.trim().length()>0)
		{
			sql=sql+"and sex ='"+sex+"'";
			request.setAttribute("sex", sex);
		}
		
		
		
	/*	String name="";
		if(request.getParameter("name")!=null)
		{
			name=request.getParameter("name");
		}
		String account="";
		if(request.getParameter("account")!=null)
		{
			account=request.getParameter("name");
		}
		String age="";
		if(request.getParameter("age")!=null)
		{
			age=request.getParameter("age");
		}
		String sex="";
		if(request.getParameter("sex")!=null)
		{
			sex=request.getParameter("sex");
		}*/

		
				
		System.out.println(sql);
		List<Map<String,String>>list=DBTools.executeQuery(sql);
		request.setAttribute("list", list);
		request.getRequestDispatcher("ManagerMent.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
	}

}
