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

@WebServlet("/AddActivity")
public class AddActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title="";
		String content="";
		String start_date="";
		String end_date="";
		String create_date="";
		
		if(request.getParameter("title")!=null)
		{
			title=request.getParameter("title");
			request.setAttribute("title", title);
			
		}
		
		if(request.getParameter("content")!=null)
		{
			content=request.getParameter("content");
			request.setAttribute("content", content);
		}
		
		if(request.getParameter("start_date")!=null)
		{
			start_date=request.getParameter("start_date");
			request.setAttribute("start_date", start_date);
		}
		
		if(request.getParameter("end_date")!=null)
		{
			end_date=request.getParameter("end_date");
			request.setAttribute("end_date", end_date);
		}
		
		if(request.getParameter("create_date")!=null)
		{
			create_date=request.getParameter("create_date");
			request.setAttribute("create_date", create_date);
		}
		
		if(title.trim().length()==0)
		{
			request.setAttribute("msg", "标题不能为空！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(content.trim().length()==0)
		{
			request.setAttribute("msg", "内容不能为空！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(start_date.trim().length()==0)
		{
			request.setAttribute("msg", "开始时间不能为空！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(end_date.trim().length()==0)
		{
			request.setAttribute("msg", "结束时间不能为空！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(create_date.trim().length()==0)
		{
			request.setAttribute("msg", "发起时间不能为空！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(create_date.compareTo(start_date)>0)
		{
			request.setAttribute("msg", "活动开始时间不能早于发起时间！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(create_date.compareTo(end_date)>0)
		{
			request.setAttribute("msg", "活动结束时间不能早于发起时间！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(start_date.compareTo(end_date)>0)
		{
			request.setAttribute("msg", "活动结束时间不能早于开始时间！");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		String sql="select count(*) from  activity where a_title='"+title+"'";
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		String count="";
		if(map!=null)
		{
			count=map.get("count(*)");
			if(count.compareTo("0")>0)
			{
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('活动已存在,不能重复发布');"
						+ "window.location.href='ActivityCheck';"
						+ "</script>");
				out.close();
			
			}
			
			else
			{
				String sql2="insert into activity (a_title,a_content,s_date,e_date,a_date)values('"
						+title+"','"+content+"','"+start_date+"','"+end_date+"','"+create_date+"')";
				/*System.out.println(sql2);*/
				
				int result=DBTools.executeUpdate(sql2);
				 if(result>0)
					{
					 HttpSession session=request.getSession();
						String account=session.getAttribute("account").toString();
						String name=session.getAttribute("user_name").toString();
						String action="发起了新活动";				
						 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						 String date2=df.format(new Date());// new Date()为获取当前系统时间
						 LoginTools.AddLog(account, name, action, date2);
						 
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out=response.getWriter();
						out.print("<script>"
								+ "alert('发起成功');"
								+ "window.location.href='ActivityCheck';"
								+ "</script>");
						out.close();
						
					}
					else
					{

						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out=response.getWriter();
						out.print("<script>"
								+ "alert('发起失败。请联系网站管理员');"
								+ "window.top.location.href='index';"
								+ "</script>");
						out.close();
						
					}
				
				
				
				
			}
		}
		
		
		
		
		
		
		
	}

}
