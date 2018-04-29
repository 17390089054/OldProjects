package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.UtilQuery;
/**
 * 
 * @ClassName:     WeatherAction.java
 * @Description:   调用方法
 * 
 * @author          knight
 * @version         V1.0  
 * @Date           2017年11月2日 下午11:40:21
 */
@WebServlet("/weather")
public class WeatherAction extends HttpServlet {
	private static String url="http://apis.haoservice.com/weather";
	private static String applykey="2a67947badc44b69b9bb71cce5826761";
	//private static String path="http://apis.haoservice.com/weather?cityname=长春&key=2a67947badc44b69b9bb71cce5826761";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符编码
		req.setCharacterEncoding("utf-8");
		//获取城市名称
		String cityname=req.getParameter("cityname");
		System.out.println(cityname);
		//拼接URL
		String path=url+"?cityname="+cityname+"&key="+applykey+"";
		System.out.println(path);
		//输出结果
		String result=GetWeather(path);
		System.out.println(result);
		//返回至前台页面
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(result);
		//req.setAttribute("result", result);
		//req.getRequestDispatcher("weather.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//经过post请求
		req.setCharacterEncoding("utf-8");
		String cityname=req.getParameter("cityname");
		System.out.println(cityname);
		String path=url+"cityname="+cityname+"&key="+applykey;
		String result=GetWeather(path);
		System.out.println(result);
		
	}
	

	
	public static void main(String[] args) {
		//String key="32511b6af26e46b6a933cd632be7eadc";
	/*	String url="http://www.tuling123.com/openapi/api";
		//String args2="key=32511b6af26e46b6a933cd632be7eadc&info=";
		Map<String,String>map=new HashMap<String,String>();
		map.put("key", "32511b6af26e46b6a933cd632be7eadc");
		map.put("info", "hello");
		String s=UtilQuery.OpenUrl(url, map, "get");*/
		String path="http://apis.haoservice.com/weather?cityname=长春&key=2a67947badc44b69b9bb71cce5826761";
		System.out.println(GetWeather(path));
		//System.out.println(s);
	}
	
	
	public static String GetWeather(String path)
	{
		StringBuilder sb=new StringBuilder();
		BufferedReader bf=null;
		
		try {
			URL url=new URL(path);
			URLConnection uc=url.openConnection();
			InputStreamReader input=new InputStreamReader(uc.getInputStream(),"utf-8");
			bf=new BufferedReader(input);
			String line="";
			while((line=bf.readLine())!=null)
			{
				sb.append(line);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(bf!=null)
			{
				try {
					bf.close();
					
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			}
		}
		
		
		return sb.toString();
	}
	

}
