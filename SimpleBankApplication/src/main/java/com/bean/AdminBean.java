package com.bean;

public class AdminBean {

	private String username;
	private Long bankAccNo;
	private String transactionId;
	private Double amount;
	private String email;
	private String password;

	public AdminBean() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(Long bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminBean [username=" + username + ", bankAccNo=" + bankAccNo + ", transactionId=" + transactionId
				+ ", email=" + email + ", password=" + password + "]";
	}

}
