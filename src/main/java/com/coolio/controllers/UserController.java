package com.coolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coolio.services.UserService;
import com.coolio.templates.FindUserRequest;
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

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/protected/showMyProfile")
	public ResponseEntity<List<SearchUserResponse>> showProfileOnLogOn(Authentication authentication) {
		return userService.showProfileOnLogOn(authentication);
	}

	@PostMapping("/protectedAdmin/createUser")
	public ResponseEntity<UserCreationResponse> createUser(@RequestBody UserCreationRequest userCreationRequest) {
		return userService.createUser(userCreationRequest);
	}
	
	@PostMapping("/protected/findByUserName")
	public ResponseEntity<List<SearchUserResponse>> searchUser(@RequestBody FindUserRequest findUserRequest, Authentication authentication){
		return userService.searchUserByUserName(findUserRequest, authentication);
	}

}
