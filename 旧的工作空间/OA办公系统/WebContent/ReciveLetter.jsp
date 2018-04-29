<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page
    import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Map"
    %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resource/css_mail/style.css" type="text/css" media="screen"/>
<title>收件箱</title>
		<style>
        *{
            margin:0;
            padding:0;
        }
        table{
        margin:2% auto;
        width:80%;
        }
        body{
            font-family: Georgia, serif;
            font-size: 20px;
            font-style: italic;
            font-weight: normal;
            letter-spacing: normal;
            background: #f0f0f0;
        }
        #content{
            background-color:#fff;
            width:75%;
            padding:40px;
            margin:0 auto;
            border-left:30px solid #1D81B6;
            border-right:1px solid #ddd;
            -moz-box-shadow:0px 0px 16px #aaa;
        }
        .head{
            font-family:Helvetica,Arial,Verdana;
            text-transform:uppercase;
            font-weight:bold;
            font-size:12px;
            font-style:normal;
            letter-spacing:3px;
            color:#888;
            border-bottom:3px solid #f0f0f0;
            padding-bottom:10px;
            margin-bottom:10px;
        }
        .head a{
            color:#1D81B6;
            text-decoration:none;
            float:right;
            text-shadow:1px 1px 1px #888;
        }
        .head a:hover{
            color:#f0f0f0;
        }
        #content h1{
            font-family:"Trebuchet MS",sans-serif;
            color:#1D81B6;
            font-weight:normal;
            font-style:normal;
            font-size:56px;
            text-shadow:1px 1px 1px #aaa;
        }
        #content h2{
            font-family:"Trebuchet MS",sans-serif;
            font-size:34px;
            font-style:normal;
            background-color:#f0f0f0;
            margin:40px 0px 30px -40px;
            padding:0px 40px;
            clear:both;
            /* float:left */;
            width:100%;
            color:#aaa;
            text-shadow:1px 1px 1px #fff;
        }

    </style>

</head>
<body>
<%
	List<Map<String,String>>list=new ArrayList<Map<String,String>>();
	if(request.getAttribute("list")!=null)
	{
		list=(List<Map<String,String>>)request.getAttribute("list");
	}
	String name="";
	if(request.getAttribute("user_name")!=null)
	{
		name=request.getAttribute("user_name").toString();
	}
%>
<script type="text/javascript">
function del()
{
	var msg="确 认 删 除 ?";
	if(confirm(msg)==true)
	{
		return true;
	}
	else
	{
		return false;
	}
	
}

</script>
       
            <table class="table1">
                <thead>
                    <tr>
                        <th scope="col" abbr="Starter">序&nbsp;&nbsp;&nbsp;号</th>
                        <th scope="col" abbr="Starter">&nbsp;发 &nbsp;送 &nbsp;人 </th>
                        <th scope="col" abbr="Medium">&nbsp;接&nbsp; 收&nbsp; 人</th>
                        <th scope="col" abbr="Business">邮 &nbsp;件&nbsp; 内&nbsp; 容</th>
                        <th scope="col" abbr="Business">发 &nbsp;送&nbsp; 时&nbsp; 间</th>                       
                        <th scope="col" abbr="Deluxe">邮 &nbsp;件 &nbsp;状 &nbsp;态</th>
                        <th scope="col" abbr="Deluxe">操&nbsp;&nbsp;&nbsp;作</th>
                    </tr>
                </thead>
               
                <tbody>
                <%
                int num=1;
                for(int i=list.size()-1;i>=0;i--)
                {
                	boolean flag=false;
                	String status=list.get(i).get("STATUS");
                	
                	if(!status.equals("2"))
                	{
                %>
                    <tr>
                       	<td><%=num++ %></td>
                        <td><%=list.get(i).get("user_name") %></td>
                        <td><%=name %></td>
                        <td><%=list.get(i).get("Message") %></td>
                        <td><%=list.get(i).get("P_Date") %></td>
                        <td><%
                        if(status.equals("0"))
                        {
                        	out.write("未 查 看 ");
                        	
                        }
                        
                        if(status.equals("1"))
                        {
                        	out.write("已 查 看");
                        	flag=true;
                        }
                        
                        
                        %></td>
                        <td>
                     
                        <a href="EmailView?id=<%=list.get(i).get("M_ID") %>" name="content" style="text-decoration:none;color:brown">查 &nbsp;&nbsp;看</a>&nbsp;&nbsp;&nbsp;&nbsp;
                      
                        <a href="EmailDelete?id=<%=list.get(i).get("M_ID") %>" name="content" style="text-decoration:none;color:orangered" onclick="javascript:return del();">删&nbsp;&nbsp; 除</a>
                       
                        </td>
                    </tr>
				<%}
                	}%>
                </tbody>
            </table>
</body>
</html>