package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Entity.QuestionBank;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionBank, Long> {
    List<QuestionBank> findBySubject(String subject);

    @SuppressWarnings("unchecked")
    QuestionBank save(QuestionBank question);
}
