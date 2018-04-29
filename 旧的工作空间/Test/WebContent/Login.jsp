<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%--   <%request.setCharacterEncoding("UTF-8"); %>--%>
   <%--  <%String msg=request.getParameter("msg")==null?"":request.getParameter("msg");%> --%>
   <%
  		String msg="";
 	if(request.getAttribute("msg")!=null)
 	{
 	msg=request.getAttribute("msg").toString();	
 	}
 	String account="";
 	if(request.getAttribute("account")!=null)
 	{
 		account=request.getAttribute("account").toString();
 	}

   %>
   
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table
{
border:1px ;
height:32.5%;
width:25%;
margin:0 auto;
background:lightgray;
border-radius:10px;
}
div span
{
	color:red;
	font-size:30px;
}
div
{
	text-align:center;
	color:#abc123;
	margin:0px,auto,auto,10px;
	font-size:40px;
	letter-spacing:5px;
	

}
td
{
	text-align:center;
	
	font-size:25px;
	font-color:red;
}
body
{
background-image:url("C:/Users/q1807/Pictures/Screenshots/屏幕截图(2).png");

}
.box
{
height:32.5px;
width:240px;
border-radius:5px;

}
.bt
{
height:45px;
width:230px;
background-color:red;
color:white;
border-radius:10px;
font-size:20px;
}
</style>
</head>
<body>
<div>欢 迎 登 录</div><br>
<form action="Login" method="post" >
<table border="1">
<tr>
<td>账号</td>
<td><input type="text"  class="box" maxlength="20" name="account" value=<%=account %>></td>
</tr>
<tr>
<td>密码</td>
<td><input type="password"  class="box" maxlength="20" name="password" ></td>
</tr>
<tr>
<td></td>
<td align="center"><input type="submit" class="bt" value="确     认     登     录 "></td></tr>
</table>
</form>
<br>
<div align="center"><span><%=msg %></span></div>
</body>
</html>