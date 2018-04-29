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
		//���ܶ���������ʽ����
		/*String user_name=request.getParameter("user_name");
		String user_picture=request.getParameter("user_picture");*/
		//�洢�ؼ���name �� value
		Map<String,Object>map=new HashMap<String,Object>();
		//1.�жϵ�ǰ�����Ƿ�Ϊ�ϴ�
		boolean flag=ServletFileUpload.isMultipartContent(request);
		String realpath="/resource/Upload";
		if(flag)
		{
			//2.��ȡ������·��
			String path=request.getServletContext().getRealPath(realpath);
			File file=new File(path);
			//3.�ж��ļ�Ŀ¼�Ƿ���� �������򴴽�
			if(!file.isDirectory())
			{
				file.mkdirs();
			}
			//4.���������ļ�����
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//5.�����ļ��ϴ�����
			ServletFileUpload upload=new ServletFileUpload(factory);
			InputStream input=null;
			OutputStream output=null;
			//6.�����ϴ�����
			try {
				//7.��ȡ��������
				List<FileItem> filelist=upload.parseRequest(request);
				//8.������������������
				Iterator<FileItem> fileitem=filelist.iterator();
				//9.��ȡǰ�˿ؼ�nameֵ
				while(fileitem.hasNext())
				{
					FileItem File=fileitem.next();
					//10.��ȡinput�ؼ���
					String fieldname=File.getFieldName();
					//11.��ȡ����������
					input=File.getInputStream();
					//12.�ж��Ƿ�Ϊ��ͨ�ؼ�s ����ת��ΪString
					if(File.isFormField())//�ı�
					{
						String value=Streams.asString(input,"utf-8");
						map.put(fieldname, value);
						
					}
					else//�ļ�����
					{
						//13.�����ļ��������µ��ļ�
						String filename=File.getName();
						
						if(filename!=null&&filename.trim().length()>0)
						{
							//14.��ȡ�ļ���׺��
							String exc=FilenameUtils.getExtension(filename);
							//15.�����µ��ļ���
							String new_name=UUID.randomUUID()+"."+exc;
							//16.outputStreamд���ļ� �߶���д
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
							System.out.println("��δѡ���ļ�");
						}
					}
					
					
				}
					
				
			} catch (FileUploadException e) {
				System.out.println("����������"+e.getMessage());
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
			System.out.println("��������ϴ�");
		}
		
		System.out.println(map);
	}

}
