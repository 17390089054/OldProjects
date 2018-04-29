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
<title>Insert title here</title>
<style>
*{padding:0px;margin:0px;}
html,body{height:100%;width:100%}
</style>
</head>
<body>
 	<form method="post" action="Upload.do" enctype="multipart/form-data"  >
		姓名:<input type="text" name="user_name"/><br/>
		上传头像:<input type="file" name="user_picture"/><br/>
		<button>提 交</button>
	</form>

</body>
</html>