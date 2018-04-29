package com.myDesign.oa;

import java.io.IOException;
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


@WebServlet("/RestView")
public class RestView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		String rest_id="";
		if(request.getParameter("id")!=null)
		{
			rest_id=request.getParameter("id");			
		}
		String sql="select *from user as u,rest as r where u.user_id=r.fk_user_id and rest_id='"+rest_id+"'";
		/*System.out.println(sql);*/
		Map<String,String> map=new HashMap<String,String>();
		map=(Map<String,String>)DBTools.executeQuery(sql).get(0) ;
	/*	System.out.println(map);*/
		if(map!=null)
		{
			request.setAttribute("map", map);
			
			HttpSession session=request.getSession();
			String account=session.getAttribute("account").toString();
			String name=session.getAttribute("user_name").toString();
			String action="�鿴�������ϸ��Ϣ";
			
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			 String date=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			 LoginTools.AddLog(account, name, action, date);
			 
			request.getRequestDispatcher("RestView.jsp").forward(request, response);
			return;
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
