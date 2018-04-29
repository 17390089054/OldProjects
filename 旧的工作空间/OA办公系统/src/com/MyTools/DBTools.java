package com.MyTools;
import java.sql.*;
import java.util.*;
public class DBTools {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/cy57_oa?characterEncoding=UTF-8";
	private static final String user="root";
	private static final String password="admin";
	static Connection cn=null;
	static Statement s=null;
	private static void getConnection()
	{
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int executeUpdate(String sql)
	{
		getConnection();
		try {
			s=cn.createStatement();
			int result=s.executeUpdate(sql);
			return result;
		} catch (Exception e) {
		
			e.printStackTrace();
			return -1;
		}
		finally
		{
			close(null,s,cn);
		}
	}
	
	public static List executeQuery(String sql)
	{
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		ResultSet rs=null;
		getConnection();
		try {
			s=cn.createStatement();
			rs=s.executeQuery(sql);
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount=rsmd.getColumnCount();
			String columnName[]=new String [columnCount];
			for(int i=0;i<rsmd.getColumnCount();i++)
			{
				columnName[i]=rsmd.getColumnName(i+1);
			}
			
			while(rs.next())
			{
				Map<String,String>map=new TreeMap<String,String>();
				for(int i=0;i<columnCount;i++)
				{
					
					map.put(columnName[i],rs.getString(columnName[i]));

					
				}
				list.add(map);
			}
			
			return list;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		finally
		{
			close(rs,s,cn);
		}
			
	}
	
	private static void close(ResultSet rs,Statement s,Connection cn)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(s!=null)
		{
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(cn!=null)
		{
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
