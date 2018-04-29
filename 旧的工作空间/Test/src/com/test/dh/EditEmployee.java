package com.test.dh;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(!Check.check(request, response))
		{
			
			return;
		}
							
		request.setCharacterEncoding("UTF-8");
	//��ȡ��ǰ�û�id a��ǩ��ֵ
		/*String id="";
		if(request.getParameter("id")!=null)
		{
			 id=request.getParameter("id");
		}*/
		String id=request.getParameter("id");
		String sql="select * from user where id ="+id;
		System.out.println(sql);
	//һ����¼�൱��һ��map ��ֵ˳��	
	Map<String,String>map= (Map<String, String>) DBTools.executeQuery(sql).get(0);
		request.setAttribute("map", map);
		
		
		
		
		
		
		
		//doPost(request, response);
		request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//����request�����е�����
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String  account=request.getParameter("account");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		//�������ݴ���request
		request.setAttribute("name", name);
		request.setAttribute("account", account);
		request.setAttribute("sex", sex);
		request.setAttribute("age", age);
		request.setAttribute("id", id);
		
		//�жϴ��صĸ�����ֵ�Ƿ�Ϊ�� ������
		if(name!=null&&name.trim().length()==0)
		{
			request.setAttribute("msg", "��������Ϊ��!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		if(sex!=null&&sex.trim().length()==0)
		{
			request.setAttribute("msg", "�Ա���Ϊ��!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		if(age!=null&&age.trim().length()==0)
		{
			request.setAttribute("msg", "���䲻��Ϊ��!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		if(account!=null&&account.trim().length()==0)
		{
			request.setAttribute("msg", "�˺Ų���Ϊ��!");
			request.getRequestDispatcher("EditEmployee.jsp").forward(request, response);
			return;
		}
		String sql="update user set name ='"+name+"',account ='"+account+"',age ="+age+",sex='"+sex+"' where id="+id;
		System.out.println(sql);
		int result=DBTools.executeUpdate(sql);
		if(result>0)
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('�༭�ɹ�');"
					+ "windows.top.location.href='ManagerMent.jsp';"
					+ "</script>");
			out.close();
			
		}
		else
		{

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('�༭ʧ�ܡ�����ϵ��վ����Ա');"
					+ "windows.top.location.href='MainView.jsp';"
					+ "</script>");
			out.close();
			
		}
	
		
		
		
	
	}

}
