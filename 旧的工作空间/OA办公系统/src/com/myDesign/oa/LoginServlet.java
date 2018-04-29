package com.myDesign.oa;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Check.Check(request, response))
		{
			
			return;
		}
		request.setCharacterEncoding("utf-8");
		String sql="select * from log as l, user as u where l.fk_user_id=u.user_id ";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		
		list=DBTools.executeQuery(sql);
		if(list!=null&&list!=null)
		{
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("LoginServlet.jsp").forward(request, response);
			return;
			
		}
		
	
		 
		 
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
