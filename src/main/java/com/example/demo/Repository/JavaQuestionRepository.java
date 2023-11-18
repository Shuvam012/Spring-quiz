package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.JavaQuestion;

public interface JavaQuestionRepository  extends JpaRepository<JavaQuestion, Long>{

	List<JavaQuestion> findAll();

	@SuppressWarnings("unchecked")
	JavaQuestion save(JavaQuestion question);

}