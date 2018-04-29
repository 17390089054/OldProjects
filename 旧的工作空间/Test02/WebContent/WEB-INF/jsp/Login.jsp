<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<form method="post" action="Login.do">
账 号 : <input type="text" name="account" required/><br/><br/>
密 码 : <input type="password" name="password" required/><br/><br/>
<button>登 录</button>
<span style="color:red">${msg}</span>
</form>
</body>
</html>