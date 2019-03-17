package com.coolio.POJO;

import java.util.Date;

/**
 * The POJO class to be used for transporting the User object accross the
 * application.
 * 
 * @author Aseem Savio
 * @since v1.1
 * 
 */
public class Users {

	private String userName;
	private String password;
	private Boolean enabled;
	private String firstName;
	private String lastName;
	private String city;
	private String statePlace;
	private String zip;
	private Integer companyCode;
	private Date dateOfBirth;
	private String mobile;

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + ", enabled=" + enabled + ", firstName="
				+ firstName + ", lastName=" + lastName + ", city=" + city + ", statePlace=" + statePlace + ", zip="
				+ zip + ", companyCode=" + companyCode + ", dateOfBirth=" + dateOfBirth + ", mobile=" + mobile + "]";
	}

	public Users() {

	}

	public Users(String userName, String password, Boolean enabled, String firstName, String lastName, String city,
			String statePlace, String zip, Integer companyCode, Date dateOfBirth, String mobile) {
		super();
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.statePlace = statePlace;
		this.zip = zip;
		this.companyCode = companyCode;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
	}
}
