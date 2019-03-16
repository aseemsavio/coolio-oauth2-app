package com.coolio.repository;

import org.springframework.data.repository.CrudRepository;

import com.coolio.entities.CompanyEntity;

public interface UserRepository extends CrudRepository<CompanyEntity, Integer> {

	CompanyEntity findByCompanyDomain(String companyDomain);

}
