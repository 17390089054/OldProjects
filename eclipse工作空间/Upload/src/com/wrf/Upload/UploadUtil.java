package com.wrf.Upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

/** 
 * @package:      com.wrf.Upload
 * @Description:  上传工具类
 * @author        knight
 * @Date          2017年11月15日 下午2:29:12 
 */
public class UploadUtil {
	
	/**
	 * 构造方法私有化 ，使之无法实例化 只能通过类名调用 节约空间
	 */
	private UploadUtil(){};
	/**
	 *上传方法
	 * @param request 请求
	 * @param realpath 上传路径
	 * @return Map<String,Object>map
	 * @throws IOException 
	 */
	
	public static Map<String,Object> Upload(HttpServletRequest request,String realpath) throws IOException
	{	
		//存储控件的name 和 value
				Map<String,Object>map=new HashMap<String,Object>();
				//1.判断当前请求是否为上传
				boolean flag=ServletFileUpload.isMultipartContent(request);
				
				if(flag)
				{
					//2.获取服务器路径
					String path=request.getServletContext().getRealPath(realpath);
					File file=new File(path);
					//3.判断文件目录是否存在 不存在则创建
					if(!file.isDirectory())
					{
						file.mkdirs();
					}
					//4.创建磁盘文件工厂
					DiskFileItemFactory factory=new DiskFileItemFactory();
					//5.创建文件上传对象
					ServletFileUpload upload=new ServletFileUpload(factory);
					InputStream input=null;
					OutputStream output=null;
					//6.解析上传对象
					try {
						//7.获取解析内容
						List<FileItem> filelist=upload.parseRequest(request);
						//8.迭代器遍历解析对象
						Iterator<FileItem> fileitem=filelist.iterator();
						//9.获取前端控件name值
						while(fileitem.hasNext())
						{
							FileItem File=fileitem.next();
							//10.获取input控件名
							String fieldname=File.getFieldName();
							//11.获取输入流数据
							input=File.getInputStream();
							//12.判断是否为普通控件s 是则转换为String
							if(File.isFormField())//文本
							{
								String value=Streams.asString(input,"utf-8");
								map.put(fieldname, value);
								
							}
							else//文件数据
							{
								//13.根据文件名生成新的文件
								String filename=File.getName();
								
								if(filename!=null&&filename.trim().length()>0)
								{
									//14.获取文件后缀名
									String exc=FilenameUtils.getExtension(filename);
									//15.生成新的文件名
									String new_name=UUID.randomUUID()+"."+exc;
									//16.outputStream写入文件 边读边写
									 output=new FileOutputStream(path+"/"+new_name);
									byte [] b=new byte [1024];
									int len=-1;
									while((len=input.read(b))!=-1)
									{
										output.write(b, 0, len);
									}						
									map.put(fieldname, realpath+"/"+new_name);
									map.put(fieldname+"_old", filename);
								}
								else
								{
									System.out.println("尚未选择文件");
								}
							}
							
							
						}
							
						
					} catch (FileUploadException e) {
						System.out.println("解析出错了"+e.getMessage());
						e.printStackTrace();
					}
					finally
					{
						if(input!=null)
						{
							input.close();
						}
						
						if(output!=null)
						{
							output.close();
						}
					}
					
				}
				else
				{
					System.out.println("该请求非上传");
				}
				
				return map;
			}
			
	

}
