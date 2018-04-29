<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"
	import="java.util.ArrayList"
	import="java.util.Map"
 %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="resource/css/style.css"/>       
        <link href="resource/assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="resource/assets/css/ace.min.css" />
        <link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
        <style type="text/css">
        .btn
        {
        bg-color:blue;
        font-color:white;
        
        }
        .btn2
        {
        bg-color:red;
        font-color:white;
        }
        
        </style>
<style type="text/css"> 


body { 
font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
color: #4f6b72; 
background: #E6EAE9; 
} 

a { 
color: #c75f3e; 
} 

#mytable { 
width: 65%; 
 text-align:center; 
padding:5px,2px,auto,5px ; 
margin: auto; 
} 

caption { 
padding: 6px 10px 10px 180px; 
width: 700px; 
font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
font-size:30px;
text-align: center; 
} 

th { 
font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 

font-size:22px;
color: #4f6b72; 
 border-right: 1px solid #C1DAD7;  
border-bottom: 1px solid #C1DAD7;  
 border-top: 1px solid #C1DAD7;
letter-spacing: 2px; 
text-transform: uppercase; 
text-align: center; 
padding: 15px 15px 10px 5px;  
background: #CAE8EA  no-repeat; 
} 

th.nobg { 
border-top: 0; 
border-left: 0; 
border-right: 1px solid #C1DAD7; 
background: none; 
} 

td { 
align:center;
border-right: 1px solid #C1DAD7; 
border-bottom: 1px solid #C1DAD7; 
background: #fff; 
font-size:18px; 
padding: 10px 10px 20px 10px; 
color: #4f6b72; 
} 


td.alt { 
background: #F5FAFA; 
color: #797268; 
} 

th.spec { 
 border-left: 1px solid #C1DAD7; 
border-top: 0; 
background: #fff no-repeat; 
font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
} 

th.specalt { 
 border-left: 1px solid #C1DAD7;  
border-top: 0; 
background: #f5fafa no-repeat; 
font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
color: #797268; 
} 
 
</style> 
        
			<script src="resource/assets/js/jquery.min.js"></script>

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="resource/assets/js/bootstrap.min.js"></script>
		<script src="resource/assets/js/typeahead-bs2.min.js"></script>
		<script src="resource/assets/js/jquery.dataTables.min.js"></script>
		<script src="resource/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="resource/js/H-ui.js"></script> 
        <script type="text/javascript" src="resource/js/H-ui.admin.js"></script> 
        <script src="resource/assets/layer/layer.js" type="text/javascript" ></script>
        <script src="resource/assets/laydate/laydate.js" type="text/javascript"></script>
<title>部 门 列 表 </title>
</head>

<body>
<script type="text/javascript">
function del()
{
	var msg="确 认 删 除 ?";
	if(confirm(msg)==true)
	{
		return true;
	}
	else
	{
		return false;
	}
	
}

</script>
<%
	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
	if(request.getAttribute("list")!=null)
	{
		list=(List<Map<String,String>>)request.getAttribute("list");
		
	}
	
%>
<div id="Member_Ratings">
     
  <div class="d_Confirm_Order_style">
      
    <div class="search_style">
			<div class="table_menu_list">
			<!-- <form action="DepartmentList" method="post"> -->
			       <table id="mytable" >
			       <caption><span>公 司 部 门 表 </span></caption> 
					<tr>
					<th scope="col"> 序 号 </th>
					<th scope="col"> 部 门 名 称 </th>
					<th scope="col"> 部 门  状 态 </th>
					<th scope="col"> 操 &nbsp;&nbsp;&nbsp;&nbsp;作 </th>
					</tr>
					<%
					for(int i=0;i<list.size();i++)
					{			
						String status=list.get(i).get("d_status");
						if(!status.equals("0"))
						{
						
					%>
					<tr>
					<input type="hidden" value="<%=list.get(i).get("d_id")%>"/>
					<td class="row"><%=i+1%></td>
					<td class="row"><%=list.get(i).get("d_name") %></td>
					<td class="row">
					<%
					
					if(status.equals("1"))
					{
						
						out.write("可          用");					
					}
					else
					{
						
						out.write("不     可       用");
					}					
					%> 
					</td>
					<td class="row">
					 <a href="DepartmentRevise?id=<%=list.get(i).get("d_id")%>" name="content" style="link:lightblue;visited:lightyellow;hover:purple">修 &nbsp;改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <a href="DepartmentDelete?id=<%=list.get(i).get("d_id")%>"  onclick="javascript:return del();" 
					 name="content" style="link:red;visited:lightyellow;hover:purple">删 &nbsp;除</a>
					</td>
					</tr>
					<%} 
					}
					%>
					</table>
				<!-- </form> -->
			</div>
	</div>
 </div>
</div>
</body>


</html>