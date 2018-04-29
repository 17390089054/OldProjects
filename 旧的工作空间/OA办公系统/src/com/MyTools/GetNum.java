package com.MyTools;

import java.util.HashMap;
import java.util.Map;

public class GetNum {
	
	@SuppressWarnings("unchecked")
	public static String Count(String sql)
	{
		String count="";
		Map<String,String>map=new HashMap<String,String>();
		map=(Map<String, String>) DBTools.executeQuery(sql).get(0);
		if(map!=null)
		{
			count=map.get("count(*)");
		}
		
		return count;
	}

}
