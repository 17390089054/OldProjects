<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<style>
input
{
width:500px;
height:30px;
border-radius:5px;

}
.container
{
width:80%;
height:120px;
margin:20px;

}
.img
{
width:40%;
height:120px;
/* margin:10px; */ 
float:left;
margin-left:220px;
}
.text
{
width:40%;
height:120px;
margin-right:20px; 
float:left;
}


.btn
{
width:200px;
height:40px;
border-radius:10px;
color:white;
background-color:skyblue;
font-size:18px;
padding:5px;
cursor:pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>酒店列表</title>
</head>
<body>
<div align="center">
<form action="Hotel.do" method="post">
<input type="text" name="url" placeholder="此 处 粘 贴 你 的 网 址 " required/>
<button class="btn">查 &nbsp;&nbsp;&nbsp;&nbsp; 询</button>
</form >
</div>
<c:forEach items="${list }" var="v" varStatus="vs">
<div class="container">
<div class="img">
<img src="${v.img}" width="180" height="120" />
</div>
<div class="text">
<span>${v.name }</span><br/>
<span>${v.place}</span>
</div>
</div>
</c:forEach>
</body>
</html>