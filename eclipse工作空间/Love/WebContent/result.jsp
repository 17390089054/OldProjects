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
<title>结果扫描</title>
<style>
	*{padding:0px;margin:0px;}
	html,body{
		height:100%;
		width:100%;
		background:url("resource/img/timg.jpg") no-repeat;
		background-size:100% 100%;
		overflow:hidden;
	}
	.result{
		width:200px;
		height:200px;
		background-color:#fff;
		margin:220px auto;
		padding:30px;
	}
	 h1{
		margin:10px auto;
		display:block;
		text-align:center;
		color:skyblue;
	}
	.result img{
		margin: auto;
		display:block;
		
		
	}
	
</style>
</head>
<body>
	<div class="result">
		<h1>爱的二维码</h1>
		<img src="resource/result/result.png">
	</div>
	<audio src="resource/music/Beyond - 真的爱你.mp3" autoplay></audio>
	
</body>
</html>