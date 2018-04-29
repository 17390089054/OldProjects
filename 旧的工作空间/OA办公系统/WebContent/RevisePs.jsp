<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<title>密码修改  </title>
</head>
<body class="login-layout Reg_log_style" >

    <%
    String msg="";
    if(request.getAttribute("msg")!=null)
    {
    	msg=request.getAttribute("msg").toString();
    }
    String password="";
    if(request.getAttribute("password")!=null)
    {
    	password=request.getAttribute("password").toString();
    }
    String password1="";
    if(request.getAttribute("password1")!=null)
    {
    	password1=request.getAttribute("password1").toString();
    }
    
    String password2="";
    if(request.getAttribute("password2")!=null)
    {
    	password2=request.getAttribute("password2").toString();
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
								密码修改
							</h4>
							<form action="RevisePs" method="post"  >
								<fieldset>
									<ul style="margin:0 60px;">
									   <li  class="frame_style form_error" ><label class="user_icon"></label><input name="password" type="text" value="<%=password %>"  placeholder=" 请 输 入 原 密 码   "/></li>
										<li  class="frame_style form_error" ><label class="user_icon"></label><input name="password1" type="text" value="<%=password1 %>"  placeholder=" 请 输 入 新密 码   "/></li>
											<li  class="frame_style form_error" ><label class="user_icon"></label><input name="password2" type="text" value="<%=password2 %>"  placeholder=" 请 确 认 新 密 码   "/></li>
									 
									 </ul>
									<div class="space"></div>
									<div class="clearfix">
										
										<button type="submit" class="width-35 btn btn-sm btn-primary" style="margin-left:139px;" id="login_btn">
											<i class="icon-user"> 确 认 修 改  </i>
											
										</button>
									</div>
									
									<div class="space-4"></div>
									
									
								</fieldset>
							</form>
						<div align="center" style="color:red; size:30px"><span><%=msg %></span></div>
							<div class="social-or-login center">
								
								<!-- <span class="bigger-110">通知</span> -->
							</div>
						
						</div><!-- /widget-main -->
						<div class="toolbar clearfix">
					
						</div>
			</div><!-- /widget-body -->
		</div><!-- /login-box -->
	</div><!-- /position-relative -->
</div>

	
<!-- 	<div class="loginbm">版权所有  2017  <a href="">长春四海兴唐科技有限公司</a> </div><strong></strong>
 --></body>
</html>