  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" ></meta>
		<title>OA办公系统  </title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="resource/assets/css/ace.min.css" />
		<link rel="stylesheet" href="resource/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="resource/assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="resource/css/style.css"/>
		<script src="resource/assets/js/ace-extra.min.js"></script>
		<script src="resource/js/jquery-1.9.1.min.js"></script>        
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="resource/assets/js/bootstrap.min.js"></script>
		<script src="resource/assets/js/typeahead-bs2.min.js"></script>
		<script src="resource/assets/js/ace-elements.min.js"></script>
		<script src="resource/assets/js/ace.min.js"></script>
        <script src="resource/assets/layer/layer.js" type="text/javascript"></script>
		<script src="resource/assets/laydate/laydate.js" type="text/javascript"></script>
        <script src="resource/js/jquery.nicescroll.js" type="text/javascript"></script>
	    <script src="resource/my/index.js" type="text/javascript"></script>
	</head>
	<body class="skin-2">
		<div class="navbar navbar-default" id="navbar">
        <script type="text/javascript">try{ace.settings.check('navbar' , 'fixed')}catch(e){}</script>
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="" class="navbar-brand">
						
						<br/>
						<h1>	OA办公系统
						</h1>			
				</a>
				</div>
				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">	
						<li class="light-blue no-border margin-1 light-pink">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span  class="time"><em id="time"></em></span>
								<span class="user-info"><small>欢迎光临,</small>
								<%
								String user_name="";
								if(	session.getAttribute("user_name")!=null)
								{
									 user_name=session.getAttribute("user_name").toString();
								}
								
								String email="";
								if(session.getAttribute("email")!=null)
								{
									email=session.getAttribute("email").toString();
								}
							
								out.write(user_name);
								%>
								</span>
				 				<i class="icon-caret-down"></i>
							</a>
							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li><a href="javascript:void(0)" name="ChangeAccount" title="切换账号" class="iframeurl"><i class="icon-cog"></i>切换账号</a></li>
								<li><a href="javascript:void(0)" name="ReviseInfo" title="个人信息" class="iframeurl"><i class="icon-user"></i>个人资料</a></li>
								<li><a href="javascript:void(0)" name="RevisePs" title="修改密码" class="iframeurl"><i class="icon-user"></i>修改密码</a></li>
								<li class="divider"></li>
								<li><a href="javascript:ovid(0)" id="Exit_system"><i class="icon-off"></i>退出</a></li>
							</ul>
			   			</li>
	           			<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href=""><i class="icon-bell-alt"></i><span class="badge badge-important">8</span></a>
							<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
	                            <li class="dropdown-header"><i class="icon-warning-sign"></i><%=email %>条通知</li>
	                            <li>
                              		<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comments-alt"></i>
												最新消息
											</span>
											<span class="pull-right badge badge-info">+<%=email %></span>
										</div>
									</a>
								</li>
								<li>
									<a href="Login">
										<i class="btn btn-xs btn-primary icon-user"></i>
										切换为登录
									</a>
								</li>
								<li>
									<a href="ReciveLetter" target="_self">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
												最近邮件
											</span>
											<span class="pull-right badge badge-success">+<%=email %></span>
										</div>
									</a>
								</li>
								<li>
									<a href="dd.jsp" target="iframe">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-info icon-twitter"></i>
												用户消息
											</span>
											<span class="pull-right badge badge-info">+4</span>
										</div>
									</a>
								</li>
								<li>
									<a href="#">
										查看所有通知
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>
					</ul>
            
                </div>
			</div>
		</div>
		<div class="main-container" id="main-container">
        <script type="text/javascript">try{ace.settings.check('main-container' , 'fixed')}catch(e){}</script>
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>
			<div class="sidebar" id="sidebar">
			<script type="text/javascript">try{ace.settings.check('sidebar' , 'fixed')}catch(e){}</script>
					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<a class="btn btn-success">
								<i class="icon-signal"></i>
							</a>
							<a class="btn btn-info">
								<i class="icon-pencil"></i>
							</a>
							<a class="btn btn-warning">
								<i class="icon-group"></i>
							</a>
							<a class="btn btn-danger">
								<i class="icon-cogs"></i>
							</a>
						</div>
						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>
							<span class="btn btn-info"></span>
							<span class="btn btn-warning"></span>
							<span class="btn btn-danger"></span>
						</div>
					</div>
					<div id="menu_style" class="menu_style">
					<ul class="nav nav-list" id="nav_list">
					<% 
					String account="";
					
					if(session.getAttribute("account")!=null)
					{
						account=session.getAttribute("account").toString();
						
					}
					
					if(account.equals("admin"))
					{
					
					
					%>
						<li><a href="#" class="dropdown-toggle"><i class="icon-desktop"></i><span class="menu-text"> 员工管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
								<li class="home"><a  href="javascript:void(0)" name="UserAdd"  title="员工添加" class="iframeurl"><i class="icon-double-angle-right"></i>员工添加</a></li>
								<li class="home"><a  href="javascript:void(0)" name="UserList" title="员工列表"  class="iframeurl"><i class="icon-double-angle-right"></i>员工列表</a></li>
								<li class="home"><a href="javascript:void(0)" name="Resigner" title="离职查看"  class="iframeurl"><i class="icon-double-angle-right"></i>离职查看</a></li>
								<li class="home"><a href="javascript:void(0)" name="RegisterCheck" title="注册审批"  class="iframeurl"><i class="icon-double-angle-right"></i>注册审批</a></li>
							</ul>
						</li>
						
						
						<li>
						<a href="#" class="dropdown-toggle"><i class="icon-desktop"></i><span class="menu-text"> 部门管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
								<li class="home"><a  href="javascript:void(0)" name="DepartmentAdd"  title="部门添加" class="iframeurl"><i class="icon-double-angle-right"></i>部门添加</a></li>
								<li class="home"><a  href="javascript:void(0)" name="DepartmentList" title="部门列表"  class="iframeurl"><i class="icon-double-angle-right"></i>部门列表</a></li>
							
							</ul>
						</li>
						
						
							<li><a href="#" class="dropdown-toggle"><i class="icon-desktop"></i><span class="menu-text"> 日志管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
								<li class="home"><a  href="javascript:void(0)" name="LoginServlet"  title="登录日志" class="iframeurl"><i class="icon-double-angle-right"></i>登录日志</a></li>
								 <li class="home"><a  href="javascript:void(0)" name="ActionServlet" title="操作日志"  class="iframeurl"><i class="icon-double-angle-right"></i>操作日志</a></li>
					
							</ul>
						</li>
						<%} %>
						
						<li>
						<a href="#" class="dropdown-toggle"><i class="icon-desktop"></i><span class="menu-text"> 公告管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
					   		<%
					   		if(account.equals("admin"))
					   		{
					   		%>
								<li class="home"><a  href="javascript:void(0)" name="AddNotice"  title="发布公告" class="iframeurl"><i class="icon-double-angle-right"></i>发布公告</a></li>
								<li class="home"><a  href="javascript:void(0)" name="CheckNotice" title="公告管理"  class="iframeurl"><i class="icon-double-angle-right"></i>公告管理</a></li>
								
								<%} %>
								<li class="home"><a href="javascript:void(0)" name="NoticeList" title="查看公告"  class="iframeurl"><i class="icon-double-angle-right"></i>查看公告</a></li>
								
								
							</ul>
						</li>
						
						
						<li><a href="#" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 日报管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
					   		<%
					   		if(account.equals("admin"))
					   		{
					   		
					   		%>
								<li class="home"><a  href="javascript:void(0)" name="ReportManagement"  title="日报审批" class="iframeurl"><i class="icon-double-angle-right"></i>读日报</a></li>
								<%
					   		}
								%>
								<li class="home"><a  href="javascript:void(0)" name="WriteReport" title="写日报"  class="iframeurl"><i class="icon-double-angle-right"></i>写日报</a></li>
								<li class="home"><a href="javascript:void(0)" name="ReportView" title="查看历史"  class="iframeurl"><i class="icon-double-angle-right"></i>查看历史</a></li> 
							</ul>
						</li>
						
						<li><a href="#" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 请假管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
								<li class="home"><a  href="javascript:void(0)" name="AddRest"  title="请假申请" class="iframeurl"><i class="icon-double-angle-right"></i>请假申请</a></li>
								<%
								if(account.equals("admin"))
								{
								%>
								<li class="home"><a  href="javascript:void(0)" name="DealRest" title="请假处理"  class="iframeurl"><i class="icon-double-angle-right"></i>请假处理</a></li>
								<%
								}
								%>
								 <li class="home"><a href="javascript:void(0)" name="RestHistory" title="请假历史"  class="iframeurl"><i class="icon-double-angle-right"></i>请假历史</a></li> 
							</ul>
						</li>
						
						<li><a href="#" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 报销管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
								<li class="home"><a  href="javascript:void(0)" name="AddPayment"  title="报销申请" class="iframeurl"><i class="icon-double-angle-right"></i>报销申请</a></li>
								<li class="home"><a  href="javascript:void(0)" name="PaymemtHistory"  title="报销历史" class="iframeurl"><i class="icon-double-angle-right"></i>报销历史</a></li>
								
								<% if(account.equals("admin"))
									{%>
								<li class="home"><a  href="javascript:void(0)" name="Dealpayment" title="报销审批"  class="iframeurl"><i class="icon-double-angle-right"></i>报销审批</a></li>
							<%} %>
							</ul>
						</li>
						

						
						
						
						<li><a href="#" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 活动管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
					   		<%
					   		if(account.equals("admin"))
					   		{
					   		%>
								<li class="home"><a  href="javascript:void(0)" name="AddActivity"  title="发起活动" class="iframeurl"><i class="icon-double-angle-right"></i>发起活动</a></li>
							<%} %>
								<li class="home"><a  href="javascript:void(0)" name="ActivityCheck"  title="查看活动" class="iframeurl"><i class="icon-double-angle-right"></i>查看活动</a></li>
								<li class="home"><a  href="javascript:void(0)" name="ActivityJoined" title="已参加的活动"  class="iframeurl"><i class="icon-double-angle-right"></i>正在进行活动</a></li>
								<%
								if(account.equals("admin"))
								{
								%>
								<li class="home"><a href="javascript:void(0)" name="ActivityOut" title="已结束的活动"  class="iframeurl"><i class="icon-double-angle-right"></i>已结束的活动</a></li>
							<%} %>
							</ul>
						</li>
						
						<li>
						<a href="#" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 任务管理 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
								<%if(account.equals("admin")) 
								{%>
								<li class="home"><a  href="javascript:void(0)" name="AddMisssion"  title="发起任务" class="iframeurl"><i class="icon-double-angle-right"></i>发起任务</a></li>
								<%} %>
								<li class="home"><a  href="javascript:void(0)" name="AcceptMission" title="接受任务"  class="iframeurl"><i class="icon-double-angle-right"></i>接受任务</a></li>
						
							</ul>
						</li>
						
						<li>
						<a href="#" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 个人信息 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
								<li class="home"><a  href="javascript:void(0)" name="ReviseInfo"  title="修改信息" class="iframeurl"><i class="icon-double-angle-right"></i>修改信息</a></li>
								<li class="home"><a  href="javascript:void(0)" name="RevisePs" title="密码修改"  class="iframeurl"><i class="icon-double-angle-right"></i>密码修改</a></li>
								
							</ul>
						</li>
						
						<li>
						<a href="#" class="dropdown-toggle"><i class="icon-user"></i><span class="menu-text"> 个人邮箱 </span><b class="arrow icon-angle-down"></b></a>
					   		<ul class="submenu">
					   		<%
					   		if(account.equals("admin"))
					   		{
					   		%>
					   			<li class="home"><a  href="javascript:void(0)" name="SendAll"  title="群发邮件" class="iframeurl"><i class="icon-double-angle-right"></i>群发邮件</a></li>
					   		<%} %>
								<li class="home"><a  href="javascript:void(0)" name="SendLetter"  title="发件箱" class="iframeurl"><i class="icon-double-angle-right"></i>发件箱</a></li>
								<li class="home"><a  href="javascript:void(0)" name="ReciveLetter" title="收件箱"  class="iframeurl"><i class="icon-double-angle-right"></i>收件箱</a></li>
								
							</ul>
						</li>
					</ul>
				</div>
				<script type="text/javascript">
		           $("#menu_style").niceScroll({  
			        cursorcolor:"#888888",  
			        cursoropacitymax:1,  
		         	touchbehavior:false,  
			        cursorwidth:"5px",  
			        cursorborder:"0",  
			        cursorborderradius:"5px"  
		            }); 
				</script>
				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
				</div>
                   <script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>
			<div class="main-content">
                <script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li>
							<i class="icon-home home-icon"></i>
							<a href="index.jsp">首页</a>
						</li>
						<li class="active"><span class="Current_page iframeurl"></span></li>
                           <li class="active" id="parentIframe"><span class="parentIframe iframeurl"></span></li>
						<li class="active" id="parentIfour"><span class="parentIfour iframeurl"></span></li>
					</ul>
				</div>
				<iframe id="iframe" style="border:0; width:100%; background-color:#FFF;" name="iframe" frameborder="0" src="home.jsp">  </iframe>
				
			</div>
            <div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
				    <i class="icon-cog bigger-150"></i>
				</div>
				<div class="ace-settings-box" id="ace-settings-box">
					<div>
					    <div class="pull-left">
					        <select id="skin-colorpicker" class="hide">
					            <option data-skin="default" value="#438EB9">#438EB9</option>
					            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
					            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
					            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
					        </select>
					    </div>
					    <span>&nbsp; 选择皮肤</span>
					</div>
					<div>
					    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
					    <label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
					</div>
					
					<div>
					    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
					    <label class="lbl" for="ace-settings-rtl">切换到左边</label>
					</div>
					<div>
	                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
	                    <label class="lbl" for="ace-settings-add-container">
							切换窄屏
							<b></b>
						</label>
					</div>
				</div>
			</div>	
		</div>
	</div>
	<!--底部样式-->
	<div class="footer_style" id="footerstyle">  
		<script type="text/javascript">try{ace.settings.check('footerstyle' , 'fixed')}catch(e){}</script>
			<p class="l_f">版权所有：长春四海兴唐科技有限公司</p>
			<p class="r_f">qq：930439814</p>
	</div>
	<!--修改密码样式-->
	<div class="change_Pass_style" id="change_Pass">
	   <ul class="xg_style">
	    <li><label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><input name="原密码" type="password" class="" id="password"></li>
	    <li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input name="新密码" type="password" class="" id="Nes_pas"></li>
	    <li><label class="label_name">确认密码</label><input name="再次确认密码" type="password" class="" id="c_mew_pas"></li>              
	   </ul>          
	</div>

	</body>
</html>
