package com.shiva.exceptions;

public class UserNotFoundException extends Exception{

	 /**
	 * Exception for User already present
	 */
	private static final long serialVersionUID = 1678608689120373812L;
		
		private String message;

		public UserNotFoundException(String message) {
			super();
			this.message = message;
		}	
}
