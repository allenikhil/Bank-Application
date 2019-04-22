package org.jsp.app.modelB;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GoldLoan 
{
	private String amount;
	private String time;
	private String city;
	@Id
	private String mobileNumber;
	
	public GoldLoan() 
	{
		super();
	}
	
	public GoldLoan(String amount, String time, String city, String mobileNumber) {
		super();
		this.amount = amount;
		this.time = time;
		this.city = city;
		this.mobileNumber = mobileNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "GoldLoan [amount=" + amount + ", time=" + time + ", city=" + city + ", mobileNumber=" + mobileNumber
				+ "]";
	}
	
}
