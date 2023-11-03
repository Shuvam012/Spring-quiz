package com.example.demo.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Student;
import com.example.demo.StudentNotFoundException;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student signup(Student student) {
        
        return studentRepository.save(student);
    }

    @Override
    public Student login(String username, String password) {
        // Implement login logic here, including password validation.
        Optional<Student> existingStudent = studentRepository.findByUsername(username);
        
        if (existingStudent.isPresent() && existingStudent.get().getPassword().equals(password)) {
            return existingStudent.get();
        } else {
            throw new StudentNotFoundException ("Invalid user");
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
