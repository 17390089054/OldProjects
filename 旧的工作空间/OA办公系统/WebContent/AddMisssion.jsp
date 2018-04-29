<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page 
    import="java.util.List"
    import="java.util.Map"
    import="java.util.ArrayList"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发 起 任 务</title>
<style>
.basic-grey {
margin-left:auto;
margin-right:auto;
max-width: 40%;
background: #F7F7F7;
padding: 25px 15px 25px 10px;
font: 15px Georgia, "Times New Roman", Times, serif;
color: #888;
text-shadow: 1px 1px 1px #FFF;
border:1px solid #E4E4E4;
}
.basic-grey h1 {
font-size: 28px;
padding: 0px 0px 10px 40px;
display: block;
border-bottom:1px solid #E4E4E4;
margin: -10px -15px 30px -10px;;
color: #888;
}
.basic-grey h1>span {
display: block;
font-size: 14px;
}
.basic-grey label {
display: block;
margin: 0px;
}
.basic-grey label>span {
float: left;
width: 20%;
text-align: right;
padding-right: 10px;
margin-top: 10px;
color: #888;
}
.basic-grey input[type="text"], .basic-grey input[type="email"], .basic-grey textarea, .basic-grey select {
border: 1px solid #DADADA;
color: #888;
height: 30px;
margin-bottom: 16px;
margin-right: 6px;
margin-top: 2px;
outline: 0 none;
padding: 3px 3px 3px 5px;
width: 70%;
font-size: 15px;
line-height:15px;
box-shadow: inset 0px 1px 4px #ECECEC;
-moz-box-shadow: inset 0px 1px 4px #ECECEC;
-webkit-box-shadow: inset 0px 1px 4px #ECECEC;
}
.basic-grey textarea{
padding: 5px 3px 3px 5px;
}
.basic-grey select {
background: #FFF url('down-arrow.png') no-repeat right;
background: #FFF url('down-arrow.png') no-repeat right);
appearance:none;
-webkit-appearance:none;
-moz-appearance: none;
text-indent: 0.01px;
text-overflow: '';
width: 70%;
height: 35px;
line-height: 25px;
}
.basic-grey textarea{
height:100px;
}
.basic-grey .button {
background: #E27575;
border: none;
padding: 10px 25px 10px 25px;
color: #FFF;
box-shadow: 1px 1px 5px #B6B6B6;
border-radius: 3px;
text-shadow: 1px 1px 1px #9E3F3F;
cursor: pointer;
}
.basic-grey .button:hover {
background: #CF7A7A
}
</style>

</head>
<body>
<form action="AddMisssion" method="post" >
<%
List<Map<String,String>>list=new ArrayList<Map<String,String>>();
if(request.getAttribute("list")!=null)
{
	list=(List<Map<String,String>>)request.getAttribute("list");
}
String title="";
String content="";
String department="";
String date="";
String msg="";

if(request.getAttribute("title")!=null)
{
	title=request.getAttribute("title").toString();
}

if(request.getAttribute("content")!=null)
{
	content=request.getAttribute("content").toString();
}

if(request.getAttribute("department")!=null)
{
	department=request.getAttribute("department").toString();
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
<fieldset class="basic-grey"  style="margin-top:5%">
<h1>任 务 表
<span>请 填 写 以 下 内 容</span>
</h1>
<ul style="list-style:none">
<li style="margin-top:2%">
<label>
<span> 标  题 :</span></label>
<input id="name" type="text" name="title" value="<%=title %>" />
</li>

<li style="margin-top:2%">
<label>
<span> 内 容 :</span></label>
<textarea id="message" name="content" >
<%=content %>
</textarea>
</li>

<li style="margin-top:2%">
<label>
<span> 部 门 :</span>
</label>
<select name="department" >
<option>
<%=department%>

</option>
<%
for(int i=0;i<list.size();i++)
{
%>
<option ><%=list.get(i).get("d_name") %></option>
<%} %>
</select>
</li>

<li>
<label>
<span>时 间 :</span>
</label>
<input type="date" name="date" value="<%=date %>" style="width:70%;height:6%;padding:3 0;border-radius:4px ;"  style="margin-top:5%"/>
</li>

<li style="margin-top:5%">
<label>
<span>&nbsp;</span></label>
<input type="submit" class="button" value=" 发    布   " />
</li>
</ul>
</fieldset>
</form>
<div align="center" style="margin-top:5px;"><span style="color:red;size:30px;"><%=msg %></span></div>
</body>
</html>