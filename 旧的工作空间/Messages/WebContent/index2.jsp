<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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

手机号:<input type="text" maxlength=11 id="phone" placeholder=" 请 输 入 你 的 手 机 号  "/>
<input type="button"  value="获取验证码" onclick="sendCode();"/>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">


//定义一个方法发送验证码
function sendCode(){
	var telephone=$("#phone").val();
//利用ajax获取手机号
$.ajax({
		//数据上传路径
		url:"sendCode",
		//上传的方式
		type:"post",
		//上传的数据
		data:{"phone":telephone},
		//返回参数
		success:
			function(code)		
			{			
			console.log(code);			
			}
		
		
		});
}
 /*
 * 定义一个对象
 */
/* var object={"name":"草泥马","age":"18","fun":function(){alert("草泥马"+this.name+this.age)}};
 /* alert("你好，"+object.name+"！你的年龄为 "+object.age);  object.fun();*/


</script>






</body>
</html>