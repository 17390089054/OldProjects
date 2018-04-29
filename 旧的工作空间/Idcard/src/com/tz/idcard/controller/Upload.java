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
 * �ļ��ϴ���
 * @author knight
 *
 */
@WebServlet("/fileUpload")
public class Upload extends HttpServlet  {
	//��ȡ�ϴ��ļ� ǰ��̨���ݽ���
	//1.�̳�HttpServlet��
	//2.�������·��
	//3.���彻������
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String fileName=null;
		//�ж��Ƿ�Ϊ�ļ��ϴ���
		boolean flag=ServletFileUpload.isMultipartContent(request);
		try
		{
			if(flag)
			{
								
			//�����ļ��ϴ�����
			 DiskFileItemFactory factory=new DiskFileItemFactory();
			 ServletFileUpload upload=new  ServletFileUpload(factory);
				 //����������
			Iterator<FileItem>items= upload.parseRequest(request).iterator();
				while(items.hasNext())
				{
					FileItem item=items.next();
					fileName=item.getName();
					//�����ļ��ϴ�·��
					String filePath=request.getRealPath("upload");
					File file=new File(filePath);
					//�ļ��Ƿ����  �������򴴽�
					if(!file.exists())
					{
						file.mkdirs();
					}
					//�ϴ��ļ�
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
