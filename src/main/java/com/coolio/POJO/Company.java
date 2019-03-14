package com.coolio.POJO;

/**
 * POJO that helps traverse a Company entity in and around the application.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */
public class Company {

	Integer companyCode;
	String companyName;
	String companyDomain;

	public Company() {

	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}//

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDomain() {
		return companyDomain;
	}

	public void setCompanyDomain(String companyDomain) {
		this.companyDomain = companyDomain;
	}

	public Company(Integer companyCode, String companyName, String companyDomain) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyDomain = companyDomain;
	}

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + ", companyDomain="
				+ companyDomain + "]";
	}
}
