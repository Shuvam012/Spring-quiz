package com.example.demo;

public class InvalidPasswordException extends RuntimeException{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String message) {
	        super(String.format(" Incorrect "));
	    }
}
