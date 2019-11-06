package com.zitro.zbackend.exceptions;

import com.zitro.zcommon.exceptions.NotFoundException;

public class DeletedUserException extends NotFoundException {

	private static final long serialVersionUID = 1L;
	
	public DeletedUserException(String message) {
		super(message);
	}
	
}
