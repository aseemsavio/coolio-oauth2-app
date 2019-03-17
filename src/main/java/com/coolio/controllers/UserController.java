package com.coolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coolio.POJO.UserCreationRequest;
import com.coolio.POJO.UserCreationResponse;
import com.coolio.POJO.Users;
import com.coolio.entities.AuthoritiesEntity;
import com.coolio.entities.UsersEntity;
import com.coolio.repository.AuthoritiesRepository;
import com.coolio.repository.UserRepository;
import com.coolio.services.UserService;

/**
 * Contains REST end points for the User Entity operations.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/protectedAdmin/createUser")
	public ResponseEntity<UserCreationResponse> createUser(@RequestBody UserCreationRequest userCreationRequest) {
		return userService.createUser(userCreationRequest);
	}

}
