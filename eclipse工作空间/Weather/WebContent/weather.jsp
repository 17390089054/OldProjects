<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天气查询</title>
<style>
*
{
margin:0px;
padding:0px;
}
html,body
{
height:100%;
width:100%;
}
.text
{
width:200px;
height:20px;
padding:5px;
border-radius:5px;
}
.btn
{
color:#fff;
background-color:skyblue;
width: 80px;
height: 34px;
font-size:18px;
border-radius:5px;
}


</style>
</head>
<body>
<form action="weather" method="post"> 
请输入城市名称:<input type="text" name="cityname" class="text"/>
<button class="btn">查 询</button>

</form>
${result }
</body>
</html>