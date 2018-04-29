<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page 
    import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Map"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>用户列表</title>
</head>

<body>
<script type="text/javascript">
function del()
{
	var msg="\n确 认 删 除 ?";
	if(confirm(msg)==true)
	{
		return true;
	}
	else
	{
		return false;
	}
}
</script>
<div class="page-content clearfix">
<%
	String account="";
	if(request.getAttribute("account")!=null)
	{
		account=request.getAttribute("account").toString();
	}
	
	String user_name="";
	if(request.getAttribute("user_name")!=null)
	{
		user_name=request.getAttribute("user_name").toString();
	}
	String address="";
	if(request.getAttribute("address")!=null)
	{
		address=request.getAttribute("address").toString();
	}
	
	String department="";
	if(request.getAttribute("department")!=null)
	{
		department=request.getAttribute("department").toString();
	}
	
	
	String date="";
	if(request.getAttribute("date")!=null)
	{
		date=request.getAttribute("date").toString();
	}


%>
 <form action="UserList" method="post">
    <div id="Member_Ratings">
     
      <div class="d_Confirm_Order_style">
      
    <div class="search_style">
   
     
      <ul class="search_content clearfix">
     <li><h2 style="color:purple;size:15px;">快 速 查 询</h2></li>
       <li><label class="l_f">用 户 名 :</label>
       <input name="account" type="text"  class="text_add"  value="<%=account %>" style=" width:100px"/></li>
       <li><label class="l_f">姓 名 :</label>
       <input name="user_name" type="text"  class="text_add" value="<%=user_name %>"  style=" width:100px"/></li>
       
        <li><label class="l_f">地 址 :</label>
       <input name="address" type="text"  class="text_add"  value="<%=address %>" style=" width:100px"/></li>
       
        <li><label class="l_f">部 门 :</label>
       <input name="department" type="text"  class="text_add"  value="<%=department %>" style=" width:100px"/></li>
       
       <li><label class="l_f"> 加 入  时 间  :</label>
       <input type="date" name="date" class="text_add" id="start" value="<%=date %>" style=" margin-left:10px;"></li>
       
       <li style="width:90px;">
       <input type="submit" class="btn_search" value=" 查    询   ">
       </li>
      
      </ul>
     
    </div>
 	</div>
        </div>
     </form>
     </div>

    
    
     <div class="">
     
     </div>

     
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
				<th width="180"> 操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 作 </th>
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
			 String stus=list.get(i).get("user_status");
			 if(!stus.equals("0"))
			 {			
	%>
		<tr>
         <td><%=i+1%></td>
         	
         <td><%=list.get(i).get("account")%></td>
         <td><%=list.get(i).get("user_name")%></td>
         <td><%=list.get(i).get("d_name")%></td>
         <td><%=list.get(i).get("user_create_time") %></td>
         <td><%=list.get(i).get("user_addr") %></td>
         <td>
         <%
        
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
         <td>
         <a href="EmployeeRevise?id=<%=list.get(i).get("user_id")%>" name="content" style="link:lightblue;visited:lightyellow;hover:purple">修 &nbsp;改</a>&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="EmployeeDelete?id=<%=list.get(i).get("user_id")%>" onclick="javascript:return del();" target="content" style="link:red;visited:lightyellow;hover:purple">删 &nbsp;除</a>
         </td>
		</tr>
	<%} 
	
	}%> 
      </tbody>
	</table>
	<div class="row">
	<div class="col-sm-6">

	</div>
	</div>	
   </div>
 
  
 

<!--添加用户图层-->
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span class="add_name"><input value="" name="用户名" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">真实姓名：</label><span class="add_name"><input name="真实姓名" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label><span class="add_name">
     <label><input name="form-field-radio" type="radio" checked="checked" class="ace"><span class="lbl">男</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">女</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">保密</span></label>
     </span>
     <div class="prompt r_f"></div>
     </li>
     <li><label class="label_name">固定电话：</label><span class="add_name"><input name="固定电话" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">移动电话：</label><span class="add_name"><input name="移动电话" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">电子邮箱：</label><span class="add_name"><input name="电子邮箱" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li class="adderss"><label class="label_name">家庭住址：</label><span class="add_name"><input name="家庭住址" type="text"  class="text_add" style=" width:350px"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">关闭</span></label></span><div class="prompt r_f"></div></li>
    </ul>
 </div>
</body>
</html>