package model;

public class LoginModel {
	
	private long consumerId;
	private String userName;
	private String password;
	
	public LoginModel(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public long getConsumerId() {
		return consumerId;
	}
	
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
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
