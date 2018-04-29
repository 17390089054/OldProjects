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
	<title>登陆</title>
	
	
</head>
<body class="login-layout Reg_log_style" ><!-- style="background:purple;" -->

<canvas id="q"></canvas>
	<script type="text/javascript" >
var s = window.screen;
var width = q.width = s.width;
var height = q.height = s.height;
var letters = Array(256).join(1).split('');
var draw = function () {
  q.getContext('2d').fillStyle='rgba(0,0,0,.05)';
  q.getContext('2d').fillRect(0,0,width,height);
  q.getContext('2d').fillStyle='#0F0';
  letters.map(function(y_pos, index){
    text = String.fromCharCode(3e4+Math.random()*33);
    x_pos = index * 10;
    q.getContext('2d').fillText(text, x_pos, y_pos);
    letters[index] = (y_pos > 758 + Math.random() * 1e4) ? 0 : y_pos + 10;
  });
};
setInterval(draw, 33);
</script>
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
<script type="text/javascript">  
    // 这里使用最原始的js语法实现，可对应换成jquery语法进行逻辑控制  
    var demoImg = document.getElementById("demo_img");  
    var demoInput = document.getElementById("demo_input");  
    //隐藏text block，显示password block  
    function hideShowPsw(){  
        if (demoInput.type == "password") {  
            demoInput.type = "text";  
            demo_img.src = "invisible.png";  
        }else {  
            demoInput.type = "password";  
            demo_img.src = "visible.png";  
        }  
    }  
</script> 

	<div class="logintop">    
	    <span>欢迎登陆OA办公系统</span>    
	    <ul>
	    <li><a href="register.jsp">注册</a></li>
	    <li><a href="#">帮助</a></li>
	    <li><a href="#">关于</a></li>
	    </ul>   
    </div>
    <div class="loginbody">
		<div class="login-container">
			<div class="center" >
				<h1 style="color:white;">OA办公系统</h1>
	     		 <!--  <img src="resource/images/logo.png" />设置logo图片 -->
			</div>
			<div class="space-6" ></div>
			<div class="position-relative">
				<div id="login-box" class="login-box widget-box no-border visible" >
					<div class="widget-body" >
						<div class="widget-main" >
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee orange"></i>
								用 户  登  录
							</h4>
							<div class="login_icon"><img width="130px" height="130px" src="1.jpg" /></div>
							<form action="Login" method="post">
								<fieldset>
									<ul>
									   <li class="frame_style form_error"><label class="user_icon"></label><input name="用户名" type="text"  
									   value="<%=account%>"
									    placeholder=" 请 输 入 用 户 名 "/></li>
									   <li class="frame_style form_error"><label class="password_icon"></label><input name="密码" type="password"   placeholder="请 输 入 密 码 " id="userpwd"/></li>
									 </ul>
									<div class="space"></div>
									<div class="clearfix">
										<!-- <a>可添加其他功能</a> -->
										<button type="submit" class="width-35 pull-center btn btn-sm btn-primary" id="login_btn">
											<i class="icon-file"></i>
											登陆
										</button>
										<a href="register.jsp" class="width-35 pull-center btn btn-sm btn-primary" id="login_btn">
											<i class="icon-file"></i>
											注册
										</a>
									</div>
									
								</fieldset>
							</form>
							<div align="center" style="color:red" height="20%"><span><%=msg%></span></div>
							
							<div class="social-or-login center">
								<span class="bigger-110">温馨提示</span>
							</div>
							<div class="social-login center">
							本网站系统不再对IE8以下浏览器支持，请见谅。
							<%
							String name="";
							if(session.getAttribute("rand")!=null)
							{
								name=(String)session.getAttribute("rand");
							}
							%>
							<%=name %>
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



