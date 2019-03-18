package com.coolio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coolio.entities.AuthoritiesEntity;
import com.coolio.entities.UsersEntity;
import com.coolio.repository.AuthoritiesRepository;
import com.coolio.repository.UserRepository;
import com.coolio.templates.SearchUserResponse;
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

	public ResponseEntity<SearchUserResponse> findByUserName(String userName, Authentication authentication) {
		UsersEntity usersEntity = null;
		usersEntity = userRepository.findByUserName(userName);
		AuthoritiesEntity authoritiesEntity = null;
		authoritiesEntity = authoritiesRepository.findByUsername(userName);

		if (usersEntity == null || authoritiesEntity == null) {
			SearchUserResponse nullSearchUserResponse = new SearchUserResponse();
			return ResponseEntity.ok().header("status", "Could not find record").body(nullSearchUserResponse);
		} else {
			SearchUserResponse searchUserResponse = new SearchUserResponse();
			searchUserResponse.setUserName(usersEntity.getUserName());
			searchUserResponse.setFirstName(usersEntity.getFirstName());
			searchUserResponse.setLastName(usersEntity.getLastName());
			searchUserResponse.setCity(usersEntity.getCity());
			searchUserResponse.setStatePlace(usersEntity.getStatePlace());
			searchUserResponse.setZip(usersEntity.getZip());
			searchUserResponse.setCompanyCode(usersEntity.getCompanyCode());
			searchUserResponse.setDateOfBirth(usersEntity.getDateOfBirth());
			searchUserResponse.setMobile(usersEntity.getMobile());
			searchUserResponse.setAuthority(authoritiesEntity.getAuthority());

			Integer companyCodeOfUser = sameOrganizationCheck(authentication);
			if (companyCodeOfUser != usersEntity.getCompanyCode()) {
				SearchUserResponse nullSearchUserResponse = new SearchUserResponse();
				return ResponseEntity.ok()
						.header("status", "The person is from a different organization. Could Not process Request")
						.body(nullSearchUserResponse);
			} else {
				return ResponseEntity.ok().header("status", "success").body(searchUserResponse);
			}
		}
	}

	public Integer sameOrganizationCheck(Authentication authentication) {
		String userName = authentication.getName();
		UsersEntity userEntity = new UsersEntity();
		userEntity = userRepository.findByUserName(userName);
		Integer companyCode = userEntity.getCompanyCode();
		System.out.println("Company Code: " + companyCode);
		return companyCode;
	}

}
