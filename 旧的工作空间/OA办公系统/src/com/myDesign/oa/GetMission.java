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


@WebServlet("/GetMission")
public class GetMission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		String m_id="";
		if(request.getParameter("id")!=null)
		{
			m_id=request.getParameter("id");
		}
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String sql="select d_name from user as u,department as d where u.fk_department_id=d.d_id and account='"+account+"'";
		/*System.out.println(sql);*/
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		String department="";
		if(map!=null)
		{
			department=map.get("d_name");
		}
		
		String sql2="select d_name from department as d,mission as m where d.d_id=m.fk_department_id and m_id=' "+m_id+"'";
		/*System.out.println(sql2);*/
		Map<String,String>map2=new HashMap<String,String>();
		map2=(Map<String,String>)DBTools.executeQuery(sql2).get(0);
		String department1="";
		if(map2!=null)
		{
			department1=map2.get("d_name");
		}
		
		if(!department1.equals(department))
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('非此部门不能接受此任务');"
					+ "window.top.location.href='index';"
					+ "</script>");
			out.close();
			
			
			
		}
		else
		{
			String sql3="update mission set m_status=1 where m_id='"+m_id+"'";
			int result=DBTools.executeUpdate(sql3);
			
			 if(result>0)
				{
				 
					String name=session.getAttribute("user_name").toString();
					String action="接受了任务";				
					 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					 String date2=df.format(new Date());// new Date()为获取当前系统时间
					 LoginTools.AddLog(account, name, action, date2);
					 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('接受成功，请尽快完成');"
							+ "window.location.href='AcceptMission';"
							+ "</script>");
					out.close();
					
				}
				else
				{

					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('接受失败。请联系网站管理员');"
							+ "window.top.location.href='index.jsp';"
							+ "</script>");
					out.close();
					
				}
			
			
			
			
			
			
		}
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
