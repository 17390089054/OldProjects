<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	*{margin: 0;padding: 0;}
      html,body{width: 100%;height: 100%;}
      body{background:url(img/bg.jpg) no-repeat; background-size:cover /*自动适应*/}
	  h1{text-align:center;color:#666;line-height:60px}
	  #canvas{display:none;}
	  h3{height:80px;line-height:60px;color:blue;text-align:center;}		
	#media{width:534px;height:400px;margin:40px auto 0;position:relative;overflow:hidden;}
	#login{width:200px;height:50px; line-height:50px;text-align:center;color:#fff;background:#00f1ff;cursor:pointer;border-radius:40px;
	margin:40px auto 0;
	}
</style>
<title>门禁识别系统</title>
</head>
<body>
<h1>门禁识别系统-汪荣福</h1>
<h3 class="message"></h3>
<div id="media" >
		<video id="video" width="534" height="400" src=""></video>
		<canvas id="canvas" width="534" height="400" ></canvas>
		<div id="scan"></div>
</div>

<div id="login">登 录</div>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	/*获取元素*/
	var video=document.getElementById("video");
	var context=canvas.getContext("2d");
	/*获取摄像头面部流媒体 将流媒体放置video中进行播放 */
	var getUserMedia=(navigator.getUserMedia|| navigator.webkitGetUserMedia||navigator.mozGetUserMedia||navigator.msGetUserMedia)
	getUserMedia.call(navigator,
			{video:true,audio:false},
			function(localMediaStream){
				video.src=window.URL.createObjectURL(localMediaStream);
				video.onloadedmetadata=function(){video.play();}
	},
	function(e){console.log("获取摄像头失败",e)});
	
	/*点击登录按钮 获取面部信息并传到后台*/
	$("#login").click(function(){
		context.drawImage(video,0,0,534,400);
		var imgSrc=document.getElementById("canvas").toDataURL('image/png');
		var base64=imgSrc.split("base64,")[1];
		$.ajax({
			url:"login",
			type:"post",
			data:{"imageBase64":base64},
			success:function(data)
			{
				if(eval(data))
					{
					window.location.href="http://www.tanzhouedu.com";
				
					}
				else
					{
					$(".message").html("验证不通过,请重新测试");
					}
			}
			
		})
		
	});
	
	
	
</script>
</body>
</html>