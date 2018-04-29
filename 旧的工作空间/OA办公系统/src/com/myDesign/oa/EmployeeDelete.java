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

@WebServlet("/EmployeeDelete")
public class EmployeeDelete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		String id="";
		if(request.getParameter("id")!=null)
		{
			id=request.getParameter("id");
			
		}	
		
		String sql="update user set user_status=0 where user_id='"+id+"'";
		
		/*System.out.println(sql);*/
		int result=DBTools.executeUpdate(sql);
		
		if(result>0)
		{
			HttpSession session=request.getSession();
			String account=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="ɾ����һ��Ա����Ϣ";
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			 String date=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			 LoginTools.AddLog(account, name, action, date);
			 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('ɾ���ɹ�');"
					+ "window.location.href='UserList';"
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
