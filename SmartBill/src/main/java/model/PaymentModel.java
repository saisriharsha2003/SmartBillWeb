package model;

public class PaymentModel {
	private int transactionNumber;
	private int billNumber;
	private double paidAmount;
	private String transactionMode;
	private String transactionDate;
	private long consumerId;
	
	public int getTransactionNumber() {
		return transactionNumber;
	}
	
	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	public int getBillNumber() {
		return billNumber;
	}
	
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	
	public double getPaidAmount() {
		return paidAmount;
	}
	
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	public String getTransactionMode() {
		return transactionMode;
	}
	
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public long getConsumerId() {
		return consumerId;
	}
	
	public PaymentModel(int transactionNumber, int billNumber, double paidAmount, String transactionMode,
			String transactionDate, long consumerId) {
		super();
		this.transactionNumber = transactionNumber;
		this.billNumber = billNumber;
		this.paidAmount = paidAmount;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.consumerId = consumerId;
	}
	
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	
	
}
