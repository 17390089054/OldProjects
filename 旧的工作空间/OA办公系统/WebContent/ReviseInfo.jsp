<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.Map"
    import="java.util.HashMap"
    import="java.util.List"
    import="java.util.ArrayList"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
.dark-matter {
margin-left: auto;
margin-right: auto;
max-width: 500px;
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
height:100px;
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

<title>信息修改</title>
</head>
<body>
<form action="ReviseInfo" method="post"  style="margin-top:2%">
<%

List<Map<String,String>>list=new ArrayList<Map<String,String>>();
if(request.getAttribute("list")!=null)
{
	list=(List<Map<String,String>>)request.getAttribute("list");
}

Map<String,String>map=new HashMap<String,String>();

String id="";
String account="";
String user_name="";
String department="";
String id_card="";
String telephone="";
String address="";
String msg="";
if(request.getAttribute("map")!=null)
{
	map=(Map<String,String>)request.getAttribute("map");
	id=map.get("user_id");
	account=map.get("account");
	user_name=map.get("user_name");
	department=map.get("d_name");
	id_card=map.get("user_card");
	telephone=map.get("user_tel");
	address=map.get("user_addr");
}
else
{
	if(request.getAttribute("id")!=null)
	{
		id=request.getAttribute("id").toString();
	}
	
	if(request.getAttribute("account")!=null)
	{
		account=request.getAttribute("account").toString();
	}
	if(request.getAttribute("user_name")!=null)
	{
		user_name=request.getAttribute("user_name").toString();
	}
	
	if(request.getAttribute("department")!=null)
	{
		department=request.getAttribute("department").toString();
	}
	
	if(request.getAttribute("id_card")!=null)
	{
		id_card=request.getAttribute("id_card").toString();
	}
	
	if(request.getAttribute("telephone")!=null)
	{
		telephone=request.getAttribute("telephone").toString();
	}
	
	if(request.getAttribute("address")!=null)
	{
		address=request.getAttribute("address").toString();
	}
	
	if(request.getAttribute("msg")!=null)
	{
		msg=request.getAttribute("msg").toString();
	}
	
	
	
}

%>


<fieldset class="dark-matter">
<h1 >信息修改表
<span>请确认以下信息</span>
</h1>
<ul style="list-style:none">
<li >
<input type="hidden" name="id" value="<%=id%>"/>
</li>

<li style="margin-top:2%">
<label>
<span>用 户 名:</span></label>
<input id="name" type="text" name="account" value="<%=account %>" readonly />
</li>

<li style="margin-top:2%">
<label>
<span>真 实 姓 名 :</span></label>
<input id="email" type="text" name="user_name"  value="<%=user_name %>" />
</li>

<li style="margin-top:2%">
<label>
<span>电 话 :</span></label>
<input id="name" type="text" name="telephone" value="<%= telephone%>"  />
</li>


<li style="margin-top:2%">
<label>
<span>身 份 证 号 :</span></label>
<input id="name" type="text" name="id_card" value="<%=id_card %>" />
</li>

<li style="margin-top:2%">
<label>
<span>住 址 :</span></label>
<input id="name" type="text" name="address" value="<%=address %>" />
</li>

<li style="margin-top:2%">
<label>
<span>部 门 :</span>
</label>
<select name="department"  value="<%=department%>" >
<option ><%=department %></option>
<%-- <%
for(int i=0;i<list.size();i++)
{
%>
<option ><%=list.get(i).get("d_name") %></option>
<%} %> --%>
</select>
</li>
<li style="margin-top:2%">
<label>
<span>&nbsp;</span></label>
<input type="submit" class="button" value="确  认  修  改" />
</li>
</ul>
</fieldset>
<div align="center" ><span style="font-size:20px;color:red"><%=msg %></span></div>
</form>
</body>
</html>