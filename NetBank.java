package org.jsp.app.modelB;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NetBank
{
	@Id
	private String accountNumber;
	private String emailId;
	private String password;
	private String accountHolder;
	private String accountType;
	
	
	
	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountHolder() {
		return accountHolder;
	}


	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	
	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "NetBank [accountNumber=" + accountNumber + ", emailId=" + emailId + ", password=" + password
				+ ", accountHolder=" + accountHolder + ", accountType=" + accountType + "]";
	}

	public NetBank()
	{
		super();
	}

	public NetBank(String accountNumber, String emailId, String password, String accountHolder, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.emailId = emailId;
		this.password = password;
		this.accountHolder = accountHolder;
		this.accountType = accountType;
	}


	
}
