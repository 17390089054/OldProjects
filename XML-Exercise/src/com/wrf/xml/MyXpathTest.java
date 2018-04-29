package com.wrf.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MyXpathTest {

	public static void main(String[] args) {
		try {
			//创建解析工厂
			DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
			//创建解析器
			DocumentBuilder builder=documentBuilderFactory.newDocumentBuilder();
			//解析文档  生成document【org.w3c.dom】对象树
			Document document=builder.parse("config/bookstore.xml");
			//创建Xpath对象
			XPath xPath=XPathFactory.newInstance().newXPath();
			/*
			 * 1.0 获取bookstore下book属性category值为web下的第二个的title的文本内容
			bookstore->book[@category='web'][2]->title
			xPath路径:/bookstore/book[@category='web'][2]/title/text()
			*/
			//解析文档
			String titleExpression="/bookstore/book[@category='web'][2]/title/text()";
			String title=(String)xPath.evaluate(titleExpression, document, XPathConstants.STRING);		
			System.out.println(title);
			
			/*2.0 获取bookstore下book属性category值为web下的title属性lang为en的文本内容
			bookstore->book[@category='web']->title[@lang='en']
			xpath路径：/bookstore/book[@category='web']/title[@lang='en']/text()
			*/
			String titleLangExpression="/bookstore/book[@category='web']/title[@lang='en']/text()";
			String titleLang=(String)xPath.evaluate(titleLangExpression, document, XPathConstants.STRING);
			System.out.println(titleLang);
			
			/*3.0 获取bookstore下book属性category值为cooking下的title的lang属性值
			bookstore->book[@category='cooking']->title->@lang
			xPath路径:/bookstore/book[@category='cooking']/title/@lang
			*/
			String titleLangAttr="/bookstore/book[@category='cooking']/title/@lang";
			String titleAttr=(String)xPath.evaluate(titleLangAttr, document, XPathConstants.STRING);
			System.out.println(titleAttr);
			
			/*4.0 获取bookstore下的所有book节点集合
			Xpath路径:/bookstore/book
			*/
			String books="/bookstore/book";
			NodeList list=(NodeList) xPath.evaluate(books, document, XPathConstants.NODESET);
			//遍历list
			for(int i=0;i<list.getLength();i++)
			{
				//解析单个元素
				Element elt=(Element)list.item(i);
				String titlelist=(String)xPath.evaluate("title", elt,XPathConstants.STRING);
				String author=(String)xPath.evaluate("author", elt,XPathConstants.STRING);
				String year=(String)xPath.evaluate("year", elt,XPathConstants.STRING);
				String price=(String)xPath.evaluate("price", elt,XPathConstants.STRING);
				System.out.println(titlelist+" "+author+" "+year+" "+price);
				System.out.println("====================");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
