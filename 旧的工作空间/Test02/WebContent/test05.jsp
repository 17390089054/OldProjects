<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
request:<%=request.getAttribute("msg") %><br/>
session:<%=session.getAttribute("msg") %><br/>
application:<%=application.getAttribute("msg") %><br/>
pageContext:<%=pageContext.getAttribute("msg")%><br/>
<span style="color:red;size:20px">${map.f}</span> 

</body>
</html>