package com.ocab.model;

public class Security {

	private int userId;
	private String pwdChar;
	private String usrPwd;
	private int pwdId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPwdChar() {
		return pwdChar;
	}
	public void setPwdChar(String pwdChar) {
		this.pwdChar = pwdChar;
	}
	public int getPwdId() {
		return pwdId;
	}
	public void setPwdId(int pwdId) {
		this.pwdId = pwdId;
	}
	public String getUsrPwd() {
		return usrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}
	
}
