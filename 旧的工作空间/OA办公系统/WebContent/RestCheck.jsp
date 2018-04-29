<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page 
    import="java.util.Map"
    import="java.util.HashMap"
     %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假审批</title>
</head>
<%
Map<String,String>map=new HashMap<String,String>();
String rest_id="";
String user_name="";
String start_date="";
String end_date="";
String reason="";
String reply="";
String msg="";
if(request.getAttribute("map")!=null)
{
	map=(Map<String,String>)request.getAttribute("map");
	rest_id=map.get("rest_id");
	user_name=map.get("user_name");
	start_date=map.get("start_date");
	end_date=map.get("end_date");
	reason=map.get("rest_reason");
	if(map.get("reply")!=null)
	{
		reply=map.get("reply");
	}

	
}
else
{
	if(request.getAttribute("rest_id")!=null)
	{
		rest_id=request.getAttribute("rest_id").toString();
	}
	if(request.getAttribute("user_name")!=null)
	{
		user_name=request.getAttribute("user_name").toString();
	}
	
	if(request.getAttribute("start_date")!=null)
	{
		start_date=request.getAttribute("start_date").toString();
	}
	
	if(request.getAttribute("end_date")!=null)
	{
		end_date=request.getAttribute("end_date").toString();
	}
	
	if(request.getAttribute("reason")!=null)
	{
		reason=request.getAttribute("reason").toString();
	}
	
	if(request.getAttribute("reply")!=null)
	{
		reply=request.getAttribute("reply").toString();
	}
	

	if(request.getAttribute("msg")!=null)
	{
		msg=request.getAttribute("msg").toString();
	}
	
	
}


%>
<script type="text/javascript">
function check()
{
	document.form.action="RestCheck";
	
	document.form.submit();
	}
function cancel()
{
	document.form.action="Restfall";
	document.form.submit();
	}

</script>

<div style="background-color:yellowgreen">
<form action="" name="form" method="post">

 <span style="color:purple;size:30px;"> 请 假 审 批  </span>
 <fieldset style="text-align:center;margin-right:4%;border:0">
 <ul style="list-style:none;">
<li><input type="hidden" name="rest_id" value="<%=rest_id%>"></li>

 <li style="margin-top:1%">
<label> 请 假 人  </label> 
<input type="text" style="width:25%;border-radius:5px;padding:5;margin-left:2%" name="user_name" value="<%=user_name %>" readonly />
</li> 

<li style="margin-top:1%">
<label>开 始 时 间 </label>
<input type="date" name="start_date" value="<%=start_date %>" style="width:25%;padding:5 25;margin:10;border-radius:5px ;"  />
</li>

<li style="margin-top:1%">
<label>结 束  时 间 </label>
<input type="date" name="end_date"  value="<%=end_date %>" style="width:25%;padding:5 25;margin:10;border-radius:5px ;"  />
</li>


<li style="margin-top:1%">
<label >请  假  原   因 </label>
<textarea cols="45" rows="12" name="reason" style="border-radius:5px;margin-left:1%">
<%=reason %>
</textarea>
</li>

<li style="margin-top:1%">
<label >回 &nbsp; &nbsp; &nbsp; &nbsp;复 </label>
<textarea cols="45" rows="12" name="reply" style="border-radius:5px;margin-left:2%">
<%=reply %>
</textarea>
</li>


<li style="margin-top:1%;margin-left:8%">
<input type="submit"  style="background-color:red;color:white;font-size:18px;padding:10 5 10 10;margin:10 10 5 5;border-radius:10px;"  value="确  认  通   过  "  onclick="check()"   />
<input type="submit"  style="background-color:orange;color:white;font-size:18px;padding:10 5 10 10;margin:10 10 5 5;border-radius:10px;"  value="不  予  通  过  "  onclick="cancel()"   />
</li>
</ul>
</fieldset>


</form>
<div align="center" style="margin-top:-2%"><span style="color:red;size:30px;"><%=msg %></span></div>
</div>





</body>
</html>