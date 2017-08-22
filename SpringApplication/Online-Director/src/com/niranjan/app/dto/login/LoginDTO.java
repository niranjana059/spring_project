package com.niranjan.app.dto.login;

import java.io.Serializable;

public class LoginDTO implements Serializable{
	private String userName;
	private String password;

	public LoginDTO(){
		System.out.println(this.getClass().getSimpleName()+" created..");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + "]";
	}

}
