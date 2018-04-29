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


@WebServlet("/DepartmentList")
public class DepartmentList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("UTF-8");
	String sql="select * from department ";
	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
	list=DBTools.executeQuery(sql);
	
	if(list!=null&&list.size()!=0)
	{
		request.setAttribute("list", list);
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String name=session.getAttribute("user_name").toString();
		String action="查看了部门信息";
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 String date=df.format(new Date());// new Date()为获取当前系统时间
		 LoginTools.AddLog(account, name, action, date);
		 
			request.getRequestDispatcher("DepartmentList.jsp").forward(request, response);
			return;
	}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
