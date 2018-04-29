<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<base href="<%=basePath%>">
	<head>
		<meta charset="GBK">
		<title>JAVA开发表白系统</title>
		<meta name="keywords" content="表白,爱情">
		<meta name="description" content="JAVA开发二维码表白系统">
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			
			html,body{
				height:100%;
				width:100%;
				background:url("resource/img/5.jpg") no-repeat;
				background-size:100% 100%;
				overflow:hidden;
			}
			/*信息栏*/
			h1{
				font-size:26px;
				text-align:center;
				font-weight:700;
				/*线性渐变*/
				background:-webkit-linear-gradient(45deg,#ffcc00,#ff6699,#ebdf72,#8de265,#71e3e3,#6688e3,#914eda,#da27a9);
				/*文本按照背景图的颜色渐变*/
				color:transparent;-webkit-background-clip:text;
				animation:randombackground 30s linear infinite;
				
			}
			/*box start*/
			.box{
				width:400px;				
				/*background:#22b7cc;*/
				margin:100px auto;
				text-align:center;
				line-height:100px;
			}
			/*输入框*/
			.box .text{
				width:300px;
				height:120px;
				text-indent:20px;
				font-size:18px;
				color:#666;
				border-radius:5px;
			}
			/*提交按钮*/
			.box input{
					width:300px;
					height:50px;
					border-radius:8px;
					font-size:25px;
					color:#fff;
					outline:none;
					background:#74d3de;
					text-align:center;
					line-height:50px;
					cursor:pointer;
					box-shadow:1px 2px 15px #000;
			}
			.box input:active{
				box-shadow:0px 0px 5px #000;
			}
			/*box end*/
			@keyframes randombackground{
				from{background-position:0 0;}
				to{background-position:2000px 0;}
			}
			
		</style>
	</head>
	<body>
		<!--box start-->
		<div class="box" >
			<h1>JAVA开发爱的二维码扫一扫</h1>
			<textarea class="text"></textarea>
			<input type="button" value="生成爱的二维码"/>
		</div>
		<!--box end-->
		
		<script type="text/javascript" src="resource/js/jquery.min.js"></script>
		<script type="text/javascript">
		/*随机更换背景图片*/
		setInterval(changeBackground,3000);
		function changeBackground(){
			var num=parseInt(Math.random()*10);
			
			$("body").css("background-image","url(resource/img/"+num+".jpg)");
			$("body").css({"background-size":"100% 100%","overflow":"hidden"});
		}
		$(":input").on("click",function(){
			var text=$(".text").val();
			if(text!=""){
				$(".text").val("");
				 $.ajax({
					url:"produce",
					method:"POST",
					dataType:"json",
					data:{"text":text},
					success:function(data){
						 if(data.flag){
							 console.log(data.path);
							window.top.location.href="result.jsp";							
						}  
					} 
				});
			}
			else
			{
				$(".text").focus();
			}
			
		});
			
		</script>
	</body>
</html>