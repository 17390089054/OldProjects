package com.myDesign.oa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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


@WebServlet("/ActivityJoined")
public class ActivityJoined extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String time=df.format(new java.util.Date());
		String sql="update activity set a_status=0   where s_date<'"+time+"'";
		DBTools.executeUpdate(sql);
		String sql2="update activity set a_status=1  where s_date<='"+time+"' and e_date>='"+time+"'";
		DBTools.executeUpdate(sql2);
		String sql3="update activity set a_status=2 where e_date<'"+time+"'";
		DBTools.executeUpdate(sql3);
		
		
		
		String Sql="select * from activity";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(Sql);
		if(list!=null)
		{
			request.setAttribute("list", list);
			
			 	HttpSession session=request.getSession();
				String account=session.getAttribute("account").toString();
				String name=session.getAttribute("user_name").toString();
				String action="查看了所有进行中的活动";				
				 SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				 String date2=df2.format(new Date());// new Date()为获取当前系统时间
				 LoginTools.AddLog(account, name, action, date2);
				 request.getRequestDispatcher("ActivityJoined.jsp").forward(request, response);
				 return;
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
