package com.shiva.exceptions;

public class UserAlreadyPresentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3990725932614945112L;

	 String message;

	public UserAlreadyPresentException(String message) {
		super();
		this.message = message;
	}

}
