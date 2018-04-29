package com.tz.idcard.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.id.utils.DbUtil;


@WebServlet("/save")
public class Save extends HttpServlet  {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		
		String gender=request.getParameter("gender");
		
		String address=request.getParameter("address");
		
		String nation=request.getParameter("nation");
	
		String date=request.getParameter("date");

		
		String number=request.getParameter("number");
		
			if(name.trim().length()==0&&gender.trim().length()==0&&address.trim().length()==0&&nation.trim().length()==0&&date.trim().length()==0&&number.trim().length()==0)
			{
				response.getWriter().write("未识别到任何信息，请检查网络");
				return;
				
			}
		
		
		
		
		
		
		
	
	String sql="insert into user (name,gender,nation,date,address,number)values(?,?,?,?,?,?)";
	int result=DbUtil.update(sql,name,gender,nation,date,address,number);
	
		
	if(result>0)
	{
		
			response.getWriter().print("保存成功!");
		
	}
	else
	{
		response.getWriter().print("保存失败!");
		
	}
	}
}
