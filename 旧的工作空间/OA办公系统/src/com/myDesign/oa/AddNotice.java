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

@WebServlet("/AddNotice")
public class AddNotice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.getRequestDispatcher("AddNotice.jsp").forward(request,response);
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
			
			context=request.getParameter("context");
			request.setAttribute("context", context);
		}
		
		if(request.getParameter("date")!=null)
		{
			date=request.getParameter("date");
			request.setAttribute("date",date);
			
		}
/*		System.out.println(title);
		System.out.println(context);
		System.out.println(date);
		*/
		//�ж������Ƿ�Ϊ�ղ�����
		
		if(title.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� Ϊ ��");
			request.getRequestDispatcher("AddNotice.jsp").forward(request, response);
			return;
		}
		
		if(context.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� Ϊ ��");
			request.getRequestDispatcher("AddNotice.jsp").forward(request, response);
			return;
			
		}
		
		if(date.trim().length()==0)
		{
			request.setAttribute("msg", "���ڲ���Ϊ��");
			request.getRequestDispatcher("AddNotice.jsp").forward(request, response);
			return;
		}
		
		String sql="insert into notice (notice_title,notice_content,create_time) values ('"+title+"','"+context+"','"+date+"')";
		
		System.out.println(sql);
		
		int result=DBTools.executeUpdate(sql);
		
		 if(result>0)
			{
			 HttpSession session=request.getSession();
				String account=session.getAttribute("account").toString();
				String name=session.getAttribute("user_name").toString();
				String action="�������¹���";				
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				 String date2=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
				 LoginTools.AddLog(account, name, action, date2);
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('�����ɹ�');"
						+ "window.location.href='NoticeList';"
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
