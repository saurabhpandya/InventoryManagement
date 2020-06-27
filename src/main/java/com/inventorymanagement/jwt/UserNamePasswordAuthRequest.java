package com.inventorymanagement.jwt;

public class UserNamePasswordAuthRequest {

	private String username;
	private String password;

	public UserNamePasswordAuthRequest() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
