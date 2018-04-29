<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>练习</title>
<style>
*{padding:0px;margin:0px;}
html,body{height:100%;width:100%}
</style>
<script src="resouces/jquery-3.2.1.js"></script>
<script>
	function c()
	{
		$.ajax({
			url:"ajax.do",
			type:"GET",
			 dataType:"json", 
			data:{user_addr:"吉林省长春市",user_sex:"男"},
			success:function(data)
			{
				//alert(data.user_name);
				$("div").html(data.user_name+" "+data.user_age+" "+data.user_sex+" "+data.user_addr);
			},
			error:function()
			{
				alert("出错了");
			}
					
		})
	}
	
	function check()
	{
		$.get("ajax.do",{user_sex:"男",user_addr:"吉林省长春市南关区"},function(data){
			$("div").html(data.user_name+" "+data.user_age+" "+data.user_sex+" "+data.user_addr);
		},"json");
	}
	

</script>
</head>
<body>
<input type="button" value="点我试试" onclick="check()"/>
<div></div>
</body>
</html>