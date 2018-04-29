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


@WebServlet("/AcceptMission")
public class AcceptMission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		String sql="select * from mission as m,department as d where m.fk_department_id=d.d_id";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		list=DBTools.executeQuery(sql);
		if(list!=null&&list.size()!=0)
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("AcceptMission.jsp").forward(request,response);
			return;
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
