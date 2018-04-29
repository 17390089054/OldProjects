package com.mvc.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.Service.UserSelect;
import com.mvc.Tools.DBUtil;
import com.mvc.Tools.PageBean;
import com.mvc.Tools.User;


@WebServlet("/UserList.do")
public class UserList extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ܲ�ѯ����
		String account=request.getParameter("account");
		//String password=request.getParameter("password");
		String user_name=request.getParameter("user_name");
		String user_age=request.getParameter("user_age");
		String user_sex=request.getParameter("user_sex");
		String user_status=request.getParameter("user_status");
		//System.out.println(user_status);
		//ʵ����һ��USerBean	
		User user=new User();
		user.setAccount(account);
		user.setUser_name(user_name);
		user.setUser_age(user_age);
		user.setUser_sex(user_sex);
		user.setUser_status(user_status);
		//����ǰ̨��ѯ�ķ�ҳ��Ϣ
		PageBean pb=new PageBean();
		//����ÿҳ�ļ�¼��
		pb.setNum(3);
		if(!("").equals(request.getParameter("pageNow"))&&request.getParameter("pageNow")!=null)
		{	
			pb.setPageNow(Integer.parseInt(request.getParameter("pageNow")));
		}
	
		//System.out.println(	UserSelect.Select(user, pb));
		//��ѯ�������   ��������PageBean��
		request.setAttribute("user", user);
		//System.out.println(UserSelect.Select(user,pb));
		request.setAttribute("pb", UserSelect.Select(user,pb));
		
		request.getRequestDispatcher("WEB-INF/jsp/UserList.jsp").forward(request, response);
		
		
		
	}

}
