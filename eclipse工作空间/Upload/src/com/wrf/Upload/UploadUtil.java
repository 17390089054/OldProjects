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
 * @Description:  �ϴ�������
 * @author        knight
 * @Date          2017��11��15�� ����2:29:12 
 */
public class UploadUtil {
	
	/**
	 * ���췽��˽�л� ��ʹ֮�޷�ʵ���� ֻ��ͨ���������� ��Լ�ռ�
	 */
	private UploadUtil(){};
	/**
	 *�ϴ�����
	 * @param request ����
	 * @param realpath �ϴ�·��
	 * @return Map<String,Object>map
	 * @throws IOException 
	 */
	
	public static Map<String,Object> Upload(HttpServletRequest request,String realpath) throws IOException
	{	
		//�洢�ؼ���name �� value
				Map<String,Object>map=new HashMap<String,Object>();
				//1.�жϵ�ǰ�����Ƿ�Ϊ�ϴ�
				boolean flag=ServletFileUpload.isMultipartContent(request);
				
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
									map.put(fieldname+"_old", filename);
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
					
				}
				else
				{
					System.out.println("��������ϴ�");
				}
				
				return map;
			}
			
	

}
