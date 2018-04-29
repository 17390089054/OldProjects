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
<title>QQ一键登录</title>
<style>
*{padding:0px;margin:0px;}
html,body{height:100%;width:100%}
</style>
</head>
<body>
	<a href="/qqLogin">一键登录</a>
</body>
</html>