package com.mvc.Service;

import java.util.Map;

import com.mvc.Tools.DBUtil;

public class UserService {
	/**
	 * service��
	 * ���ڴ����ǰ̨���͵�����
	 * �����ݿ���н����󽫽�����ظ�Servlet
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
				throw new Exception("�˺��ѱ�����,����ϵͳ����Ա");
			}
		}
		else
		{
			throw new Exception("�˺Ż��������"); 
		}
		
		
	}
	
	
	
	
}
