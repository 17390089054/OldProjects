package com.MyTools;

public class LoginTools {

	public static void AddLog(String account,String name,String action, String date)
	{
		
		String sql="insert into log_action (log_account,log_name,log_action,log_date) values ('"+account+"','"+
		name+"','"+action+"','"+date+"')";
		
		int result=DBTools.executeUpdate(sql);
		if(result>0)
		{
			System.out.println("��Ӽ�¼�ɹ�!");			
		}
		else
		{
			System.out.println("���ʧ��!");
		}
		
	
	}
	
}
