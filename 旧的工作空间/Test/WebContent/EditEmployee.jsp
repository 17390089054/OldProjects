<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page 
 import="java.util.List"
 import="java.util.Map"
 %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 td {
	text-align:center;
}
table{
		width:22.5%;
		height:32.5%;
}
span{
color:red;
font-size:20px;
}
</style>
</head>
<body>
<div align="center">
<h1 style="color:purple; size:20;"> 员 工 信 息 编 辑 </h1>
<%
	String name="";
	String account="";
	String age="";
	 String sex="";
	  String msg="";
	  String id="";
	Map<String,String> map=(Map<String,String>)request.getAttribute("map");
	if(map!=null)
	{
		name=map.get("name");
		account=map.get("account");
		sex=map.get("sex");
		age=map.get("age");
		id=map.get("id");
	}
	
	else
	{
	
		   if(request.getAttribute("name")!=null)
		   {
			   name=request.getAttribute("name").toString();
		   }
		
		   if(request.getAttribute("account")!=null)
		   {
			   account=request.getAttribute("account").toString();
		   }
		  
		   if(request.getAttribute("age")!=null)
		   {
			   age=request.getAttribute("age").toString();
		   }
		  
		   if(request.getAttribute("sex")!=null)
		   {
			   sex=request.getAttribute("sex").toString();
		   }
		 
		   if(request.getAttribute("msg")!=null)
		   {
			   msg=request.getAttribute("msg").toString();
		   }
	}
	
   
   
%>
<form action="EditEmployee" method="post">
<table border="1" >
<input type="hidden" name="id" value="<%=id%>" >
<tr>
<td>姓  名 :</td>
<td><input type="text" name="name"  maxlength="20px" value="<%=name%>"></td>
</tr>
<tr>
<td>性 别 :</td>
<td><input type="radio" name="sex" value="男"
<%
if(sex.equals("男"))
{
	%>
	checked
	<%} %>
>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="sex" value="女"
<%
if(sex.equals("女")){
%>
checked
<%}%>
>女
</td>
</tr>
<tr>
<td>年 龄 :</td>
<td><input type="number" name="age"  maxlength="20px" value="<%=age%>"></td>
</tr>
<tr>
<td>账 号 :</td>
<td><input type="text" name="account"  maxlength="20px" value="<%=account%>" disabled></td>
</tr>
<tr>
<td></td>
<td>
<input type="submit" value="确 认 提 交">
</td>
</tr>
</table>
</form>
<span><%=msg %></span>
</div> 


</body>
</html>