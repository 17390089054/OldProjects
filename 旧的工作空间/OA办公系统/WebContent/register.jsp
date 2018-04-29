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
	<title>用户注册  </title>
</head>
<body class="login-layout Reg_log_style" style="background:purple;">
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

String password="";
if(request.getAttribute("password")!=null)
{
	password=request.getAttribute("password").toString();
}

String password2="";
if(request.getAttribute("password2")!=null)
{
	password2=request.getAttribute("password2").toString();
}

String user_name="";
if(request.getAttribute("user_name")!=null)
{
	user_name=request.getAttribute("user_name").toString();
}


String id_card="";
if(request.getAttribute("id_card")!=null)
{
	id_card=request.getAttribute("id_card").toString();
}


String address="";
if(request.getAttribute("address")!=null)
{
	address=request.getAttribute("address").toString();
}


String telephone="";
if(request.getAttribute("telephone")!=null)
{
	telephone=request.getAttribute("telephone").toString();
}



%>
	<div class="logintop">    
	    <span>欢迎注册OA办公系统</span>    
	    <ul>
	    <li><a href="login.jsp">登陆</a></li>
	    <li><a href="#">帮助</a></li>
	    <li><a href="#">关于</a></li>
	    </ul>    
    </div>
    <div class="loginbody" style="height:620px">
		 <div class="login-container">
			<div class="center">
				
			</div> 
			
		
			<div class="position-relative" >
<!-- 				<div id="login-box" class="login-box widget-box no-border visible">
 -->					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee orange"></i>
								欢 迎 注 册
							</h4>
							<form action="Register" method="post"  >
								<fieldset>
									<ul style="margin:0 60px;">
									   <li  class="frame_style form_error"><label class="user_icon"></label><input name="account" type="text"  value="<%=account %>" placeholder=" 用   户   名  "/><!-- <i>用户名</i> --></li>
									   <li  class="frame_style form_error"><label class="home_icon"></label><input name="password" type="password"  value="<%=password %>" placeholder=" 密    码  "/><!-- <i>用户名</i> --></li>
									   <li  class="frame_style form_error"><label class="home_icon"></label><input name="password2" type="password"  value="<%=password2 %>" placeholder=" 确   认   密   码  "/>
									   <li  class="frame_style form_error"><label class="user_icon"></label><input name="user_name" type="text" value="<%=user_name %>" placeholder=" 真  实   姓   名   "/><!-- <i>用户名</i> --></li>
										 <li  class="frame_style form_error"><label class="user_icon"></label><input name="id_card" type="text" value="<%=id_card %>" placeholder=" 身   份   证   号  "/>
									  	 <li  class="frame_style form_error"><label class="user_icon"></label><input name="address" type="text" value="<%=address%>" placeholder=" 家   庭   住   址 "/>
									  	  <li  class="frame_style form_error"><label class="user_icon"></label><input name="telephone" type="number" oninput="if(value.length>11)value=value.slice(0,11)"  value="<%=telephone %>"  placeholder=" 联  系  电  话  "/>
									 </ul>
									<div class="space"></div>
									<div class="clearfix">
										<!-- <a>可添加其他功能</a> -->
										<button type="submit" class="width-35 btn btn-sm btn-primary" style="margin-left:139px;" id="login_btn">
											<i class="icon-file"></i>
											注册
										</button>
									</div>
									<div class="space-4"></div>
								</fieldset>
							</form>
							<div align="center" style="color:red; size:20px"><span><%=msg %></span></div>
							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>
							<div class="social-login center">
							本网站系统不再对IE8以下浏览器支持，请见谅。
							</div>
						</div><!-- /widget-main -->
						<div class="toolbar clearfix">
						</div>
					</div><!-- /widget-body -->
				</div><!-- /login-box -->
			</div><!-- /position-relative -->
		</div>
	</div>
	<div class="loginbm">版权所有  2017  <a href="">长春四海兴唐科技有限公司</a> </div><strong></strong>
</body>
</html>