package model;

public class ComplaintModel {
	private int complaintId;
	private long consumerNumber;
	private String landmark;
	private String serviceType;
	private String category;
	private long mobile;
	private String contactPerson;
	private String prolem;
	private String address;
	
	public ComplaintModel(int complaintId, long consumerNumber, String landmark, String serviceType, String category,
			long mobile, String contactPerson, String prolem, String address) {
		super();
		this.complaintId = complaintId;
		this.consumerNumber = consumerNumber;
		this.landmark = landmark;
		this.serviceType = serviceType;
		this.category = category;
		this.mobile = mobile;
		this.contactPerson = contactPerson;
		this.prolem = prolem;
		this.address = address;
	}
	
	public int getComplaintId() {
		return complaintId;
	}
	
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	
	public long getConsumerNumber() {
		return consumerNumber;
	}
	
	public void setConsumerNumber(long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	
	public String getLandmark() {
		return landmark;
	}
	
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public long getMobile() {
		return mobile;
	}
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getProlem() {
		return prolem;
	}
	
	public void setProlem(String prolem) {
		this.prolem = prolem;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
