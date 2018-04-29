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
    <title>日报历史</title>
<style>

body {
    width: 95%;
    margin: 2% auto;
    font-family: 'trebuchet MS', 'Lucida sans', Arial;
    font-size: 17px;
    text-align:center;
    color: #444;
}

table {
    *border-collapse: collapse; /* IE7 and lower */
    border-spacing: 0;
    text-align:center;
    width: 100%;    
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
    text-align:center;  
}    
    
.bordered td, .bordered th {
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    padding: 15px;
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

</style>
</head>

<body>
<%
List<Map<String,String>>list=new ArrayList<Map<String,String>>();
		if(request.getAttribute("list")!=null)	
		{
			list=(List<Map<String,String>>)request.getAttribute("list");			
		}


	    boolean flag=false;
	    
	    if(list.size()>0)
	    {
	    	flag=true;
	    }
	    if(flag)
	    {


%>
<h2 style="text-align:center;color:purple;font-size:30px">日 报 历 史</h2>
<table class="bordered">
    <thead>

    <tr>
        <th>序 &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;号</th>        
        <th>日 报 名 称</th>
        <th>提 交 时 间</th>
         <th>提 交 状 态</th>
         <th>审 批 状 态</th>
         <th>操&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;作</th>
    </tr>
    </thead>
    <tr>
    <%

    for(int i=list.size()-1;i>=0;i--)
    {
    	int operation=0;
    %>
        <td><%=list.size()-i %></td>        
        <td><%=list.get(i).get("report_title") %></td>
		 <td><%=list.get(i).get("create_time") %></td>
        <td>
        <%
				if(list.get(i).get("report_status").equals("0"))
				{
					out.write("草 稿");
					operation=1;
				}
				else
				{
					out.write("已 提 交");
				}
        %>
        </td>
         <td>
         <%
         		
         		if(list.get(i).get("report_status").equals("2"))
         		{
         			out.write("已 审 批");
         		}
         		else
         		{
         			
         			out.write("未 审 批 ");
         		}
         
         
         %>
         
         </td>
          <td>
          <%
          if(operation==0)
          {
          %>
          <a href="ReportLook?id=<%=list.get(i).get("report_id") %>" name="content" style="text-decoration:none">查  &nbsp; &nbsp;看</a>
          <%} %>
          <%if(operation==1){ %>
          <a href="ReportEdit?id=<%=list.get(i).get("report_id") %>" name="content" style="text-decoration:none">编  &nbsp; &nbsp;辑</a>
          <%} %>
          </td>
    </tr>        
 <%}
    
    }
    
	    else
	    {
    
    	out.write("暂时没有日报! "+"<a href='WriteReport' name='content' style='text-decoration:none;font-size:20px;' >点我添加</a>");
   
	    }
    
    %>
</table>

<br><br>



<br>
    

</body>
</html>