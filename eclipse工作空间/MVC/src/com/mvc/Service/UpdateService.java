package com.mvc.Service;

import java.util.Map;

import com.mvc.Tools.DBUtil;
import com.mvc.Tools.User;

/** 
 * @package:        com.mvc.Service
 * @Description:  	�û���Ϣ�޸���
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017��11��6�� ����10:27:21 
 */
public class UpdateService {
	
	/**
	 * �˺��ظ���ѯ
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
			throw new Exception("�˺��ظ�,��������д!");
		}
		
	}
	
	/**
	 * ��Ϣ�޸�������
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
			throw new Exception("�޸�ʧ��!����ϵ��վ����Ա!");
		}
			
	}
	
	/**
	 * ɾ��������
	 * @param user_id
	 * @throws Exception
	 */
	public static void DeleteUser(String user_id) throws Exception
	{
		String sql="delete from user where user_id=?";
		int result=DBUtil.executeUpdate(sql, user_id);
		if(result<0)
		{
			throw new Exception("����δ֪����,����ϵ����Ա!");
		}
		
		
		
	}
	
	
	
	
	
	
}
