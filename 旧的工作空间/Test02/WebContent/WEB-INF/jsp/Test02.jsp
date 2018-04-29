<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线用户</title>
</head>
<body>
<table border="1" width="200px" height="100px" style="text-align:center;">
<caption>用户列表</caption>
<thead>
<tr>
<th>序号</th>
<th>姓名</th>
<th>年龄</th>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.userList}" var="u" varStatus="vs">
<tr>
<td>${vs.count }</td>
<td>${u.name }</td>
<td>${u.age}</td>
</tr>
</c:forEach>
</tbody>
<tfoot>
</tfoot>
</table>

<c:if test="${userList[0].age  ne 40}" var="user">
哈哈哈哈
你猜对了

</c:if>
<c:if test="${!user }" >
你猜错了
</c:if>
<br/>
<c:choose >
<c:when test="${userList[1].age gt 60 }">恭喜你 ，答错了，年龄太大！</c:when>
<c:when test="${userList[1].age lt 40 }">恭喜你 ，答错了，年龄太小！</c:when>
<c:otherwise>正确年龄55</c:otherwise>

</c:choose>


</body>
</html>