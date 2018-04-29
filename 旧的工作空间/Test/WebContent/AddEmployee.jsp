<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1 style="color:purple; size:20;">新 增 员 工</h1>
<%
String name="";
   if(request.getAttribute("name")!=null)
   {
	   name=request.getAttribute("name").toString();
   }
   String account="";
   if(request.getAttribute("account")!=null)
   {
	   account=request.getAttribute("account").toString();
   }
   String password="";
   if(request.getAttribute("password")!=null)
   {
	   password=request.getAttribute("password").toString();
   }
   String age="";
   if(request.getAttribute("age")!=null)
   {
	   age=request.getAttribute("age").toString();
   }
   String sex="";
   if(request.getAttribute("sex")!=null)
   {
	   sex=request.getAttribute("sex").toString();
   }
   String msg="";
   if(request.getAttribute("msg")!=null)
   {
	   msg=request.getAttribute("msg").toString();
   }
   
   
%>
<form action="AddEmployee" method="post">
<table border="1" >
<tr>
<td>姓  名 :</td>
<td><input type="text" name="name" placeholder="   请 输 入 您 的 名 字  " maxlength="20px" value="<%=name%>"></td>
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
<td><input type="number" name="age" placeholder="   请 输 入 您 的  年 龄" maxlength="20px" value="<%=age%>"></td>
</tr>
<tr>
<td>账 号 :</td>
<td><input type="text" name="account" placeholder="   请 输 入 您 的 账 号" maxlength="20px" value="<%=account%>"></td>
</tr>
<tr>
<td>密  码 :</td>
<td><input type="password" name="password" placeholder="   请 输 入 您 的 密 码" maxlength="20px" value="<%=password%>"></td>
</tr>

<tr>
<td></td>
<td>
<input type="reset" value="重  置  " >&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="确 认 提 交">
</td>
</tr>
</table>
</form>
<span><%=msg %></span>
</div> 
</body>
</html>