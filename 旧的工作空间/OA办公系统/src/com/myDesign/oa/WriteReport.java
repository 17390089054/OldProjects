package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MyTools.DBTools;
import com.MyTools.LoginTools;


@WebServlet("/WriteReport")
public class WriteReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("WriteReport.jsp").forward(request, response);
		return;
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title="";
		String context="";
		String date="";
		
		//����ǰ̨���ݲ��п�
		
		if(request.getParameter("title")!=null)
		{
			title=request.getParameter("title");
			request.setAttribute("title", title);
		}
		
		if(request.getParameter("context")!=null)
		{
			
			context=request.getParameter("context").trim();
			request.setAttribute("context", context);
		}
		
		if(request.getParameter("date")!=null)
		{
			date=request.getParameter("date");
			request.setAttribute("date",date);
			
		}
		
		
		if(title.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� Ϊ ��");
			request.getRequestDispatcher("WriteReport.jsp").forward(request, response);
			return;
		}
		
		if(context.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� Ϊ ��");
			request.getRequestDispatcher("WriteReport.jsp").forward(request, response);
			return;
			
		}
		
		if(date.trim().length()==0)
		{
			request.setAttribute("msg", "���ڲ���Ϊ��");
			request.getRequestDispatcher("WriteReport.jsp").forward(request, response);
			return;
		}
		
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String name=session.getAttribute("user_name").toString();
		
		
		String sql="select user_id from user where account='"+account+"'";
		
		Map<String,String> map =new HashMap<String,String>();
		
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		
		String user_id="";
		if(map!=null)
		{
			user_id=map.get("user_id");
			String sql2="insert into report (fk_user_id,create_time,report_title,report_content,report_status)"
					+ "values('"+user_id+"','"+date+"','"+title+"','"+context+"','1')";
			
			
			int result=DBTools.executeUpdate(sql2);
			
			 if(result>0)
				{
				
					String action="�ύ��һƪ�ձ�";				
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String date2=df.format(new Date());
					 LoginTools.AddLog(account, name, action, date2);
					 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('����ɹ�');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
				}
				else
				{

					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('����ʧ�ܡ�����ϵ��վ����Ա');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
				}
			
			
			
			
			
			
			
			
					
		}
		
	
		
		
		
		
		
		
	}

}
