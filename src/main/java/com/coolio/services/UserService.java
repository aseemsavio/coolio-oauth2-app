package com.coolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coolio.entities.AuthoritiesEntity;
import com.coolio.entities.UsersEntity;
import com.coolio.repository.AuthoritiesRepository;
import com.coolio.repository.UserRepository;
import com.coolio.templates.UserCreationRequest;
import com.coolio.templates.UserCreationResponse;
import com.coolio.utils.UsersUtills;

/**
 * Service class, containing validations for the User Entity.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthoritiesRepository authoritiesRepository;

	public ResponseEntity<UserCreationResponse> createUser(UserCreationRequest userCreationRequest) {
		UsersUtills usersUtills = new UsersUtills();
		if (usersUtills.everyThingInPlace(userCreationRequest)) {
			UsersEntity usersEntity = new UsersEntity();
			usersEntity.setUserName(userCreationRequest.getUserName());

			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			String pass = bCryptPasswordEncoder.encode(userCreationRequest.getPassword());
			usersEntity.setPassword(pass);

			usersEntity.setEnabled(userCreationRequest.getEnabled());
			usersEntity.setFirstName(userCreationRequest.getFirstName());
			usersEntity.setLastName(userCreationRequest.getLastName());
			usersEntity.setCity(userCreationRequest.getCity());
			usersEntity.setStatePlace(userCreationRequest.getStatePlace());
			usersEntity.setZip(userCreationRequest.getZip());
			usersEntity.setCompanyCode(userCreationRequest.getCompanyCode());
			usersEntity.setDateOfBirth(userCreationRequest.getDateOfBirth());
			usersEntity.setMobile(userCreationRequest.getMobile());

			UsersEntity entity = new UsersEntity();
			entity = userRepository.save(usersEntity);

			AuthoritiesEntity authoritiesEntity = new AuthoritiesEntity();
			authoritiesEntity.setUsername(userCreationRequest.getUserName());
			authoritiesEntity.setAuthority(userCreationRequest.getAuthority());
			authoritiesRepository.save(authoritiesEntity);

			UserCreationResponse userCreationResponse = new UserCreationResponse();
			userCreationResponse.setUsername(entity.getUserName());
			userCreationResponse.setFirstName(entity.getFirstName());
			userCreationResponse.setLastName(entity.getLastName());
			return ResponseEntity.ok().header("status", "success").body(userCreationResponse);
		} else {
			UserCreationResponse nullUserCreationResponse = new UserCreationResponse();
			return ResponseEntity.badRequest().header("status", "Empty field(s) cannot be accepted.")
					.body(nullUserCreationResponse);
		}
	}
}
