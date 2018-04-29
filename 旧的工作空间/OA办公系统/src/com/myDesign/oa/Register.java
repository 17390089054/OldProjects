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

@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.getRequestDispatcher("register.jsp").forward(request,response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		/*��ǰ̨�ý������ݲ��ж��Ƿ�Ϊnull*/
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
			request.setAttribute("password", password);
		}
		
		String password2="";
		if(request.getParameter("password2")!=null)
		{
			password2=request.getParameter("password2");
			request.setAttribute("password2", password2);
		}
		
		String user_name="";
		if(request.getParameter("user_name")!=null)
		{
			user_name=request.getParameter("user_name");
			request.setAttribute("user_name", user_name);
		}
		
		String id_card="";
		if(request.getParameter("id_card")!=null)
		{
			id_card=request.getParameter("id_card");
			request.setAttribute("id_card", id_card);
		}
		
		String address="";
		if(request.getParameter("address")!=null)
		{
			address=request.getParameter("address");
			request.setAttribute("address", address);
		}
		
		String telephone="";
		if(request.getParameter("telephone")!=null)
		{
			telephone=request.getParameter("telephone");
			request.setAttribute("telephone", telephone);
		}
		
		/*�����пղ����Դ�����Ϣ*/
		//���ݻ���
		if(account.trim().length()==0)
		{
			request.setAttribute("msg", "��  �� �� �� �� �� !");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		//request.setAttribute("account", account);
		
		
		if(password.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� �� �� �� !");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		//request.setAttribute("password", password);

		
		if(password2.trim().length()==0)
		{
			request.setAttribute("msg", "�� ȷ �� �� �� !");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		//request.setAttribute("password2", password2);

		
		if(user_name.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� �� �� �� !");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		//request.setAttribute("user_name", user_name);

		
		if(id_card.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� �� ֤ �� �� ");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		//request.setAttribute("id_card", id_card);

		if(address.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� ͥ �� ַ !");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		//request.setAttribute("address", address);

		if(telephone.trim().length()==0)
		{
			request.setAttribute("msg", "�� �� �� �� ϵ �� �� !");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		//request.setAttribute("telephone", telephone);
		
		
		if(!password.equals(password2))
		{
			
			request.setAttribute("msg", "ǰ�����벻һ��");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
			
		}
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		 String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		
		String sql="select count(*) from user where account= '"+account+"'";
		System.out.println(sql);
		list=DBTools.executeQuery(sql);
		int result=0;
		if(list.size()!=0&&list.get(0).get("count(*)").equals("0"))
		{
			
			String sql2="insert into user (user_name,account,password,user_card,user_tel,user_addr,user_create_time,user_status) values ('"+user_name+"','"
					+account+"','"+password+"','"+id_card+"','"+telephone+"','"+address+"','"+time+"',2)";
			
/*			System.out.println(sql2);
*/			
			result=DBTools.executeUpdate(sql2);
			
			
			
		
		}
		
		
		if(result>0)
		{
			HttpSession session=request.getSession();
			/*String account2=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();*/
			String action=user_name+"�ύ��ע������";
			
			 SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			 String date=df2.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			 LoginTools.AddLog(account, user_name, action, date);
			 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('ע��ɹ�,��ȴ�����Ա����');"
					+ "window.top.location.href='login.jsp';"
					+ "</script>");
			out.close();
			
		}
		else
		{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('ע��ʧ�ܡ�����ϵ��վ����Ա');"
					+ "window.top.location.href='login.jsp';"
					+ "</script>");
			out.close();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
