package com.mvc.Service;

import com.mvc.Tools.DBUtil;

/** 
 * @package:      com.mvc.Service
 * @Description:  �޸��û�״̬
 * @author        knight
 * @Date          2017��12��10�� ����6:09:42 
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
			throw new Exception("�޸�ʧ�ܣ�����ϵ����Ա");
		}
		
	}

}
