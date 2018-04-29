package com.wrf.xml;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class SystemConfigParse {	
	public static void main(String[] args) {
		try {
			//获取解析器
			SAXReader reader=new SAXReader();
			//解析文档获取document【org.dom4j】对象树
			Document document=reader.read("config/config.xml");
			//解析节点元素
			//driver-name节点 config-->database-info->driver-name
			//driver-name xpath路径: /config/database-info/driver-name
			Element configElt=(Element) document.selectSingleNode("/config/database-info/driver-name");
			String driverName=configElt.getStringValue();
			System.out.println(driverName);
			
			//url节点 config->database-info->url
			//url节点xpath路径: /config/database-info/url
			//url节点xpath路径: //url			
			//url节点xpath路径: config//url
			Element urlElt=(Element)document.selectSingleNode("/config//url");
			String url=urlElt.getStringValue();
			System.out.println(url);
			
			//user节点xpath路径 config/database-info/user
			//user节点xpath路径 config/user
			//user节点xpath路径 //user
			Element userElt=(Element)document.selectSingleNode("//user");
			String user=userElt.getStringValue();
			System.out.println(user);
			
			//password节点xpath路径: config/database-info/password
			//password节点xpath路径://password
			//password节点xpath路径:config//password
			Element passwordElt=(Element)document.selectObject("//password");
			String password=passwordElt.getText();
			System.out.println(password);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
