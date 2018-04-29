<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
*
{
margin:5px;
padding:0px;
}
html,body
{
height:100%;
width:100%;
/* overflow:hidden; */
}

.top 
{
width:100%;
height:28%;
/* margin:0px auto 0px; */
}
.login
{

float:right;
line-height:330px;
margin-right:6%;
width:20%;
height:100%;
font-size:20px;

}

.logo
{
width:60%;
height:100%;
float:left;
/* margin:0px auto;  */
}

.main_view
{
/* height:600px; */
margin-buttom:150px;
border:1px;
width:100%;
height:100%;

}
.menu
{
float:left;
border:5px solid gray;
padding:0px;
width:15%;
height:90%;
border-radius:10px;
text-align:center;
 background-color:lightgray; 
}
.nav
{
float:right;
border-radius:10px;
width:80%;
height:90%;
margin-right:10px;
}

.frame
{
padding:0px;
width:90%;
height:100%;

}
ul
{

list-style:none;
margin-top:5px;
font-size:20px;
padding:10px;
}
li
{
margin-top:10px;
}
ul a
{
text-decoration:none;
color:purple; 
text-decoration:none;

}

body a:link
{
color:orangered;
text-decoration:none;

}

body a:visited
{
color:coffee;
}

body a:hover
{
color:orange;
}
#color{
		height:30px;
		width:30px;
		border-radius: 15px;
		cursor: pointer;
	}


</style>
<title>主页</title>

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
<!-- 头部信息 -->
<div class="top">
<div class="logo">
<img src="resource/bg4.jpg" width="600px" height="200px"/>
</div>
<div class="login">
<span>欢迎登录:${user.user_name } <a href="LogOut.do" target="_self">退出系统</a>
</span>
</div>

</div>

<!-- 主页部分 -->
<div class="main_view">

<!-- 导航栏 -->
<div class="menu" id="left">
<ul>
<li><a href="UserAdd.do" target="content">员工添加</a></li>
<li><a href="UserList.do" target="content">员工列表</a></li>
<li><a href="" target="content">员工修改</a></li>
<li><a href="" target="content">离职员工</a></li>
</ul>
 更 换 背 景:<input type="color" id="color"/>
</div>
<!-- iframe内部-->
<div class="nav">
<iframe name="content" class="frame">

</iframe>
 </div>

</div>
</body>
</html>