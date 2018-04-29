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
<title>查看日报</title>
</head>
<body>
<%
	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
	if(request.getAttribute("list")!=null)
	{
		list=(List<Map<String,String>>)request.getAttribute("list");
	}

%>

<div style="background-color:lightgray;height:100%">
 <span style="color:purple;size:30px;align:center"> 查 看 日 报 </span>
 <fieldset style="text-align:center;margin-right:4%;border:0">
 <ul style="list-style:none;">


<li style="margin-top:1%">
<span style="font-size:28px;color:purple">
 <%=list.get(0).get("report_title")%>
</span>
</li>



<li style="margin-top:1%">
<span style="font-size:20px;color:green">
<%=list.get(0).get("report_content") %>
</span>
</li>


<li style="margin-top:1%;text-align:right;">
<span style="font-size:15px;color:blue">
<br/><br/><br/>
<%=list.get(0).get("create_time") %>
</span>
</li>


</ul>
</fieldset>


<div align="center" style="margin-top:5px;"><span style="color:red;size:30px;"></span></div>
</div>
</body>
</html>