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

import com.MyTools.Check;
import com.MyTools.DBTools;

@WebServlet("/ReportLook")
public class ReportLook extends HttpServlet {
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
		
		String sql="select * from report where report_id='"+id+"'";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);
		if(list!=null)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("ReportLook.jsp").forward(request, response);
			return;
		}
			
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
