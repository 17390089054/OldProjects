package com.wrf.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * @package:        com.wrf.test
 * @Description:  TODO(������һ�仰�����������������) 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017��11��8�� ����2:10:07 
 */
public class Test03 {
	public static void main(String[] args) {
		//File file=new File("D://Program Files/Microsoft Office/Templates/2052");
		String path="D://f.xml";
		File f=new File(path);
		try {
			FileWriter fw=new FileWriter(f,true);
			fw.write("����");
			fw.close();
			System.out.println("д��ɹ�!");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		//Search(file);
	}

	private static void Search(File file) {
		if(file.isDirectory())
		{
			File[] files=file.listFiles();
			for(File f:files)
			{
				if(f.isDirectory())
				{
					Search(f);
				}
				else
				{
					System.out.println(f);
				}
			}
			
		}
		else
		{
			System.out.println(file);
		}
	
		
	}

}
