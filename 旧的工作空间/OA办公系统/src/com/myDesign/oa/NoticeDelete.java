package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyTools.Check;
import com.MyTools.DBTools;
import com.MyTools.LoginTools;


@WebServlet("/NoticeDelete")
public class NoticeDelete extends HttpServlet {
	
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
		
		String sql="update notice set notice_status=0 where notice_id='"+notice_id+"'";
		
		int result=DBTools.executeUpdate(sql);
		
		if(result>0)
		{
			HttpSession session=request.getSession();
			String account=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="删除了一条公告";
			
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account, name, action, date);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('删除成功');"
					+ "window.location.href='NoticeList';"
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
