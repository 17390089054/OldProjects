package com.mvc.Service;

import java.util.Map;

import com.mvc.Tools.DBUtil;
import com.mvc.Tools.User;

/** 
 * @package:        com.mvc.Service
 * @Description:  	用户信息修改类
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017年11月6日 下午10:27:21 
 */
public class UpdateService {
	
	/**
	 * 账号重复查询
	 * @param account
	 * @throws Exception
	 */
	public static void GetAccountNum(String account) throws Exception
	{
		String sql="select count(*) as num from user where account=?";
		Map<String,Object>map=DBUtil.query(sql, account);
		String num=map.get("num").toString();
		if(num.compareTo("1")>0)
		{
			throw new Exception("账号重复,请重新填写!");
		}
		
	}
	
	/**
	 * 信息修改主方法
	 * @param user
	 * @throws Exception
	 */
	public static void UpdateUser(User user) throws Exception
	{
		String sql="update user set account=?,user_name=?,user_age=?,user_sex=?,user_status=? where user_id=?";
		int result=DBUtil.executeUpdate(sql, new Object[]{
				user.getAccount(),
				user.getUser_name(),
				user.getUser_age(),
				user.getUser_sex(),
				user.getUser_status(),
				user.getUser_id()
					
		});
		
		if(result>0)
		{
		}
		else
		{
			throw new Exception("修改失败!请联系网站管理员!");
		}
			
	}
	
	/**
	 * 删除主方法
	 * @param user_id
	 * @throws Exception
	 */
	public static void DeleteUser(String user_id) throws Exception
	{
		String sql="delete from user where user_id=?";
		int result=DBUtil.executeUpdate(sql, user_id);
		if(result<0)
		{
			throw new Exception("遇到未知错误,请联系管理员!");
		}
		
		
		
	}
	
	
	
	
	
	
}
