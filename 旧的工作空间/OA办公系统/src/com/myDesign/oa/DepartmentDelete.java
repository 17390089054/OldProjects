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


@WebServlet("/DepartmentDelete")
public class DepartmentDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		String d_id="";
		if(request.getParameter("id")!=null)			
		{
			d_id=request.getParameter("id");		
		}
		
		String sql="select count(*) from user where fk_department_id='"+d_id+"'";
		
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		
		list=DBTools.executeQuery(sql);
		
		if(list!=null&&list.size()!=0)
		{
			int count=Integer.parseInt(list.get(0).get("count(*)"));
			
			if(count>0)
			{
				
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('该部门尚有员工，不能删除！');"
							+ "window.location.href='DepartmentList';"
							+ "</script>");
					out.close();
					return;
			
			}
		
		}
			
		String sq12="select d_status from department where d_id='"+d_id+"'";
		List<Map<String,String>>list2=new ArrayList<Map<String,String>>();
		list2=DBTools.executeQuery(sq12);
		if(list2!=null)
		{
			String status=list2.get(0).get("d_status");			
			if(status.equals("0"))
			{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('该部门已删除，不能重复删除！');"
						+ "window.location.href='DepartmentList';"
						+ "</script>");
				out.close();
				
				return;
			}
	
		}
		
		
		
		
			String Sql="update department set d_status='0' where d_id='"+d_id+"'";
			
			int result=DBTools.executeUpdate(Sql);
			
			if(result>0)
			{
				HttpSession session=request.getSession();
				String account=session.getAttribute("account").toString();
				String name=session.getAttribute("user_name").toString();
				String action="删除了一个部门";
				
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				 String date=df.format(new Date());// new Date()为获取当前系统时间
				 LoginTools.AddLog(account, name, action, date);
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('删除成功');"
						+ "window.location.href='DepartmentList';"
						+ "</script>");
				out.close();
				
			}
			else
			{

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('删除失败。请联系网站管理员');"
						+ "window.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
			
			
			
			
			
		
		
		
			
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
