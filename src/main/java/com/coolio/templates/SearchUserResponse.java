package com.coolio.templates;

import java.util.Date;

/**
 * Response template for all search requests.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

public class SearchUserResponse {

	private String userName;
	private String firstName;
	private String lastName;
	private String city;
	private String statePlace;
	private String zip;
	private Integer companyCode;
	private Date dateOfBirth;
	private String mobile;
	private String authority;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatePlace() {
		return statePlace;
	}

	public void setStatePlace(String statePlace) {
		this.statePlace = statePlace;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "FearchUserResponse [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", city=" + city + ", statePlace=" + statePlace + ", zip=" + zip + ", companyCode=" + companyCode
				+ ", dateOfBirth=" + dateOfBirth + ", mobile=" + mobile + ", authority=" + authority + "]";
	}
}
