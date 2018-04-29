<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
*{padding:0px;margin:0px;}
html,body{height:100%;width:100%}
</style>
</head>
<body>
姓名:${map.user_name }<br/>
年龄:${map.user_age }<br/>
性别:${map.user_sex }<br/>
<img src="${map.user_picture}" /><br/>
<a href="${map.user_picture }" download="${map.user_picture_old}">点击下载</a>
</body>
</html>