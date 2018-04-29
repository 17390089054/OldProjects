package com.wrf.Filter;

import java.io.IOException;
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
			if(path.endsWith("/Login.do"))
			{
				chain.doFilter(req, resp);
			}
			else
			{
				response.sendRedirect("Login.do");
			}
			
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
