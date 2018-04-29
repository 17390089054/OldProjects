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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>操作日志</title>
	<link rel="stylesheet" href="resource/css_log/style.css" type="text/css">
</head>

<body>

<div id="container">   
<%
	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
	
	if(request.getAttribute("list")!=null)
	{
		list=(List<Map<String,String>>)request.getAttribute("list");
	
	}



%>
	<table class="zebra">
    <caption>系 统 操 作 日 志</caption>
		<thead>
        	<tr>
				<th>序&nbsp;&nbsp;号</th>
				<th>用 户 名</th>
				<th>操 作 人 员</th>
				<th>操 作 内 容</th>
				<th>操 作 时 间</th>
            </tr>
		</thead>
        <tbody>
        <%
        for(int i=list.size()-1;i>0;i--)
        {
        %>
        	<tr>
            	<td><%=list.size()-i %></td>
                <td><%=list.get(i).get("log_account") %></td>
                <td><%=list.get(i).get("log_name") %></td>
                <td><%=list.get(i).get("log_action") %></td>
                <td><%=list.get(i).get("log_date") %></td>
            </tr>
            <%} %>
        </tbody>
	</table>
</div>
    
</body>
</html>