<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<style>


td span
{
color:lightblue;
font-size:15px;
}


.smart-green {
margin-left:auto;
margin-right:auto;
max-width: 40%;
background: #F8F8F8;
padding: 30px 30px 20px 30px;
font: 15px Arial, Helvetica, sans-serif;
color: #666;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
}
.smart-green h1 {
font: 28px "Trebuchet MS", Arial, Helvetica, sans-serif;
padding: 20px 0px 20px 40px;
display: block;
margin: -30px -30px 10px -30px;
color: #FFF;
background: #9DC45F;
text-shadow: 1px 1px 1px #949494;
border-radius: 5px 5px 0px 0px;
-webkit-border-radius: 5px 5px 0px 0px;
-moz-border-radius: 5px 5px 0px 0px;
border-bottom:1px solid #89AF4C;
}
.smart-green h1>span {
display: block;
font-size: 12px;
color: #FFF;
}
.smart-green label {
display: block;
margin: 0px 0px 5px;
}
.smart-green label>span {
float: left;
margin-top: 10px;
color: #5E5E5E;
}
.smart-green input[type="text"], .smart-green input[type="email"], .smart-green textarea, .smart-green select {
color: #555;
height: 30px;
line-height:15px;
width: 100%;
padding: 0px 0px 0px 10px;
margin-top: 2px;
border: 1px solid #E5E5E5;
background: #FBFBFB;
outline: 0;
-webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
font: normal 14px/14px Arial, Helvetica, sans-serif;
}
.smart-green textarea{
height:100px;
padding-top: 10px;
}
.smart-green select {
background: url('down-arrow.png') no-repeat right, -moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
background: url('down-arrow.png') no-repeat right, -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width:100%;
height:30px;
}
.smart-green .button {
background-color: #9DC45F;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-border-radius: 5px;
border: none;
padding: 10px 25px 10px 25px;
color: #FFF;
text-shadow: 1px 1px 1px #949494;
}
.smart-green .button:hover {
background-color:#80A24A;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>写日报</title>
</head>
<body>
<%
String title="";
String context="";
String date="";
if(request.getAttribute("title")!=null)
{
	title=request.getAttribute("title").toString();
	
}

if(request.getAttribute("context")!=null)
{
	context=request.getAttribute("context").toString();
	
}

if(request.getAttribute("date")!=null)
{
	date=request.getAttribute("date").toString();
	
}

String msg="";

if(request.getAttribute("msg")!=null)
{
	msg=request.getAttribute("msg").toString();
	
}


%>
<script type="text/javascript">
function save()
{
	document.form.action="SaveReport";
	
	document.form.submit();
	}
function submit()
{
	document.form.action="WriteReport";
	document.form.submit();
	}

</script>


<form action="" method="post" name="form" >

<fieldset class="smart-green">
<h1 >日 报 添 加
<span>请 填 写 以 下 内 容</span>
</h1>
<ul style="list-style:none">
<li>
<label >
<span>标 题 :</span></label>
<input id="name" type="text" name="title" value="<%= title%>" placeholder="请 输 入  日 报 标 题" />
</li>


<li>
<label>
<span>内 容 :</span></label>
<textarea id="message" name="context" placeholder="请 输 入 日 报 内 容 ">
<%=context %>
</textarea>
</li>

<li>
<label>
<span>时 间 :</span>
</label>
<input type="date" name="date" style="width:100%;padding:5 5;margin-left:0%;border-radius:5px ;"  value="<%=date%>"/>

</li>
<li style="margin-top:5%">
<label>
<span>&nbsp;</span></label>
<input type="submit" class="button" value="存 为 草 稿 "  onclick="save()"/>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" class="button" value="确 认 提 交 " onclick="submit()"/>
</li>
</ul>
</fieldset>
</form>

</body>
</html>