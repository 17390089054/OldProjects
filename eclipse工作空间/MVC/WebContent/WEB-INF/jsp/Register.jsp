<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
ul{
list-style:none;
margin:2%  40% auto ;
padding:2%;
}
li
{
padding:4%;
}
input
{
height:25px;
width:200px;
}



button
{
color:white;
background-color:red;
font-size:15px;
padding:6px;
width:120px;
height:40px;
margin-left:-10px;
border-radius:5px;
}
fieldset
{
border:0px;
position:absolutely;
}
input.sex
{

width:25px;

}
html,body
{
width:100%;
height:100%;
}
*
{
margin:0px;
padding:0px;
}
div
{
height:100%;
width:100%;
overflow:hidden;
margin:0px;
position: absolute;
text-align:center;
color:gray;
background:url(resource/bg.jpeg)no-repeat;background-size:100% 100%;
border:1px solid gray ;
border-radius:10px;
}
</style>
<title>用户注册</title>
</head>
<body>
<div style="float:right ;font-color:yellow"><a href="Login.do" target="_self">已有账号 去登录</a></div>
<div>
<form action="Register.do" method="post">
<fieldset>
<ul>
<li><input type="text" name="account"  value="${account }" placeholder=" 请 输 入 账 号 " /></li>
<li><input type="password" name="password"  value="${password }" placeholder=" 请 输 入 密 码 " /></li>
<li><input type="password" name="password2" value="${password2 }" placeholder=" 请 确 认 密 码 " /></li>
<li><input type="text" name="user_name" value="${user_name }" placeholder=" 请 输 入  姓 名 " /></li>
<li><input type="number" name="age" value="${age }" placeholder=" 请 输 入 年 龄 " /></li>
<li><input type="radio" name="sex" value="男"  class="sex"/> 男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="sex" value="女"  class="sex"/> 女</li>
<li><button> 确 认 注 册 </button></li>
</ul>
<span style="color:purple;font-size:15px;font-weight:bloder">${msg }</span>

</fieldset>

</form>
</div>
</body>
</html>