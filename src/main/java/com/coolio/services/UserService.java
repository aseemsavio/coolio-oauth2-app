package com.coolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coolio.POJO.Company;
import com.coolio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Company createCompany(Company company) {
		return userRepository.save(company);
	}

}
