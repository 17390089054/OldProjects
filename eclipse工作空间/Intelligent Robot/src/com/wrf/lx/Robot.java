package com.wrf.lx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @package:        com.wrf.lx
 * @Description:  TODO(这里用一句话描述这个方法的作用) 
 * @author        knight
 * @Date          2018年1月22日 下午8:38:43 
 */
@WebServlet("/Robot")
public class Robot extends HttpServlet {
	private static final String URL="http://www.tuling123.com/openapi/api";
	private static final String KEY="2c570281f3b145e7aff4c6aa02427e3d";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//接收前台参数 拼接请求链接
		//String text=req.getParameter("text");
		String text = new String (req.getParameter( "text" ).getBytes ( "utf-8" ),"GBK" );
		String queryUrl=URL+"?key="+KEY+"&info="+text;
		//System.out.println(queryUrl);
		//建立请求并发送链接
		//新建URL
		URL url=new URL(queryUrl);
		//建立连接
		URLConnection connection = url.openConnection();
		//获取IO流
		InputStream inputStream = connection.getInputStream();
		//定义一个StringBuilder存储读取结果
		StringBuilder sb=new StringBuilder();
		//定义一个bufferedReader(逐字节)读取IO流
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
		
		//开始读取IO流
		String temp="";
		while((temp=reader.readLine())!=null)
		{
			sb.append(temp);
		}
		
		//关闭链接
		reader.close();
		System.out.println(sb.toString());
		//结果返回至前台
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println(sb.toString());
	
	}

}
