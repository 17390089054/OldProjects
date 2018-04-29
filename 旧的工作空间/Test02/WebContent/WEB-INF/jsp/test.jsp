<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
web-inf下的文件
 <%
//response.sendRedirect("WEB-INF/Test02.jsp");
request.getRequestDispatcher("Test02.jsp").forward(request, response); %> 

</body>
</html>