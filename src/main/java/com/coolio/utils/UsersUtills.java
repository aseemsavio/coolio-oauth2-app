package com.coolio.utils;

import com.coolio.templates.UserCreationRequest;

/**
 * Utilss for Users Entity
 * 
 * @author Aseem Savio
 * @since v1.0
 *
 */

public class UsersUtills {

	public boolean isNull(String string) {
		if (string != null && !string.isEmpty())
			return false;
		return true;
	}

	public boolean everyThingInPlace(UserCreationRequest userCreationRequest) {
		if (isNull(userCreationRequest.getUserName()) || isNull(userCreationRequest.getPassword())
				|| isNull(userCreationRequest.getFirstName()) || isNull(userCreationRequest.getAuthority())
				|| isNull(userCreationRequest.getMobile()) || isNull(userCreationRequest.getAuthority())) {
			return false;
		}
		return true;
	}
}
