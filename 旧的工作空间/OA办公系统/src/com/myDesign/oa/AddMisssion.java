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

@WebServlet("/AddMisssion")
public class AddMisssion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		if(!Check.Check(request, response))
		{
			
			return;
		}
		String sql="select d_name from department";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);
		if(list!=null&&list!=null)
		{
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("AddMisssion.jsp").forward(request, response);
			return;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title="";
		String content="";
		String department="";
		String date="";
		//数据判空回显
		
		String sql="select d_name from department";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);
		request.setAttribute("list", list);
		
		
		if(request.getParameter("title")!=null)
		{
			title=request.getParameter("title");
			request.setAttribute("title",title);
		}
		
		if(request.getParameter("content")!=null)
		{
			content=request.getParameter("content");
			request.setAttribute("content",content);
		}
		
		if(request.getParameter("department")!=null)
		{
			department=request.getParameter("department");
			request.setAttribute("department",department);
		} 
		
		if(request.getParameter("date")!=null)
		{
			date=request.getParameter("date");
			request.setAttribute("date",date);
		}
		
	
		if(title.trim().length()==0)
		{
			request.setAttribute("msg", "标 题 不 能 为 空 ！");
			request.getRequestDispatcher("AddMisssion.jsp").forward(request, response);
			return;
		}
		
		if(content.trim().length()==0)
		{
			request.setAttribute("msg", "内 容 不 能 为 空 ！");
			request.getRequestDispatcher("AddMisssion.jsp").forward(request, response);
			return;
		}
		
		if(department.trim().length()==0)
		{
			
			request.setAttribute("msg", " 尚 未 选 择 部 门 ！");
			request.getRequestDispatcher("AddMisssion.jsp").forward(request, response);
			return;
		}
		
		if(date.trim().length()==0)
		{
			request.setAttribute("msg", " 时 间 不 能 为 空 ！");
			request.getRequestDispatcher("AddMisssion.jsp").forward(request, response);
			return;
		}
		System.out.println(title);
		String sql4="select count(*) from  mission where m_title='"+title+"'";
		Map<String,String>map2=new HashMap<String,String>();
		map2=(Map<String,String>)DBTools.executeQuery(sql4).get(0);
		String count="";
		if(map2!=null)
		{
			count=map2.get("count(*)");
			if(count.compareTo("0")>0)
			{
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('任务已存在,不能重复发起');"
						+ "window.location.href='AddMission';"
						+ "</script>");
				out.close();
			
			}
		
			else
			{
				
				
				String sql2="select d_id from department where d_name=' "+department+"'";
				Map<String,String> map=new HashMap<String,String>();
				map=(Map<String,String>)DBTools.executeQuery(sql2).get(0);
				String d_id="";
				if(map!=null)
				{
					d_id=map.get("d_id");
					
					String sql3="insert into mission (m_title,m_content,m_date,fk_department_id)values('"+title+"','"+content+"','"
					+date+"','"+d_id+"')";		
						
					int result=DBTools.executeUpdate(sql3);
					
					 if(result>0)
						{
						 HttpSession session=request.getSession();
							String account=session.getAttribute("account").toString();
							String name=session.getAttribute("user_name").toString();
							String action="对"+department+"发起了任务";				
							 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
							 String date2=df.format(new Date());// new Date()为获取当前系统时间
							 LoginTools.AddLog(account, name, action, date2);
							 
							response.setContentType("text/html;charset=UTF-8");
							PrintWriter out=response.getWriter();
							out.print("<script>"
									+ "alert('发起成功');"
									+ "window.top.location.href='index';"
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

}
