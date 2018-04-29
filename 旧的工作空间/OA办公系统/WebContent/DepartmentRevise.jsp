<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page 
    import="java.util.List" 
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
	<title>用户注册  </title>
</head>
<body class="login-layout Reg_log_style" style="background:purple;">
<div class="logintop">    
	    <span>欢迎登陆OA办公系统</span>    
	    <ul>
	    <li><a href="login.jsp">退出系统</a></li>
	    <li><a href="#">帮助</a></li>
	 
	    </ul>    
    </div>
    <%
    String id="";
    String msg="";
    String department="";
  	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
  	list=(List<Map<String,String>>)request.getAttribute("list");
  	if(list!=null)
  	{
  		id=list.get(0).get("d_id").toString();
  		department=list.get(0).get("d_name").toString();	
  	}
  	else
  	{
  		if(request.getAttribute("id")!=null)
  		{
  			id=request.getAttribute("id").toString();
  		}

  	    if(request.getAttribute("msg")!=null)
  	    {
  	    	msg=request.getAttribute("msg").toString();
  	    }
  	   
  	    if(request.getAttribute("department")!=null)
  	    {
  	    	department=request.getAttribute("department").toString();
  	    }
  	    
  		
  		
  	}
  	
  	
  	
    %>
  <div class="loginbody" style="height:620px">
		 <div class="login-container">
			<div class="center">
				
			</div> 
			
		
			<div class="position-relative" >

					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee orange"></i>
								部 门 修  改
							</h4>
							<form action="DepartmentRevise" method="post"  >
								<fieldset>
									<ul style="margin:0 60px;">
									<!-- <li  class="frame_style form_error"><label class="user_icon"></label> --><input name="id" type="hidden" value="<%=id %>" /><!-- </li> -->
									   <li  class="frame_style form_error"><label class="user_icon"></label><input name="department" type="text" value="<%=department %>"  /></li>
									  
									 </ul>
									<div class="space"></div>
									<div class="clearfix">
										
										<button type="submit" class="width-35 btn btn-sm btn-primary" style="margin-left:139px;" id="login_btn">
											<i class="icon-user"> 确 认 修  改  </i>
											
										</button>
									</div>
									
									<div class="space-4"></div>
									
									
								</fieldset>
							</form>
						<div align="center" style="color:red; size:30px"><span><%=msg %></span></div>
							<div class="social-or-login center">
								
							</div>
						
						</div><!-- /widget-main -->
						<div class="toolbar clearfix">
					
						</div>
			</div><!-- /widget-body -->
		</div><!-- /login-box -->
	</div><!-- /position-relative -->
</div>

	
	<div class="loginbm">版权所有  2017  <a href="">长春四海兴唐科技有限公司</a> </div><strong></strong>
</body>
</html>