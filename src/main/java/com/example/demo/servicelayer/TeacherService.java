package com.example.demo.servicelayer;

import com.example.demo.InvalidPasswordException;
import com.example.demo.Teacher;
import com.example.demo.TeacherNotFoundException;



public interface TeacherService {
	 Teacher login(String username, String password) throws TeacherNotFoundException, InvalidPasswordException;
}
