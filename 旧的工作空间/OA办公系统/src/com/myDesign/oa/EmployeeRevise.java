package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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


@WebServlet("/EmployeeRevise")
public class EmployeeRevise extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("UTF-8");
		
			String user_id="";
			if(request.getParameter("id")!=null)
			{
				user_id=request.getParameter("id");

			}
			String sql2="select d_name from department ";
			List<Map<String,String>>list2=new ArrayList<Map<String,String>>();
			list2=DBTools.executeQuery(sql2);
			if(list2!=null&&list2.size()!=0)
			{
				request.setAttribute("list2", list2);
			}
			String sql="select * from user as u,department as d where  u.fk_department_id=d.d_id and  user_id='"+user_id+"'";
			System.out.println(sql);
			List<Map<String,String>>list=new LinkedList<Map<String,String>>();
			list=DBTools.executeQuery(sql);
			if(list!=null&&list.size()!=0)
			{
				request.setAttribute("list", list);
				request.getRequestDispatcher("employeeRevise.jsp").forward(request, response);
				return;
			}
		
		
			
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String sql2="select d_name from department ";
		List<Map<String,String>>list2=new ArrayList<Map<String,String>>();
		list2=DBTools.executeQuery(sql2);
		if(list2.size()!=0)
		{
			request.setAttribute("list2", list2);
		}


		
					
		//数据判null
		
		String user_id="";
		if(request.getParameter("id")!=null)
		{
			user_id=request.getParameter("id");
			request.setAttribute("id", user_id);

		}
		
		String account="";
		if(request.getParameter("account")!=null)
		{
			account=request.getParameter("account");
			request.setAttribute("account",account );
		}
		

		String user_name="";
		if(request.getParameter("user_name")!=null)
		{
			user_name=request.getParameter("user_name");
			request.setAttribute("user_name",user_name);
		}
		
		String id_card="";
		if(request.getParameter("id_card")!=null)
		{
			id_card=request.getParameter("id_card");
			request.setAttribute("id_card",id_card);
		}
		
		String address="";
		if(request.getParameter("address")!=null)
		{
			address=request.getParameter("address");
			request.setAttribute("address",address);
		}
		
		String telephone="";
		if(request.getParameter("telephone")!=null)
		{
			telephone=request.getParameter("telephone");
			request.setAttribute("telephone",telephone);
		}
		
		String department="";
		if(request.getParameter("department")!=null)
		{
			department=request.getParameter("department");
			request.setAttribute("department",department);
		}
		//数据判空并回显
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "用 户  名 不 能 为 空 ！");
			request.getRequestDispatcher("employeeRevise.jsp").forward(request, response);
			return;
		}
		
		
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg", "用 户 姓 名 不 能 为 空 ！");
			request.getRequestDispatcher("employeeRevise.jsp").forward(request, response);
			return;
		}
		
		if(id_card.trim().length()==0)
		{
			request.setAttribute("msg", "用 户 身  份  证  不 能 为 空 ！");
			request.getRequestDispatcher("employeeRevise.jsp").forward(request, response);
			return;
		}
		
		if(address.trim().length()==0)
		{
			request.setAttribute("msg", "用 户  地  址  不 能 为 空 ！");
			request.getRequestDispatcher("employeeRevise.jsp").forward(request, response);
			return;
		}
		
		if(telephone.trim().length()==0)
		{
			request.setAttribute("msg", "用 户 联 系 方 式  不 能 为 空 ！");
			request.getRequestDispatcher("employeeRevise.jsp").forward(request, response);
			return;
		}
		
		
		String sql3="select d_id from  department where d_name=' "+department+"'";
		
		System.out.println(sql3);
		
		String sql="";
		
		String d_id="";
		
		List<Map<String,String>>list3=new ArrayList<Map<String,String>>();
		list3=DBTools.executeQuery(sql3);
		
		if(list3.size()!=0)
		{
			d_id=list3.get(0).get("d_id");
			sql="update user set user_name='"+user_name+"',"+"account='"+account+"',user_card='"+id_card+"', fk_department_id='"+
			d_id+"',user_tel='"+telephone+"', user_addr='"+address+"' where user_id='"+user_id+"'";
			System.out.println(sql);
		}
		
		/*String sql4="update department set d_name=' "+department+"'"+" where d_id='"+d_id+"'";
		
		System.out.println(sql4);
		
		DBTools.executeUpdate(sql4);*/
		
		int result=DBTools.executeUpdate(sql);
		
		if(result>0)
		{
			HttpSession session=request.getSession();
			String account2=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="修改了"+user_name+"的信息";
			
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 String date=df.format(new Date());// new Date()为获取当前系统时间
			 LoginTools.AddLog(account2, name, action, date);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('编辑成功');"
					+ "windows.location.href='UserList';"
					+ "</script>");
			out.close();
			
		}
		else
		{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('编辑失败。请联系网站管理员');"
					+ "windows.top.location.href='index.jsp';"
					+ "</script>");
			out.close();
			
		}
		
		
	}

}
