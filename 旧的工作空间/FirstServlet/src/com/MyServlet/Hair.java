package com.MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/Hair" },
loadOnStartup=-1,name="Hair",displayName="my servlet program!")
public class Hair extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public Hair() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Servlet程序</title></head>");
		out.print("<body>");
		out.print("<h1>一个简单的Servlet程序</h1>");
		out.print("<p>您好，欢迎访问!");
		out.print("</body>");
		out.print("</html>");
		out.flush();
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
