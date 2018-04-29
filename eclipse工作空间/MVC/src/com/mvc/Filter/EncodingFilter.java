package com.mvc.Filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*.do")
public class EncodingFilter implements Filter{
	String encoding="utf-8"; 
	@Override
	public void destroy() {
		
		System.out.println("过滤器已删除");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		String method=request.getMethod();
		if(method.equalsIgnoreCase("POST"))
		{
			
			request.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(req, resp);
		/*System.out.println("字符编码过滤器放行后");*/
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		if(config.getInitParameter("encoding")!=null)
		{
			encoding=config.getInitParameter("encoding");
		}
	
		
		System.out.println("过滤器创建");
	}
	

}
