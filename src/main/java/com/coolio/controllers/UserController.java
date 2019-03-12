package com.coolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolio.POJO.Company;
import com.coolio.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("createCompany")
	public String createCompany(Company company) {
		Company createdCompany = userService.createCompany(company);
		return createdCompany.toString();
	}

}
