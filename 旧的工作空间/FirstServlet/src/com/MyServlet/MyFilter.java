package com.MyServlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/MyFilter")
public class MyFilter implements Filter {
		String encoding=null;
    public MyFilter() {
    }

	
	public void destroy() {
		encoding=null;
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(encoding!=null)
		{
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
			
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("encoding");
	}

}
