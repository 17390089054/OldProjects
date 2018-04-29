package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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


@WebServlet("/ReportEdit")
public class ReportEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		String id="";
		if(request.getParameter("id")!=null)
		{
			id=request.getParameter("id");
		}
		
		String sql="select * from report where report_id='"+id+"'";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ReportEdit.jsp").forward(request, response);
			return;
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String report_id="";
		String report_title="";
		String report_content="";
		String create_time="";
		//接收数据并判空
		if(request.getParameter("id")!=null)
		{
			report_id=request.getParameter("id");
			request.setAttribute("id", report_id);
			
		}
		
		if(request.getParameter("title")!=null)
		{
			report_title=request.getParameter("title");
			request.setAttribute("title", report_title);
			
		}
		
		if(request.getParameter("context")!=null)
		{
			report_content=request.getParameter("context");
			request.setAttribute("context", report_content);
			
		}
		
		if(request.getParameter("date")!=null)
		{
			create_time=request.getParameter("date");
			request.setAttribute("date", create_time);
			
		}
		
		
		if(report_title.trim().length()==0)
		{
			request.setAttribute("msg", "标 题 不 能 为 空");
			request.getRequestDispatcher("ReportEdit.jsp").forward(request, response);
			return;
		}
		
		if(report_content.trim().length()==0)
		{
			request.setAttribute("msg", "内 容 不 能 为 空");
			request.getRequestDispatcher("ReportEdit.jsp").forward(request, response);
			return;
		}
		
		if(create_time.trim().length()==0)
		{
			request.setAttribute("msg", "时 间 不 能 为 空");
			request.getRequestDispatcher("ReportEdit.jsp").forward(request, response);
			return;
		}
		
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String name=session.getAttribute("user_name").toString();
		
		String sql="select user_id from user where account='"+account+"'";
		
		Map<String,String>map=new HashMap<String,String>();
		
		String user_id="";
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		if(map!=null)
		{
			user_id=map.get("user_id");
			
			String sql2="update report set fk_user_id='"+user_id+"',create_time='"+create_time+"',report_title='"
			+report_title+"',report_content='"+report_content.trim()+"',report_status='1' where report_id='"+report_id+"'";
			
		
			
			int result=DBTools.executeUpdate(sql2);
			
			 if(result>0)
				{
				 	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String date2=df.format(new Date());
					String action="编辑了草稿";				
					
					 LoginTools.AddLog(account, name, action, date2);
					 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('编辑成功');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
				}
				else
				{

					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('编辑失败。请联系网站管理员');"
							+ "window.top.location.href='index.jsp';"
							+ "</script>");
					out.close();
					
				}
			
			
			
			
		}
		
		
	}

}
