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
 * @Description:  TODO(生成二维码) 
 * @author        knight
 * @Date          2018年2月6日 上午11:05:22 
 */

@WebServlet("/produce")
public class Produce extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//设置字符编码
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");		
			//接收前台参数
			String text = req.getParameter("text");
			//清除上一次的缓存
			deleteFile("resource"+File.separator+"result"+File.separator+"result.png");
			//生成二维码
			String path=getPath(req);
			QrcodeUtil.QrcodeImg(text,path);
			//操作成功返回二维码图片地址
			Map<String, Object>map=new HashMap<String,Object>();
			map.put("flag", true);
			map.put("path", "resource"+File.separator+"result"+File.separator+"result.png");
			//转换为json
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
	/** 清除缓存文件
	 * @param FileName
	 * @return 
	 */
	public void deleteFile(String FileName){
		File file=new File(FileName);
		if(file.exists()&&file.isFile()){
			if(file.delete()){
				System.out.println("删除文件"+FileName+"成功!");
			}
		}else{
			System.out.println("删除文件"+FileName+"成功!");
		}
	}
}
