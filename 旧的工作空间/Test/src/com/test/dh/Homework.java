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
		out.write("<center><h1 style='color:lightblue'>��  ӭ   ע  ��</h1></center><br>"
				+ "<form action='register.jsp' method='post' style='align:center'>"
				+ "<table align='center' border='1' cellspacing='1' height='570' width='425.5' bgcolor='lightgreen'>"
				+ "<tr><td>�� ��</td>"
				+ "<td><input type='text' length=20 placeholder='   ��    ��    ��    ��    �� ' >"+"</td></tr>"
						+ ""
				+ "<tr><td>�Ա�</td>"
				+ "<td>&nbsp;&nbsp;<input type='radio' value='nan' name='sex' checked>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type='radio' value='nv' name='sex'>Ů"
				+ "</td></tr>"
				+ ""
				+ "<tr><td>��������</td>"
				+ "<td><select>"
				+ "<option>��ѡ��</option>"
				+ "<option>1995</option><option>1996</option><option>1997</option><option>1998</option><option>1999</option></select>&nbsp;��"
				+"&nbsp;&nbsp;<select>"
				+"<option>��ѡ��</option>"
				+ "<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>"
				+ "</select>&nbsp;��"
				+ "&nbsp;&nbsp;<select>"
				+ "<option>��ѡ��</option>"
				+ "<option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>"
				+ "</select>&nbsp;��"
				+ "</td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td>��ͥסַ</td>"
				+ "<td><select>"
				+ "<option>��ѡ��</option>"
				+ "<option>����ʡ</option><option>ɽ��ʡ</option><option>����ʡ</option><option>�ӱ�ʡ</option><option>����ʡ</option></select>"
				+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select>"
				+"<option>��ѡ��</option>"
				+ "<option>������</option><option>������</option><option>ͨ����</option><option>��ɽ��</option><option>��ʯ��</option>"
				+ "</select>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<select>"
				+ "<option>��ѡ��</option>"
				+ "<option>ũ����</option><option>������</option><option>�Ϲ���</option><option>........</option><option>...........</option>"
				+ "</select>"
				+ "</td>"
				+ "</tr>"
				+ ""
				+"<tr>"
				+ "<td>�ֻ���</td>"
				+ "<td><input type='text' maxlength=11 placeholder='��  ��  ��  11  λ ��  �� ��'>&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type='button' value='��  ֤  ��' style='color:orange'></td>"
				+ "</tr>"
				+ "" 
				+ "<tr><td>����</td>"
				+ "<td><input type='password' maxlength=20 placeholder='  ��  ��  ��  ��  ��  ��   ��   '></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>ȷ������</td>"
				+ "<td><input type='password' maxlength placeholder='  ��  ��  ��  ��  ��  ��   ��   '> </td></tr>"
				+ "<tr><td>ע��Э��</td>"
				+ "<td><textarea cols=40 rows=20></textarea></td>"
				+ "</tr>"
				+ ""
				+ "<tr>"
				+ "<td></td>"
				+ "<td><input type='checkbox'>������ϸ�Ķ�����Э��</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td></td>"
				+ "<td>"
				+ "&nbsp;&nbsp;&nbsp;<input type='reset' value=' ��   �� ' style=' color:orangered' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "<input type='submit' value=' ȷ  ��  ע   ��  ' style='color:red'>"
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
