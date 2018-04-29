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

import com.MyTools.Check;
import com.MyTools.DBTools;
import com.MyTools.LoginTools;

@WebServlet("/ActivityJoin")
public class ActivityJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		String a_id="";
		if(request.getParameter("id")!=null)
		{
			a_id=request.getParameter("id");
		}
		
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String sql2="select fk_activity_id from user where account='"+account+"'";
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql2).get(0);
		if(map!=null)
		{
			if(map.get("fk_activity_id")!=null)
			{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('���Ѳ������������ظ�����');"
						+ "windows.top.location.href='index';"
						+ "</script>");
				out.close();
				
			}
			else
			{
				

				String sql="update user set fk_activity_id='"+a_id+"' where account='"+account+"'";
				int result=DBTools.executeUpdate(sql);
				if(result>0)
				{
					
					String name=session.getAttribute("user_name").toString();
					String action="�μ��˻";
					
					 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
					 String date=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
					 LoginTools.AddLog(account, name, action, date);
					
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('����ɹ�');"
							+ "windows.top.location.href='index.jsp';"
							+ "</script>");
					out.close();
					
				}
				else
				{

					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('����ʧ�ܡ�����ϵ��վ����Ա');"
							+ "windows.top.location.href='index.jsp';"
							+ "</script>");
					out.close();
					
				}
				
				
				
			}
			
			
		}
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
