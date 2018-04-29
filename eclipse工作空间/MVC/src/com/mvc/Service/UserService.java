package com.mvc.Service;

import java.util.Map;

import com.mvc.Tools.DBUtil;

public class UserService {
	/**
	 * service层
	 * 用于处理从前台发送的请求
	 * 与数据库进行交互后将结果返回给Servlet
	 * @throws Exception 
	 */
	public Map<String,Object> LoginService(String account,String password ) throws Exception
	{
		String sql="select * from User where account=? and password=? ";
		Map<String,Object>map=DBUtil.query(sql, new Object[]{account,password});
		if(map!=null&&map.size()>0)
		{
			if(map.get("user_status").toString().equals("1"))
			{
				return map;
			}
			else
			{
				throw new Exception("账号已被禁用,请联系统管理员");
			}
		}
		else
		{
			throw new Exception("账号或密码错误"); 
		}
		
		
	}
	
	
	
	
}
