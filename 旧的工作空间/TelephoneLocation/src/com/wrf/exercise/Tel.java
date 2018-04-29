package com.wrf.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import net.sf.json.JSON;

/**
 * 
 * @ClassName:Tel
 * @author knight
 *
 */

@SuppressWarnings("serial")
@WebServlet("/Tel")
public class Tel extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取前台的手机号码
		String tel=req.getParameter("phone");
		
		//获取链接对象
		String con="http://sj.apidata.cn/?mobile="+tel+"";
		URL url=new URL(con); //建立链接
		URLConnection uc=url.openConnection();//打开链接
		//文件输入流
		InputStreamReader reader=new InputStreamReader(uc.getInputStream(),"UTF-8");
		//缓冲流
		BufferedReader bf=new BufferedReader(reader);
		StringBuilder sb=new StringBuilder();  
		String line="";
		while((line=bf.readLine())!=null)
		{
			sb.append(line);
		 
		}
		
		//解析json
		//Result result=JSONObject.parseObject(sb.toString()).get("data","province","city","isp");
		req.setAttribute("result", "result");
		req.getRequestDispatcher("result.jsp").forward(req, resp);
		
		
	
		
	}

}
