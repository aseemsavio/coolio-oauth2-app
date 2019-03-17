package com.coolio.repository;

import org.springframework.data.repository.CrudRepository;

import com.coolio.entities.AuthoritiesEntity;

/**
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

public interface AuthoritiesRepository extends CrudRepository<AuthoritiesEntity, String> {

}
