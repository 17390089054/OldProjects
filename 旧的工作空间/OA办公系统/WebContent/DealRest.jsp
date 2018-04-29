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
<title>请假处理</title>
<link rel="stylesheet" type="text/css" media="screen" href="resource/css_table/css-table.css" />
<script type="text/javascript" src="resource/my_js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="resource/my_js/style-table.js"></script>
</head>

<body>
<%
	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
	if(request.getAttribute("list")!=null)
	{
		list=(List<Map<String,String>>)request.getAttribute("list");
	}



%>
<table id="travel" summary="Travel times to work by main mode (Autumn 2006) - Source: London Travel Report 2007 http://www.tfl.gov.uk/assets/downloads/corporate/London-Travel-Report-2007-final.pdf">

	<caption>请 假  处 理 </caption>
    
    <thead>    
    	<tr>
            <th scope="col" rowspan="2">申&nbsp; &nbsp;请&nbsp;&nbsp; 列&nbsp;&nbsp; 表</th>
            <th scope="col" colspan="7"> 请 &nbsp;&nbsp; 假 &nbsp;&nbsp;详 &nbsp;&nbsp;情 </th>
        </tr>
        
        <tr>
            <th scope="col">姓 &nbsp;&nbsp;名</th>
            <th scope="col">请 假 原 因</th>
            <th scope="col">起 始 日 期</th>
            <th scope="col">截 止 日 期</th>
            <th scope="col">审 批 状 态</th>
           	<th  scope="col">回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;复</th>
            <th scope="col">操 &nbsp;&nbsp;&nbsp;&nbsp;作</th>
        </tr>        
    </thead>
    
  
    
    <tbody>
    <%
		for(int i=list.size()-1;i>=0;i--)    
		{
			int reply=0;
    %>
    	<tr>
    		<th scope="row">第 <%=list.size()-i %> 条</th>
            <td><%=list.get(i).get("user_name") %></td>
            <td><%=list.get(i).get("rest_reason") %></td>
            <td><%=list.get(i).get("start_date") %></td>
            <td><%=list.get(i).get("end_date") %></td>
            <td><%
            if(list.get(i).get("rest_status").equals("0"))
            {
            	out.write("待 审 批");
            	reply=1;
            }
            
            if(list.get(i).get("rest_status").equals("1"))
            {
            	out.write("已 审 批");
            }
            if(list.get(i).get("rest_status").equals("2"))
            {
            	out.write("已 审 批");
            }
            %></td>
            <td>
            <%
            if(reply==1)
            {
            	out.write("无");
            }
            else
            {
            	out.write(list.get(i).get("reply"));
            	
            }
            
            %></td>
            <td>
            <%if(reply==0){ %>
            <a href="RestView?id=<%=list.get(i).get("rest_id") %>" name="content" style="text-decoration:none">查&nbsp;&nbsp;&nbsp;&nbsp;看</a>
             <%} %>
             <%if(reply==1) {%>
             <a href="RestCheck?id=<%=list.get(i).get("rest_id") %>" name="content" style="text-decoration:none">审&nbsp;&nbsp;&nbsp;&nbsp;批</a></td>
        <%} %>
        </tr>
        
   <%} %>    
        
    </tbody>

</table>


</body>
</html>