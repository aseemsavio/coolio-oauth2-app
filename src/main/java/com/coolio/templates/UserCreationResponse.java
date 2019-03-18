package com.coolio.templates;

/**
 * Response Template for User Creation.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

public class UserCreationResponse {

	private String username;
	private String firstName;
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserCreationResponse [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
}
