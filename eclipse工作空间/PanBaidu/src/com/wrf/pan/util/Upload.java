package com.wrf.pan.util;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** 
 * @package:        com.wrf.pan.util
 * @Description:  TODO(�ٶ����ϴ���̨) 
 * @author        knight
 * @Date          2018��2��3�� ����11:46:45 
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	@Override
	protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			System.out.println(req.getParameter("file"));
			resp.getWriter().print("��������");
		
		
		}
}
