package com.example.demo;

public class TeacherNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherNotFoundException(String message) {
        super(String.format(" not found "));
    }
}
