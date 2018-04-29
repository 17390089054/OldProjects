package com.wrf.Upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload.do")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/JSP/Upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//接受二进制流形式数据
		/*String user_name=request.getParameter("user_name");
		String user_picture=request.getParameter("user_picture");*/
		//存储控件的name 和 value
		Map<String,Object>map=new HashMap<String,Object>();
		//1.判断当前请求是否为上传
		boolean flag=ServletFileUpload.isMultipartContent(request);
		String realpath="/resource/Upload";
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
			
			request.getRequestDispatcher("WEB-INF/JSP/test.jsp").forward(request, response);
		}
		else
		{
			System.out.println("该请求非上传");
		}
		
		System.out.println(map);
	}

}
