<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"
    		import="java.util.Map"
     %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="resource/css/style.css"/>
	<link rel="stylesheet" href="resource/assets/css/ace.min.css" />
	<link rel="stylesheet" href="resource/assets/css/font-awesome.min.css"/>
	<link href="resource/assets/css/codemirror.css" rel="stylesheet"/>
	<script src="resource/assets/js/ace-extra.min.js"></script>
	<script src="resource/assets/js/jquery.min.js"></script>        
	<script src="resource/assets/dist/echarts.js"></script>
	<script src="resource/assets/js/bootstrap.min.js"></script>            
	<title></title>
</head>		
<body>
<div class="page-content clearfix">
 <div class="alert alert-block alert-success">
  <button type="button" class="close" data-dismiss="alert"><i class="icon-remove"></i></button>
  <i class="icon-ok green"></i>欢迎使用<strong class="green">OA办公系统<small>(v1.2)</small></strong>,你本次登陆时间为<%=new java.util.Date().toLocaleString() %>，登陆IP:<%= request.getRemoteAddr()%>.	
 </div>
 
 <%
 String EmployeeTotal="";
 
 String account="";
 if(session.getAttribute("account")!=null)
 {
	 account=session.getAttribute("account").toString();
 }
 if(session.getAttribute("EmployeeTotal")!=null)
 {
	 EmployeeTotal=session.getAttribute("EmployeeTotal").toString();
 }
 
 String EmployeeAvalible="";
 if(session.getAttribute("EmployeeAvalible")!=null)
 {
	 EmployeeAvalible=session.getAttribute("EmployeeAvalible").toString();
 }
 
 String EmployeeOut="";
 if(session.getAttribute("EmployeeOut")!=null)
 {
	 EmployeeOut=session.getAttribute("EmployeeOut").toString();
	 
 }
 
 String EmployeeCheck=""; 
 if(session.getAttribute("EmployeeCheck")!=null)
 {
	 EmployeeCheck=session.getAttribute("EmployeeCheck").toString();
 }
 
 String DepartmentCount="";
 if(session.getAttribute("DepartmentCount")!=null)
 {
	 DepartmentCount=session.getAttribute("DepartmentCount").toString();
 }
 String Activity="";
 if(session.getAttribute("Activity")!=null)
 {
	 Activity=session.getAttribute("Activity").toString();
 }
 
 String Mission="";
 if(session.getAttribute("Mission")!=null)
 {
	 Mission=session.getAttribute("Mission").toString();
 }
 //日报部分
 String ReportCount="";
 if(session.getAttribute("ReportCount")!=null)
 {
	 ReportCount=session.getAttribute("ReportCount").toString();
 }
 
 //日报草稿
 String Report="";
 if(session.getAttribute("Report")!=null)
 {
	 Report=session.getAttribute("Report").toString();
 }
 
 //日报提交
 String ReportSubmit="";
 if(session.getAttribute("ReportSubmit")!=null)
 {
	 ReportSubmit=session.getAttribute("ReportSubmit").toString();
 }
 
 //日报审批
 String ReportRead="";
 if(session.getAttribute("ReportRead")!=null)
 {
	 ReportRead=session.getAttribute("ReportRead").toString();
 }
 
 //请假总数
 String RestTotal="";
 if(session.getAttribute("RestTotal")!=null)
 {
	 RestTotal=session.getAttribute("RestTotal").toString();
 }
 
 //请假总数
 String RestAdd="";
 if(session.getAttribute("RestAdd")!=null)
 {
	 RestAdd=session.getAttribute("RestAdd").toString();
 }
 
 //请假总数
 String RestPass="";
 if(session.getAttribute("RestPass")!=null)
 {
	 RestPass=session.getAttribute("RestPass").toString();
 }
 
 //请假总数
 String RestFail="";
 if(session.getAttribute("RestFail")!=null)
 {
	 RestFail=session.getAttribute("RestFail").toString();
 }
 
 List<Map<String,String>>notice=(List<Map<String,String>>)session.getAttribute("notice");
 
 %>
 <div class="state-overview clearfix">
 <%
 			if(account.equals("admin"))
 			{
 %>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">                   
                          <div class="symbol terques">
                             <i class="icon-user"></i>
                          </div>
                          <div class="value">
                              <h1><a href="UserList"><%=EmployeeTotal %></a></h1>
                              <p>系统用户</p>
                          </div>
                       </a>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol red">
                              <i class="icon-tags"></i>
                          </div>
                          <div class="value">
                              <h1><a href="DepartmentList"><%=DepartmentCount %></a></h1>
                              <p>系统部门</p>
                          </div>
                      </section>
                  </div>
           <%} %>       
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol yellow">
                              <i class="icon-shopping-cart"></i>
                          </div>
                          <div class="value">
                              <h1><a href="ActivityCheck"><%=Activity %></a></h1>
                              <p>最近活动</p>
                          </div>
                      </section>
                  </div>
                  <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol blue">
                              <i class="icon-bar-chart"></i>
                          </div>
                          <div class="value">
                              <h1><a href="AcceptMission"><%=Mission %></a></h1>
                              <p>任务记录</p>
                          </div>
                      </section>
                  </div>
              </div>
             <!--实时交易记录-->
             
             <div class="clearfix">
          <div class="Order_Statistics ">         
          <div class="title_name">员工统计信息</div>
           <table class="table ">
           <tbody>
           <tr><td class="name">待审批员工：</td><td class="munber"><a href="RegisterCheck"><%=EmployeeCheck%></a>&nbsp;个</td></tr>
           <tr><td class="name">新增员工：</td><td class="munber"><a href="UserList"><%=EmployeeCheck%></a>&nbsp;个</td></tr>
           <tr><td class="name">在职员工：</td><td class="munber"><a href="UserList"><%=EmployeeAvalible%></a>&nbsp;个</td></tr>
            <tr><td class="name">已离职员工：</td><td class="munber"><a href="Resigner"><%=EmployeeOut %></a>&nbsp;个</td></tr>
           
           </tbody>
          </table>
         </div>
          
         <div class="Order_Statistics">
          <div class="title_name">个人日报统计信息</div>
           <table class="table ">
           <tbody>
           <tr><td class="name">日报总数：</td><td class="munber"><a href="ReportView"><%=ReportCount %></a>&nbsp;个</td></tr>
           <tr><td class="name">草稿日报：</td><td class="munber"><a href="ReportView"><%=Report %></a>&nbsp;个</td></tr>
           <tr><td class="name">已提交日报：</td><td class="munber"><a href="ReportView"><%=ReportSubmit %></a>&nbsp;个</td></tr>
           <tr><td class="name">已审批日报：</td><td class="munber"><a href="ReportView"><%= ReportRead%></a>&nbsp;个</td></tr>
          
           </tbody>
          </table>
         </div> 
         
         <div class="Order_Statistics" >
          <div class="title_name">个人请假统计信息</div>
           <table class="table table-bordered">
           <tbody>
           <tr><td class="name">请假总数：</td><td class="munber"><a href="RestHistory"><%=RestTotal %></a>&nbsp;次</td></tr>
           <tr><td class="name">请假申请：</td><td class="munber"><a href="RestHistory"><%=RestAdd %></a>&nbsp;次</td></tr>
           
           <tr><td class="name">请假通过：</td><td class="munber"><a href="RestHistory"><%=RestPass %></a>&nbsp;次</td></tr>
           
           <tr><td class="name">请假驳回：</td><td class="munber"><a href="RestHistory"><%=RestFail %></a>&nbsp;次</td></tr> 
           </tbody>
          </table>
         </div> 
       
         <div class="news_style">
          <div class="title_name">系统公告</div>
          <ul class="list">
          <% 
          if(notice.size()>0)
          {
          for(int i=notice.size()-1;i>=notice.size()-6;i--){ %>
           <li><i class="icon-bell red"></i>
           <a href="NoticeDetails?id=<%=notice.get(i).get("notice_id")%>">
           <%=notice.get(i).get("notice_title")%>&nbsp;&nbsp;&nbsp;
           <span style="float:right;margin-right:5px">
           <%=notice.get(i).get("create_time") %></span>
           </a>
           </li>
           <%} 
           
           }%>
          </ul>
         </div> 
         </div>
  
     </div>
     <div style="height:5%">
     </div>
     
     <div class="clearfix">
  		<div class="home_btn">
    
     <%
   
     if(account.equals("admin"))
     {
     %>
   
     <a href="UserAdd"  title="员工添加" class="btn  btn-info btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-addp.png" /></i>
     <h5 class="margin-top">员工添加</h5>
     </a>
     
     <a href="UserList"  title="员工管理" class="btn  btn-primary btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-cpgl.png" /></i>
     <h5 class="margin-top">员工管理</h5>
     </a>
     
       <a href="RegisterCheck"  title="注册审批" class="btn  btn-success btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-grxx.png" /></i>
     <h5 class="margin-top">注册审批</h5>
     </a>
     
     <%} %>
     <a href="ReviseInfo"  title="信息修改" class="btn  btn-success btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-grxx.png" /></i>
     <h5 class="margin-top">信息修改</h5>
     </a>
     
       <a href="ActivityCheck "  title="活动中心" class="btn  btn-info btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-cpgl.png" /></i>
     <h5 class="margin-top">活动中心</h5>
     </a>
    
     
     <a href="RevisePs"  title="密码修改" class="btn  btn-info btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/xtsz.png" /></i>
     <h5 class="margin-top">密码修改</h5>
     </a>
     <a href="WriteReport"  title="添加日报" class="btn  btn-purple btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-gwcc.png" /></i>
     <h5 class="margin-top">添加日报</h5>
     </a>
     
     <a href="AddRest"  title="请假申请" class="btn  btn-pink btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-ad.png" /></i>
     <h5 class="margin-top">请假申请</h5>
     </a>
      <a href="AddPayment"  title="报销申请" class="btn  btn-info btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-addwz.png" /></i>
     <h5 class="margin-top">报销申请</h5>
     </a>
     
      
     
         <a href="ReciveLetter"  title="收件箱" class="btn  btn-info btn-sm no-radius">
     <i class="bigger-200"><img src="resource/images/icon-gwcc.png" /></i>
     <h5 class="margin-top">收件箱</h5>
     </a>
     
  </div>
 
 </div>
</body>
</html>
<script type="text/javascript">
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.no-radius').on('click', function(){
	var cname = $(this).attr("title");
	var chref = $(this).attr("href");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe').html(cname);
    parent.$('#iframe').attr("src",chref).ready();;
	parent.$('#parentIframe').css("display","inline-block");
	parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
    parent.layer.close(index);
	
});
     $(document).ready(function(){
		 
		  $(".t_Record").width($(window).width()-640);
		  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
		 $(".t_Record").width($(window).width()-640);
		});
 });
	 
	 
 </script>   