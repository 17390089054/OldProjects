package com.wrf.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/** 
 * @package:        com.wrf.Practice
 * @Description:    数据抓取核心类 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017年10月27日 下午9:34:13 
 */
public class DataDownUtil {
/*
 * 1.获取源代码
 * 2.解析源代码
 * 3.数据筛选
 * 4.数据存储
 */
	public static String getHtmlResource(String url,String encoding) 
	{
		InputStreamReader input=null;
		BufferedReader bf=null;
		StringBuilder sb=new StringBuilder();
		
		try
		{
		//建立网络链接
		URL Url=new URL(url);
		//打开网络链接
		URLConnection con=Url.openConnection();
		//读取源码
		input=new InputStreamReader(con.getInputStream(),encoding);
		//高效率读取源码           
		bf=new BufferedReader(input);
		//字符串操作类
		
		String line="";
		while((line=bf.readLine())!=null)
		{
			sb.append(line+"\n");
			
		}
		}
		catch(Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		finally
		{
			try {
				bf.close();
				input.close();
			} catch (IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
			
			
		}
	
	
		
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param url
	 * @param encoding
	 * @return
	 */
	public static List<HashMap<String,String>> GetInfo(String url,String encoding)
	{
		
		//定义一个List集合用与于存储查询结果
		List<HashMap<String,String>>list=new ArrayList<HashMap<String,String>>();

		//获取下载页面
		String html=getHtmlResource(url, encoding);
		//解析页面
		Document document=Jsoup.parse(html);
		//获取酒店列表
		Element element=document.getElementById("hotel_list");
		//获取hotel_listz中的酒店集合
		Elements elements=document.getElementsByClass("hotel_new_list");
		//forEach循环变历集合
		for (Element element2: elements)
		{
			//获取图片链接
			String img=element2.getElementsByTag("img").attr("src");
			//获取酒店名称信息
			String name=element2.getElementsByTag("img").attr("alt");
			//获取酒店位置
			String place=element2.getElementsByClass("hotel_item_htladdress").text();
			//存入map 添加到list集合中
			//定义一个Map用于临时存储
			HashMap<String,String>map=new HashMap<String,String>();
			map.put("img",img);
			map.put("name", name);
			map.put("place", place);
			list.add(map);			
		}
	
		return list;
	}
	
	
	
	
	
/*	public static void main(String[] args) {
		List<HashMap<String,String>>list=GetInfo("http://hotels.ctrip.com/hotel/shanghai2#ctm_ref=ctr_hp_sb_lst","utf-8");
		for(HashMap<String,String>map:list)
		{
			System.out.println(map.get("img"));
			System.out.println(map.get("name"));
			System.out.println(map.get("place"));
			System.out.println("===============");
			
		}
		
		
		
	}*/
	
	
	
}
