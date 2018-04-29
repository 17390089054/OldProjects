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


@WebServlet("/EmailView")
public class EmailView extends HttpServlet {
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
	
	HttpSession session=request.getSession();
	String name=session.getAttribute("user_name").toString();
	request.setAttribute("name", name);
	
	String sql="update message set Status=1 where M_ID='"+id+"'";
	int result=DBTools.executeUpdate(sql);
	
	if(result>0)
	{
		String Sql="select * from  (SELECT   M_ID ,user_name ,RecID,Message,P_Date,STATUS from user as u ,message as m,messagetext as mt where m.MessageID=mt.ID and m.SendID=u.user_id  )  as t  "
				+ "where M_ID='"+id+"'";
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(Sql).get(0);		
		if(map!=null)
		{
			request.setAttribute("map", map);
			
			String account=session.getAttribute("account").toString();
			
			String action="查看一则群邮件";		
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date2=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account, name, action, date2);
			 
			request.getRequestDispatcher("EmailView.jsp").forward(request, response);
			return;
		}
		
	}
	else
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>"
				+ "alert('发送失败。请联系网站管理员');"
				+ "window.top.location.href='index';"
				+ "</script>");
		out.close();
		
	}
	
	

	

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
