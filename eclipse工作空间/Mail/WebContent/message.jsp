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
	<title>信息提示页</title>
	<style>
		*{padding:0px;margin:0px;}
		html,body{height:100%;width:100%}
		.message{
			width:30%;
			margin:20px auto;
		}
		/*提示文字*/
		div span{
			display:block;
			margin:20px auto;
			color:lightblue;
			font-size:35px;
		}
		/*按钮*/
		.btn{
			height: 45px;
		    width: 110px;
		    color: #fff;
		    background-color: #00ccff;
		    font-size: 18px;
		    border-radius: 8px;
		    display: block;	
		}
	</style>
</head>
<body>
	<div style='width:100%'>
		<div class="message">
			<span >${msg}</span>
			<button class="btn"  onclick="javascript:window.location.href='index.jsp'">返回首页</button>							
		</div>
	</div>
</body>
</html>