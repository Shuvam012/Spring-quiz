package com.example.demo.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentSController {
	  @Autowired
	    private StudentRepository studentRepository;

	    @PostMapping("/signup")
	    public ResponseEntity<String> signup(@RequestBody Student student) {
	        
	        if (studentRepository.findByUsername(student.getUsername()).isPresent()) {
	            return ResponseEntity.badRequest().body("Username already exists");
	        }

	        studentRepository.save(student);
	        return ResponseEntity.ok("Signup successful");
	    }
	    
	    
	    
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody Student student) {
	        Optional<Student> existingStudent = studentRepository.findByUsername(student.getUsername());
	        
	        if (existingStudent.isPresent() && existingStudent.get().getPassword().equals(student.getPassword())) {
	            
	            return ResponseEntity.ok("Login successful");
	        } else {
	            return ResponseEntity.badRequest().body("Invalid credentials");
	        }
	    }

}
