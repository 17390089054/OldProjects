<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<title>申请报销
</title>
<style>
.elegant-aero {
margin-top:2%;
margin-left:auto;
margin-right:auto;
max-width: 45%;
background: #D2E9FF;
padding: 20px 20px 20px 20px;
font: 15px Arial, Helvetica, sans-serif;
color: #666;
}
.elegant-aero h1 {
font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
padding: 10px 10px 10px 20px;
display: block;
background: #C0E1FF;
border-bottom: 1px solid #B8DDFF;
margin: -20px -20px 15px;
}
.elegant-aero h1>span {
display: block;
font-size: 15px;
}
.elegant-aero label>span {
float: left;
margin-top: 10px;
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
font: 200 12px/25px Arial, Helvetica, sans-serif;
height: 30px;
line-height:15px;
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
<body >
<%

String reason="";
String type="";
String place="";
String money="";
String msg="";
if(request.getAttribute("reason")!=null)
{
	reason=request.getAttribute("reason").toString();
	
}

if(request.getAttribute("type")!=null)
{
	type=request.getAttribute("type").toString();
	
}

if(request.getAttribute("place")!=null)
{
	place=request.getAttribute("place").toString();
	
}

if(request.getAttribute("money")!=null)
{
	money=request.getAttribute("money").toString();
	
}

if(request.getAttribute("msg")!=null)
{
	msg=request.getAttribute("msg").toString();
	
}
%>
<form action="AddPayment" method="post"  >

<fieldset class="elegant-aero">
<h1 >报 销 表
<span>请 填 写 以 下 内 容 </span>
</h1>
<ul style="list-style:none">
<li>
<label>
<span>地 点 :</span>
</label>
<input id="name" type="text" name="place" placeholder="请 输 入 报 销 地 点" value="<%=place%>"/>
</li>

<li>
<label>
<span>类 型 :</span>
</label>
<input id="email" type="text" name="type" placeholder="请 输 入 报 销 类 型" value="<%=type%>"/>
</li>

<li>
<label>
<span>原 因 :</span></label>
<textarea id="message" name="reason" placeholder="请 输 入 报 销 原 因">
<%=reason %>
</textarea>
</li>

<li>
<label>
<span>金 额 :</span>
</label>
<input type="text" name="money" placeholder="请 输 入 报 销 金 额" value="<%=money %>" />


</li>
<li>
<label>
<span>&nbsp;</span>
</label>
<input type="submit" class="button" value=" 提   交  " />
</li>
</ul>
<div align="center"><span style="size:20px;color:red"><%=msg %> </span>   </div>
</fieldset>

</form>

</body>
</html>