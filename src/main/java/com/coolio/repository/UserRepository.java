package com.coolio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coolio.POJO.Users;
import com.coolio.entities.UsersEntity;

/**
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

public interface UserRepository extends CrudRepository<UsersEntity, String> {

	UsersEntity findByUserName(String userName);

	List<UsersEntity> findByFirstName(String firstName);

}
