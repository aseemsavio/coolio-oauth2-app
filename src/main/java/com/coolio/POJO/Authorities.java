package com.coolio.POJO;

/**
 * Authorities POJO class
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

public class Authorities {

	private String username;
	private String authority;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + "]";
	}
}
