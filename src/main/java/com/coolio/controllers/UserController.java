package com.coolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coolio.POJO.Company;
import com.coolio.entities.CompanyEntity;
import com.coolio.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createCompany")
	public String createCompany(@RequestBody Company company) {
		CompanyEntity createdCompanyEntity = userService.createCompany(company);
		Company createdCompany = new Company();
		createdCompany.setCompanyCode(createdCompanyEntity.getCompanyCode());
		createdCompany.setCompanyName(createdCompanyEntity.getCompanyName());
		createdCompany.setCompanyDomain(createdCompanyEntity.getCompanyDomain());
		return createdCompany.toString();
	}

}
