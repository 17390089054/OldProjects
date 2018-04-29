<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
		margin:20px;
		background:#ccc;
	}
	body a:visited{/* 点击之后的a标签 */
		color:orange;
	}
	body a:link{/* 没有点击的a标签 */
		color:yellow;
	}
	body a:hover{/* 划过的a标签 */
		color:#00ff00;
	}
	.left{
		width:20%;
		border:5px solid gray;
		float:left;
		border-radius: 10px;
		font-size:25px;
		font-weight: bold;/* 加粗 */
		color:#fff;
		background:gray;
	}
	.left h2,ul{
		margin:40px;
	}
	.right{
		width:78%;
		border:5px solid gray;	
		float:right;
		border-radius: 10px;
		background:#fff;
	}
	.iframe{
		width:100%;
		height:680px;
		border:0;
	}
	#color{
		height:30px;
		width:30px;
		border-radius: 15px;
		cursor: pointer;
	}


</style>
<script type="text/javascript">
window.onload=function()
{
	document.getElementById("color").onchange=function()
	{
		document.getElementById("left").style.background = document.getElementById("color").value;
	}
}
</script>
</head>
<body>
<div class="left" id="left">
<h2> 系 统 菜 单</h2><br>
<ul>
<li><a href="AddEmployee" target="content">员工新增</a></li>
<li><a href="ManagerMent" target="content">员工管理</a></li>
<li><a href="" target="content">商品类别</a></li>
<li><a href="" target="content">客户管理</a></li>
<li><a href="Login" >退出系统</a></li>
</ul>
背景:<input type="color" id="color">
</div>

<div class="right">
<iframe class="iframe" name="content"></iframe>
</div>

</body>
</html>