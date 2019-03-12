package com.coolio.repository;

import org.springframework.data.repository.Repository;

import com.coolio.POJO.Company;
import com.coolio.entities.CompanyEntity;

public interface UserRepository extends Repository<Company, Integer> {

	CompanyEntity save(CompanyEntity companyEntity);

}
