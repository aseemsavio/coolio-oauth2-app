package com.coolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coolio.POJO.Company;
import com.coolio.services.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping("/all/createCompany")
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {
		return companyService.createCompany(company);
	}

}
