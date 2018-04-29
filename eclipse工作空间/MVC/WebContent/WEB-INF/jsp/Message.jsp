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
<link href="resource/bootstrap.css" rel="stylesheet">
<title>信息提示</title>
<style>
*{padding:0px;margin:0px;}
html,body{height:100%;width:100%}
</style>
</head>
<body>
<form action="${requestScope.url}" method="get">
<div align="center" style="margin:0 auto;">
<h1 style="font-size:25px;color:coffee">${requestScope.msg}</h1>
<br/></br>
<button class="btn btn-info">确 定</button>
</div>
</form>
</body>
</html>