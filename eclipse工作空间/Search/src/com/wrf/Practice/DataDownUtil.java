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
 * @Description:    ����ץȡ������ 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017��10��27�� ����9:34:13 
 */
public class DataDownUtil {
/*
 * 1.��ȡԴ����
 * 2.����Դ����
 * 3.����ɸѡ
 * 4.���ݴ洢
 */
	public static String getHtmlResource(String url,String encoding) 
	{
		InputStreamReader input=null;
		BufferedReader bf=null;
		StringBuilder sb=new StringBuilder();
		
		try
		{
		//������������
		URL Url=new URL(url);
		//����������
		URLConnection con=Url.openConnection();
		//��ȡԴ��
		input=new InputStreamReader(con.getInputStream(),encoding);
		//��Ч�ʶ�ȡԴ��           
		bf=new BufferedReader(input);
		//�ַ���������
		
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
		
		//����һ��List���������ڴ洢��ѯ���
		List<HashMap<String,String>>list=new ArrayList<HashMap<String,String>>();

		//��ȡ����ҳ��
		String html=getHtmlResource(url, encoding);
		//����ҳ��
		Document document=Jsoup.parse(html);
		//��ȡ�Ƶ��б�
		Element element=document.getElementById("hotel_list");
		//��ȡhotel_listz�еľƵ꼯��
		Elements elements=document.getElementsByClass("hotel_new_list");
		//forEachѭ����������
		for (Element element2: elements)
		{
			//��ȡͼƬ����
			String img=element2.getElementsByTag("img").attr("src");
			//��ȡ�Ƶ�������Ϣ
			String name=element2.getElementsByTag("img").attr("alt");
			//��ȡ�Ƶ�λ��
			String place=element2.getElementsByClass("hotel_item_htladdress").text();
			//����map ��ӵ�list������
			//����һ��Map������ʱ�洢
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
