package com.example.demo.servicelayer;

import java.util.List;

import com.example.demo.Student;

public interface StudentService {
	 Student signup(Student student);
	    Student login(String username, String password);
	    List<Student> getAllStudents();

}
