<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style>
  .container
  {
	text-align:center;
	
  
  }
  html,body
  {
  background-image:url("resource/bg2.jpg");
  background-size:100% 100%;
  height:100%;
  width:100%;
  overflow:hidden;
  }
	input
	{
	width:200px;
	height:35px;
	border-radius:4px;
	 border-color:lightgray;
	}
	.btn
	{
	background-color:skyblue;
	color:white;
	width:200px;
	height:45px;
	font-size:18px;
	padding:5px;
	border-radius:10px;
	cursor:pointer;
	}
	h1
	{
	font-size:35px;
	color:purple;
	}
	
	  
  </style>
  <script type="text/javascript" src="resource/jquery-3.2.1.js"></script>
  <script type="text/javascript">
  	function checkAccount(obj)
  	{
  		var account=obj.value;
  		var accountError=document.getElementById("accountError");
  		if(account.trim()=="")
  		{
  			accountError.innerHTML="<font style='color:red;font-size:25px'>账号不能为空!</font>";
  		}
 		
  		
  	}
  	function clearAccountError()
  	{
  		var accountError=document.getElementById("accountError");
  		accountError.innerHTML="";
  	}
  
 	function checkPassword(obj)
  	{
  		var password=obj.value;
  		var passwordError=document.getElementById("passwordError");
  		if(password.trim()=="")
  		{
  			passwordError.innerHTML="<font style='color:red;font-size:25px'>密码不能为空!</font>";
  		}
 		
  		
  	}
  	function clearPasswordError()
  	{
  		var passwordError=document.getElementById("passwordError");
  		passwordError.innerHTML="";
  	}
  
  
  		function check()
  		{
 			
  			 var msg=document.getElementById("msg");
  			var account=document.getElementById("account").value;
  			var password=document.getElementById("password").value;
  			if(!account)
  			{	
  				msg.innerHTML="账号不能为空";				
  				document.getElementById("account").focus();
  				return;
  			}
  			if(!password)
			{
				msg.innerHTML="密码不能为空";
				document.getElementById("password").focus();
				return;
			}
  			document.getElementById("myForm").submit();
  		/* 	var account=$("#account").val();
  			var password=$("#password").val();
  			$.post("CheckAccountValid.do",{account:account,password:password},function(data)
  					{

  						 if(!data.flag)
						{
  							$("#msg").html(data.msg);						
						}
  						else
  							{
  								
  							} 
  					},"json");
  						
  			var form=$("#myForm");
  			form.action="Login.do";
  			form.method="post"; */
  		}
  		
  </script>
<title>用户登录</title>
</head>
<body>

<form method="post" action="Login.do" id="myForm">
<div class="container" align="center">
<h1>欢 迎 登 录</h1>
<input type="text" name="account"  value="${requestScope.account }"  id="account" placeholder=" 请 输 入 账 号 "
 onblur="checkAccount(this)" onfocus="clearAccountError()"/>

<span id="accountError" style="position:absolute;margin-left:5px"></span>
<br/><br/>
<input type="password" name="password" placeholder=" 请 输 入 密 码 " id="password"
onblur="checkPassword(this)" onfocus="clearPasswordError()">
<span id="passwordError" style="position:absolute;margin-left:5px"></span>
<br/><br/>
<button class="btn"  onclick="check()">登 &nbsp;&nbsp;&nbsp;&nbsp;录 </button><br/><br/>
<span style="color:red;font-size:25px" id="msg">${msg}</span>
</div>

</form>
</body>
</html>