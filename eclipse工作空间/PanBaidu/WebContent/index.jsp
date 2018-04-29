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
		<meta charset="GBK">
		<title>百度云</title>
		<meta name="keywords" content="百度云,网盘,文件上传">
		<meta name="description" content="百度云文件上传系统">
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			/*top start*/
			.top{
				width:100%;
				height:60px;
				background-color:#000;
				
			}
			.top .banner{
				width:90%;
				height:50px;
				background-color:#000;
				margin:auto;
				padding:5px;
			}
			.top .banner span
			{
				width:380px;
				height:50px;
				line-height:50px;
				font-size:28px;
				font-weight:800;
				color:#fff;
				float:right;
			}
			/*top end*/
			/*btn start*/
			.btn
			{
				width:90%;
				height:50px;
				margin:10px auto;
				position:relative;
			}
			.btn a
			{
				width:120px;
				height:40px;
				display:block;
				position:absolute;
				top:5px;
				background-color:skyblue;
				font-size:20px;
				text-align:center;
				font-weight:700;
				line-height:40px;
				color:#fff;
				text-decoration:none;
				border-radius:5px;
			}
			.btn a:hover{
				color:#66ffff;

			}
			/*btn end*/
			/*files start*/
			.files
			{
				width:90%;
				height:400px;
				margin:10px auto;
			}
			.files .tb 
			{
				width:100%;
				border-collapse:collapse;/*消除边框*/
			}
			


			.files .tb thead tr td
			{
				background-color:#7b7b7b;
				font-size:22px;	
				height:40px;
				line-height:40px;
				padding-left:10px;
			}
			.files .tb tbody tr
			{
				margin-top:5px;
				border-bottom:1px dotted #909090;
			}
			.files .tb tbody tr td
			{
				padding-left:10px;
				cursor:pointer;
				
			}
			.files .tb tbody tr td img
			{
				margin:5px auto;
			}
			.files .tb tbody tr td a
			{
				text-decoration:none;

			}
			.files .tb tbody tr:hover
			{
				background:#ababab;
				
			}
		/*file end*/
		/*progress start*/
			.progress{
				width:600px;
				height:40px;
				background-color:#2bcccc;
				position:absolute;
				bottom:2px;
				right:5px;
				border-radius:5px;

			}
			.progress span
			{
				color:white;
				font-size:25px;
				float:right;
				line-height:40px;
				margin-right:50px;
			}
			.progress progress
			{
				width:440px;
				height:34px;
				margin: 2px 0px 2px 2px;
			}
		/*progress end*/

		</style>
	</head>
	<body>
	<!--top start-->
		<div class="top">
			<div class="banner">
				<img src="resource/img/logo.png" width="160px" height="50px" alt="logo图片">	
				<span>Java开发百度云文件上传系统</span>
			</div>
		</div>
	<!--top end-->
	<!---btn start--->
		<div class="btn">
		<input type="file" name="file" id="file" style="display:none"/>
			<a href="javascript:void(0)" id="upload">+上传文件</a>
		</div>
	<!--btn end-->
	<!--files start-->
	<div class="files">
		<table class="tb">
			<thead>
				<tr>
					<td>图片预览</td>
					<td>文件名称</td>
					<td>上传时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img src="resource/img/qf.png" height="50px" width="80px" alt="图片预览"></td>
					<td>用户图片</td>
					<td>2018年2月1号</td>
					<td><a href="javascript:void(0)">删除</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--files end-->
	
	<!---progress start-->
	<div class="progress">
		<progress id="progressBar"  value="0"  max="100"></progress>
		<span>上传进度</span>
		<span id="percentage"></span>	
	</div>
	<!--progress end-->
	<!-- script -->
	<script type="text/javascript" src="resource/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resource/js/ajaxfileupload.js"></script>
	<script type="text/javascript">
		$("#upload").click(function(){
			$(":file").click();
			var file=$("#file").val();
			if($.trim(file)==""){
				alert("请选择你要上传的文件");
				console.log("test");			
			}
			console.log("执行到这里了");
		$.ajaxFileUpload({
			url:"/pan/Upload",
			type:"post",
			secureuri:false,
			fileElement:"file",
			dataType:"json",
			data:{},
			success:function(data,status){
				if(data.Result){
					alert("文件处理成功"+data.FileName);
				}else{
					alert("文件处理出错"+data.ErrorMessage);
				}		
			},
			error:function(data,status,e){
				alert("错误:上传组件错误,请检查网络!");
			}
			
			
			
			
			
			
			
		})
			
			
				
				
				
			
			
			
			
		
			
			
			
		})

	</script> 
	<!-- -script -->
	</body>
</html>