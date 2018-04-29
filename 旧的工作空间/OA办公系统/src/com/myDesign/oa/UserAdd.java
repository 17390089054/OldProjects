package com.myDesign.oa;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
			
			List<Map<String,String>> list=new ArrayList<Map<String,String>>();
			
			String sql="select d_name from department";
			
			list=DBTools.executeQuery(sql);
			if(list!=null&&list.size()!=0)
			{
				request.setAttribute("list", list);
				request.getRequestDispatcher("userAdd.jsp").forward(request, response);
				return;
			}
			else
			{
				request.getRequestDispatcher("userAdd.jsp").forward(request, response);
			}
		
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		//从前台接收数据并处判空
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		
		String sql="select d_name from department";
		
		list=DBTools.executeQuery(sql);
		if(list.size()!=0)
		{
			request.setAttribute("list", list);
			//request.getRequestDispatcher("userAdd.jsp").forward(request, response);
		}
		
		String account="";
		if(request.getParameter("用户名")!=null)
		{
			
			account=request.getParameter("用户名");
			request.setAttribute("account", account);
		}
		
		String password="";
		if(request.getParameter("用户密码")!=null)
		{
			
			password=request.getParameter("用户密码");
			request.setAttribute("password", password);
		}
		
		String user_name="";
		if(request.getParameter("真实姓名")!=null)
		{
			
			user_name=request.getParameter("真实姓名");
			request.setAttribute("user_name", user_name);
		}
		
		String department="";
		if(request.getParameter("部门")!=null)
		{
			
			department=request.getParameter("部门");
			
			request.setAttribute("department", department);
		}
		
		String tel="";
		if(request.getParameter("移动电话")!=null)
		{
			
			tel=request.getParameter("移动电话");
			request.setAttribute("tel", tel);
		}
		
		String id="";
		if(request.getParameter("身份证号")!=null)
		{
			
			id=request.getParameter("身份证号");
			request.setAttribute("id", id);
		}
		
		String addr="";
		if(request.getParameter("家庭住址")!=null)
		{
			
			addr=request.getParameter("家庭住址");
			request.setAttribute("addr", addr);
		}
		
		//判断数据是否为空并回显
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "尚 未 输 入 用 户 名 ");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;
		}
		
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg", "用 户 姓 名 不 能 为 空 ");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;
		}
		
		if(password.trim().length()==0)
		{
			request.setAttribute("msg", "尚 未 设 置 密 码 ");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;
		}
				
		if(department.trim().length()==0)
		{
			request.setAttribute("msg", " 尚 未 选 择 部 门 ");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;
		}
		
		if(tel.trim().length()==0)
		{
			request.setAttribute("msg", "尚 未 输 入 电 话");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;
		}
		
		
		if(id.trim().length()==0)
		{
			request.setAttribute("msg", "尚 未 输 入 身 份 证 号 码 ");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;
		}
		
		if(addr.trim().length()==0)
		{
			request.setAttribute("msg", "尚 未 输 入 地 址 ");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;
		}
		//检查账号是否被注册
		String sql4="select count(*) from user where account= '"+account+"'";
		System.out.println(sql4);
		List<Map<String,String>> list3=new ArrayList<Map<String,String>>();
		list3=DBTools.executeQuery(sql4);
		if(list3.size()!=0&&list3.get(0).get("count(*)").equals("1"))
		{		
			request.setAttribute("msg", "账 号 已 被 注 册 ");
			request.getRequestDispatcher("userAdd.jsp").forward(request,response);
			return;			
		}
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 String time=df.format(new Date());// new Date()为获取当前系统时间
		
		//获取已分配部门的id
		String sql3="select d_id from department where d_name= ' "+department+"'";
		List<Map<String,String>> list2=new ArrayList<Map<String,String>>();
		list2=DBTools.executeQuery(sql3);
/*		System.out.println(sql3);
*/		String d_id="";
		if(list2.size()!=0)
		{
			d_id=list2.get(0).get("d_id");

			String sql2="insert into user (user_name,account,password,user_card,user_tel,user_addr,user_create_time,fk_department_id) values"
					+ "('"+user_name+"','"+account+"','"+password+"','"+id+"','"+tel+"','"+addr+"','"+time+"','"+d_id+"')";
			
			/*System.out.println(sql2);*/
			
			/*List<Map<String,String>> list4=new ArrayList<Map<String,String>>();*/
			 int result=DBTools.executeUpdate(sql2);
			 if(result>0)
				{
				 HttpSession session=request.getSession();
					String account2=session.getAttribute("account").toString();
					String name=session.getAttribute("user_name").toString();
					String action="添加了一个用户";
					
					 SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					 String date=df.format(new Date());// new Date()为获取当前系统时间
					 LoginTools.AddLog(account2, name, action, date);
					 
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('添加成功!');"
							+ "window.location.href='UserList';"
							+ "</script>");
					out.close();
					
				}
				else
				{

					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.print("<script>"
							+ "alert('注册失败。请联系网站管理员');"
							+ "window.top.location.href='index';"
							+ "</script>");
					out.close();
					
				}
			
			
			System.out.println(d_id);
		}
		else
		{
			return;
						
		}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
