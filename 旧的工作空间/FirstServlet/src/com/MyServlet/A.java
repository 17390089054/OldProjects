package com.MyServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A
 */
@WebServlet("/A")
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		//response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
	String number=new String(request.getParameter("number").getBytes("ISO-8859-1"),"UTF-8");
	String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
	String author=new String(request.getParameter("author").getBytes("ISO-8859-1"),"UTF-8");
	String price=new String(request.getParameter("price").getBytes("ISO-8859-1"),"UTF-8");
	out.write("<h2>ͼ����Ϣ��ӳɹ�</h2><br><hr>");
	out.write("ͼ����:"+number+"<br>");
	out.write("ͼ������:"+name+"<br>");
	out.write("ͼ������:"+author+"<br>");
	out.write("ͼ��۸�:"+price+"<br>");
	out.flush();
	out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
