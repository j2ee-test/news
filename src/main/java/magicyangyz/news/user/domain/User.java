package magicyangyz.news.user.domain;

import java.sql.Timestamp;

public class User {
	private Integer userId;
	private String name;
	private String type;
	private String password;
	private String registerDate;
	private String enable;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public User(Integer userId, String name, String type, String password, String time, String enable) {
		super();
		this.userId = userId;
		this.name = name;
		this.type = type;
		this.password = password;
		this.registerDate = time;
		this.enable = enable;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", type=" + type + ", password=" + password
				+ ", registerDate=" + registerDate + ", enable=" + enable + "]";
	}
	
}
