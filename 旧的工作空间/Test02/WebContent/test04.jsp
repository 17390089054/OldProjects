<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
<%
	//JSP内置九大对象
	//request response out application session page pageContext config exception 
	request.setAttribute("msg","request的内容");
	session.setAttribute("msg", "session的内容");
	 application.setAttribute("com.msg","Appication的内容");
	pageContext.setAttribute("msg", "pageContext的内容"); 
	
	Map<String,Object>map=new HashMap<String,Object>();
	map.put("f",25);
	session.setAttribute("map", map);
	
	
	
	
	
	//response.sendRedirect("test05.jsp");
	request.getRequestDispatcher("test05.jsp").forward(request,response);
%>


<span style="color:red;size:20px">${requestScope.msg}</span> 
<span style="color:red;size:20px">${applicationScope['com.msg']}</span> 

<span style="color:red;size:20px">${map.f}</span> 

<%-- request:<%=request.getAttribute("msg") %><br/>
session:<%=session.getAttribute("msg") %><br/>
application:<%=application.getAttribute("msg")%><br/>
pageContext:<%=pageContext.getAttribute("msg")%><br/> --%>

<%-- <%request.getRequestDispatcher("test05.jsp").forward(request, response); %>
 --%>

</body>
</html>