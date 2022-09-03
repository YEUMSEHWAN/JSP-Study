package com.login;

public class UserVO {

	private String userID;
	private String userPassword;
	private String userEmail;
	private String userName;
	private String userJumin;
	private String userAlchol;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String password) {
		userPassword = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmil) {
		this.userEmail = userEmil;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserJumin() {
		return userJumin;
	}

	public void setUserJumin(String userJumin) {
		this.userJumin = userJumin;
	}

	public String getUserAlchol() {
		return userAlchol;
	}

	public void setUserAlchol(String userAlchol) {
		this.userAlchol = userAlchol;
	}

}