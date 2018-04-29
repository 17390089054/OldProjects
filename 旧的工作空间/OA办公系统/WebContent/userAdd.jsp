<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"
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
<title>用户添加</title>
</head>

<body>
<%
	String  msg="";
	if(request.getAttribute("msg")!=null)
	{
		msg=request.getAttribute("msg").toString();
	}
	
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
	String department="";
	if(request.getAttribute("department")!=null)
	{
		department=request.getAttribute("department").toString();
	}
	
	String password="";
	if(request.getAttribute("password")!=null)
	{
		password=request.getAttribute("password").toString();
	}

	String tel="";
	if(request.getAttribute("tel")!=null)
	{
		tel=request.getAttribute("tel").toString();
	}

	String addr="";
	if(request.getAttribute("addr")!=null)
	{
		addr=request.getAttribute("addr").toString();
	}

	String id="";
	if(request.getAttribute("id")!=null)
	{
		id=request.getAttribute("id").toString();
	}

	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
	
	if(request.getAttribute("list")!=null)
	{
		
		list=(List<Map<String,String>>)request.getAttribute("list");
	}
	


%>
<!--添加用户图层-->
<form action="UserAdd" method="post">
<div class="add_menber" id="add_menber_style">
  
    <ul class=" page-content">
    
     <li>
     <label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label>
     <span class="add_name">
     <input  name="用户名"  value="<%=account %>"  type="text"  class="text_add"/>
     </span>    
     <div class="prompt r_f"></div>    
     </li>
     
     <li>
     <label class="label_name">用 户 姓 名 :</label>
     <span class="add_name">
     <input name="真实姓名" type="text" value="<%=user_name %>" class="text_add"/>
     </span>
     <div class="prompt r_f"></div>
     </li>
     
     <li>
     <label class="label_name">用 户 密 码 :</label>
     <span class="add_name">
     <input name="用户密码" type="text"  value="<%=password %>" class="text_add"/>
     </span>
     <div class="prompt r_f"></div>
     </li>
     

     <li>
     <label class="label_name">所 在 部 门 :</label>
     <span class="add_name">
   
   	<select name="部门"  class="text_add" >
   <option><%=department%></option>
   	<%
   	for(int i=0;i<list.size();i++)
   	{
   		
   	%>
   	<option>
   	<% 
	
   		out.write(list.get(i).get("d_name"));
   	}
	
   	%>
   	
   </option>
   	
   	</select>
     </span>
     <div class="prompt r_f"></div>
     </li>
     
     <li>
     <label class="label_name">移 动 电 话 :</label>
     <span class="add_name">
     <input name="移动电话" type="number" value="<%=tel %>"
     oninput="if(value.length>11)value=value.slice(0,11)"  class="text_add"/>
     </span><div class="prompt r_f"></div>
     </li>
     
     <li>
     <label class="label_name">身 份 证 号 :</label>
     <span class="add_name">
     <input name="身份证号" type="text"  value="<%=id%>" class="text_add"/></span>
     <div class="prompt r_f"></div>
     </li>
     
     <li class="adderss">
     <label class="label_name">家 庭 住 址 :</label>
     <span class="add_name">
     <input name="家庭住址" type="text"  class="text_add"  value="<%=addr %>" style=" width:350px"/></span>
     <div class="prompt r_f"></div>
     </li>
     	
 </div>
 <ul class="center" style="align:center;">
    	<li>
    	<input class="btn btn-warning" type="submit" value="添加">
    	<input class="btn btn-info" type="button" value="取消">
    	</li>
    </ul>
    
<div align="center" style="color:red;size:30px; margin:20px">
<span><%=msg %> </span>

</div>



</form>
</body>
</html>