package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.SpringQuestion;

public interface SpringQuestionRepository extends JpaRepository<SpringQuestion, Long> {

    List<SpringQuestion> findAll();

    @SuppressWarnings("unchecked")
    SpringQuestion save(SpringQuestion question);
}