package com.zitro.zbackend.exceptions;

import com.zitro.zcommon.exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
