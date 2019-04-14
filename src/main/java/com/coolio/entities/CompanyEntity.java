package com.coolio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * This class is a Company Entity for Java Persistence.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

@Entity
@DynamicUpdate
@Table(name = "company")
public class CompanyEntity {

	@Id
	@Column(name = "company_code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer companyCode;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_domain")
	private String companyDomain;

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

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

	@Override
	public String toString() {
		return "CompanyEntity [companyCode=" + companyCode + ", companyName=" + companyName + ", companyDomain="
				+ companyDomain + "]";
	}

}
