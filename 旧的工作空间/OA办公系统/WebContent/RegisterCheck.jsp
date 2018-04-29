<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"  import="java.util.ArrayList"  import="java.util.Map"%>
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
			<script src="resource/assets/js/jquery.min.js"></script>

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="resource/assets/js/bootstrap.min.js"></script>
		<script src="resource/assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="resource/assets/js/jquery.dataTables.min.js"></script>
		<script src="resource/assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="resource/js/H-ui.js"></script> 
        <script type="text/javascript" src="resource/js/H-ui.admin.js"></script> 
        <script src="resource/assets/layer/layer.js" type="text/javascript" ></script>
        <script src="resource/assets/laydate/laydate.js" type="text/javascript"></script>
<title>注册审批</title>
</head>
<body>
<div class="page-content clearfix">

	<div class="table_menu_list">
		 <% 
	 
	 String msg="";
	 if(request.getAttribute("msg")!=null)
	 {
		 msg=request.getAttribute("msg").toString();
	 }
	 
 List<Map<String,String>>list=new ArrayList<Map<String,String>>();
     
     if(request.getAttribute("list")!=null)
     {
    	   
    	 list=(List<Map<String,String>>)request.getAttribute("list");
    	 
	
     }
     List<Map<String,String>>list2=new ArrayList<Map<String,String>>();
     if(request.getAttribute("list2")!=null)
     {
    	   
    	 list2=(List<Map<String,String>>)request.getAttribute("list2");
	
     } 
     
     String department="";
     if(request.getAttribute("department")!=null)
     {
    	 department=request.getAttribute("department").toString();
     }
     
		boolean flag=false;
		if(list.size()>0)
		{
			flag=true;
		}
		
		if(flag)
		{
	%>
	<form action="RegisterCheck" method="post">
       <table class="table table-striped table-bordered table-hover">
		<thead>
		 <tr>
				
				<th width="80"> 序 号</th>
				<th width="80"> 用 户 名 </th>
				<th width="120"> 员 工 姓 名 </th>
				<th width="150"> 所 属部 门 </th>
				<th width="180"> 加 入 时 间 </th>
				
				<th width="200"> 家 庭 地 址 </th>
				
				<th width="100"> 状 态 </th>                
				<th width="160"> 审&nbsp;&nbsp;&nbsp;&nbsp; 批 </th>
			</tr>
		</thead>

	<tbody>

     <% 
    
     
    
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).get("fk_department_id")==null)
			{
	%>
		<tr>
         <td><%=i+1%></td>
         <input type="hidden" name="user_id"  value="<%=list.get(i).get("user_id") %>">	
         <td><%=list.get(i).get("account")%></td>
         <td><%=list.get(i).get("user_name")%></td>
         <td>
         <select name="department"  style="width:100px;">
         <option>
     	<%=department %>
         </option>
         <%
         	for(int j=0;j<list2.size();j++)
         	{
         %>
         <option>
         <%=list2.get(j).get("d_name") %>
         </option>
         <%
         	}
         %>
         </select>
         </td>
         	
         <td><%=list.get(i).get("user_create_time") %></td>
         <td><%=list.get(i).get("user_addr") %></td>
         <td>
         <%
          String status=list.get(i).get("user_status");
         
          if(status.equals("2"))
         {
        	 out.write("待审批");
         }
        
         %>

         </td>
         <td>
        
          <input type="submit" value="  确     定   " style="background-color:skyblue;color:white ;border-radius:5px;">&nbsp;&nbsp;&nbsp;
          <input type="button" value="  取     消   " onclick="history.go(-1)" style="background-color:orange;color:white ;border-radius:5px;">
         </td>
		</tr>
	<%}
			else
			{
				out.write("<span>暂时没有注册用户!</span>");
			}
		}
		
	}%> 
      </tbody>
	</table>
	</form>
	<div><span style="color:red;size:20px;align:center"><%=msg%></span></div>
	<div class="row">
	<div class="col-sm-6">

	</div>
	</div>	
   </div>
 </div>
</body>
</html>