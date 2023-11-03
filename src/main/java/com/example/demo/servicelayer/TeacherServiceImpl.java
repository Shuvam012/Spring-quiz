package com.example.demo.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.InvalidPasswordException;
import com.example.demo.Teacher;
import com.example.demo.TeacherAlreadyExistsException;
import com.example.demo.TeacherNotFoundException;
import com.example.demo.Repository.TeacherRepository;

@Service
public abstract class TeacherServiceImpl implements TeacherService {
	 @Autowired
	    private TeacherRepository teacherRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    public Teacher login(String username, String password) {
	        // Implement login logic here, including password validation.
	        Teacher existingTeacher = teacherRepository.findByUsername(username)
	                .orElseThrow(() -> new TeacherNotFoundException("Teacher not found"));

	        // Check the provided password against the hashed password in the database
	        if (passwordEncoder.matches(password, existingTeacher.getPassword())) {
	            return existingTeacher;
	        } else {
	            throw new InvalidPasswordException("Invalid password");
	        }
	    }
	}
    
}