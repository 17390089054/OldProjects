package com.mvc.Service;

import java.util.Map;

import com.mvc.Tools.DBUtil;
import com.mvc.Tools.User;

public class RegisterService {
	/**
	 * 注册方法
	 * @param account
	 * @param password
	 * @param user_name
	 * @param age
	 * @param sex
	 * @throws Exception
	 */
	public void Register(String account,String password,String user_name,String age,String sex) throws Exception
	{
		int count=GetAccountNum(account);
		if(count==0)
		{
			int Age=Integer.parseInt(age);
			String sql="insert into user (account,password,user_name,user_age,user_sex)values(?,?,?,?,?)";
			int result=DBUtil.executeUpdate(sql, new Object[]{account,password,user_name,Age,sex});
			if(result<0)
			{
				
				throw new Exception("注册遇到未知错误，请联系网站管理员");
				
			}
		}
		else
		{
			throw new Exception("账号已存在！");
		}
		
		
			
	}

	/**
	 * 用户账号个数查询方法
	 * @param account
	 * @return countNum
	 */
	public static int GetAccountNum(String account)
	{
		String Sql="select count(*) from user where account=? ";
		Map<String,Object>map=DBUtil.query(Sql,account);
		int count=Integer.parseInt(map.get("count(*)").toString());
		return count;
	}
	
	/**
	 * 用户添加方法 
	 * @author knight
	 * @param user
	 * @throws Exception
	 */
	public static void Register(User user) throws Exception
	{
		int num=GetAccountNum(user.getAccount());
		if(num==0)
		{
			String sql="insert into user(account,password,user_name,user_age,user_sex,user_status) values (?,?,?,?,?,?)";
			int age=Integer.parseInt(user.getUser_age());
			
			int result=DBUtil.executeUpdate(sql, new Object[]{user.getAccount().trim(),user.getPassword().trim(),user.getUser_name().trim(),age,user.getUser_sex(),user.getUser_status()});
			
			if(result<0)
			{
				throw new Exception("添加遇到未知错误，请重新填写");
				
			}
			
		}
		else
		{
			throw new Exception("账号已重复");
		}
		
		
	}

	

}
