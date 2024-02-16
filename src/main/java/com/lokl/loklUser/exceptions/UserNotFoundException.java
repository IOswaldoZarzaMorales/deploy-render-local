package com.lokl.loklUser.exceptions;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	 public UserNotFoundException(Long id) {
		super("No podemos encontrar al usuario con id " + id);
	}

	
	
	
	
	
	
	
}//siempre
