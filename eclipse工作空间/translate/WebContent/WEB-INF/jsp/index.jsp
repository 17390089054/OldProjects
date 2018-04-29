<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style>
html,body
{
height:100%;
width:100%;
}
*
{
margin:0px;
padding:0px;
}
body
{
background:url("resource/img/bg.jpg");
background-size:100% 100%;
}
.title
{
background-color:gray;
text-align:center;
padding:10px;
background:rgba(0,0,0,0.2);
}
.title span
{
font-size:25px;
color:white;
}
.content
{
width:642px;
height:400px;
margin:50px auto 0px;
/* border:2px solid gray; */
}

#text
{
width:598px;
background:rgba(141,139,137,.4);
border:3px solid rgba(141,139,137,.4);
padding:20px;
outline:none; 
resize:none;
font-size:20px;
color:#fff;
}
.select
{
margin:5px auto;
}
.select select
{
width:180px;
height:40px;
/* margin:10px 10px 5px 10px; */
font-size:18px;
text-align:center;
color:#267e7b;
}

.img
{
margin:10px 10px -8px 15px;
}
#btn
{
	background-color:#0093ff;
	font-size:20px;
	color:#fff;
	text-align:center;
	display:inline-block;
	width:120px;
	height:40px;
	line-height:40px;
	margin:16px 20px 0px 25px;
	text-decoration:none;
}

.result
{
	width:639px;
	height:230px;
	margin:20px auto;
	background:rgba(0,0,0,.1);
	border:3px solid  rgba(141,139,137,.4);
	position:relative;
}
.audio
{
	width:19px;
	height:17px;
	position:absolute ;right: 10px ;top: 10px;
	background:url("resource/img/sound-1.png");
	cursor:pointer;
}
.audio:hover
{
	background:url("resource/img/sound-2.png");
}

.r_text
{
	width:599px;
	height:190px;
	/* background:red; */
	padding:20px;
	font-size:20px;
	color:#fff;

}
</style>
</head>
<body>
<!-- title部分 -->
<div class="title">
<span>JAVA 开 发 十 六 国 语 言 实 时 语 音 互 译 系 统 </span>
</div>
<!--content部分  -->
<div class="content">
<!-- 中文输入部分 -->
	<input  type="text" id="text"/>
	<!-- 语言选择部分 -->
	<div class="select">
		<select name="from" id="from">
			<option value="auto">智能识别</option>
			<option value="zh">中文</option>
			<option value="wyw">文言文</option>
			<option value="yue">粤语</option>
			<option value="en">英语</option>
			<option value="jp">日语</option>
			<option value="ru">俄语</option>
			<option value="kor">韩语</option>
			<option value="de">德语</option>
			<option value="fra">法语</option>
			<option value="th">泰语</option>
			<option value="pt">葡萄牙语</option>
			<option value="ara">阿拉伯语</option>
			<option value="swe">瑞典语</option>
			<option value="hu">匈牙利语</option>
			<option value="cht">繁体中文</option>
			<option value="vie">越南语</option>
			<option value="it">意大利语</option>
			<option value="el">希腊语</option>
			<option value="rom">罗马尼亚语</option>
			
		</select>
		<img alt="右箭头" src="resource/img/sign_in.png" class="img">
		<select name="to" id="to">
			<option value="zh">中文</option>
			<option value="en">英语</option>
			<option value="jp">日语</option>
			<option value="ru">俄语</option>
			<option value="kor">韩语</option>
			<option value="de">德语</option>
			<option value="fra">法语</option>
			<option value="wyw">文言文</option>
			<option value="yue">粤语</option>
			<option value="cht">繁体中文</option>						
			<option value="th">泰语</option>
			<option value="pt">葡萄牙语</option>
			<option value="ara">阿拉伯语</option>
			<option value="swe">瑞典语</option>
			<option value="hu">匈牙利语</option>			
			<option value="vie">越南语</option>
			<option value="it">意大利语</option>
			<option value="el">希腊语</option>
			<option value="rom">罗马尼亚语</option>
		</select>
		
		<a href="javascript:trans()" id="btn">查 询</a>
	
		</div>
	<!-- 结果显示部分 -->
	<div class="result">
		<div class="r_text"></div>
		<div class="audio"></div>
	</div>
</div>
	<script src="resource/js/jquery-3.1.1.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	//获取前台数据传到后台进行翻译
	function trans()
	{
		//接收前台数据
		var text=$("#text").val();
		var from=$("#from").val();
		var to=$("#to").val();
		//利用ajax上传到后台
		$.ajax({
			//上传路径
			url:"Translate.do",
			//上传方式
			type:"POST",
			//上传数据
			data:{"text":text,"from":from,"to":to},
			//返回值类型
			dataType:"json",
			//返回状态
			success:function(result)
					{
					var r_text=result.trans_result[0].dst;
					$(".r_text").html(r_text);
					$(".audio").click(function(){
						r_text=r_text.replace(/\s+/g,"_");
						if(to=="wyw")
							{
							to="zh";
							}
						else if(to=="yue")
							{
							to="cte";
							}
						var Oaudio=$("<audio src=http://fanyi.baidu.com/gettts?lan="+to+"&text="+r_text+"&spd=3&source=web autoplay></audio>");
						$("audio").remove();
						$("body").append(Oaudio);
						 $("#text").select(); 
					})
					}		
		})
	
	}
	</script>
</body>
</html>