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
			request.setAttribute("msg", "���ⲻ��Ϊ�գ�");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(content.trim().length()==0)
		{
			request.setAttribute("msg", "���ݲ���Ϊ�գ�");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(start_date.trim().length()==0)
		{
			request.setAttribute("msg", "��ʼʱ�䲻��Ϊ�գ�");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(end_date.trim().length()==0)
		{
			request.setAttribute("msg", "����ʱ�䲻��Ϊ�գ�");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(create_date.trim().length()==0)
		{
			request.setAttribute("msg", "����ʱ�䲻��Ϊ�գ�");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(create_date.compareTo(start_date)>0)
		{
			request.setAttribute("msg", "���ʼʱ�䲻�����ڷ���ʱ�䣡");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(create_date.compareTo(end_date)>0)
		{
			request.setAttribute("msg", "�����ʱ�䲻�����ڷ���ʱ�䣡");
			request.getRequestDispatcher("AddActivity.jsp").forward(request, response);
			return;
		}
		
		if(start_date.compareTo(end_date)>0)
		{
			request.setAttribute("msg", "�����ʱ�䲻�����ڿ�ʼʱ�䣡");
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
						+ "alert('��Ѵ���,�����ظ�����');"
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
						String action="�������»";				
						 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
						 String date2=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
						 LoginTools.AddLog(account, name, action, date2);
						 
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out=response.getWriter();
						out.print("<script>"
								+ "alert('����ɹ�');"
								+ "window.location.href='ActivityCheck';"
								+ "</script>");
						out.close();
						
					}
					else
					{

						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out=response.getWriter();
						out.print("<script>"
								+ "alert('����ʧ�ܡ�����ϵ��վ����Ա');"
								+ "window.top.location.href='index';"
								+ "</script>");
						out.close();
						
					}
				
				
				
				
			}
		}
		
		
		
		
		
		
		
	}

}
