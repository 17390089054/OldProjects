<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link href="resource/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="resource/jquery-3.2.1.js"></script>
<script type="text/javascript">
function del()
{
	var msg="您真的要删除吗？";
	if(confirm(msg)==true)
		{
			return true;
		}
	else
		{
		return false;
		}	
}

	function changeUserStatus(obj,user_id,user_status,user_name)
	{
		if(confirm("确认修改【"+user_name+"】账户状态么?"))
		{
			$.post("ChangeUserStatus.do",{user_id:user_id,user_status:user_status},function(data)
					{
						console.log("修改状态:"+data.msg);
						console.log("返回状态"+data.flag);

						var status="";
						if(user_status==1)
						{
							status="禁用";
						}
						else
						{
							status="可用";
						}
						
						if(data.flag)
						{
							$(obj).html(status);	
						}				
						
					},"json")
		}
	
	}

</script>
</head>
<body>
<div class="row" style="margin:20px 20px 20px 0px;font-size:15px;">
	<div class="col-md-12">
		<form action="UserList.do" method="post">
		账号:<input type="text" name="account" value="${user.account }" style="border-radius:10px;"/>&nbsp;&nbsp;&nbsp;
		姓名:<input type="text" name="user_name" value="${user.user_name }" style="border-radius:10px;"/>&nbsp;&nbsp;
		年龄:<input type="number" min="0" name="user_age" value="${user.user_age }" style="border-radius:5px;"/>&nbsp;&nbsp;
		性别:		
		<input type="radio" name="user_sex" value="男"
		<c:if test="${user.user_sex=='男'}"> checked</c:if>/>男
		
		
			<input type="radio" name="user_sex" value="女" 
			<c:if test="${user.user_sex =='女'}">checked</c:if>/>女
			&nbsp;&nbsp;&nbsp;
		状态：<select name="user_status" >
				<option value="" 
				<c:if test="${user.user_status==''}">selected</c:if>
				>请选择
				</option>
				
				<option value="1"
				<c:if test="${user.user_status=='1'}">selected</c:if>				
				>可用</option>
				
				<option value="0"
				<c:if test="${user.user_status=='0'}">selected</c:if>
				>禁用</option>
			 </select>
			 &nbsp;&nbsp;
		<button class="btn" style="color:white;background-color:orange">查 询 </button>
		</form>
	</div>
</div>
<table class="table" >
	<thead>
		<tr>
		<th>序&nbsp;&nbsp;&nbsp;&nbsp;号</th>
		<th>用 户 姓 名</th>
		<th>账&nbsp;&nbsp;&nbsp;&nbsp;号</th>
		<th>用 户 年 龄 </th>
		<th>用 户 性 别 </th>
		<th>用 户 状 态 </th>
		<th>操 &nbsp;&nbsp;&nbsp;&nbsp;作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${ empty pb.list }">
		<tr><td colspan="7" style="text-align:center">暂 时 没有 数 据</td></tr>
		</c:if>
		<c:if test="${!empty pb.list }">
			<c:forEach items="${pb.list }" var="v" varStatus="vs">
				<tr>
				<td>${vs.count }</td>
				<td>${v.user_name }</td>
				<td>${v.account }</td>
				<td>${v.user_age }</td>
				<td>${v.user_sex }</td>
				<td>
				<a  style="cursor:pointer" href="javascript:void(0)" onclick="changeUserStatus(this,${ v.user_id},${v.user_status},'${v.user_name}' )">			
				<c:if test="${v.user_status==1}">
				可用
				</c:if>
				<c:if test="${v.user_status==0}">
				禁用
				</c:if>
				</a>
				</td>
				<td>
				<a  target="content" class="btn btn-info" href="UserUpdate.do?user_id=${v.user_id}">修改</a>
				<a  target="content" class="btn btn-danger" href="UserDelete.do?user_id=${v.user_id}" onclick="javascript:return del()">删除</a>
				</td>
				</tr>	
			</c:forEach>
		
		</c:if>
			
	<tbody>
	
	
</table>
	<span>
			&nbsp;&nbsp;<a href="UserList.do?pageNow=1" target="content">首页</a>
			&nbsp;&nbsp;<a href="UserList.do?pageNow=${pb.pageNow-1>0?pb.pageNow-1:1}" target="content">上一页</a>
			&nbsp;&nbsp;<a href="UserList.do?pageNow=${pb.pageNow+1<pb.pageCount?pb.pageNow+1:pb.pageCount}" target="content">下一页</a>
			&nbsp;&nbsp;<a href="UserList.do?pageNow=${pb.pageCount}" target="content">尾   页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span>当 前 第  ${pb.pageNow} 页</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span>共${pb.pageCount}页</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span>共${pb.numCount}条数据</span>		
		</span>	
</body>
</html>