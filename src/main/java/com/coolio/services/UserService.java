package com.coolio.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coolio.constants.CoolioConstants;
import com.coolio.entities.AuthoritiesEntity;
import com.coolio.entities.UsersEntity;
import com.coolio.repository.AuthoritiesRepository;
import com.coolio.repository.UserRepository;
import com.coolio.templates.FindUserRequest;
import com.coolio.templates.SearchUserResponse;
import com.coolio.templates.UserCreationRequest;
import com.coolio.templates.UserCreationResponse;
import com.coolio.templates.UserNamePassword;
import com.coolio.utils.UsersUtills;

import reactor.core.publisher.Mono;

/**
 * Service class, containing validations for the User Entity.
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

@Service
public class UserService {

	private Integer responseID = 0;
	
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
			usersEntity.setDisplayPictureURL(userCreationRequest.getDisplayPictureURL());

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

	public ResponseEntity<List<SearchUserResponse>> showProfileOnLogOn(Authentication authentication) {
		FindUserRequest findUserRequest = new FindUserRequest(authentication.getName());
		ResponseEntity<List<SearchUserResponse>> responseEntity = searchUserByUserName(findUserRequest, authentication);
		return responseEntity;
	}

	public Integer sameOrganizationCheck(Authentication authentication) {
		String userName = authentication.getName();
		UsersEntity userEntity = new UsersEntity();
		userEntity = userRepository.findByUserName(userName);
		Integer companyCode = userEntity.getCompanyCode();
		return companyCode;
	}

	/**
	 * 
	 * @param usersEntity
	 * @param authoritiesEntity
	 * @param responseID - should be initialized to 0 while calling the method.
	 * @return
	 */
	public SearchUserResponse findUser(UsersEntity usersEntity, AuthoritiesEntity authoritiesEntity, Integer responseID) {
		responseID++;
		SearchUserResponse searchUserResponse = new SearchUserResponse();
		searchUserResponse.setResponseID(responseID);
		searchUserResponse.setUserName(usersEntity.getUserName());
		searchUserResponse.setFirstName(usersEntity.getFirstName());
		searchUserResponse.setLastName(usersEntity.getLastName());
		searchUserResponse.setCity(usersEntity.getCity());
		searchUserResponse.setStatePlace(usersEntity.getStatePlace());
		searchUserResponse.setZip(usersEntity.getZip());
		searchUserResponse.setCompanyCode(usersEntity.getCompanyCode());
		searchUserResponse.setDateOfBirth(usersEntity.getDateOfBirth());
		searchUserResponse.setMobile(usersEntity.getMobile());
		searchUserResponse.setDisplayPictureURL(usersEntity.getDisplayPictureURL());
		searchUserResponse.setAuthority(authoritiesEntity.getAuthority());
		return searchUserResponse;
	}

	public ResponseEntity<List<SearchUserResponse>> searchUserByUserName(FindUserRequest findUserRequest,
			Authentication authentication) {
		List<SearchUserResponse> searchUserResponsesList = new ArrayList<SearchUserResponse>();
		String searchString = findUserRequest.getSearchCode();

		UsersEntity usersEntity = null;
		usersEntity = userRepository.findByUserName(searchString);
		AuthoritiesEntity authoritiesEntity = null;
		authoritiesEntity = authoritiesRepository.findByUsername(searchString);

		if (usersEntity == null || authoritiesEntity == null) {
			List<SearchUserResponse> nullSearchUserResponseList = null;
			return ResponseEntity.ok()
					.header("status", "The person is from a different organization. Could Not process Request")
					.body(nullSearchUserResponseList);
		} else {
			SearchUserResponse searchUserResponse = findUser(usersEntity, authoritiesEntity, 0);
			Integer companyCodeOfUser = sameOrganizationCheck(authentication);
			if (companyCodeOfUser != usersEntity.getCompanyCode()) {
				// do nothing
			} else {
				searchUserResponsesList.add(findUser(usersEntity, authoritiesEntity, 0));
				return ResponseEntity.ok().header("status", "success").body(searchUserResponsesList);
			}
		}
		return null;
	}

	public String isUserFound(UserNamePassword usernamePassword) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		UsersEntity entity = userRepository.findByUserNameAndPassword(usernamePassword.getUserName(), bCryptPasswordEncoder.encode(usernamePassword.getPassword()));
		if(entity != null) {
			System.out.println("ENTITY " + entity.getUserName() + " " + entity.getPassword() + " REQUEST "  + usernamePassword.getUserName() + " " + usernamePassword.getPassword());
			return CoolioConstants.BOOLEAN_YES;
		}
		return CoolioConstants.BOOLEAN_NO;
	}


}
