package com.coolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coolio.POJO.Company;
import com.coolio.entities.CompanyEntity;
import com.coolio.repository.UserRepository;

/**
 * Service Class containing validation of the request body before being sent to
 * the Repository interface.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<Company> createCompany(Company company) {

		if (company.getCompanyDomain().equals(null) || company.getCompanyName().equals(null)) {
			Company nullCompany = new Company();
			return ResponseEntity.badRequest().header("status", "Empty Field(s) cannot be accepted.").body(nullCompany);
		} else {

			CompanyEntity companyEntity = new CompanyEntity();
			companyEntity.setCompanyName(company.getCompanyName());
			companyEntity.setCompanyDomain(company.getCompanyDomain());

			CompanyEntity isFound = new CompanyEntity();
			isFound = userRepository.findByCompanyDomain(companyEntity.getCompanyDomain());

			if (isFound != null) {
				Company nullCompany = new Company();
				return ResponseEntity.badRequest().header("status", "Duplicate Company cannot be created.")
						.body(nullCompany);
			} else {
				CompanyEntity createdCompanyEntity = userRepository.save(companyEntity);
				Company createdCompany = new Company();
				createdCompany.setCompanyCode(createdCompanyEntity.getCompanyCode());
				createdCompany.setCompanyName(createdCompanyEntity.getCompanyName());
				createdCompany.setCompanyDomain(createdCompanyEntity.getCompanyDomain());
				return ResponseEntity.ok().header("status", "success").body(createdCompany);
			}
		}

	}

}
