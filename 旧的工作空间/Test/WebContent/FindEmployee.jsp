<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<h1 style="align:center;color:red">员工信息表</h1>
<body>
 <%
 String account="";
	
	String name="";
	
	String tel="";
	
	List<Map<String,String>> user1=(List<Map<String,String>>)request.getAttribute("user1");

	 if(user1.get(0).get("account")!=null)
		{
			account=user1.get(0).get("account");
		}
	 if(user1.get(0).get("name")!=null)
		{
			 name=user1.get(0).get("name");
		}
	 if(user1.get(0).get("tel")!=null)
		{
			tel=user1.get(0).get("tel");
		}

	
	
%>
<%=account %> 
<form action="Employee" method="post">
账 号:<input type="text" maxlength="20" name="account">
姓 名:<input type="text" maxlength="20" name="name">
<input type="submit" value="查 询">
</form>

<table border="1" width="100%">
<tr>
<th>编号</th>
<th>姓名</th>
<th>账号</th>
<th>电话</th>
<th>部门</th>
<th>操作</th>
</tr>
<%
List<Map<String,String>> user=(List<Map<String,String>>)request.getAttribute("userlist");
for(int i=0;i<user.size();i++)
{
%>
<tr>

<td><%=i+1 %></td>
<td><%=user.get(i).get("name")%></td>
<td><%=user.get(i).get("account")%></td>
<td><%=user.get(i).get("tel")%></td>
<td><%=user.get(i).get("dp")%></td>
<td><a href="EditEmployee?id= <%=user.get(i).get("id") %>" target="content">编 辑</a>&nbsp;&nbsp;
<a href="DeleteEmployee?id=<%=user.get(i).get("id") %>" target="content"> 删 除</a></td>
</tr>
<%} %>

</table>
</body>
</html>