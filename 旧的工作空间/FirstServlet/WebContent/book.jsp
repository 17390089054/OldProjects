<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="A" method="post">
<table align="center" border="1" width=350 >
<tr>
<td colspan="2" align="center"><h2>添加图书信息</h2></td>
</tr>
<tr>
<td align="center"height="20">图书信息:</td>
<td><input type="text" name="number" size="15"></td>
</tr>
<tr>
<td align="center"height="20">图书名称:</td>
<td><input type="text" name="name" size="15"></td>
</tr>

<tr>
<td align="center"height="20">作者:</td>
<td><input type="text" name="author" size="15"></td>
</tr>

<tr>
<td align="center"height="20">价格</td>
<td><input type="text" name="price" size="15"></td>
</tr>
<tr>
<td colspan=2 align="center">
<input type="submit" value="添         加 " height="20">
</td>
</tr>
</table>
</form>
</body>
</html>