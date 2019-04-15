package com.coolio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

@Entity
@Table(name="authorities")
public class AuthoritiesEntity {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "authority")
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
		return "AuthoritiesEntity [username=" + username + ", authority=" + authority + "]";
	}
	
}
