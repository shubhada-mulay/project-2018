package com.ocab.model;

public class UserInfo {
	private int userExtID;
	private int usrId;
	private short userAge;
	private String userGender;
	private String userPinCode;
	private String userAddress;
	private String userCity;
	
	public int getUserExtID() {
		return userExtID;
	}
	public void setUserExtID(int userExtID) {
		this.userExtID = userExtID;
	}
	public int getUsrId() {
		return usrId;
	}
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}
	public short getUserAge() {
		return userAge;
	}
	public void setUserAge(short userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPinCode() {
		return userPinCode;
	}
	public void setUserPinCode(String userPinCode) {
		this.userPinCode = userPinCode;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
}
