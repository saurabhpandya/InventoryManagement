package com.inventorymanagement.security;

public enum ApplicationUserPermission {
	
	USER_READ("user:read"), 
	USER_WRITE("user:write"), 
	POST_READ("post:read"),
	POST_WRITE("post:write");

	private final String permission;

	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
}
