package com.longnguyen.model;

public class AccountModel {
	private int id;
	private String fullName;
	private String endDate;
	private String email;
	private String password;
	private String addRess;
	private String phone;
	
	
	
	
	public AccountModel(int id, String fullName, String endDate, String email, String password, String addRess,
			String phone) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.endDate = endDate;
		this.email = email;
		this.password = password;
		this.addRess = addRess;
		this.phone = phone;
	}
	public AccountModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddRess() {
		return addRess;
	}
	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}
	
	
}
