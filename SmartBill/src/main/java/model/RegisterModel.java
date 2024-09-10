package model;

public class RegisterModel {
	
	private long consumerId;
	private String title;
	private String name;
	private String email;
	private long mobile;
	private String gender;
	private String userName;
	private String password;
	
	public RegisterModel(long consumerId, String title, String name, String email, long mobile, String gender,
			String userName, String password) {
		
		this.consumerId = consumerId;
		this.title = title;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
	}
	
	public long getConsumerId() {
		return consumerId;
	}
	
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
