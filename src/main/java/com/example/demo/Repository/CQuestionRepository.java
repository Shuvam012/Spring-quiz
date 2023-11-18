package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CQuestion;

public interface CQuestionRepository extends JpaRepository<CQuestion, Long> {

    List<CQuestion> findAll();

    @SuppressWarnings("unchecked")
    CQuestion save(CQuestion question);
}