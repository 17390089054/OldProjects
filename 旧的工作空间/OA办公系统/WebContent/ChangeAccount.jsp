<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	<title>切换账号 </title>
</head>
<body class="login-layout Reg_log_style" >

    <%
    String msg="";
    if(request.getAttribute("msg")!=null)
    {
    	msg=request.getAttribute("msg").toString();
    }
    String account="";
    if(request.getAttribute("account")!=null)
    {
    	account=request.getAttribute("account").toString();
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
								账号切换
							</h4>
							<form action="ChangeAccount" method="post"  >
								<fieldset>
									<ul style="margin:0 60px;">
									   <li  class="frame_style form_error" ><label class="user_icon"></label><input name="account" type="text" value="<%=account %>"  placeholder=" 请 输 入 账 号   "/></li>
										<li  class="frame_style form_error" ><label class="user_icon"></label><input name="password" type="password"   placeholder=" 请 输 入 密 码   "/></li>
									 
									 </ul>
									<div class="space"></div>
									<div class="clearfix">
										
										<button type="submit" class="width-25 btn btn-sm btn-primary" style="margin-left:90px;float:left" id="login_btn">
											<i class="icon-user"> 确 认 </i>
											</button>
											
										
											<button  type="button" class="width-25 btn btn-sm btn-primary" onclick="history.go(-1)" style="margin-right:130px;float:right"  >
											<i class="icon-user"> 取 消 </i>
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

 </body>
</html>