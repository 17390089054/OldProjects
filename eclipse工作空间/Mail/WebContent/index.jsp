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
	<meta charset="GBK">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="Email,邮件">
	<meta name="description" content="Java开发邮件发送系统">
	<title>QQ邮箱</title>
	<style>
		*{padding:0px;margin:0px;}
		html,body{height:100%;width:100%;
			background:url(resource/img/2.jpg) no-repeat;background-size:100% 100%;
		}
		/*header start*/
		.header{
			width:100%;
			
		}
		.banner{
			width:90%;
			margin:5px auto;
		}
		.banner span{
			display:block;
			float:right;
			line-height:100px;
			font-size:30px;
			color:#818181;
			font-weight:700;
		}
		/*header end*/

		/*mail start*/
		.mail{
			width:100%;
						
		}
		.mail .top{
			width:30%;
			margin:20px auto;
			
		}
		.mail .top .fm{
			
			width:80%;
			margin:10px auto;
			padding:10px;
		}
		/*输入框*/
		input{
			width:320px;
			display:block;
			border-radius:5px solid #666;
			height:30px;
			outline:none;
			margin:10px;
			font-size:15px;
		}
		/*文本框*/
		textarea{
			display:block;
			margin-left:10px;
			margin-top:8px;
			text-indent:20px;
			outline:none;
			
		}
		/*按钮*/
		.btn{
			width:320px;
			color:#fff;
			background-color:#00ccff;
			font-size:25px;
			border-radius:5px;
			margin-top:25px;
			height:50px;
			display:block;
			box-shadow:0 0 10px #666;	
			padding:5px;	
		}
		.btn:active{
			box-shadow:0 0 0px #fff;
		}
		/*标签*/
		label{
			color:#666;
			font-weight:700;
		}
		/*错误信息提示文本*/
		.error{
			font-size:25px;
			color:#cccc99;
		}
	/*mail end*/

	</style>
</head>
<body>
	<!--header start-->
	<div class="header">
		<div class="banner">
			<img src="resource/img/logo.jpg" width="180px" height="120px" alt="logo">
			<span>JAVA开发邮件群发系统</span>
		</div>
	</div>
	<!--header end-->
	<!--mail start-->
	<div class="mail">
		<div class="top">
			<div class="fm">
				<!--form start-->
				<form action="mail" method="post" id="myForm">
					<p>
						<label>收件人:</label>
						<input type="text" name="recipient" class="text" onfocus="cleanError()">
					</p>
					<p>
						<label>主&nbsp;&nbsp;题:</label>
						<input type="text" name="title" class="text" onfocus="cleanError()">
					</p>
					<p>
						<label>内&nbsp;&nbsp;容:</label>
						<textarea rows="10" cols="48" name="content" onfocus="cleanError()"></textarea>
					</p>
					<p>
						<input type="button" class="btn" value="发 送" onclick="send()"/>
					</p>
					
				</form>
				<!--form end-->
				<span class="error"></span>
			</div>
		</div>
	</div>
	<!--mail end-->
	
	
	<script src="resource/js/jquery-1.11.1.min.js"></script>
	<script>
		//提交表单主方法
		function send(){
			/*接收前台数据*/
			var rec=$("input[name='recipient']").val();
			var title=$("input[name='title']").val();
			var content=$("textarea").val();
			//判空
			if(!$.trim(rec)){
				$(".error").html("收件人不能为空!");
				return;
			}else{
					var email=$.trim(rec);
					if(email.split(",")==-1){
						if(!isEmail(email)){
							$(".error").html("email格式不正确!");
							return;
						}
					}
					else{						
							var arr=email.split(",");
							console.log(arr);
							for(var i=0;i<arr.length;i++){
								if($.trim(arr[i])==""||!isEmail(arr[i])){
									$(".error").html("email格式不正确!");
									return;
								}
							}
						}	
				} 
			
			
			if(!$.trim(title)){
				$(".error").html("标题不能为空!");
				return;
			}

			if(!$.trim(content)){
				$(".error").html("内容不能为空!");
				return;
			}
		//提交表单
		$("#myForm").submit();

		}
		
		//验证邮箱是否正确
		function isEmail(str){
			//正则校验邮箱格式	
			/*/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/;*/		
			var regExpression=/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
			if(regExpression.test(str)){
				return true;
			}		
				return false;		
		}
		
		
		//清除错误信息
		function cleanError(){
			$(".error").html("");
		}
		//按回车键提交表单
		$(document).keydown(function(e){
			if(e.keyCode==13){
				send();				
			}
		})

	</script>
</body>
</html>	