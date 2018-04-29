package com.mvc.Tools;
/** 
 * @package:        com.mvc.Tools
 * @Description:    用户Bean 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017年10月28日 下午6:34:50 
 */
public class User {
	Integer user_id;

	String account=null;
	String password=null;
	String user_name=null;
	String user_age=null;
	String user_status=null;
	String user_sex=null;
	//Getter &&Setter
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_age() {
		return user_age;
	}
	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", account=" + account + ", password=" + password + ", user_name="
				+ user_name + ", user_age=" + user_age + ", user_status=" + user_status + ", user_sex=" + user_sex
				+ "]";
	}
	
	

}
