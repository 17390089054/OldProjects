<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>群发邮件</title>
<style>
.bootstrap-frm {

margin-left:auto;
margin-right:auto;
max-width: 40%;
background: #FFF;
padding: 20px 30px 20px 30px;
font: 15px "Helvetica Neue", Helvetica, Arial, sans-serif;
color: #888;
text-shadow: 1px 1px 1px #FFF;
border:1px solid #DDD;
border-radius: 5px;
-webkit-border-radius: 5px;
-moz-border-radius: 5px;
}
.bootstrap-frm h1 {
font: 28px "Helvetica Neue", Helvetica, Arial, sans-serif;
padding: 0px 0px 10px 40px;
display: block;
border-bottom: 1px solid #DADADA;
margin: -10px -30px 30px -30px;
color: #888;
}
.bootstrap-frm h1>span {
display: block;
font-size: 13px;
}
.bootstrap-frm label {
display: block;
margin: 0px 0px 5px;
}
.bootstrap-frm label>span {
float: left;
width: 20%;
text-align: right;
padding-right: 10px;
margin-top: 10px;
color: #333;
font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
font-weight: bold;
}
.bootstrap-frm input[type="text"], .bootstrap-frm input[type="email"], .bootstrap-frm textarea, .bootstrap-frm select{
border: 1px solid #CCC;
color: #888;
height: 30px;
line-height:15px;
margin-bottom: 16px;
margin-right: 6px;
margin-top: 2px;
outline: 0 none;
padding: 5px 0px 5px 5px;
width: 70%;
border-radius: 4px;
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
-moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
}
.bootstrap-frm select {
background: #FFF url('down-arrow.png') no-repeat right;
background: #FFF url('down-arrow.png') no-repeat right;
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width: 70%;
height: 35px;
line-height:15px;
}
.bootstrap-frm textarea{
height:120px;
padding: 5px 0px 0px 5px;
width: 70%;
}
.bootstrap-frm .button {
background:brown;
border: 1px solid #CCC;
padding: 10px 25px 10px 25px;
color:white;
border-radius: 4px;
}
.bootstrap-frm .button:hover {
color: white;
background-color:red;
border-color: #ADADAD;
}
</style>
</head>
<body>
<div style="background-color:lightgray;height:100%">
<%
	String text="";
	String date="";
	String msg="";
	if(request.getAttribute("text")!=null)
	{
		text=request.getAttribute("text").toString();
	}
	
	if(request.getAttribute("date")!=null)
	{
		date=request.getAttribute("date").toString();
	}

	if(request.getAttribute("msg")!=null)
	{
		msg=request.getAttribute("msg").toString();
		
	}


%>
<form action="SendAll" method="post"  >
<fieldset class="bootstrap-frm"  >
<h1 style="color:purple;" >群发邮件
<span>请填写以下内容</span>
</h1>
<ul style="list-style:none">
<li>
<label>
<span>发 给 :</span></label>
<input id="name" type="text" name="name" value=" 所 有 人 " style="margin-top:1.5%" readonly/>
</li>


<li>
<label>
<span>内 容 :</span></label>
<textarea id="message" name="text"  style="margin-top:1.5%">
<%=text%>
</textarea>
</li>

<li style="margin-top:2%">
<label>
<span> 时 间 :</span>
</label>
<input type="date" name="date" style="width:70%;height:6%;padding:3 0;border-radius:4px ;" value="<%=date %>" style="margin-top:3.5%"/>
</li>

<li style="margin-top:5%">
<label>
<span>&nbsp;</span></label>
<input type="submit" class="button" value=" 发    送  " />
</li>
</ul>
<div align="center"><span style="color:red;font-size:25px;"><%=msg %></span></div>

</fieldset>
</form>
</div>


</body>
</html>