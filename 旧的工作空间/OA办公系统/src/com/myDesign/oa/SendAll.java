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

@WebServlet("/SendAll")
public class SendAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			if(!Check.Check(request, response))
			{
				
				return;
			}
			request.getRequestDispatcher("SendAll.jsp").forward(request, response);
			return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String text="";
		String date="";
		
		if(request.getParameter("text")!=null)
		{
			text=request.getParameter("text");
			request.setAttribute("text", text);
		}
		
		if(request.getParameter("date")!=null)
		{
			date=request.getParameter("date");
			request.setAttribute("date", date);
		}
		
		if(text.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� �� Ϊ �� !");
			request.getRequestDispatcher("SendAll.jsp").forward(request, response);
			return;
		}
		
		if(date.trim().length()==0)
		{
			request.setAttribute("msg", "�� ѡ �� �� �� !");
			request.getRequestDispatcher("SendAll.jsp").forward(request, response);
			return;
			
		}
		
		String sql="insert into messagetext (Message,P_Date) values('"+text+"','"+date+"')";
		String sql2="insert into message (sendID,RecID,Status) values(1,0,0)";
		String sql3="update message set MessageId=M_Id where status=0";
		
		int result=DBTools.executeUpdate(sql);
		int result2=DBTools.executeUpdate(sql2);
		int result3=DBTools.executeUpdate(sql3);
		if(result>0&&result2>0&&result3>0)
		{
		
			
			 HttpSession session=request.getSession();
				String account=session.getAttribute("account").toString();
				String name=session.getAttribute("user_name").toString();
				String action="������һ��Ⱥ�ʼ�";		
				 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
				 String date2=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
				 LoginTools.AddLog(account, name, action, date2);
				 
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.print("<script>"
						+ "alert('���ͳɹ�');"
						+ "window.top.location.href='index';"
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
