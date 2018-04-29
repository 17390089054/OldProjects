<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="java.util.Map"
	import="java.util.HashMap"
 %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告详情</title>
</head>
<body>
<%
	Map<String,String>map=new HashMap<String,String>();
	if(request.getAttribute("map")!=null)
	{
		map=(Map<String,String>)request.getAttribute("map");
		
	}
	String title="";
	String content="";
	String date="";
	if(map.get("notice_title")!=null)
	{
		title=map.get("notice_title").toString();
	}
	
	if(map.get("notice_content")!=null)
	{
		content=map.get("notice_content").toString();
	}
	
	
	if(map.get("create_time")!=null)
	{
		date=map.get("create_time").toString();
	}
	
%>
<div style="margin:5% 20% 0% 20%;background-color:lightblue;" >
<div align="center"  > 
<h1 style="color:purple">
公 告 详 情
</h1>
</div>
<div  align="center">
<%=title %>
</div>
<hr>
<div  align="center">
<%=content %>
<br>
<br>
<div style="float:left;margin-left:16%"><span >望 周 知 ！</span></div>
<br>
<br>
<div align="right" style="margin-right:2%"><%=date %></div>
</div>
</div>
</body>
</html>