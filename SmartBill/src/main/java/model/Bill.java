package model;

import java.util.*;
import java.time.*;

public class Bill {
	private int billNuber;
	private double dueAmount;
	private double payableAmount;
	private String dueDate;
	private String status;
	private long consumerId;
	
	public int getBillNuber() {
		return billNuber;
	}
	
	public void setBillNuber(int billNuber) {
		this.billNuber = billNuber;
	}
	
	public double getDueAmount() {
		return dueAmount;
	}
	
	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}
	
	public double getPayableAmount() {
		return payableAmount;
	}
	
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getConsumerId() {
		return consumerId;
	}
	
	public void setConsumerId(long consumerId) {
		this.consumerId = consumerId;
	}
	
	public Bill(int billNuber, double dueAmount, double payableAmount, String dueDate, String status,
			long consumerId) {

		this.billNuber = billNuber;
		this.dueAmount = dueAmount;
		this.payableAmount = payableAmount;
		this.dueDate = dueDate;
		this.status = status;
		this.consumerId = consumerId;
	}
	
}
