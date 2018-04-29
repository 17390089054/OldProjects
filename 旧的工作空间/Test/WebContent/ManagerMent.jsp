<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"
    import="java.util.Map"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table{
	width:100%;
}
td{
	text-align:center;
}
font{
color:orangered;
font-size:20px;
}


</style>
</head>
<body>
<div align="center">
<h1 style="color:purple ;size:30px">员 工 在 职 表 </h1>

<form action="SelectEmployee" method="post">
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

%>
<font> 快 速 查 询  </font>&nbsp;&nbsp;
账 号:&nbsp;<input type="text" maxlength="20" name="account" value="<%=account%>">&nbsp;&nbsp;
姓 名:&nbsp;<input type="text" maxlength="20" name="name" value="<%=name%>">&nbsp;&nbsp;
年 龄:&nbsp;<input type="number" maxlength="10" name="age" value="<%=age%>">&nbsp;&nbsp;
性 别:&nbsp;<input type="radio" value="男" name="sex" value="<%
	if(sex.equals("sex"))
	{
	%>
	checked
<%
	}
%>男"
>男&nbsp;&nbsp;
<input type="radio" value="女" name="sex" value="
<%
if(sex.equals("sex"))
{
%>
checked
<%}%>
">女&nbsp;&nbsp;
<input type="submit" value=" 查  询   ">
</form>


</div>
<table border="1">
<tr>
<th>编号</th>
<th>姓名</th>
<th>账号</th>
<th>密码</th>
<th>年龄</th>
<th>性别</th>
<th>操作</th>
</tr>
<%
List<Map<String,String>>list=(List<Map<String,String>>)request.getAttribute("list");
for(int i=0;i<list.size();i++)
{
%>
<tr>
<td><%=i+1 %></td>
<td><%=list.get(i).get("name") %></td>
<td><%=list.get(i).get("account") %></td>
<td><%=list.get(i).get("password") %></td>
<td><%=list.get(i).get("age") %></td>
<td><%=list.get(i).get("sex") %></td>
<td>
<a href="EditEmployee?id=<%=list.get(i).get("id") %>" target="content"> 编 辑</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="DeleteEmployee?id=<%=list.get(i).get("id") %>" target="content"> 删 除</a>
</td>
</tr>
<%} %>

</table>
</body>
</html>