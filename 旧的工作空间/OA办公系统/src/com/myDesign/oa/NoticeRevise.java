package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyTools.Check;
import com.MyTools.DBTools;
import com.MyTools.LoginTools;


@WebServlet("/NoticeRevise")
public class NoticeRevise extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		String notice_id="";
		if(request.getParameter("id")!=null)
		{
			notice_id=request.getParameter("id");
			
		}
		
		Map<String,String>map=new TreeMap<String,String>();
		
		String sql="select * from notice where notice_id='"+notice_id+"'";
		map=(Map<String, String>) DBTools.executeQuery(sql).get(0);
		
		if(map!=null)
		{
			request.setAttribute("map", map);
			request.getRequestDispatcher("NoticeRevise.jsp").forward(request, response);
			return;
			
		}
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("utf-8");
		String notice_id="";
		String notice_title="";
		String notice_content="";
		String create_time="";
		//接受前台数据判null
		if(request.getParameter("notice_id")!=null)
		{
			notice_id=request.getParameter("notice_id");
			request.setAttribute("notice_id", notice_id);
			
		}
		
		if(request.getParameter("notice_title")!=null)
		{
			notice_title=request.getParameter("notice_title");
			request.setAttribute("notice_title", notice_title);
			
		}
		
		if(request.getParameter("notice_content")!=null)
		{
			notice_content=request.getParameter("notice_content");
			request.setAttribute("notice_content", notice_content);
			
		}
		
		if(request.getParameter("create_time")!=null)
		{
			create_time=request.getParameter("create_time");
			request.setAttribute("create_time", create_time);
			
		}
		//前台数据判空并回显
		if(notice_id.trim().length()==0)
		{
			request.setAttribute("msg", "id 不 能 为 空 !");
			request.getRequestDispatcher("NoticeRevise.jsp").forward(request, response);
			return;
		} 
		
		if(notice_title.trim().length()==0)
		{
			request.setAttribute("msg", "标 题 不 能 为 空 !");
			request.getRequestDispatcher("NoticeRevise.jsp").forward(request, response);
			return;
		}
		
		if(notice_content.trim().length()==0)
		{
			request.setAttribute("msg", "内 容 不 能 为 空 !");
			request.getRequestDispatcher("NoticeRevise.jsp").forward(request, response);
			return;
		}
		
		if(create_time.trim().length()==0)
		{
			request.setAttribute("msg", "时 间 不 能 为 空 !");
			request.getRequestDispatcher("NoticeRevise.jsp").forward(request, response);
			return;
		}
		
	String sql="update notice set notice_title='"+notice_title+"',notice_content='"+
	notice_content+"',create_time='"+create_time+"' where notice_id='"+notice_id+"'";
		
	System.out.println(sql);
	
	int result=DBTools.executeUpdate(sql);
	
	if(result>0)
	{
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String name=session.getAttribute("user_name").toString();
		String action="修改了公告信息";
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 String date=df.format(new Date());// new Date()为获取当前系统时间
		 LoginTools.AddLog(account, name, action, date);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>"
				+ "alert('修改成功');"
				+ "window.location.href='NoticeList';"
				+ "</script>");
		out.close();
		
	}
	else
	{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>"
				+ "alert('修改失败。请联系网站管理员');"
				+ "window.top.location.href='index';"
				+ "</script>");
		out.close();
		
	}
	
	
	
		
		
		
		
		
		
	}

}
