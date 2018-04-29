<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>  
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息修改</title>
<style>
*{padding:0px;margin:0px;}
html,body{height:100%;width:100%}

.elegant-aero {
position:absolute;top:20px;left:0px;right:5px;
margin-top:50px;
margin-left:400px;
margin-right:200px; 
max-width: 1000px;
background: #D2E9FF;
padding: 20px 20px 20px 20px;
font: 18px Arial, Helvetica, sans-serif;
color: #666;

}
.elegant-aero h1 {
font: 28px "Trebuchet MS", Arial, Helvetica, sans-serif;
padding: 10px 10px 10px 20px;
display: block;
background: #C0E1FF;
border-bottom: 1px solid #B8DDFF;
margin: -20px -20px 15px;
}
.elegant-aero h1>span {
display: block;
font-size: 16px;
}
.elegant-aero label>span {
float: left;
margin-top: 15px;
color: #5E5E5E;
}
.elegant-aero label {
display: block;
margin: 0px 0px 5px;
}
.elegant-aero label>span {
float: left;
width: 20%;
text-align: right;
padding-right: 15px;
margin-top: 10px;
font-weight: bold;
}
.elegant-aero input[type="text"], .elegant-aero input[type="email"], .elegant-aero textarea, .elegant-aero select {
color: #888;
width: 70%;
padding: 0px 0px 0px 5px;
border: 1px solid #C5E2FF;
background: #FBFBFB;
outline: 0;
-webkit-box-shadow:inset 0px 1px 6px #ECF3F5;
box-shadow: inset 0px 1px 6px #ECF3F5;
font: 200 15px/25px Arial, Helvetica, sans-serif;
height: 30px;
line-height:18px;
margin: 2px 6px 16px 0px;
}
.elegant-aero textarea{
height:100px;
padding: 5px 0px 0px 5px;
width: 70%;
}
.elegant-aero select {
background: #fbfbfb url('down-arrow.png') no-repeat right;
background: #fbfbfb url('down-arrow.png') no-repeat right;
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width: 70%;
}
.elegant-aero .button{
padding: 10px 30px 10px 30px;
background: #66C1E4;
border: none;
color: #FFF;
box-shadow: 1px 1px 1px #4C6E91;
-webkit-box-shadow: 1px 1px 1px #4C6E91;
-moz-box-shadow: 1px 1px 1px #4C6E91;
text-shadow: 1px 1px 1px #5079A3;
}
.elegant-aero .button:hover{
background: #3EB1DD;
}
</style>
</head>
<body>

<form action="UserUpdate.do" method="post" class="elegant-aero">
<h1>信 息 修 改
<span>请 确 认 以 下 内 容 :</span>
</h1>
<input type="hidden" name="user_id" value="${user.user_id }"/>
<label>
<span>用 户 名 :</span>
<input id="name" type="text" name="account"  value="${user.account }"/>
</label>
<label>
<span>姓 名 :</span>
<input id="email" type="text" name="user_name" value="${user.user_name }" />
</label>

<label>
<span>年 龄 :</span>
<input id="email" type="text" name="user_age" value="${user.user_age }" />
</label>

<label>
<span>性 别 :</span><select name="user_sex" >
<option value=" " 
<c:if test="${user.user_sex eq '' }">
selected
</c:if>
>==请选择==</option>

<option value="男" 
<c:if test="${user.user_sex eq '男' }">
selected
</c:if>
>男</option>

<option value="女"
<c:if test="${user.user_sex eq '女' }">
selected
</c:if>
>女</option>
</select>
</label>

<label>
<span> 状 态 :</span><select name="user_status">
<%-- <option value=" " 
<c:if test="${user.user_status eq '' }">
selected
</c:if>
>==请选择==</option> --%>
<option value="1" 
<c:if test="${user.user_status eq '1' }">
selected
</c:if>
>可用</option>

<option value="0"
<c:if test="${user.user_status eq '0' }">
selected
</c:if>
>禁用</option>
</select>
</label>

<label>
<span>&nbsp;</span>
<input type="submit" class="button" value=" 确 认 修 改 " />&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="button" value=" 取 消 " onclick="history.go(-1)"/>
</label>
</form>
<div style="font-size:20px;color:red;"align="center">${msg } </div>

</body>
</html>