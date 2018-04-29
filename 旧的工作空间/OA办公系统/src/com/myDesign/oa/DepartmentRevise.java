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

@WebServlet("/DepartmentRevise")
public class DepartmentRevise extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		String d_id="";
		if(request.getParameter("id")!=null)
		{
			d_id=request.getParameter("id");
			request.setAttribute("id", d_id);
		}
		
		String sql="select *from department where d_id='"+d_id+"'";
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
/*		System.out.println(sql);
*/		
		list=DBTools.executeQuery(sql);
		
		if(list!=null&&list.size()!=0)
		{
			request.setAttribute("list",list);
			request.getRequestDispatcher("DepartmentRevise.jsp").forward(request, response);
			
			return;
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String d_id="";
			String department="";
			
			if(request.getParameter("id")!=null)
			{
				
				d_id=request.getParameter("id");
				request.setAttribute("id", d_id);
			}
			
			if(request.getParameter("department")!=null)
			{
				department=request.getParameter("department");
				request.setAttribute("department", department);
				
			}
			
			
			
			if(department.trim().length()==0)
			{
				request.setAttribute("msg", "部门名称不能为空!");
				request.getRequestDispatcher("DepartmentRevise.jsp").forward(request, response);
				return;
			}
			
			String sql="select d_status from department where d_id='"+d_id+"'";
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			
			list=DBTools.executeQuery(sql);
			
			String d_status="";
			if(list.size()!=0)
			{
				d_status=list.get(0).get("d_status");
				if(d_status.equals("0"))
				{
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('该部门已删除,不可修改！');"
							+ "window.location.href='DepartmentList';"
							+ "</script>");
					out.close();
					return;
					
				}
				else
				{
					String sql2="update department set d_name='"+department+"'"+"where d_id='"+d_id+"'";
/*					System.out.println(sql2);
*/					 int result=DBTools.executeUpdate(sql2);
					 
					 if(result>0)
						{
						 
						 HttpSession session=request.getSession();
							String account=session.getAttribute("account").toString();
							String name=session.getAttribute("user_name").toString();
							String action="修改了"+department+"的部门信息";
							
							 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
							 String date=df.format(new Date());// new Date()为获取当前系统时间
							 LoginTools.AddLog(account, name, action, date);
							 
							response.setContentType("text/html;charset=UTF-8");
							PrintWriter out=response.getWriter();
							out.print("<script>"
									+ "alert('编辑成功');"
									+ "window.location.href='DepartmentList';"
									+ "</script>");
							out.close();
							
						}
						else
						{

							response.setContentType("text/html;charset=UTF-8");
							PrintWriter out=response.getWriter();
							out.print("<script>"
									+ "alert('编辑失败。请联系网站管理员');"
									+ "window.top.location.href='index';"
									+ "</script>");
							out.close();
							
						}
					
					
			}
			
				
				
				
				
				
			}
			
			
			
			
		
		
		
		
		
		
		
		
	}

}
