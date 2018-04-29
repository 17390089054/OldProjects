package com.wrf.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConnectorParser {
	public static void main(String[] args) {
		try {
			//获取解析器
			SAXReader reader=new SAXReader();
			//解析xml文档 获取document【org.dom4j】对象树
			Document document =reader.read("config/server.xml");
			//connector节点xpath路径：server/service/connector
			//connector节点xpath路径：server//connector
			//connector节点xpath路径：//connector
			Element element=(Element)document.selectObject("server/service/connector");
			//获取connector的port属性
			Attribute attribute=element.attribute("port");
			String port=attribute.getStringValue();
			System.out.println(port);
			//直接获取port属性的value值
			System.out.println(element.attributeValue("port"));			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
