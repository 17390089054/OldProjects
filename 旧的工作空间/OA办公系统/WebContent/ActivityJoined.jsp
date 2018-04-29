<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page 
    import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Map"
    import=" java.text.SimpleDateFormat"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="resource/css_table/css-table.css" />
<script type="text/javascript" src="resource/my_js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="resource/my_js/style-table.js"></script>
<title>正在进行的活动</title>
</head>
<body>
<table id="travel" summary="Travel times to work by main mode (Autumn 2006) - Source: London Travel Report 2007 http://www.tfl.gov.uk/assets/downloads/corporate/London-Travel-Report-2007-final.pdf" style="margin-top:1%">

	<!-- <caption style="font-size:18px;color:purple">活 动 表</caption> -->
    <%
    List<Map<String,String>>list=new ArrayList<Map<String,String>>();
    if(request.getAttribute("list")!=null)
    {
    	list=(List<Map<String,String>>)request.getAttribute("list");	
    }
    
    %>
   
    
    
    <thead>    
    	<tr>
            <th scope="col" rowspan="2">主 菜 单</th>
            <th scope="col" colspan="7">活&nbsp; &nbsp; &nbsp; &nbsp; 动 &nbsp; &nbsp; &nbsp; &nbsp;详 &nbsp; &nbsp; &nbsp; &nbsp;情</th>
        </tr>
        
        <tr>
            <th scope="col">标 &nbsp; &nbsp; &nbsp; &nbsp;题</th>
            <th scope="col">内 &nbsp; &nbsp; &nbsp; &nbsp;容</th>
            <th scope="col">开 始 时 间</th>
            <th scope="col">结 束 时 间</th>
            <th scope="col">发 起 时 间</th>
            <th scope="col">状 &nbsp; &nbsp;态</th>
             <th scope="col">操 &nbsp; &nbsp; &nbsp; &nbsp;作</th>
        </tr>        
    </thead>
    

    
    <tbody>
    <%
   
    
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    String time=df.format(new java.util.Date());
  
    int count=1;
    for(int i=list.size()-1;i>=0;i--)
    {
    	
    	  if(time.compareTo(list.get(i).get("s_date"))>=0&&time.compareTo(list.get(i).get("e_date"))<=0) 
    	{ 
    	
    %>
    	<tr>
    		<th scope="row"><%=count++ %></th>
            <td><%=list.get(i).get("a_title") %></td>
            <td><%=list.get(i).get("a_content") %></td>
            <td><%=list.get(i).get("s_date") %></td>
            <td><%=list.get(i).get("e_date") %></td>
            <td><%=list.get(i).get("a_date") %></td>
            <td>
           	<%
           	String status=list.get(i).get("a_status") ;
           	if(status.equals("0"))
           	{
           		out.write("未 开 始");
           	}
           	else
           	{
           		if(status.equals("1"))
           		{
           			out.write("正 在 进 行");
           		}
           		
           	}
           	%>
           	</td>
            <td>
            <a href="ActivityView?id=<%=list.get(i).get("a_id") %>" style="text-decoration:none">查 &nbsp;&nbsp;  看</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <a href="ActivityJoin?id=<%=list.get(i).get("a_id") %>" style="text-decoration:none">参 &nbsp;&nbsp;与</a>
            </td>
        </tr>
    
      <% } 
    	 
    	
    	}

    	%>  
    </tbody>

</table>
</body>
</html>