package com.myDesign.oa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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


@WebServlet("/ReciveLetter")
public class ReciveLetter extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(!Check.Check(request, response))
		{
			
			return;
		}
		HttpSession session=request.getSession();
		String user_name=session.getAttribute("user_name").toString();
		String account=session.getAttribute("account").toString();
		
		String sql2="select user_id from user where account='"+account+"'";
		Map<String,String>map=new HashMap<String,String>();
		String user_id="";
		map=(Map<String,String>)DBTools.executeQuery(sql2).get(0);
		if(map!=null)
		{
			user_id=map.get("user_id");
		}
		
		request.setAttribute("user_name", user_name);
		String sql="select * from  (SELECT M_ID ,user_name ,RecID,Message,P_Date,STATUS from user as u ,message as m,messagetext as mt where m.MessageID=mt.ID and m.SendID=u.user_id  ) "
				+ " as t where RecID='"+user_id+"' or RecID=0";
		List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		
		list=DBTools.executeQuery(sql);
		if(list!=null)
		{
			request.setAttribute("list", list);

			request.getRequestDispatcher("ReciveLetter.jsp").forward(request,response);
			return;
		}
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
