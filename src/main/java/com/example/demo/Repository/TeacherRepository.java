package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	Optional<Teacher> findByUsername(String username);
}
