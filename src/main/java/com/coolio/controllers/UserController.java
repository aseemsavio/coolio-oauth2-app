package com.coolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coolio.services.UserService;
import com.coolio.templates.SearchUserResponse;
import com.coolio.templates.UserCreationRequest;
import com.coolio.templates.UserCreationResponse;

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
	
	@GetMapping("/protected/findByUserName/{user_name}")
	public ResponseEntity<SearchUserResponse> findByUserName(@PathVariable("user_name") String userName, Authentication authentication){
		return userService.findByUserName(userName, authentication);
	}

}
