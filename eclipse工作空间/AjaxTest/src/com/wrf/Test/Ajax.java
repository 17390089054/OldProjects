package com.wrf.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

import jdk.nashorn.internal.scripts.JS;

/** 
 * @package:        com.wrf.Test
 * @Description:  TODO(������һ�仰�����������������) 
 * @author        knight
 * @Date          2017��12��6�� ����2:27:57 
 */
@WebServlet("/ajax.do")
public class Ajax extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		Map<String,Object>map=new HashMap<>();
		map.put("user_name", "��ɽ");
		map.put("user_age", 15);
		String user_sex=req.getParameter("user_sex");
		String user_addr=req.getParameter("user_addr");
		map.put("user_sex", user_sex);
		map.put("user_addr",user_addr);
		for(String x:map.keySet())
		{
			System.out.println(map.get(x)+" ");
		}
		//ԭ��Json
		//out.write("{\"user_name\":\"��ɽ\",\"user_age\":\"15\"}");
		Gson gson=new Gson();
		out.write(gson.toJson(map));
		out.flush();
		out.close();		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String user_sex=req.getParameter("user_sex");
		String user_addr=req.getParameter("user_addr");
		
		PrintWriter out=resp.getWriter();
		Map<String,Object>map=new HashMap<>();
		map.put("user_name", "����");
		map.put("user_age", 25);
		map.put("user_sex", user_sex);
		map.put("user_addr",user_addr);
		//ԭ��Json
		//out.write("{\"user_name\":\"��ɽ\",\"user_age\":\"15\"}");
		Gson gson=new Gson();
		out.write(gson.toJson(map));
		out.flush();
		out.close();
		
		
	}

}
