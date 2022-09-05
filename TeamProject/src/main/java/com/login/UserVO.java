package com.login;

public class UserVO {

	private String userID;
	private String userPassword;
	private String userEmail;
	private String userName;
	private String userJumin;
	private String userAlchol;

	public String getuserID() {
		return userID;
	}

	public void setuserID(String userID) {
		this.userID = userID;
	}

	public String getuserPassword() {
		return userPassword;
	}

	public void setuserPassword(String password) {
		userPassword = password;
	}

	public String getuserEmail() {
		return userEmail;
	}

	public void setuserEmail(String userEmil) {
		this.userEmail = userEmil;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getuserJumin() {
		return userJumin;
	}

	public void setuserJumin(String userJumin) {
		this.userJumin = userJumin;
	}

	public String getuserAlchol() {
		return userAlchol;
	}

	public void setuserAlchol(String userAlchol) {
		this.userAlchol = userAlchol;
	}

}