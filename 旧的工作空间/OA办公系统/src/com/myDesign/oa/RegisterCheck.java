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


@WebServlet("/RegisterCheck")
public class RegisterCheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("UTF-8");
		
		String sql="select * from user where fk_department_id is null ";
		
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);

		if(list!=null&&list.size()!=0)
		{
			request.setAttribute("list",list);
			
			
		}
		
		
		String sql2="select d_name from department ";		
		List<Map<String,String>> list2=new ArrayList<Map<String,String>>();
		list2=DBTools.executeQuery(sql2);
		if(list2!=null&&list2.size()!=0)
		{
			request.setAttribute("list2", list2);	
			request.getRequestDispatcher("RegisterCheck.jsp").forward(request, response);
			return;
		}
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String department="";
		
		if(request.getParameter("department")!=null);	
		{
			
			department=request.getParameter("department");
			
			request.setAttribute("department",department);
						
		}
		
		
		
		String user_id="";
		if(request.getParameter("user_id")!=null)
		{
			user_id=request.getParameter("user_id");
			
		}
		
		
		if(department.trim().length()==0)
		{
			request.setAttribute("msg", "尚未选择部门");
			request.getRequestDispatcher("RegisterCheck.jsp").forward(request, response);
			return;
			
		}
		
		String d_id="";
		
		String Sql="select d_id from department where d_name=' "+department+"'";
		
		System.out.println(Sql);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		
		list=DBTools.executeQuery(Sql);
		
		
		if(list!=null&&list.size()!=0)
		{
			
			d_id=list.get(0).get("d_id");
			
		}
	
		String sql="update user set fk_department_id='"+d_id+"',user_status=1 where user_id='"+user_id+"'";		
		System.out.println(sql);
		int result=0;
		
		result=DBTools.executeUpdate(sql);
		
		if(result>0)
		{
			HttpSession session=request.getSession();
			String account=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="审批了一条注册信息";
			
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account, name, action, date);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('审批成功');"
					+ "window.location.href='UserList';"
					+ "</script>");
			out.close();
			
		}
		else
		{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('审批失败');"
					+ "window.top.location.href='index';"
					+ "</script>");
			out.close();
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
