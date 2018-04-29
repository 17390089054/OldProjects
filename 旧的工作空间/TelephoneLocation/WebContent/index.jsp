<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--网页编码-->
	<!--声明当前网页的三要素-->
	<meta name="Keywords" content="关键字，关键词">
	<meta name="Desctiption" content="描述信息">
<title>手机归属地查询</title>
<!--css 层叠样式表-->
<style>
<!--解决不同浏览器兼容问题-->
	/*start-top*/
	*{margin:0px;padding:0px;}
	html,body{height:100%;width:100%;overflow:hidden} 
	.top{width:100%;height:80px;background-color:#3399ff;padding-top:5px;padding-bottom:5px;}
	.top .center{width:90%;height:100%;background-color:#3399ff;margin:0px auto;}
	.top .center span{color:#ffffff;float:right;font-size:30px;line-height:60px;padding:5px;}

	/*end top*/


	/*start mobile*/
	.mobile{width:600px;height:400px;margin:80px auto}
	.mobile .mobile-left{width:214px;height:410px;background:url("img/phone.png");
	background-size:210px 410px;float:left;}
	.mobile .mobile-right{width:250;height:180px; }
	.mobile .mobile-right span{font-size:35px;color:#00ccff;text-align:center;margin-left:40px;MASRGIN-TOP:50px;} 
	.mobile .mobile-right .search{width:180px;height:28px;border-radius:5px;margin-top:25px;margin-left:60px;}
	.mobile .mobile-right .btn 
	{width:76px;height:30px;background-color:rgba(0, 153, 255, 1);margin-left:35px;color:white;line-height:20px;font-size:22px;
	}
	.mobile.mobile-right.btn:hover(box-shadow:0px 0px 5px #000;)
	
	}
	/*end mobile*/
</style>
</head>

<body>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<!--start top-->
	<div class="top">
		<div class="center">
		<img src="img/logo.png" width=150px height=65px alt="logo" />
		<span >Java开发手机号码验证平台</span>
		</div>
	
	</div>
	<!--end top-->


	<!--start mobile-->
	<Form  action="Tel" method="Post">
	<div class="mobile">
		<div class="mobile-left"></div>
		<div class="mobile-right">
			<span>
			手 机 归 属 地 查 询

			</span>
			<input  type="text" class="search">
			<input type="button" value=" 查  询 " class="btn">
		</div>
	
	</div>
	</Form>
	<!--end mobile-->
<script type="text/javascript">
$(".btn").click(function(){
		
			var phone=$("#phone").val();
			$.ajax({
				type:"POST",
				url:"Tel",
				dataType:"json",
				data:{"phone":phone},
				success:function(e){
					alert("查询成功");
					console.log(e.data.mobile);
					console.log(e.data.province);
					console.log(e.data.city);
					console.log(e.data.isp);
				}
				
			});

		}		
		)

</script>



</body>
</html>