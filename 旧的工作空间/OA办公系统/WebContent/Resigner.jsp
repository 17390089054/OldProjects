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
<title>离职查看</title>
</head>
<body>
<div class="page-content clearfix">

	<div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover">
		<thead>
		 <tr>
				
				<th width="80"> 序 号</th>
				<th width="100"> 用 户 名 </th>
				<th width="100"> 员 工 姓 名 </th>
				<th width="100"> 所 属部 门 </th>
				<th width="180"> 加 入 时 间 </th>
				
				<th width="200"> 家 庭 地 址 </th>
				
				<th width="70"> 状 态 </th>                
				<!-- <th width="180"> 操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 作 </th> -->
			</tr>
		</thead>

	<tbody>
	 <% 
	 
 List<Map<String,String>>list=new ArrayList<Map<String,String>>();
     
     if(request.getAttribute("list")!=null)
     {
    	   
    	 list=(List<Map<String,String>>)request.getAttribute("list");
	
     }
     
     
   
    
		for(int i=0;i<list.size();i++)
		{
	%>
		<tr>
         <td><%=i+1%></td>
         	
         <td><%=list.get(i).get("account")%></td>
         <td><%=list.get(i).get("user_name")%></td>
         <td><%-- <%=list.get(i).get("d_name")%> --%></td>
         <td><%=list.get(i).get("user_create_time") %></td>
         <td><%=list.get(i).get("user_addr") %></td>
         <td>
         <%
         String stus=list.get(i).get("user_status");
         if(stus.equals("1"))
         {
        	 out.write("在 职");
         }
         else
         {
        	 out.write("离 职");
         }
         %>
         </td>
        <%--  <td>
         <a href="EmployeeRevise?id=<%=list.get(i).get("user_id")%>" target="content" style="link:lightblue;visited:lightyellow;hover:purple">修 &nbsp;改</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="EmployeeDelete?id=<%=list.get(i).get("user_id")%>" onclick="javascript:return del();" target="content" style="link:red;visited:lightyellow;hover:purple">删 &nbsp;除</a>
         </td> --%>
		</tr>
	<%} %> 
      </tbody>
	</table>
	<div class="row">
	<div class="col-sm-6">

	</div>
	</div>	
   </div>
</div>
</body>
</html>