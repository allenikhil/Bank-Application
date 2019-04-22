package org.jsp.app.modelB;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HomeLoan
{
	@Id
	private String mobileNumber;
	private String type;
	private String amount;
	private String name;
	private String city;
	private String inCome;
	
	public HomeLoan() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public HomeLoan(String mobileNumber, String type, String amount, String name, String city, String inCome)
	{
		super();
		this.mobileNumber = mobileNumber;
		this.type = type;
		this.amount = amount;
		this.name = name;
		this.city = city;
		this.inCome = inCome;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInCome() {
		return inCome;
	}
	public void setInCome(String inCome) {
		this.inCome = inCome;
	}

	@Override
	public String toString()
	{
		return "HomeLoan [mobileNumber=" + mobileNumber + ", type=" + type + ", amount=" + amount + ", name=" + name
				+ ", city=" + city + ", inCome=" + inCome + "]";
	}
}
