<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page 
    import="java.util.List"
    import="java.util.ArrayList"
    import="java.util.Map"
     %>
<!DOCTYPE html">
<html>
<head>
    <title>登录日志</title>

    <style type="text/css">
    table
    {
    border:0;   
    text-align:center;
    margin:0% 5% 5% 10%;
     cellpadding:0;
   		width:80%;
      cellspacing:0;
    }
        .t1
        {
            clear: both;
            border: 1px solid #c9dae4;
        }
        .t1 tr th
        {
            color: #0d487b;
           /*  background: #f2f4f8 url(../CSS/Table/images/sj_title_pp.jpg) repeat-x left bottom; */
            line-height: 28px;
            border-bottom: 1px solid #9cb6cf;
            border-top: 1px solid #e9edf3;
            font-weight: normal;
            text-shadow: #e6ecf3 1px 1px 0px;
            padding-left: 5px;
            padding-right: 5px;
        }
        .t1 tr td
        {
            border-bottom: 1px solid #e9e9e9;
            padding-bottom: 5px;
            padding-top: 5px;
            color: #444;
            border-top: 1px solid #FFFFFF;
            padding-left: 5px;
            padding-right: 5px;
            word-break: break-all;
        }
        /* white-space:nowrap; text-overflow:ellipsis; */
        tr.alt td
        {
            background: #ecf6fc; /*这行将给所有的tr加上背景色*/
        }
        tr.over td
        {
            background: #bcd4ec; /*这个将是鼠标高亮行的背景色*/
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () { //这个就是传说的ready  
            $(".t1 tr").mouseover(function () {
                //如果鼠标移到class为stripe的表格的tr上时，执行函数  
                $(this).addClass("over");
            }).mouseout(function () {
                //给这行添加class值为over，并且当鼠标一出该行时执行函数  
                $(this).removeClass("over");
            }) //移除该行的class  
            $(".t1 tr:even").addClass("alt");
            //给class为stripe的表格的偶数行添加class值为alt
        });
    </script>
</head>
<body>
   <%
   List<Map<String,String>>list=new ArrayList<Map<String,String>>();
   
   if(request.getAttribute("list")!=null)
   {
	   list=(List<Map<String,String>>)request.getAttribute("list");	   
   }
   
   
   %>
   
    <table  id="ListArea" class="t1" >
        <tr align="center">
            <th>序 号</th>
            <th>用 户 名</th>
            <th>用 户 姓 名</th>
     		<th>登 录 时 间</th>
        </tr>
        <tr align="center">
        <%
        	for(int i=list.size()-1;i>=0;i--)
        	{
        		
        
        %>
            <td>
                <%=list.size()-i %>
            </td>
            <td>
               <%=list.get(i).get("account") %>
            </td>
            <td>
               <%=list.get(i).get("user_name") %> 
            </td>
            <td>
                <%=list.get(i).get("log_create_time") %>
            </td>

        </tr>
       
       <%
       
        	}
       %>
      
       
    </table>
   
</body>
</html>