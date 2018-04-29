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

@WebServlet("/ReviseInfo")
public class ReviseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String account=session.getAttribute("account").toString();
		
		
		String sql="select * from user as u,department as d where u.fk_department_id=d.d_id and account='"+account+"'";
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0);
		if(map!=null)
		{
			request.setAttribute("map",map);
		}
		
		String sql2="select d_name from department";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql2);
		if(list!=null)
		{
			request.setAttribute("list", list);
		}
				
		request.getRequestDispatcher("ReviseInfo.jsp").forward(request, response);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String sql2="select d_name from department";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql2);
		if(list!=null)
		{
			request.setAttribute("list", list);
		}
		
		String id="";
		String account="";
		String user_name="";
		String department="";
		String id_card="";
		String telephone="";
		String address="";
		
		if(request.getParameter("id")!=null)
		{
			id=request.getParameter("id");
			request.setAttribute("id", id);
		}
		
		
		if(request.getParameter("account")!=null)
		{
			account=request.getParameter("account");
			request.setAttribute("account", account);
		}
		
		
		if(request.getParameter("user_name")!=null)
		{
			user_name=request.getParameter("user_name");
			request.setAttribute("user_name", user_name);
		}
		
		
		if(request.getParameter("department")!=null)
		{
			department=request.getParameter("department");
			request.setAttribute("department", department);
		}
		
		
		if(request.getParameter("id_card")!=null)
		{
			id_card=request.getParameter("id_card");
			request.setAttribute("id_card", id_card);
		}
		
		
		if(request.getParameter("telephone")!=null)
		{
			telephone=request.getParameter("telephone");
			request.setAttribute("telephone", telephone);
		}
		
		
		if(request.getParameter("address")!=null)
		{
			address=request.getParameter("address");
			request.setAttribute("address", address);
		}
		//数据判空
		
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "用户名不能为空!");
			request.getRequestDispatcher("ReviseInfo.jsp").forward(request, response);
			return;
		}
		
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg", "姓名不能为空!");
			request.getRequestDispatcher("ReviseInfo.jsp").forward(request, response);
			return;
		}
		
		if(department.trim().length()==0)
		{
			request.setAttribute("msg", "部门不能为空!");
			request.getRequestDispatcher("ReviseInfo.jsp").forward(request, response);
			return;
		}
		
		if(id_card.trim().length()==0)
		{
			request.setAttribute("msg", "身份证号不能为空!");
			request.getRequestDispatcher("ReviseInfo.jsp").forward(request, response);
			return;
		}
		
		if(telephone.trim().length()==0)
		{
			request.setAttribute("msg", "联系方式不能为空!");
			request.getRequestDispatcher("ReviseInfo.jsp").forward(request, response);
			return;
		}
		
		if(address.trim().length()==0)
		{
			request.setAttribute("msg", "住址不能为空!");
			request.getRequestDispatcher("ReviseInfo.jsp").forward(request, response);
			return;
		}
		
		String sql3="select d_id from department where d_name=' "+department+"'";
		/*System.out.println(sql3);*/
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql3).get(0);
		String fk_department_id="";
		if(map!=null)
		{
			fk_department_id=map.get("d_id");
			
		}
		
		String sql4="update user set account='"+account+"',user_name='"+user_name+"',user_card='"+id_card+"',user_tel='"+
		telephone+"',user_addr='"+address+"',fk_department_id='"+fk_department_id+"' where user_id='"+id+"'";
		
		
		int result=DBTools.executeUpdate(sql4);
				

		if(result>0)
		{
			HttpSession session=request.getSession();
			String account2=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="修改了自己的基本信息";
			
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account2, name, action, date);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('修改成功');"
					+ "windows.top.location.href='index';"
					+ "</script>");
			out.close();
			
		}
		else
		{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('修改失败。请联系网站管理员');"
					+ "windows.top.location.href='index.jsp';"
					+ "</script>");
			out.close();
			
		}
		
		
		
		
		
	}

}
