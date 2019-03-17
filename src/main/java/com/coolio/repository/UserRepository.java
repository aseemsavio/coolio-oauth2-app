package com.coolio.repository;

import org.springframework.data.repository.CrudRepository;

import com.coolio.entities.UsersEntity;

/**
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

public interface UserRepository extends CrudRepository<UsersEntity, String> {

}
