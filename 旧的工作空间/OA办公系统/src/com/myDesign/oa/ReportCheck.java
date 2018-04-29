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


@WebServlet("/ReportCheck")
public class ReportCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		String report_id="";
		if(request.getParameter("id")!=null)
		{
			report_id=request.getParameter("id");			
		}
		
		String sql="update report set report_status=2 where report_id='"+report_id+"'";
		
		int result=DBTools.executeUpdate(sql);
		
		 if(result>0)
			{
			 	HttpSession session=request.getSession();
				String account=session.getAttribute("account").toString();
				String name=session.getAttribute("user_name").toString();
			 	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date2=df.format(new Date());
				String action="审批了一份日报";				
				
				 LoginTools.AddLog(account, name, action, date2);
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('审批成功');"
						+ "window.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
			else
			{

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('审批失败。请联系网站管理员');"
						+ "window.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
