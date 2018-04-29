package com.wrf.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wrf.UserInfo.User;

@WebServlet(urlPatterns={"/User.do"})
public class UserTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("User访问成功");
		List<User>list=new ArrayList<User>();
		Date date=new Date();
		/*SimpleDateFormat sf=new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String s=sf.format(date);
		System.out.println(s);*/
		User u1=new User("张山","26",date);
		list.add(u1);
		Date date2=new Date();
		User u2=new User("李四","28",date2);
		list.add(u2);
		Date date3=new Date();
		User u3=new User("王五","39",date3);
		list.add(u3);	
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/jsp/UserTest.jsp").forward(req,resp);
		
	
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}



