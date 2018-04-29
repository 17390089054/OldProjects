<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
 <head> 
  <!--网站编码格式，UTF-8 国际编码，GBK或 gb2312 中文编码--> 
  <meta http-equiv="content-type" content="text/html;charset=utf-8" /> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
  <meta name="Keywords" content="关键词一，关键词二"> 
  <meta name="Description" content="网站描述内容"> 
 <!--  <meta name="Author" content="Yvette Lau">  -->
  <!-- <meta name = "viewport" content = " width = device-width, initial-scale = 1 ">    -->
  <title>用户添加</title> 
  <!--css js 文件的引入--> 
  <link rel="stylesheet" type="text/css" href="resource/bootstrap.min.css"> 
 </head> 
 <body style="padding: 20px;"> 
 <div style="margin:10px auto 0 auto" > 
	  <div class = "col-xs-12 col-sm-6 col-md-4 col-lg-3" > 
		   <form role = "form" action="UserAdd.do"  method="post"> 
		    	<div class = "form-group"> 
				     <label for = "account">用户账号</label> 
				     <input type = "text" class = "form-control" name="account"  placeholder = "请 输 入 账 号 " value="${requestScope.user.account}"  ></input> 
			    </div> 
			    
			    <div class = "form-group" > 
				     <label for = "name">用户姓名</label> 
				     <input type = "text" class = "form-control"  name="user_name" value="${requestScope.user.user_name}" placeholder = "请 输 入 用 户 姓 名 "  ></input> 
			    </div> 
			    
			    <div class = "form-group" > 
				     <label for = "password">用户密码</label> 
				     <input type = "password" class = "form-control"  name="password" value="${requestScope.user.password}"  placeholder = "请 输 入  用 户 密 码 " ></input> 
			    </div> 
			    
			    <div class = "form-group"> 
				     <label for = "password">确认密码</label> 
				     <input type="password" class="form-control"   name="password2"	value="${password2}" placeholder = "请 确 认 你 的 密 码 " ></input> 
			    </div> 
			     
			    <div class = "form-group" > 
				     <label for = "age">用户年龄</label> 
				     <input type = "number" min="0" class = "form-control"  name="user_age" value="${requestScope.user.user_age }" placeholder = "请 输 入 用 户 年 龄"   ></input> 
			    </div> 
			    
			    <div class = "form-group"> 
			     <label for = "profession">选择性别</label> 
			     <select id = "profession"  class = "form-control" name="user_sex" > 
				      <option value=""
				      <c:if test="${requestScope.user.user_sex eq ''}">
				      selected</c:if>
				      >请选择 </option>  
				      <option value="男" 
				      <c:if test="${requestScope.user.user_sex == '男' }">selected</c:if>
				      >男</option> 
				      <option value="女" 
				      <c:if test="${requestScope.user.user_sex == '女'}">selected</c:if>
				      >女</option> 
			     </select> 
			    </div> 
			    
			    <div class="form-group"> 
			     <button type = "submit" class="btn-info btn-lg" >提交</button> 
		    	</div> 
		   </form> 
	  </div> 

</div>
	  <div style="float:left"><span style="font-color:red;font-size:20px;">${msg}</span></div>
 </body> 
</html>
