package com.test.dh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework")
public class Homework extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.write("<center><h1 style='color:lightblue'>欢  迎   注  册</h1></center><br>"
				+ "<form action='register.jsp' method='post' style='align:center'>"
				+ "<table align='center' border='1' cellspacing='1' height='570' width='425.5' bgcolor='lightgreen'>"
				+ "<tr><td>姓 名</td>"
				+ "<td><input type='text' length=20 placeholder='   请    输    入    姓    名 ' >"+"</td></tr>"
						+ ""
				+ "<tr><td>性别</td>"
				+ "<td>&nbsp;&nbsp;<input type='radio' value='nan' name='sex' checked>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type='radio' value='nv' name='sex'>女"
				+ "</td></tr>"
				+ ""
				+ "<tr><td>出生年月</td>"
				+ "<td><select>"
				+ "<option>请选择</option>"
				+ "<option>1995</option><option>1996</option><option>1997</option><option>1998</option><option>1999</option></select>&nbsp;年"
				+"&nbsp;&nbsp;<select>"
				+"<option>请选择</option>"
				+ "<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>"
				+ "</select>&nbsp;月"
				+ "&nbsp;&nbsp;<select>"
				+ "<option>请选择</option>"
				+ "<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>"
				+ "</select>&nbsp;日"
				+ "</td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td>家庭住址</td>"
				+ "<td><select>"
				+ "<option>请选择</option>"
				+ "<option>吉林省</option><option>山东省</option><option>辽宁省</option><option>河北省</option><option>河南省</option></select>"
				+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select>"
				+"<option>请选择</option>"
				+ "<option>长春市</option><option>吉林市</option><option>通化市</option><option>白山市</option><option>磐石市</option>"
				+ "</select>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<select>"
				+ "<option>请选择</option>"
				+ "<option>农安县</option><option>朝阳区</option><option>南关区</option><option>........</option><option>...........</option>"
				+ "</select>"
				+ "</td>"
				+ "</tr>"
				+ ""
				+"<tr>"
				+ "<td>手机号</td>"
				+ "<td><input type='text' maxlength=11 placeholder='请  输  入  11  位 手  机 号'>&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type='button' value='验  证  码' style='color:orange'></td>"
				+ "</tr>"
				+ "" 
				+ "<tr><td>密码</td>"
				+ "<td><input type='password' maxlength=20 placeholder='  请  设  置  您  的  密   码   '></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>确认密码</td>"
				+ "<td><input type='password' maxlength placeholder='  请  再  次  输  入  密   码   '> </td></tr>"
				+ "<tr><td>注册协议</td>"
				+ "<td><textarea cols=40 rows=20></textarea></td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td></td>"
				+ "<td><input type='checkbox'>我已仔细阅读上述协议</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td></td>"
				+ "<td>"
				+ "&nbsp;&nbsp;&nbsp;<input type='reset' value=' 重   置 ' style=' color:orangered' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type='submit' value=' 确  认  注   册  ' style='color:red'>"
				+ "</td>"
				+ "</tr>"
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ "</table>"
				+ "</form>");
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
