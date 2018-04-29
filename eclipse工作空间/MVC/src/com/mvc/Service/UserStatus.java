package com.mvc.Service;

import com.mvc.Tools.DBUtil;

/** 
 * @package:      com.mvc.Service
 * @Description:  修改用户状态
 * @author        knight
 * @Date          2017年12月10日 下午6:09:42 
 */
public class UserStatus {
	
	public void ChnageUserStatus(int user_id ,int user_status) throws Exception
	{
		if(user_status==1)
		{
			user_status=0;
		}
		else
		{
			user_status=1;
		}
		String sql="update user set user_status=? where user_id=?";
		int num=DBUtil.executeUpdate(sql, new Object[]{user_status,user_id});
		if(num<0)
		{
			throw new Exception("修改失败，请联系管理员");
		}
		
	}

}
