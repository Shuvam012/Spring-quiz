package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.HTMLQuestion;

public interface HTMLQuestionRepository extends JpaRepository<HTMLQuestion, Long> {

    List<HTMLQuestion> findAll();

    @SuppressWarnings("unchecked")
    HTMLQuestion save(HTMLQuestion question);
}