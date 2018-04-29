<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Map"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日报编辑</title>
</head>
<body>
<%
String id="";
String title="";
String context="";
String date="";
String msg="";
List<Map<String,String>>list=new ArrayList<Map<String,String>>();
if(request.getAttribute("list")!=null)
{
	list=(List<Map<String,String>>)request.getAttribute("list");
	id=list.get(0).get("report_id");
	title=list.get(0).get("report_title");
	context=list.get(0).get("report_content");
	date=list.get(0).get("create_time");	
}
else
{
	if(request.getAttribute("id")!=null)
	{
		id=request.getAttribute("id").toString();
	}
	
if(request.getAttribute("title")!=null)
{
	title=request.getAttribute("title").toString();
	
}

if(request.getAttribute("context")!=null)
{
	context=request.getAttribute("context").toString();
	
}

if(request.getAttribute("date")!=null)
{
	date=request.getAttribute("date").toString();
	
}



if(request.getAttribute("msg")!=null)
{
	msg=request.getAttribute("msg").toString();
	
}
}
%>
<div style="background-color:lightgray">
<form action="ReportEdit"  method="post">

 <span style="color:purple;size:30px;align:center"> 日 报 编 辑 </span>
 <fieldset style="text-align:center;margin-right:4%;border:0">
 <ul style="list-style:none;">
<li><input type="hidden" name="id" value="<%=id%>"/></li>

<li style="margin-top:1%">
<label> 标 题 </label> 
<input type="text" style="width:26%;border-radius:5px;padding:5;" name="title" value="<%=title%>" />
</li>



<li style="margin-top:1%">
<label>内 容 </label>
<textarea cols="46" rows="22" name="context" style="border-radius:5px">
<%=context %>
</textarea>
</li>


<li style="margin-top:1%">
<label>时 间 </label>
<input type="date" name="date" style="width:25%;padding:5 25;margin:10;border-radius:5px ;"  value="<%=date%>"/>
</li>
<input type="submit"  style="background-color:red;color:white;font-size:18px;padding:10 25 10 25;margin:10 60 0 60;border-radius:10px;"  value="确 认 提 交"     />

</ul>
</fieldset>


</form>
<div align="center" style="margin-top:5px;"><span style="color:red;size:30px;"><%=msg %></span></div>
</div>



</body>
</html>