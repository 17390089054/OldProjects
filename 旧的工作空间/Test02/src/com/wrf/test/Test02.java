package com.wrf.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/test02")*/
@WebServlet(urlPatterns={"/test02","/tt"})
public class Test02 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("∑√Œ ≥…π¶");
		req.getRequestDispatcher("WEB-INF/jsp/Filter.jsp").forward(req, resp);
		
		
		
		
		
	}
	

}
