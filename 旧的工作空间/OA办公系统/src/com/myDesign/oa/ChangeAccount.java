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

import com.MyTools.DBTools;
import com.MyTools.LoginTools;

@WebServlet("/ChangeAccount")
public class ChangeAccount extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			request.getRequestDispatcher("ChangeAccount.jsp").forward(request, response);
			return;
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String account="";
		if(request.getParameter("account")!=null)
		{
			account=request.getParameter("account");
			request.setAttribute("account", account);
		}
		
		String password="";
		if(request.getParameter("password")!=null)
		{
			password=request.getParameter("password");
			
			
		}
		
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "账号不能为空");
			request.getRequestDispatcher("ChangeAccount.jsp").forward(request, response);
			return;
		}

		if(password.trim().length()==0)
		{
			request.setAttribute("msg", "密码不能为空");
			request.getRequestDispatcher("ChangeAccount.jsp").forward(request, response);
			return;
		}
		
		String sql="select * from user where account='"+account+"'";
		Map<String,String>map=new HashMap<String,String>();
		if(DBTools.executeQuery(sql)!=null&&DBTools.executeQuery(sql).size()>0)
		{
			map=(Map<String, String>) DBTools.executeQuery(sql).get(0);
		}
		else
		{
			request.setAttribute("msg", "账号不存在");
			request.getRequestDispatcher("ChangeAccount.jsp").forward(request, response);
			return;
			
		}
		HttpSession session=request.getSession();
		String user_name="";
		String password2="";
		String user_id="";
		if(map!=null)
		{
			password2=map.get("password");
			user_name=map.get("user_name");
			user_id=map.get("user_id");
			if(password.equals(password2))
			{
				
				session.setAttribute("account", account);
				
				session.setAttribute("user_name", user_name);
				
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date=sf.format(new Date());
				
				String  action="切换了账号!";
				LoginTools.AddLog(account, user_name, action, date);
				
				
				
				PrintWriter out=response.getWriter(); 
				out.write("<script>alert('切换账号成功!');top.location.href='index'</script>");
				out.close();
				String date2=sf.format(new Date());
				String Sql="insert into log (fk_user_id,log_create_time)values ('"+user_id+"','"+date2+"')";
				int result=DBTools.executeUpdate(Sql);
				if(result>0)
				{
					System.out.println("添加登录日志成功");
				}
				else
				{
				System.out.println("添加登录日志失败");	
				}
			}
			else
			{
				request.setAttribute("msg", "密码错误");
				request.getRequestDispatcher("ChangeAccount.jsp").forward(request, response);
				return;
				
			}
			 
		}

		
		
		
		
	}

}
