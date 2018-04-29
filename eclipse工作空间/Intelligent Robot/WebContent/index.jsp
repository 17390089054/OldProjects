<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML>
<html>
	<base href="<%=basePath%>">
	<head>
		<meta charset="utf-8">
		<title>人工智能语音小助手</title>
		<meta name="keywords" content="人工智能 语音对话">
		<meta name="description" content="人工智能实现语音助手">
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			html,body{
				height:100%;
				width:100%;		
			}
			body
			{	
				background:url(resource/img/bg2.jpg);
			}
			/*header begin*/
			.header
			{
				width:100%;
				height:60px;
				background-color:#669933;
				opacity:0.85;
				font-size:30px;
				text-align:center;
				color:#fff;
				line-height:60px;
			}
			/*header end*/
			/*c-body begin*/
			.c-body
			{
				width:800px;
				height:600px;			
				margin:15px auto;
			}
			.title
			{
			width:805px;
			height:80px;
			background-color:#39db82;
			opacity:0.75;
			padding:5px auto;
			}
			.title img
			{
				margin:5px  10px;
				float:left;
			}
			.title span
			{
				font-size:30px;
				
				color:#fff;
				margin-top:25px;
				float:left;
			}

			.box
			{
				width:760px;
				height:520px;			
  				background-color:gray;
  				opacity:0.75;
 				padding:20px;
				
				
			}

			.box .chat
			{
				width:760px;
				height:450px;
				overflow:auto;
/* 				background-color:#6633cc;
 */				
			}
			.box .footer
			{
				width:760px;
				height:120px;
				
			}
			.box .footer input
			{
				height:50px;
				border-radius:5px;
				outline:none;
				border:none;
				font-size:18px;
				margin-top:20px;
			}
			.box .chat .my
			{
				width:100%;
				overflow:hidden;
				margin-top:10px;
			}
			.box .chat .robot
			{
				width:100%;
			
				overflow:hidden;
			}
			.box .chat .my span
			{
				background:url(resource/img/my.png);width:40px;height:40px;float:right;
			}
			.box  p
			{
				padding:10px;
				border-radius:5px;
				background-color:skyblue;
				max-width:220px;
				word-break:break-all;
				color:#fff;
				font-size:18px;
			}
			
			.box .chat .my p
			{
				margin-right:10px;
				float:right;
			}
			
			.box .chat .robot p
			{
				margin-left:10px;
				float:left;
			}
			
			.box .chat .robot span
			{
				background:url(resource/img/rot.png);width:40px;height:40px;float:left;
			}
			#text
			{
			
				width:640px;				
				text-indent:20px;
				float:left;
				
			}
			#btn
			{
				width:100px;
				background-color:#669999;
				color:white;
				font-size:18px;
				cursor:pointer;
				float:right;
			}

			/*c-body end*/
			
		</style>
	</head>
	<body>
		<!--header begin-->
		<div class="header">
			<b>JAVA开发人工智能语音机器人系统</b>
		</div>
		<!--header end-->

		<!--c-body begin-->
		<div class="c-body">
			<div class="title">		
					<img src="resource/img/logo.png" width="83px" height="65px" alt="图标"/>	
					<span>人工智能机器人</span>
			</div>
			<div class="box">
				<div class="chat">
					<div class="robot">
						<span></span>
						<p>想和我说点啥</p>
					</div>
					<!-- <div class="my">
						<span></span>
						<p></p>
					</div> -->
				</div>
				<div class="footer">
					<input type="text" id="text" />
					<input type="button" id="btn" value=" 发 送 " />
				</div>
			</div>

		</div>
		<!--c-body end-->
		<!-- script -->
		<script type="text/javascript" src="resource/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
		/*执行方法*/
		function check()
		{
			//获取text文本的值
			var text=$("#text").val();
			if(text=="")
			{
				text=" <br/><br/>";
			}
			//清空原内容
			$("#text").val("");
			$("#text").focus();
			//原文追加文本
			$(".chat").append("<div class='my'><span></span><p>"+text+"</p></div>");
			//自动滚动
			$(".chat").scrollTop(55555);
			//利用ajax与后台进行数据交互
			$.ajax({
					type:"POST",
					url:"Robot",
					data:{"text":text},
					success:function(result)
					{
						$("audio").remove();
						result=$.parseJSON(result);
						var text="";
						var res=result.text;
						if(result.url)
						{
							text=result.text+"<br><a href='"+result.url+"'>"+result.url+"</a>"
						}
						else
						{
							text=res;
						}
												
						
						$(".chat").append("<div class='robot'><span></span><p>"+text+"</p></div>");
						/*查找音频地址*/
						var path="http://fanyi.baidu.com/gettts?lan=zh&text="+res+"&spd=5&source=web"
						var obj="<audio src='"+path+"' autoplay></audio>";
						/*加载音频*/
						$("body").append(obj);
						$(".chat").scrollTop(55555);
					}
				});
		}
			
		/*点击触发操作*/	
			$("#btn").on("click",function(){
				check();
			});	
		/*回车键触发操作*/
		$(document).on("keydown",function(e){
			if(e.keyCode==13)
			{
				check();
			}
		
		});
		
		
		</script>
		
		<!-- script -->
	</body>
</html>