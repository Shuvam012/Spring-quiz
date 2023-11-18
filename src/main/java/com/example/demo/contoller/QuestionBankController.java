package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Repository.QuestionRepository;
import com.example.demo.Entity.QuestionBank;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/questions_bank")
public class QuestionBankController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping
    public Iterable<QuestionBank> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/subject/{subject}")
    public List<QuestionBank> getQuestionsBySubject(@PathVariable String subject) {
        return questionRepository.findBySubject(subject);
    }

    @PostMapping
    public QuestionBank addQuestion(@RequestBody QuestionBank question) {
        return questionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public QuestionBank editQuestion(@PathVariable Long id, @RequestBody QuestionBank updatedQuestion) {
        // Find the question by ID
        QuestionBank existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

        // Update the question fields with the new data
        existingQuestion.setQuestion(updatedQuestion.getQuestion());
        existingQuestion.setAnswer(updatedQuestion.getAnswer());
        existingQuestion.setSubject(updatedQuestion.getSubject());

        // Save the updated question
        return questionRepository.save(existingQuestion);
    }
}
