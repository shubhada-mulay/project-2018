package com.ocab.model;


import java.util.Date;

public class User {

	private int userId;
	private String userName;
	private String userFname;
	private String userLname;
	private String userMailId;
	private String userMobileNo;
	private Date userCreationDT;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public Date getUserCreationDT() {
		return userCreationDT;
	}

	public void setUserCreationDT(Date userCreationDT) {
		this.userCreationDT = userCreationDT;
	}

	public User(int userId, String userName, String userFname, String userLname, String userMailId,
			String userMobileNo, Date userCreationDT) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userMailId = userMailId;
		this.userMobileNo = userMobileNo;
		this.userCreationDT = userCreationDT;
	}

	public User() {}

}
