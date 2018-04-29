package com.wrf.xml;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * XML4j 读取xml文件 
 * @author knight
 */
public class XMLTest {

	public static void main(String[] args) {
		try {
			//定义解析器
			SAXReader reader=new SAXReader();
			//读取xml文件至内存 并生成document[org.dom4j]对象树
			Document document=reader.read("config/students.xml");
			//获取根节点
			Element root=document.getRootElement();	
			//遍历根节点
			for(Iterator<Element>itr=root.elementIterator();itr.hasNext();)
			{
			//开始遍历根节点
				Element rootItr=itr.next();
				for(Iterator<Element>itr2=rootItr.elementIterator();itr2.hasNext();)
				{
					//输出每个节点内容
					System.out.println(itr2.next().getStringValue());
				}
				System.out.println("=============");			
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
