package com.wrf.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 利用SAX解析xml文档并原样输出xml文档内容
 * @author knight
 */
public class MySAXParse {

	public static void main(String[] args) {	
		try {
			//创建文件解析工厂
			SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
			//创建文件解析器
			SAXParser saxParser=saxParserFactory.newSAXParser();
			//解析xml文档  parmas:文件路径+事件处理器
			saxParser.parse("config/person.xml", new MyDefaultHandler());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}	
}


/**
 * 重写DefoultHandler中的方法 事件处理器
 */

class MyDefaultHandler extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.print("<"+qName+">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print("</"+qName+">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		System.out.print(new String(ch,start,length));
	}
		
	
	
}

