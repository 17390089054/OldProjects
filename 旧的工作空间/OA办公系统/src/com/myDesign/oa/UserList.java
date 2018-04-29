package com.myDesign.oa;

import java.io.IOException;
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


@WebServlet("/UserList")
public class UserList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		String sql="select * from user as u,department as d where u.fk_department_id= d.d_id ";
		
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		
		list=DBTools.executeQuery(sql);
		if(list!=null&&list.size()!=0)
		{
			request.setAttribute("list", list);
			
			HttpSession session=request.getSession();
			String account=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="查看了员工信息";
			
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account, name, action, date);
			
			request.getRequestDispatcher("userList.jsp").forward(request, response);
			return;
		}
		else
		{
			request.setAttribute("msg", "查询失败");
			request.getRequestDispatcher("userList.jsp").forward(request, response);
			return;
					
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String account="";
		if(request.getParameter("account")!=null)
		{
		
			account=request.getParameter("account");
			request.setAttribute("account", account);
			
		}
		
		String user_name="";
		if(request.getParameter("user_name")!=null)
		{
			user_name=request.getParameter("user_name");
			request.setAttribute("user_name", user_name);
		}
		String address="";
		if(request.getParameter("address")!=null)
		{
			address=request.getParameter("address");
			request.setAttribute("address", address);
		}
		
		String department="";
		if(request.getParameter("department")!=null)
		{
			department=request.getParameter("department");
			request.setAttribute("department", department);
		}
		
		String date="";
		if(request.getParameter("date")!=null)
		{
			date=request.getParameter("date");
			request.setAttribute("date", date);
		}
		
		String sql="select * from user as u,department as d where u.fk_department_id= d.d_id and 1=1  ";
		
		if(account.trim().length()!=0)
		{
			
			sql=sql+" and account like '%"+account.trim()+"%'";
		}
		if(user_name.trim().length()!=0)
		{
			sql=sql+" and user_name like '%"+user_name.trim()+"%'";
		}
		
		if(address.trim().length()!=0)
		{
			sql=sql+" and user_addr like '%"+address.trim()+"%'";
		}
		
		if(department.trim().length()!=0)
		{
			sql=sql+" and d_name like '%"+department.trim()+"%'";
			
		}
		if(date.trim().length()!=0)
		{
			
			sql=sql+"and user_create_time like '%"+date+"%'";
		}
		System.out.println(sql);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);
		request.setAttribute("list", list);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
		
		
	
	}

}
