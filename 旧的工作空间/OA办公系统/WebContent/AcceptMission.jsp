<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Map"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务查看</title>
<style>
table
{
margin:2% auto 0% auto;
width:85%;
text-align:center;
}
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
<h2 style="text-align:center;font-size:30px;color:purple">任 务 列 表</h2>
<table class="zebra">
    <thead>
    <tr>
        <th>序 &nbsp;&nbsp;&nbsp;&nbsp;号</th>              
        <th>内 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;容</th>
         <th>标&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;题</th>
		<th>时&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;间</th>        
        <th>部&nbsp;&nbsp;&nbsp;&nbsp; 门</th>
        <th>状 &nbsp;&nbsp;&nbsp;&nbsp;态</th>
         <th>操 &nbsp;&nbsp;&nbsp;&nbsp;作</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <td>&nbsp;</td>        
        <td></td>
        <td></td>
         <td></td>
          <td></td>
           <td></td>
            <td></td>
    </tr>
    </tfoot>    
    <tr>
<%
List<Map<String,String>>list=new ArrayList<Map<String,String>>();
if(request.getAttribute("list")!=null)
{
	list=(List<Map<String,String>>)request.getAttribute("list");
}

	for(int i=list.size()-1;i>=0;i--)
	{
		int operation=0;
%>
        <td><%=list.size()-i %></td>        
        <td><%=list.get(i).get("m_content") %></td>
        <td><%=list.get(i).get("m_title") %></td>
        <td><%=list.get(i).get("m_date") %></td>
        <td><%=list.get(i).get("d_name") %></td>
        <td>
        <%
     	String	status=list.get(i).get("m_status");
        if(status.equals("0"))
        {
        	out.write("未 接 受 ");
        }
        
        if(status.equals("1"))
        {
        	operation=1;
        	out.write("已 接 受 ");
        }
     	%>
        </td>
        <td>
        <a href="CheckMission?id=<%=list.get(i).get("m_id") %>" name="content" style="text-decoration:none;color:skyblue">&nbsp;&nbsp;&nbsp;&nbsp;查 &nbsp;&nbsp;看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%if(operation==0){ %>
        <a href="GetMission?id=<%=list.get(i).get("m_id")%>" name="content" style="text-decoration:none;color:purple">接&nbsp;&nbsp; 受</a>
        <%} %>
        </td>
     
   
    </tr>        
   <%
	}
   %> 
</table>
</body>
</html>