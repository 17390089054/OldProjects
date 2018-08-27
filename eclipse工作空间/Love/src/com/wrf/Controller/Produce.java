package com.wrf.Controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.wrf.util.QrcodeUtil;

/** 
 * @package:      com.wrf.Controller
 * @Description:  TODO(���ɶ�ά��) 
 * @author        knight
 * @Date          2018��2��6�� ����11:05:22 
 */

@WebServlet("/produce")
public class Produce extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//�����ַ�����
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");		
			//����ǰ̨����
			String text = req.getParameter("text");
			//�����һ�εĻ���
			deleteFile("resource"+File.separator+"result"+File.separator+"result.png");
			//���ɶ�ά��
			String path=getPath(req);
			QrcodeUtil.QrcodeImg(text,path);
			//�����ɹ����ض�ά��ͼƬ��ַ
			Map<String, Object>map=new HashMap<String,Object>();
			map.put("flag", true);
			map.put("path", "resource"+File.separator+"result"+File.separator+"result.png");
			//ת��Ϊjson
			Gson gson=new Gson();
			String result=gson.toJson(map);				
			PrintWriter out=resp.getWriter();
			out.print(result);
			out.flush();
			out.close();
			
	}
	public String getPath(HttpServletRequest req){
		String path="";
		path=req.getServletContext().getRealPath("resource"+File.separator+"result"+File.separator+"result.png");
		return path;
	}
	/** ��������ļ�
	 * @param FileName
	 * @return 
	 */
	public void deleteFile(String FileName){
		File file=new File(FileName);
		if(file.exists()&&file.isFile()){
			if(file.delete()){
				System.out.println("ɾ���ļ�"+FileName+"�ɹ�!");
			}
		}else{
			System.out.println("ɾ���ļ�"+FileName+"�ɹ�!");
		}
	}
}
