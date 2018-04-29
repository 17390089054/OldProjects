package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyTools.Check;
import com.MyTools.DBTools;
import com.MyTools.LoginTools;


@WebServlet("/DepartmentAdd")
public class DepartmentAdd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.getRequestDispatcher("DepartmentAdd.jsp").forward(request, response);
		
		return;
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String department ="";
		
		if(request.getParameter("department")!=null)
		{
			department=request.getParameter("department");
			request.setAttribute("department", department);
			
		}
		if(department.trim().length()==0)
		{
			request.setAttribute("msg", "部 门 不 能 为 空!");
			request.getRequestDispatcher("DepartmentAdd.jsp").forward(request, response);
			return;
		}
		String Sql="select count(*) from department where d_name=' "+department+"'";
		
		List<Map<String,String>> list=new ArrayList<Map<String,String>>(); 
		
		list=DBTools.executeQuery(Sql);
		
		String count=""; 
		
		if(list!=null&&list.size()!=0)
		{
			count=list.get(0).get("count(*)");
			
			if(count.equals("1"))
			{
				request.setAttribute("msg", "该 部 门 已  存  在 ！");
				request.getRequestDispatcher("DepartmentAdd.jsp").forward(request, response);
				return;
			}
			
			
			
		}
		
		
		String sql="insert into department (d_name,d_status) values(' "+department+"','1')";
		
		System.out.println(sql);
		
		int result=DBTools.executeUpdate(sql);
		
		 if(result>0)
			{
			 HttpSession session=request.getSession();
				String account=session.getAttribute("account").toString();
				String name=session.getAttribute("user_name").toString();
				String action="添加了"+department+"部门";
				
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				 String date=df.format(new Date());// new Date()为获取当前系统时间
				 LoginTools.AddLog(account, name, action, date);	
			 
			 response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('添加成功');"
						+ "window.location.href='DepartmentList';"
						+ "</script>");
				out.close();
				
			}
			else
			{

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('添加失败');"
						+ "window.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
		
		
		
		
		
	}

}
