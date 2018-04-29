package com.wrf.Translate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.tz.util.TransApi;

@WebServlet("/Translate.do")
public class Translate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码方式
		
		request.setCharacterEncoding("utf-8");
		String text=request.getParameter("text");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		//将字符串类型数据转化为JSON格式
		JSONObject object=new JSONObject(trans(text, from, to));
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(object);;
		System.out.println(object);
		
		
	}
	public static String trans(String text,String from,String to)
	{
		TransApi api=new TransApi("20170311000042048","FTMfX96LmQhL2feHpVXG");
		String TransResult=api.getTransResult(text, from, to);
		return TransResult;
	}

}
