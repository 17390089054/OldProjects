package com.tz.idcard.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/***
 * 文件上传类
 * @author knight
 *
 */
@WebServlet("/fileUpload")
public class Upload extends HttpServlet  {
	//获取上传文件 前后台数据交互
	//1.继承HttpServlet类
	//2.定义访问路径
	//3.定义交互方法
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName=null;
		//判断是否为文件上传表单
		boolean flag=ServletFileUpload.isMultipartContent(request);
		try
		{
			if(flag)
			{
								
			//构建文件上传对象
			 DiskFileItemFactory factory=new DiskFileItemFactory();
			 ServletFileUpload upload=new  ServletFileUpload(factory);
				 //创建迭代器
			Iterator<FileItem>items= upload.parseRequest(request).iterator();
				while(items.hasNext())
				{
					FileItem item=items.next();
					fileName=item.getName();
					//定义文件上传路径
					String filePath=request.getRealPath("upload");
					File file=new File(filePath);
					//文件是否存在  不存在则创建
					if(!file.exists())
					{
						file.mkdirs();
					}
					//上传文件
					File upLoadFile=new File(filePath+"/"+fileName);
					item.write(upLoadFile);
					
				}
			}
		
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		response.getWriter().print("upload/"+fileName);
		 
	}
	
}
