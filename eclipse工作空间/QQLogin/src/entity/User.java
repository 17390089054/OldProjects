package entity;

import java.io.Serializable;

/** 
 * @package:        entity
 * @Description:  TODO(用户实体类) 
 * @author        knight
 * @Date          2018年2月7日 下午7:02:18 
 */
public class User implements Serializable{
	private int id;
	private String phone;
	private String gender;
	private String applyId;
	private String applyKey;
	private String openId;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getApplyId() {
		return this.applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getApplyKey() {
		return this.applyKey;
	}
	public void setApplyKey(String applyKey) {
		this.applyKey = applyKey;
	}
	public String getOpenId() {
		return this.openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	@Override
	public String toString() {
		return "User [id=" + this.id + ", phone=" + this.phone + ", gender=" + this.gender + ", applyId=" + this.applyId
				+ ", applyKey=" + this.applyKey + ", openId=" + this.openId + "]";
	}
	
	
	
	

}
