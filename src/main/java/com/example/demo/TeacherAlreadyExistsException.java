package com.example.demo;

public class TeacherAlreadyExistsException extends RuntimeException {
	  public TeacherAlreadyExistsException(String message) {
	        super(String.format(" not found "));
	    }
}
