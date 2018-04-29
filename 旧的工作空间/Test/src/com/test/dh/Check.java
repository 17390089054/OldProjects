package com.test.dh;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Check {
	public static boolean check(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		if(session.getAttribute("user")==null)
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("<script>"
					+ "alert('ÉÐÎ´µÇÂ¼»òµÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼');"
					+ "window.top.location.href='Login';"
					+ "</script>");
			
			out.close();		
	
			return false;
		}
		else
		{
			return true;
		}
		
		
		
		
	}
		
}
