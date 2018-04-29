package com.MyServlet;
import java.sql.*;
public class Connection1 {
public static void main(String[] args) {
	Connection cn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	try {
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/oa","root","admin");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	Statement s=null;
	ResultSet rs=null;
	try {
		s=cn.createStatement();
		rs=s.executeQuery("select * from user ");
		while(rs.next())
		{
			String id=rs.getString(1);
			String username=rs.getString(2);
			String account=rs.getString(3);
			String password=rs.getString(4);
			String permission=rs.getString(5);
			String user=rs.getString(6);
			System.out.println(id+" "+username+" "+account+" "+password+" "+permission +" "+user);
			 
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	try {
		rs.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	try {
		s.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	try {
		cn.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	
}
}
