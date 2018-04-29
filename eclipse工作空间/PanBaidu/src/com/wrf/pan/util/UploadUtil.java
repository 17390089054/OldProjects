package com.wrf.pan.util;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/** 
 * @package:        com.wrf.pan.util
 * @Description:  TODO(�ļ��ϴ�������) 
 * @author        knight
 * @Date          2018��2��1�� ����10:45:41 
 */
public class UploadUtil {
	/**
	 * �ļ��ϴ�������
	 * @param request
	 * @param response
	 * @return Map<String,Object>
	 */
	public static Map<String,Object>Upload(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object>map=new HashMap<>();
		String fileName="";
		
		try {
			//������ ������
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//��ȡ�ļ��ϴ�·��
			String path=request.getSession().getServletContext().getRealPath(File.pathSeparator);
			//�����ļ��ϴ���ַ
			String uploadPath=path+"/resource/upload";
			File file=new File(uploadPath);
			//�ļ��������򴴽�
			if(!file.exists())
			{
				file.mkdirs();
			}
			//�����ļ��ϴ�����
			FileItemFactory factory=new DiskFileItemFactory();
			//�����ϴ�����
			ServletFileUpload upload=new ServletFileUpload();
			//��������
			List<FileItem> list=upload.parseRequest(request);
			//��������
			if(list!=null)
			{
				Iterator<FileItem>it=list.iterator();
				while(it.hasNext())
				{
					//�����ȡ����
					FileItem item=it.next();
					//�ж��Ƿ�Ϊ����
					if(item.isFormField())
					{
						continue;
					}
					else{
						//��ȡ�ļ���
						String name=item.getName();
						//��ȡ�ļ���׺��
						String sub=name.substring(name.lastIndexOf("."),name.length());
						//�����µ��ļ���
						 fileName=new Date().getTime()+sub;
						File saveFile=new File(file,fileName);
						
						map.put("name", name);
						map.put("newName", fileName);
						map.put("size", item.getSize());
						map.put("url",uploadPath+fileName);
					}		
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
				
	

}
