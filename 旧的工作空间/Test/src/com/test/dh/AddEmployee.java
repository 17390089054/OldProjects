package com.test.dh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.check(request, response))
		{
			
			return;
		}
		
		
		
		request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
		//doPost(request,response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//����post�����͵�����
		//���ݻ���������ҳ��
		String name="";
		if(request.getParameter("name")!=null)
		{
			name=request.getParameter("name");
			request.setAttribute("name", name);
		}
		String sex="";
		if(request.getParameter("sex")!=null)
		{
			sex=request.getParameter("sex");
			request.setAttribute("sex", sex);
		}
		
		String age="";
		if(request.getParameter("age")!=null)
		{
			age=request.getParameter("age");
			request.setAttribute("age", age);
		}
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
		

		
		
		
		
	
		
		
		

		

		//�ж������Ƿ�Ϊ�գ�Ϊ�ջ������û�
		if(name.trim().length()==0)
		{
			request.setAttribute("msg", "�������û���");
			
			request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
			
			return;
		}
		
			if(sex.trim().length()==0)
			{
				request.setAttribute("msg", "��ѡ���Ա�");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
			
			if(age.trim().length()==0)
			{
				request.setAttribute("msg", "����������");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
		
		
			if(account.trim().length()==0)
			{
				request.setAttribute("msg", "�������˺�");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
		
				if(password.trim().length()==0)
			{
				request.setAttribute("msg", "����������");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
			//����˺��Ƿ��ظ�
			String sql1="select count(*)   as num  from user where account='"+ account+"'";
			List<Map<String,String>> list=DBTools.executeQuery(sql1);
			int repeat=Integer.parseInt(list.get(0).get("num"));
			if(repeat>0)
			{
				request.setAttribute("msg", "�˺��ѱ�ע��!");
				request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
				return;
			}
		
	
		String sql="insert into user (name,account,password,age,sex) values ('"+name +"','"+account +"','"+password +"',"+age +",'"+sex+"')";
 		System.out.println(sql);
		int result=DBTools.executeUpdate(sql);
		if(result>0)
		{
			//������ʾ
			//����out����
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write("<script>alert('��ӳɹ�!');"
					+"windows.top.location.href='MainView.jsp';"
					+ "</script>");
			out.close();
		}
		else
		{
			//���ʧ������ע��ҳ��
			request.setAttribute("msg", "���ʧ�ܣ�����ϵ����Ա");
			request.getRequestDispatcher("AddEmployee.jsp").forward(request,response);
			return;
			
		}
		
		
	
	}

}
