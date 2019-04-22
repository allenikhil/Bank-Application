package org.jsp.app.modelB;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarLoan
{
	
	private String type;
	private String city;
	private String brand;
	private String time;
	private String amount;
	private String years;
	private String status;
	@Id
	private String mobileNumber;
	
	public CarLoan() 
	{
		super();
	}

	public CarLoan(String type, String city, String brand, String time, String amount, String years, String status,
			String mobileNumber)
	{
		super();
		this.type = type;
		this.city = city;
		this.brand = brand;
		this.time = time;
		this.amount = amount;
		this.years = years;
		this.status = status;
		this.mobileNumber = mobileNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "CarLoan [type=" + type + ", city=" + city + ", brand=" + brand + ", time=" + time + ", amount=" + amount
				+ ", years=" + years + ", status=" + status + ", mobileNumber=" + mobileNumber + "]";
	}

}
