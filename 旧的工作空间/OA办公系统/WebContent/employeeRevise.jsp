<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page 
    import="java.util.List"
    import="java.util.LinkedList"
    import="java.util.Map"
    import="java.util.ArrayList"
    %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="resource/assets/css/ace.min.css" />
	<link rel="stylesheet" href="resource/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="resource/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="resource/css/style.css"/>
	<script src="resource/assets/js/ace-extra.min.js"></script>
	<script src="resource/js/jquery-1.9.1.min.js"></script>        
    <script src="resource/assets/layer/layer.js" type="text/javascript"></script>
	<title>用 户 编 辑  </title>
</head>
<body class="login-layout Reg_log_style" style="background:purple;">

<%
	String id="";
	String account=""; 
	String user_name="";
	String id_card="";
	String addr="";
	String tel="";
	String department="";
	
	String msg="";
	
	
	
	List<Map<String,String>> list=new LinkedList<Map<String,String>>();
	if(request.getAttribute("list")!=null)
	{
		
		list=(List<Map<String,String>>)request.getAttribute("list");
		id=list.get(0).get("user_id");
		user_name=list.get(0).get("user_name");
		account=list.get(0).get("account");
		id_card=list.get(0).get("user_card");
		addr=list.get(0).get("user_addr");
		tel=list.get(0).get("user_tel");
		department=list.get(0).get("d_name");
	}
	else
	{
		if(request.getAttribute("msg")!=null)
		{
			msg=request.getAttribute("msg").toString();	
		}
		
		if(request.getAttribute("id")!=null)
		{
			id=request.getAttribute("id").toString();
		}
		
		if(request.getAttribute("account")!=null)
		{
			
			account=request.getAttribute("account").toString();
			
		}
		
		
		
		if(request.getAttribute("user_name")!=null)
		{
			user_name=request.getAttribute("user_name").toString();
		}
		
		if(request.getAttribute("id_card")!=null)
		{
			id_card=request.getAttribute("id_card").toString();
		}
		
		if(request.getAttribute("address")!=null)
		{
			addr=request.getAttribute("address").toString();
		}
		
		if(request.getAttribute("telephone")!=null)
		{
			tel=request.getAttribute("telephone").toString();
		}
		
		if(request.getAttribute("department")!=null)
		{
			department=request.getAttribute("department").toString();
		}
		
	}
	
	List<Map<String,String>> list2=new ArrayList<Map<String,String>>();
	if(request.getAttribute("list2")!=null)
	{
		list2=(List<Map<String,String>>)request.getAttribute("list2");
		
	}

	
%>
<div class="loginbody" style="height:620px">
	<div class="login-container">
	<div class="center"></div>	
	<div class="position-relative" >
 				
	<div class="widget-body">
		<div class="widget-main">
			<h4 class="header blue lighter bigger">
			<i class="icon-coffee orange">用 户 编 辑</i>
										
			</h4>
				<form action="EmployeeRevise" method="post">

								
				<fieldset>
					<ul style="margin:0 60px;">
					  <li> 
					  <input name="id" type="hidden" value="<%=id %>"  >
					  </li>
					   <li  class="frame_style form_error">
					   <label class="user_icon"></label>
					   <input name="account" type="text" value="<%=account %>"  placeholder=" 用   户   名  "  readonly/>
					   </li>
					   <li  class="frame_style form_error">
					   <label class="user_icon"></label>
					   <input name="user_name" type="text" value="<%=user_name %>" placeholder=" 真  实   姓   名   "/>
					   </li>
						 <li  class="frame_style form_error">
						 <label class="user_icon"></label>
						 <input name="id_card" type="text" value="<%=id_card %>" placeholder=" 身   份   证   号  "/>
						 </li>
					  	 <li  class="frame_style form_error">
					  	 <label class="user_icon"></label>
					  	 <input name="address" type="text" value="<%=addr %>" placeholder=" 家   庭   住   址 "/>
					  	 </li>
					  	  <li  class="frame_style form_error">
					  	  <label class="user_icon"></label>
					  	  <input name="telephone" type="number" value="<%=tel %>" 
					  	  oninput="if(value.length>11)value=value.slice(0,11)"    placeholder=" 联  系  电  话  "/>
					  	  </li>
					 	<li  class="frame_style form_error">
					 	
					 	<label class="home_icon"></label>
					 						 
					 	<select name="department" value="<%=department %>" style="width:100px;">
					 	<option>
					 	<%=department%>
					 	</option>
					 	<% 
					 	for(int i=0;i<list2.size();i++)
					 	{
					 	%>
					 	<option>
					 	<%
						 out.write(list2.get(i).get("d_name"));	
					 	%>
					 	</option>
					 	<% }%>
					 	</select>
					 	</li>
					 		
					 </ul>
					<div class="space"></div>
					<div class="clearfix">
						
						<button type="submit" class="width-35 btn btn-sm btn-primary" style="margin-left:139px;" id="login_btn">
							<i class="icon-home">	</i>
						确 认 修 改
						</button>
					</div>
					<div>
				<div align="center"><span style="color:red;size:20px;"><%=msg %></span></div>
					</div>
					<div class="space-4"></div>
				</fieldset>
						
		</form>
		</div>
	</div>
	</div>
	</div>
	
</div>
</body>
</html>