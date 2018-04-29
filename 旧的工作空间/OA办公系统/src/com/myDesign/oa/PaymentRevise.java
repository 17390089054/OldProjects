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


@WebServlet("/PaymentRevise")
public class PaymentRevise extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
	String p_id="";
	if(request.getParameter("id")!=null)
	{
		p_id=request.getParameter("id");
	}
	
	String sql="select * from payment where p_id='"+p_id+"'";
	Map<String,String>map=new HashMap<String,String>();
	map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
	if(map!=null)
	{
		request.setAttribute("map", map);
		request.getRequestDispatcher("PaymentRevise.jsp").forward(request, response);
		return;
	}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reason="";
		String type="";
		String place="";
		String money="";
		String id="";
		
		if(request.getParameter("id")!=null)
		{
			id=request.getParameter("id");
			request.setAttribute("id", id);
		}
		
		if(request.getParameter("reason")!=null)
		{
			reason=request.getParameter("reason");
			request.setAttribute("reason", reason);
			
		}
		
		if(request.getParameter("type")!=null)
		{
			type=request.getParameter("type");
			request.setAttribute("type", type);
			
		}
		
		if(request.getParameter("place")!=null)
		{
			place=request.getParameter("place");
			request.setAttribute("place", place);
			
		}
		
		if(request.getParameter("money")!=null)
		{
			money=request.getParameter("money");
			request.setAttribute("money", money);
			
		}
		
		if(place.trim().length()==0)
		{
			request.setAttribute("msg", "�ص㲻��Ϊ��!");
			request.getRequestDispatcher("PaymentRevise.jsp").forward(request, response);
			return;
		}
		
		if(type.trim().length()==0)
		{
			request.setAttribute("msg", "���Ͳ���Ϊ��!");
			request.getRequestDispatcher("PaymentRevise.jsp").forward(request, response);
			return;
		}
		if(money.trim().length()==0)
		{
			request.setAttribute("msg", "����Ϊ��!");
			request.getRequestDispatcher("PaymentRevise.jsp").forward(request, response);
			return;
		}
		
		if(reason.trim().length()==0)
		{
			request.setAttribute("msg", "ԭ����Ϊ��!");
			request.getRequestDispatcher("PaymentRevise.jsp").forward(request, response);
			return;
		}
		
		
		String sql="update payment set p_reason='"+reason+"',p_type='"+type+"',p_place='"+place+"',p_money='"+money+"' where p_id='"+id+"'";
		/*System.out.println(sql);*/
		int result=DBTools.executeUpdate(sql);
		if(result>0){
			
			HttpSession session=request.getSession();
			String account=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="�޸���һ����������";				
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			 String date2=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			 LoginTools.AddLog(account, name, action, date2);
			 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>"
				+ "alert('�޸ĳɹ�');"
				+ "window.location.href='PaymentHistory';"
				+ "</script>");
		out.close();
		
	}
	else
	{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>"
				+ "alert('�޸�ʧ�ܡ�����ϵ��վ����Ա');"
				+ "window.top.location.href='index';"
				+ "</script>");
		out.close();
		
	}
		
		
		
		
		
		
		
	}

}
