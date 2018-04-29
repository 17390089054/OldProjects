package com.mvc.user;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mvc.Service.UpdateService;
import com.mvc.Service.UserSelect;
import com.mvc.Tools.User;

@WebServlet("/UserUpdate.do")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id=request.getParameter("user_id");
		User user=new User();
		try {
			user=UserSelect.GetUser(user_id);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("WEB-INF/jsp/UserUpdate.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//一次性接收所有数据
		Map<String, String[]>map=request.getParameterMap();
		User user=new User();
		try {
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		//数据判空
		if(user.getAccount().trim().length()==0)
		{
			request.setAttribute("msg", "账号不能为空!");
			request.getRequestDispatcher("WEB-INF/jsp/UserUpdate.jsp").forward(request, response);
			return;		
		}
		
		if(user.getUser_name().trim().length()==0)
		{
			request.setAttribute("msg", "姓名不能为空!");
			request.getRequestDispatcher("WEB-INF/jsp/UserUpdate.jsp").forward(request, response);
			return;		
		}
		
		if(user.getUser_age().trim().length()==0)
		{
			request.setAttribute("msg", "年龄不能为空!");
			request.getRequestDispatcher("WEB-INF/jsp/UserUpdate.jsp").forward(request, response);
			return;		
		}
		
		if(user.getUser_sex().trim().length()==0)
		{
			request.setAttribute("msg", "请选择性别!");
			request.getRequestDispatcher("WEB-INF/jsp/UserUpdate.jsp").forward(request, response);
			return;		
		}
		//验证账号有效性
		try {
			UpdateService.GetAccountNum(user.getAccount());		
				
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/UserUpdate.jsp").forward(request, response);
			e.printStackTrace();
		}
	
		//验证修改是否成功
		try {
			UpdateService.UpdateUser(user);
			request.setAttribute("msg", "编辑成功!");
			request.setAttribute("url", request.getContextPath()+"/UserList.do");
			request.getRequestDispatcher("WEB-INF/jsp/Message.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("url", request.getContextPath()+"/UserList.do");
			request.getRequestDispatcher("WEB-INF/jsp/Message.jsp").forward(request, response);
			e.printStackTrace();
		}		
		
		
		
		
	}

}
