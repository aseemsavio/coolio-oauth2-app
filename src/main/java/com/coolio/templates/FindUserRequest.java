package com.coolio.templates;

/**
 * 
 * @author Aseem Savio
 *
 */
public class FindUserRequest {

	private String searchCode;

	public String getSearchCode() {
		return searchCode;
	}

	public FindUserRequest() {
		super();
	}

	public FindUserRequest(String searchCode) {
		super();
		this.searchCode = searchCode;
	}

}
