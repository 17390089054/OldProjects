<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<style>
.white-pink {
margin-left:auto;
margin-right:auto;
max-width:40%;
background: #FFF;
padding: 30px 30px 20px 30px;
box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
-webkit-box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
font: 15px Arial, Helvetica, sans-serif;
color: #666;
border-radius: 10px;
-webkit-border-radius: 10px;
}
.white-pink h1 {
font: 28px "Trebuchet MS", Arial, Helvetica, sans-serif;
padding: 0px 0px 10px 40px;
display: block;
border-bottom: 1px solid #F5F5F5;
margin: -10px -30px 10px -30px;
color: #969696;
}
.white-pink h1>span {
display: block;
font-size: 12px;
color: #C4C2C2;
}
.white-pink label {
display: block;
margin: 0px 0px 5px;
}
.white-pink label>span {
float: left;
width: 20%;
text-align: right;
padding-right: 10px;
margin-top: 10px;
color: #969696;
}
.white-pink input[type="text"], .white-pink input[type="email"], .white-pink textarea,.white-pink select{
color: #555;
width: 70%;
padding: 3px 0px 3px 5px;
margin-top: 2px;
margin-right: 6px;
margin-bottom: 16px;
border: 1px solid #e5e5e5;
background: #fbfbfb;
height: 25px;
line-height:15px;
outline: 0;
-webkit-box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
}
.white-pink textarea{
height:100px;
padding: 5px 0px 0px 5px;
width: 70%;
}
.white-pink .button {
-moz-box-shadow:inset 0px 1px 0px 0px #fbafe3;
-webkit-box-shadow:inset 0px 1px 0px 0px #fbafe3;
box-shadow:inset 0px 1px 0px 0px #fbafe3;
background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ff5bb0), color-stop(1, #ef027d) );
background:-moz-linear-gradient( center top, #ff5bb0 5%, #ef027d 100% );
filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff5bb0', endColorstr='#ef027d');
background-color:#ff5bb0;
border-radius:9px;
-webkit-border-radius:9px;
-moz-border-border-radius:9px;
border:1px solid #ee1eb5;
display:inline-block;
color:#ffffff;
font-family:Arial;
font-size:15px;
font-weight:bold;
font-style:normal;
height: 40px;
line-height: 30px;
width:100px;
text-decoration:none;
text-align:center;
text-shadow:1px 1px 0px #c70067;
}
.white-pink .button:hover {
background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ef027d), color-stop(1, #ff5bb0) );
background:-moz-linear-gradient( center top, #ef027d 5%, #ff5bb0 100% );
filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ef027d', endColorstr='#ff5bb0');
background-color:#ef027d;
}
.white-pink .button:active {
position:relative;
top:1px;
}
.white-pink select {
background: url('down-arrow.png') no-repeat right, -moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
background: url('down-arrow.png') no-repeat right, -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width: 70%;
line-height: 15px;
height: 30px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假申请</title>
</head>
<body>
<%
String start_date="";
String end_date="";
String reason="";
String msg="";
if(request.getAttribute("start_date")!=null)
{
	start_date=request.getAttribute("start_date").toString();
}

if(request.getAttribute("end_date")!=null)
{
	end_date=request.getAttribute("end_date").toString();
}
if(request.getAttribute("reason")!=null)
{
	reason=request.getAttribute("reason").toString();
}
if(request.getAttribute("msg")!=null)
{
	msg=request.getAttribute("msg").toString();
}



%>
<form action="AddRest" method="post" >

<fieldset class="white-pink" style="margin-top:5%">
<h1 >请 假 表
<span>请填写以下信息</span>
</h1>
<ul style="list-style:none">
<li style="margin-top:5%">
<label>
<span>起始日期 :</span></label>
<input type="date" name="start_date" value="<%=start_date %>" style="width:70%;padding:5 25;border-radius:5px ;margin-top:1%"  /></li>

<li style="margin-top:5%">
<label>
<span>截至日期 :</span></label>
<input type="date" name="end_date"  value="<%=end_date %>" style="width:70%;padding:5 25;border-radius:5px ;margin-top:1%"  />
</li>

<li style="margin-top:5%">
<label>
<span>原&nbsp;&nbsp;因 :</span></label>
<textarea id="message" name="reason" style="margin-top:3%" >
<%=reason %>
</textarea>
</li>


<li style="margin-top:5%">
<label>
<span>&nbsp;</span></label>
<input type="submit" class="button" value=" 确  认  提  交 " />
</li>
</ul>
</fieldset>
<div align="center" style="margin-top:-2%"><span style="color:red;size:30px;"><%=msg %></span></div>
</form>




<%-- <div style="background-color:yellowgreen">
<form action="AddRest" name="form" method="post">

 <span style="color:purple;size:30px;"> 请 假 申 请  </span>
 <fieldset style="text-align:center;margin-right:4%;border:0">
 <ul style="list-style:none;">



<li style="margin-top:1%">
<label>开 始 时 间 </label>
<input type="date" name="start_date" value="<%=start_date %>" style="width:25%;padding:5 25;margin:10;border-radius:5px ;"  />
</li>

<li style="margin-top:1%">
<label>结 束  时 间 </label>
<input type="date" name="end_date"  value="<%=end_date %>" style="width:25%;padding:5 25;margin:10;border-radius:5px ;"  />
</li>


<li style="margin-top:1%">
<label >请  假  原   因 </label>
<textarea cols="45" rows="22" name="reason" style="border-radius:5px">
<%=reason %>
</textarea>
</li>



<input type="submit"  style="background-color:red;color:white;font-size:18px;padding:10 18 10 18;margin:10 20 5 100;border-radius:10px;"  value="  确    认    提    交  "     />

</ul>
</fieldset>


</form>

</div>
 --%>




</body>
</html>