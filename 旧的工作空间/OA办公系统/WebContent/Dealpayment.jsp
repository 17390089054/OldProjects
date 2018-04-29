<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page
    import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Map"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报销历史</title>
<style>

body {
    width:100% ;
    margin: 40px auto;
    font-family: 'trebuchet MS', 'Lucida sans', Arial;
    font-size: 14px;
    color: #444;
}

table {
    *border-collapse: collapse; /* IE7 and lower */
    border-spacing: 0;
    width: 100%;    
    text-align:center;
}

.bordered {
    border: solid #ccc 1px;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    -webkit-box-shadow: 0 1px 1px #ccc; 
    -moz-box-shadow: 0 1px 1px #ccc; 
    box-shadow: 0 1px 1px #ccc;         
}

.bordered tr:hover {
    background: #fbf8e9;
    -o-transition: all 0.1s ease-in-out;
    -webkit-transition: all 0.1s ease-in-out;
    -moz-transition: all 0.1s ease-in-out;
    -ms-transition: all 0.1s ease-in-out;
    transition: all 0.1s ease-in-out;     
}    
    
.bordered td, .bordered th {
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    padding: 10px;
    text-align: center;    
}

.bordered th {
    background-color: #dce9f9;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
    background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:    -moz-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:     -ms-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:      -o-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:         linear-gradient(top, #ebf3fc, #dce9f9);
    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
    border-top: none;
    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
}

.bordered td:first-child, .bordered th:first-child {
    border-left: none;
}

.bordered th:first-child {
    -moz-border-radius: 6px 0 0 0;
    -webkit-border-radius: 6px 0 0 0;
    border-radius: 6px 0 0 0;
}

.bordered th:last-child {
    -moz-border-radius: 0 6px 0 0;
    -webkit-border-radius: 0 6px 0 0;
    border-radius: 0 6px 0 0;
}

.bordered th:only-child{
    -moz-border-radius: 6px 6px 0 0;
    -webkit-border-radius: 6px 6px 0 0;
    border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
    -moz-border-radius: 0 0 0 6px;
    -webkit-border-radius: 0 0 0 6px;
    border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
    -moz-border-radius: 0 0 6px 0;
    -webkit-border-radius: 0 0 6px 0;
    border-radius: 0 0 6px 0;
}



/*----------------------*/

.zebra td, .zebra th {
    padding: 10px;
    border-bottom: 1px solid #f2f2f2;    
}

.zebra tbody tr:nth-child(even) {
    background: #f5f5f5;
    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
}

.zebra th {
    text-align: center;
    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
    border-bottom: 1px solid #ccc;
    background-color: #eee;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#f5f5f5), to(#eee));
    background-image: -webkit-linear-gradient(top, #f5f5f5, #eee);
    background-image:    -moz-linear-gradient(top, #f5f5f5, #eee);
    background-image:     -ms-linear-gradient(top, #f5f5f5, #eee);
    background-image:      -o-linear-gradient(top, #f5f5f5, #eee); 
    background-image:         linear-gradient(top, #f5f5f5, #eee);
}

.zebra th:first-child {
    -moz-border-radius: 6px 0 0 0;
    -webkit-border-radius: 6px 0 0 0;
    border-radius: 6px 0 0 0;  
}

.zebra th:last-child {
    -moz-border-radius: 0 6px 0 0;
    -webkit-border-radius: 0 6px 0 0;
    border-radius: 0 6px 0 0;
}

.zebra th:only-child{
    -moz-border-radius: 6px 6px 0 0;
    -webkit-border-radius: 6px 6px 0 0;
    border-radius: 6px 6px 0 0;
}

.zebra tfoot td {
    border-bottom: 0;
    border-top: 1px solid #fff;
    background-color: #f1f1f1;  
}

.zebra tfoot td:first-child {
    -moz-border-radius: 0 0 0 6px;
    -webkit-border-radius: 0 0 0 6px;
    border-radius: 0 0 0 6px;
}

.zebra tfoot td:last-child {
    -moz-border-radius: 0 0 6px 0;
    -webkit-border-radius: 0 0 6px 0;
    border-radius: 0 0 6px 0;
}

.zebra tfoot td:only-child{
    -moz-border-radius: 0 0 6px 6px;
    -webkit-border-radius: 0 0 6px 6px
    border-radius: 0 0 6px 6px
}
  
</style>
</head>
<body>
<%
List<Map<String,String>>list=new ArrayList<Map<String,String>>();

if(request.getAttribute("list")!=null)
{
	list=(List<Map<String,String>>)request.getAttribute("list");
}
%>
<h2 style="color:purple;font-size:30px;text-align:center">报 销 审 批</h2>
<table class="bordered">
    <thead>

    <tr>
        <th> 序&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</th>        
        <th>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</th>
        <th>原&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;因</th>
        <th>类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型</th>
        <th>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点</th>                
        <th>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态</th>        
        <th>金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额</th>
        <th>&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
    </tr>
    </thead>
    <%
    for(int i=list.size()-1;i>=0;i--)
    {
    	int status=0;
    %>
    <tr>
        <td><%=list.size()-i %></td>        
        <td><%=list.get(i).get("user_name") %></td>
		<td><%=list.get(i).get("p_reason") %></td>
        <td><%=list.get(i).get("p_type") %></td>
        <td><%=list.get(i).get("p_place") %></td>
        <td>
        <%
        if(list.get(i).get("p_status").equals("0"))
        {
        	out.write("未 审 批 ");
        	status=1;
        }
        else
        {
        	
        	out.write("已 审 批");
        }
        %>
        </td>
        <td><%=list.get(i).get("p_money") %></td>
        
        <td>
        <%
        if(status==1){
        %>
        <a href="PaymentCheck?id=<%=list.get(i).get("p_id") %>" name="content" style="color:orange;text-decoration:none">审 &nbsp; &nbsp; 批</a>
        <%} %>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="PaymentView?id=<%=list.get(i).get("p_id") %>" name="content" style="color:blue;text-decoration:none">查 &nbsp; &nbsp;看</a>
        </td>
    </tr>        
    <%} %>
</table>


<br>
    

</body>
</html>