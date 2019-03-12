package com.coolio.repository;

import org.springframework.data.repository.Repository;

import com.coolio.POJO.Company;

public interface UserRepository extends Repository<Company, Integer> {

	Company save(Company company);

}
