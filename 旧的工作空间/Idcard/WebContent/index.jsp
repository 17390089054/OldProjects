<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title></title>
        <style type="text/css">
        	*{margin: 0;padding: 0;}
        	html,body{width: 100%;height: 100%;}
        	input{width: 260px;height: 26px;outline: none;border: 1px solid #666;margin-top: 10px;text-indent: 20px;}
        	.center{position: absolute;top: 0;left: 0;bottom: 0;right: 0;margin: auto;}
        	.title{width: 100%;height: 60px;background: rgba(0, 0, 0, .8);color: #fff;line-height: 60px;text-align: center;font-size: 30px;}
        	.content{width: 100%;overflow: hidden;height: 400px;padding: 40px 0;position: relative;
        	background: url(img/2.png) no-repeat;background-size: cover;}
        	#center{width: 1082px;height: 400px;}
        	.show{width: 642px;height: 400px;float: left;position: relative;}
        	#scan{position: absolute;width: 100%;height: 100%;
        	background: url(img/scan.png);background-size: cover;z-index: 1;display: none;}
        	.message{float: left;margin-left: 40px;width: 400px;height: 400px;}
        	.input span{display: inline-block;width: 100px;height: 28px;line-height: 28px;color: #fff;}
        	.btn{width: 150px;height: 40px;background: red;border: none;border-radius: 14px;
        		font-size: 16px;color: #fff;cursor: pointer;margin: 20px 0 0 150px;}
        	.name{margin-top: 50px;}
        	#uploadfile{display: none;}
        	#footer{width: 100%;height: 332px;background: /* url(img/banner.png) */no-repeat  center;background-size: cover;}
			#footer .text{width: 1200px;height: 332px;margin: 0 auto;}
			#footer .text h1{font-weight: 100;padding: 100px 0 10px 100px;}
			#footer .text p{padding-left: 100px;line-height: 31px;color: #666;}
        </style>
</head>
<body>
	<div class="title">Java开发身份信息自动录入系统-汪荣福</div>
	<div class="content">
		<div class="center" id="center">
			<div class="show" id="show">
				<div id="scan"></div>
				<img id="img" class="center" src="img/1.png" width="642" height="400" />
			</div>
			
			<input type="file" name="uploadfile" id="uploadfile" />
			<div class="message">
				<form action="save" method="post">
					<div class="name input"><span>姓名:</span><input name="name" type="text" /></div>
					<div class="gender input"><span>性别:</span><input name="gender" type="text" /></div>
					<div class="nation input"><span>民族:</span><input name="nation" type="text" /></div>
					<div class="date input"><span>出生日期:</span><input name="date" type="text" /></div>
					<div class="address input"><span>住址:</span><input name="address" type="text" /></div>
					<div class="number input"><span>身份证号码:</span><input name="number" type="text" /></div>
					<input class="btn" type="button" value="保  存  " />
				</form>
			</div>
		</div>
	</div>
	<!-- footer start -->
	<div id="footer">
		<div class="text">
			<h1>身份证识别</h1>
			<p>基于业界领先的深度学习技术<br />
			为用户提供二代身份证正反面识别服务
			</p>
		</div>
	</div> 
	<!-- footer end -->
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
	//实现文件拽拉上传
	
	//获取拖拽区域
	var obj=document.getElementById("show");//根据id名称获取元素状态
	
	 obj.ondragover=function(e)
	{
		e.preventDefault();//阻止浏览器打开图片
		console.log("hello");
	}
	
 	 obj.ondraleave=function(e)
	{
		e.peventDefault();//阻止浏览器默认打开文件
		console.log("byebye");
	}   
	
	//在拽拉区放置文件
	obj.ondrop=function(e)
	{
		//阻止浏览器默认打开
		e.preventDefault();
		//获取拽拉上传的图片到服务器
		var formData=new FormData();
		
		formData.append("file",e.dataTransfer.files[0]);
		//异步上传图片(ajax)
		$.ajax(
				{
					//图片上传位置
					url:"fileUpload",
					//图片上传方式
					type:"post",
					cache:false,//不需要缓存
					
					//上传对象
					data:formData,
					processData:false,//不需要对数据进行处理
					contentType:false,//不需要声明文件类型
					//上传完成的结果
					success:function(data)
					{
						$("#img").attr({"src":data});
						scan();
						//解析图片
					 	$.ajax({
							type:"post",
							url:"parse",
							data:{"path":data},
							dataType:"JSON",
							success:
										function(data)
										{
										console.log(data);		
								
										 data=data.words_result; 
										 $(".name input").val(data.姓名.words);
										$(".gender input").val(data.性别.words);
										$(".nation input").val(data.民族.words);
										$(".date input").val(data.出生.words);
										$(".address input").val(data.住址.words);
										$(".number input").val(data.公民身份号码.words); 									
										}																
								}); 													
					}
			});
	}
	
	
	
	
	//点击保存
	$(".btn").click(function(){
		
				$.ajax({
					type:"post",
					url:"save",
					data:
						{
						"name":$(".name input").val(),
						"gender":$(".gender input").val(),
						"nation":$(".nation input").val(),
						"date":$(".date input").val(),
						"address":$(".address input").val(),
						"number":$(".number input").val()					
						},						
						success:
							function(data)
						{
							 /*  $("#img").attr({"src":data});
							//解析图片
							$.ajax(
									{
										type:"post",
										url:"parse",
										data:{"path":data},
										success:function(data)
										{
											//console.log(data);
											alert(data);
										} 
								
										
									});  */
									
									alert(data);
									
						}
						
						});								
	}				
						
	
	)
				
				
		
	
        function scan(){
			var box = $("#show");
			$("#scan").css({"display":"block","bottom":box.height()}).animate({bottom:0},2000,function(){$(this).css({"display":"none","bottom":box.height()})});
		}
	</script>
</body>
</html>