<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码接收</title>
<style>
*{margin:0px;padding:0px;}
html,body
{
	width:100%;height:100%;
}
</style>
</head>
<body>
<body>

手机号:<input type="text" maxlength=11 id="telephone" placeholder=" 请 输 入 你 的 手 机 号  "/>
<input type="button"  value="获取验证码" onclick="sendCode();"/>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">


//定义一个方法发送验证码
function sendCode(){
	var telephone=$("#telephone").val();
//利用ajax获取手机号
$.ajax({
		//数据上传路径
		url:"callCode",
		//上传的方式
		type:"post",
		//上传的数据
		data:{"telephone":telephone},
		//返回参数
		success:
			function(code)		
			{			
			console.log(code);			
			}
		
		
		});
}
</script>
</body>
</html>