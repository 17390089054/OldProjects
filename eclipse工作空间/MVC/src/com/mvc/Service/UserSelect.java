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
 * @Description:    模糊查询类 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017年10月28日 下午6:43:16 
 */

public class UserSelect {
	public static PageBean Select(User user,PageBean pb)
	{
	/*	List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();*/
		StringBuilder sb=new StringBuilder("select * from user where 1=1 ");
		//判断数据有效性 拼接sql语句
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
	
		//获取记录总数
		String count="select count(*) as count from ("+sb.toString()+")as t";
		//System.out.println(count);
		//System.out.println(count);
		Map<String,Object>m=DBUtil.query(count);
		String num =m.get("count").toString();
		//存入PageBean 查询记录总数
		pb.setNumCount(Integer.parseInt(num));
		
		//设置页面总数
		pb.setPageCount();
		
		//获取当前页面数
		int PageNow=pb.getPageNow(); 
		
		//获取查询的分页信息
		String sql=sb.toString()+" limit "+(PageNow-1)*pb.getNum()+","+pb.getNum()+"";
		//System.out.println(sql);
		//查询分页结果
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
		//返回PageBean		
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
			throw new Exception("查询用户ID不能为空!");
		}
		
		
		return user;
		
	}


	

}
