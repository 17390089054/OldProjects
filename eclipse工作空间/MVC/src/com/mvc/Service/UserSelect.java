package com.mvc.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.mvc.Tools.DBUtil;
import com.mvc.Tools.PageBean;
import com.mvc.Tools.User;

/** 
 * @package:        com.mvc.Service
 * @Description:    ģ����ѯ�� 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017��10��28�� ����6:43:16 
 */

public class UserSelect {
	public static PageBean Select(User user,PageBean pb)
	{
	/*	List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();*/
		StringBuilder sb=new StringBuilder("select * from user where 1=1 ");
		//�ж�������Ч�� ƴ��sql���
		if (user.getAccount()!=null&&user.getAccount().trim().length()>0)
		{
			sb.append(" and account like '%"+StringEscapeUtils.escapeSql(user.getAccount())+"%'");		
		}
		
		if (user.getUser_name()!=null&&user.getUser_name().trim().length()>0)
		{
			sb.append(" and user_name like '%"+StringEscapeUtils.escapeSql(user.getUser_name())+"%'");		
		}
		
		if(user.getUser_age()!=null&&user.getUser_age().trim().length()>0)
		{
			sb.append(" and user_age ="+user.getUser_age()+"");
			
		}
		
		if(user.getUser_sex()!=null&&user.getUser_sex().trim().length()>0)
		{
			sb.append(" and user_sex ='"+StringEscapeUtils.escapeSql(user.getUser_sex())+"'");
			
		}
		
		if(user.getUser_status()!=null&&user.getUser_status().trim().length()>0)
		{
			sb.append(" and user_status ="+user.getUser_status()+"");
		}
	
		//��ȡ��¼����
		String count="select count(*) as count from ("+sb.toString()+")as t";
		//System.out.println(count);
		//System.out.println(count);
		Map<String,Object>m=DBUtil.query(count);
		String num =m.get("count").toString();
		//����PageBean ��ѯ��¼����
		pb.setNumCount(Integer.parseInt(num));
		
		//����ҳ������
		pb.setPageCount();
		
		//��ȡ��ǰҳ����
		int PageNow=pb.getPageNow(); 
		
		//��ȡ��ѯ�ķ�ҳ��Ϣ
		String sql=sb.toString()+" limit "+(PageNow-1)*pb.getNum()+","+pb.getNum()+"";
		//System.out.println(sql);
		//��ѯ��ҳ���
		List<Map<String,Object>> list2=DBUtil.list(sql);
			
		if(list2!=null&&list2.size()>0)
		{
			List<User>userList=new ArrayList<User>();
			for (Map<String,Object>map:list2)
			{
				User user2=new User();
				try {
					BeanUtils.populate(user2, map);
				} catch (Exception e) {
					e.printStackTrace();
				}
				userList.add(user2);
				pb.setList(userList);   
			}
		//����PageBean		
			return pb;
		}
		else
		{
			return null;
		}
	
	}

	/**
	 * 
	 * @param user_id
	 * @return User 
	 * @throws Exception
	 */
	public static User GetUser(String user_id) throws Exception
	{
		User user=new User();
		if(user_id.trim().length()!=0)
		{
			String sql="select * from user where user_id=?";
			Map<String,Object> map=DBUtil.query(sql, user_id);
			if(map!=null)
			{
				try
				{
					BeanUtils.populate(user, map);
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
			
		}
		else
		{
			throw new Exception("��ѯ�û�ID����Ϊ��!");
		}
		
		
		return user;
		
	}


	

}
