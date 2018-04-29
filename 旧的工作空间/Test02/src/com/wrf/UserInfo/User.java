package com.wrf.UserInfo;

import java.util.Date;

public class User {
	private String name;
	private String age;
	private String acccont;
	private String password;
	private Date date;
	
	public User(String name,String age)
	{
		this.name=name;
		this.age=age;
		
	}
	
	public User(String name,String age,Date date ){
		this.name=name;
		this.age=age;
		this.date=date;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", acccont=" + acccont + ", password=" + password + ", date="
				+ date + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAcccont() {
		return acccont;
	}
	public void setAcccont(String acccont) {
		this.acccont = acccont;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
