package com.coolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coolio.POJO.Company;
import com.coolio.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createCompany")
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {
		return userService.createCompany(company);
	}

}
