<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page 
    import="java.util.Map"
    import="java.util.TreeMap"
     %>
<!DOCTYPE html">
<html>
<head>
<style>


table
{
border-radius:5px;
width:45%;
text-align:center;
margin:2% 20% 0% 27%;
/* background-color:lightgray; */
}

td span
{
color:lightblue;
font-size:15px;
}




.dark-matter {
margin-left: auto;
margin-right: auto;
max-width: 45%;
background: #555;
padding: 20px 30px 20px 30px;
font: 15px "Helvetica Neue", Helvetica, Arial, sans-serif;
color: #D3D3D3;
text-shadow: 1px 1px 1px #444;
border: none;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
}
.dark-matter h1 {
padding: 0px 0px 10px 40px;
display: block;
border-bottom: 1px solid #444;
margin: -10px -30px 30px -30px;
}
.dark-matter h1>span {
display: block;
font-size: 12px;
}
.dark-matter label {
display: block;
margin: 0px 0px 5px;
}
.dark-matter label>span {
float: left;
width: 20%;
text-align: right;
padding-right: 10px;
margin-top: 10px;
font-weight: bold;
}
.dark-matter input[type="text"], .dark-matter input[type="email"], .dark-matter textarea, .dark-matter select {
border: none;
color: #525252;
height: 25px;
line-height:15px;
margin-bottom: 16px;
margin-right: 6px;
margin-top: 2px;
outline: 0 none;
padding: 5px 0px 5px 5px;
width: 70%;
border-radius: 2px;
-webkit-border-radius: 2px;
-moz-border-radius: 2px;
-moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
background: #DFDFDF;
}
.dark-matter select {
background: #DFDFDF url('down-arrow.png') no-repeat right;
background: #DFDFDF url('down-arrow.png') no-repeat right;
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width: 70%;
height: 35px;
color: #525252;
line-height: 25px;
}
.dark-matter textarea{
height:120px;
padding: 5px 0px 0px 5px;
width: 70%;
}
.dark-matter .button {
background: #FFCC02;
border: none;
padding: 10px 25px 10px 25px;
color: #585858;
border-radius: 4px;
-moz-border-radius: 4px;
-webkit-border-radius: 4px;
text-shadow: 1px 1px 1px #FFE477;
font-weight: bold;
box-shadow: 1px 1px 1px #3D3D3D;
-webkit-box-shadow:1px 1px 1px #3D3D3D;
-moz-box-shadow:1px 1px 1px #3D3D3D;
}
.dark-matter .button:hover {
color: #333;
background-color: #EBEBEB;
}
</style>
	
	<title>公告修改  </title>
</head>
<body class="login-layout Reg_log_style" style="background-color:lightgray">
<%
Map <String,String> map=new TreeMap<String,String>();


map=(Map<String,String>)request.getAttribute("map");
	

String msg="";
String id="";
String title="";
String content="";
String date=""; 
String status="";
if(map!=null)
{
	id=map.get("notice_id");
	title=map.get("notice_title");
	content=map.get("notice_content");
	date=map.get("create_time");
	status=map.get("notice_status");
}
else
{
	if(request.getAttribute("notice_id")!=null)
	{
		id=request.getAttribute("notice_id").toString();
	}
	
	if(request.getAttribute("notice_title")!=null)
	{
		title=request.getAttribute("notice_title").toString();
	}
	
	if(request.getAttribute("notice_content")!=null)
	{
		content=request.getAttribute("notice_content").toString();
	}
	
	if(request.getAttribute("create_time")!=null)
	{
		date=request.getAttribute("create_time").toString();
	}
	
	if(request.getAttribute("msg")!=null)
	{
		msg=request.getAttribute("msg").toString();
	}
	

}


%>

<form action="NoticeRevise" method="post" >

<fieldset class="dark-matter" style="margin-top:2%;">
<h1 >公 告 修  改
<span>请 填 写 以 下 内 容 :</span>
</h1>
<ul style="list-style:none">
<li>
<input type="hidden" name="notice_id" value="<%=id %>" />
</li>

<li >
<label>
<span>标 题 :</span></label>
<input id="name" type="text" name="notice_title"  value="<%=title%>" style="margin-top:2%" />
</li>


<li>
<label>
<span>内 容 :</span></label>
<textarea id="message" name="notice_content"  style="margin-top:2%" >
<%=content %>
</textarea>
</li>

<li>
<label>
<span>时 间 :</span>
</label>
<input type="date" name="create_time" style="width:70%;padding:3 0;border-radius:4px ;" value="<%=date%>" style="margin-top:5%"/>
</li>
<li style="margin-top:5%;">
<label>
<span>&nbsp;</span></label>
<input type="submit" class="button" value=" 确  认  修   改    " />
</li>
</ul>
</fieldset>
</form>
<div align="center" style="margin-top:5px;"><span style="color:red;size:30px;"><%=msg %></span></div>



<%-- <div align="center" ><h1 style="color:white; margin-top:5%">公 告 修 改</h1></div>
<div style="margin:2% 35% 10% 35%;background-color:lightblue">
<div align="center">
<form action="NoticeRevise" method="post"> 
<fieldset>
<ul style="list-style:none;margin:3%">
<li>
<input type="hidden" name="notice_id" value="<%=id %>" />
</li>
<li >
<input type="text" style="width:70%" name="notice_title" value="<%=title %>" />
</li>


<li style="margin-top:3%">
<textarea name="notice_content" cols="40" rows="20">
 <%=content %>
</textarea>
</li>



<li  style="margin-top:3%">
<input type="date" name="create_time"   style="width:61%;padding:5 25;margin:10;border-radius:10px ;" value="<%=date%>" />
</li>

<li><input type="submit" style="background-color:red;color:white;font-size:18px;padding:5 25 5 25;margin:10 50;border-radius:5px;" value="  确   认   修   改  "/></li>
</ul>
</fieldset>
</form>

<div><span style="color:red;size:30px;"><%=msg %></span></div>
</div> --%>

<!-- </div> -->
</body>
</html>