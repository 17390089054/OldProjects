package com.myDesign.oa;

import java.io.IOException;
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

@WebServlet("/ActivityView")
public class ActivityView extends HttpServlet {
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
	String sql="select * from activity where a_id='"+id+"'";
	
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		if(map!=null)
		{
			request.setAttribute("map", map);
			HttpSession session=request.getSession();
			String account=session.getAttribute("account").toString(); 
			String name=session.getAttribute("user_name").toString();
			String action="查看了活动详细信息";
			
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account, name, action, date);	
			 
			request.getRequestDispatcher("ActivityView.jsp").forward(request, response);
			return;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
