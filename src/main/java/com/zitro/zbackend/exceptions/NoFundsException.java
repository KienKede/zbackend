package com.zitro.zbackend.exceptions;

import com.zitro.zcommon.exceptions.NotFoundException;

public class NoFundsException extends NotFoundException {

	private static final long serialVersionUID = 1L;
	
	public NoFundsException(String message) {
		super(message);
	}
	
}
