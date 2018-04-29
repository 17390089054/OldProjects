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


@WebServlet("/EmailDelete")
public class EmailDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		String id="";
		if(request.getParameter("id")!=null)
		{
			id=request.getParameter("id");
		}
		String sql="update message set Status=2 where M_ID='"+id+"'";
		int result=DBTools.executeUpdate(sql);
		 if(result>0)
			{
				HttpSession session=request.getSession();
				String account=session.getAttribute("account").toString();
				String name=session.getAttribute("user_name").toString();
			 	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date2=df.format(new Date());
				String action="ɾ����һ���ʼ�";				
				
				 LoginTools.AddLog(account, name, action, date2);
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('ɾ���ɹ�');"
						+ "window.location.href='ReciveLetter';"
						+ "</script>");
				out.close();
				
			}
			else
			{

				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('ɾ��ʧ�ܡ�����ϵ��վ����Ա');"
						+ "window.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
