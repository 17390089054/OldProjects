<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<style>
ul{
list-style:none;

}
ul li{
margin-top:1%;

}

input
{
border-radius:5px;
height:22px;
}

.btn
{
color:white;
background-color:red;
height:40px;
width:120px;
border-radius:10px;
font-size:15px;
margin-left:2%;
}
</style>
</head>
<body>
<div align="center" style="background-color:lightblue">

<form action="Register.do" method="post">
<fieldset >
<div align="center" style="backgoround-color:red ">
<ul>
<li>账号 <input type="text" name="account" /></li>
<li>密码 <input type="password" name="password" /></li>
<li>姓名 <input type="text" name="user_name" /></li>
<li>年龄 <input type="number" name="age" /></li>
<li><input class="btn" type="submit" value="     注     册      " /></li>
</ul>
</div>
</fieldset>
</form>
</div>

</body>
</html>