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
 * @Description:  TODO(文件上传工具类) 
 * @author        knight
 * @Date          2018年2月1日 下午10:45:41 
 */
public class UploadUtil {
	/**
	 * 文件上传工具类
	 * @param request
	 * @param response
	 * @return Map<String,Object>
	 */
	public static Map<String,Object>Upload(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object>map=new HashMap<>();
		String fileName="";
		
		try {
			//设置字 符编码
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			//获取文件上传路径
			String path=request.getSession().getServletContext().getRealPath(File.pathSeparator);
			//定义文件上传地址
			String uploadPath=path+"/resource/upload";
			File file=new File(uploadPath);
			//文件不存在则创建
			if(!file.exists())
			{
				file.mkdirs();
			}
			//创建文件上传工厂
			FileItemFactory factory=new DiskFileItemFactory();
			//定义上传对象
			ServletFileUpload upload=new ServletFileUpload();
			//解析请求
			List<FileItem> list=upload.parseRequest(request);
			//迭代遍历
			if(list!=null)
			{
				Iterator<FileItem>it=list.iterator();
				while(it.hasNext())
				{
					//逐个读取对象
					FileItem item=it.next();
					//判断是否为表单域
					if(item.isFormField())
					{
						continue;
					}
					else{
						//获取文件名
						String name=item.getName();
						//获取文件后缀名
						String sub=name.substring(name.lastIndexOf("."),name.length());
						//生成新的文件名
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
