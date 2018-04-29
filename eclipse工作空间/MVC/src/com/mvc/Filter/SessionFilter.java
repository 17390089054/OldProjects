package com.mvc.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.do")
public class SessionFilter implements Filter {

  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) req;
		
		String path=request.getServletPath();
		HttpServletResponse response=(HttpServletResponse) resp;
		
		if(request.getSession().getAttribute("user")!=null)
		{
			chain.doFilter(req, resp);
		}
		else
		{
			if(path.endsWith("/Login.do")||path.endsWith("/Register.do"))
			{
				chain.doFilter(req, resp);
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.write("<script>alert('µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼!');window.top.location='"+request.getContextPath()+"/Login.do'</script>");
/*				response.sendRedirect(request.getScheme()+"/Login.do");*/
				out.flush();
				out.close();
			}
			
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
