package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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


@WebServlet("/SendLetter")
public class SendLetter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!Check.Check(request, response))
		{
			
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		String sql="select account from user";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);
		if(list!=null&&list.size()!=0)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("SendLetter.jsp").forward(request, response);
			return;
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String Reciver="";
		String Message="";
		String Date="";
		
		String Sql="select account from user";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(Sql);
		if(list.size()!=0)
		{
			request.setAttribute("list", list);
		}
		request.setAttribute("list", list);
		
		if(request.getParameter("Reciver")!=null)
		{
			Reciver=request.getParameter("Reciver");
			request.setAttribute("Reciver", Reciver);
		}
		
		
		if(request.getParameter("Message")!=null)
		{
			Message=request.getParameter("Message");
			request.setAttribute("Message", Message);
		}
		
		if(request.getParameter("Date")!=null)
		{
			Date=request.getParameter("Date");
			request.setAttribute("Date", Date);
			
		}
		
		if(Reciver.trim().length()==0)
		{
			request.setAttribute("msg", " 请 选 择 接 收 人 ！");
			request.getRequestDispatcher("SendLetter.jsp").forward(request, response);
			return;
		}
		
		if(Message.trim().length()==0)
		{
			request.setAttribute("msg", " 发 送 内 容 不 能 为 空 ！");
			request.getRequestDispatcher("SendLetter.jsp").forward(request, response);
			return;
		}
		
		
		if(Date.trim().length()==0)
		{
			request.setAttribute("msg", " 请 选 择 发 送 时 间  ！");
			request.getRequestDispatcher("SendLetter.jsp").forward(request, response);
			return;
		}
		
		String RecID="";
		String SendID="";
		
		 String sql="select user_id from user where account='"+Reciver+"'";
		  Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		if(map!=null)
		{
			RecID=map.get("user_id");
			/*System.out.println(RecID);*/
		}
		 
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		/*System.out.println(account);*/
		String sql2="select user_id from user where account='"+account+"'";
		Map<String,String>map2=new HashMap<String,String>();
		map2=(Map<String,String>)DBTools.executeQuery(sql2).get(0);
		if(map2!=null)
		{
			SendID=map2.get("user_id");
		/*	System.out.println(SendID);*/
		}
		
		String sql3="insert into messagetext (Message,P_Date) values('"+Message+"','"+Date+"')";
		
		int result=DBTools.executeUpdate(sql3);
		
		if(result>0)
		{
			String sql4="insert into message (SendID,RecID,Status) values('"+SendID+"','"+RecID+"',0)";
			
			int result2=DBTools.executeUpdate(sql4);
			
			if(result2>0)
			{
				String  sql5="update message set MessageID=M_ID where status =0";
				int result3=DBTools.executeUpdate(sql5);
				
				if(result3>0)
				{
					String name=session.getAttribute("user_name").toString();
					String action="给"+Reciver+"发送了一封邮件";		
					 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					 String date2=df.format(new Date());// new Date()为获取当前系统时间
					 LoginTools.AddLog(account, name, action, date2);
					 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('发送成功');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
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
			
			
			
		}
		else
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('发送失败');"
					+ "window.top.location.href='index.jsp';"
					+ "</script>");
			out.close();
		}
		
		
		
		
		
		
		
	}

}
