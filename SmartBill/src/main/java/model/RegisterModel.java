package model;

public class RegisterModel {
	
	private long consumerNumber;
	private String meterNumber;
	private String title;
	private String name;
	private String email;
	private long mobile;
	private String gender;
	private String userName;
	private String password;
	
	public RegisterModel(long consumerNumber, String meterNumber, String title, String name, String email, long mobile, String gender,
			String userName, String password) {
		
		this.consumerNumber = consumerNumber;
		this.meterNumber = meterNumber;
		this.title = title;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
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

	public long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}
}
