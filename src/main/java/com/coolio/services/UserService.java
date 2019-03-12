package com.coolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coolio.POJO.Company;
import com.coolio.entities.CompanyEntity;
import com.coolio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public CompanyEntity createCompany(Company company) {
		CompanyEntity companyEntity = new CompanyEntity();
		companyEntity.setCompanyCode(company.getCompanyCode());
		companyEntity.setCompanyName(company.getCompanyName());
		companyEntity.setCompanyDomain(company.getCompanyDomain());
		return userRepository.save(companyEntity);
	}

}
