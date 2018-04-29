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
		//��ȡǰ̨���ֻ�����
		String tel=req.getParameter("phone");
		
		//��ȡ���Ӷ���
		String con="http://sj.apidata.cn/?mobile="+tel+"";
		URL url=new URL(con); //��������
		URLConnection uc=url.openConnection();//������
		//�ļ�������
		InputStreamReader reader=new InputStreamReader(uc.getInputStream(),"UTF-8");
		//������
		BufferedReader bf=new BufferedReader(reader);
		StringBuilder sb=new StringBuilder();  
		String line="";
		while((line=bf.readLine())!=null)
		{
			sb.append(line);
		 
		}
		
		//����json
		//Result result=JSONObject.parseObject(sb.toString()).get("data","province","city","isp");
		req.setAttribute("result", "result");
		req.getRequestDispatcher("result.jsp").forward(req, resp);
		
		
	
		
	}

}
