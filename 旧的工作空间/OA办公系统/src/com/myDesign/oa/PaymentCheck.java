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

@WebServlet("/PaymentCheck")
public class PaymentCheck extends HttpServlet {
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
		String sql="select * from payment as p,user as u where u.user_id=p.fk_user_id and p_id='"+id+"'";
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		if(map!=null)
		{
			request.setAttribute("map", map);
			request.getRequestDispatcher("PaymentCheck.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_name="";
		String id="";
		String reason="";
		String type="";
		String place="";
		String money="";
		
		
	 if(request.getParameter("user_name")!=null)
	 {
		user_name=request.getParameter("user_name"); 
		 request.setAttribute("user_name", user_name);
	 }
	 
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
		
	 if(id.trim().length()==0)
	 {
		 request.setAttribute("msg", "id不能为空! ");
		 request.getRequestDispatcher("PaymentCheck.jsp").forward(request, response);
		 return;
	 }
	 
		
	 if(user_name.trim().length()==0)
	 {
		 request.setAttribute("msg", "姓名不能为空! ");
		 request.getRequestDispatcher("PaymentCheck.jsp").forward(request, response);
		 return;
	 }
	 
		
	 if(reason.trim().length()==0)
	 {
		 request.setAttribute("msg", "原因不能为空! ");
		 request.getRequestDispatcher("PaymentCheck.jsp").forward(request, response);
		 return;
	 }
	 
		
	 if(type.trim().length()==0)
	 {
		 request.setAttribute("msg", "类型不能为空! ");
		 request.getRequestDispatcher("PaymentCheck.jsp").forward(request, response);
		 return;
	 }
	 
		
	 if(place.trim().length()==0)
	 {
		 request.setAttribute("msg", "地点不能为空! ");
		 request.getRequestDispatcher("PaymentCheck.jsp").forward(request, response);
		 return;
	 }
	 
		
	 if(money.trim().length()==0)
	 {
		 request.setAttribute("msg", "金额不能为空! ");
		 request.getRequestDispatcher("PaymentCheck.jsp").forward(request, response);
		 return;
	 }
	 
	 String  sql="update payment set p_money='"+money+"',p_status=1 where p_id='"+id+"'";
	 int result=DBTools.executeUpdate(sql);
	 if(result>0)
	 {
	 HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		String name=session.getAttribute("user_name").toString();
	 	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2=df.format(new Date());
		String action="审批并通过了一条报销信息";				
		
		 LoginTools.AddLog(account, name, action, date2);
		 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>"
				+ "alert('审批成功');"
				+ "window.location.href='PaymentView';"
				+ "</script>");
		out.close();
		
	}
	else
	{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("<script>"
				+ "alert('审批失败。请联系网站管理员');"
				+ "window.top.location.href='index';"
				+ "</script>");
		out.close();
		
	}
	 
	 
		
		
		
	}

}
