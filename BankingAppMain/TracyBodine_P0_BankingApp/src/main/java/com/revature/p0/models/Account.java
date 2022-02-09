package com.revature.p0.models;

public class Account {
	private String accountId;
	private String accountName;
	private String accountType;
	private String accountBalance;
	private Customer originator;
	
	
	// Boilerplate 
	public Account() {
		super();
	}

	public Account(String accountId, String accountName, String accountType, String accountBalance, Customer originator) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.originator = originator;
	}

	public Account(String accountName, String accountType, String accountBalance, Customer originator) {
		super();
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.originator = originator;
	}

	public Account(String accountName, String accountType, String accountBalance) {
		super();
		this.accountName = accountName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getOriginator() {
		return originator;
	}

	public void setOriginator(Customer originator) {
		this.originator = originator;
	}
	
}
