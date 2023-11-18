package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.SpringQuestion;
import com.example.demo.Repository.SpringQuestionRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/spring-questions")
public class SpringQuestionController {
    @Autowired
    private SpringQuestionRepository springQuestionRepository;

    @GetMapping
    public Iterable<SpringQuestion> getAllQuestions() {
        return springQuestionRepository.findAll();
    }

    @PostMapping
    public SpringQuestion addQuestion(@RequestBody SpringQuestion question) {
        return springQuestionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        springQuestionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public SpringQuestion editQuestion(@PathVariable Long id, @RequestBody SpringQuestion updatedQuestion) {
        // Find the question by ID
        SpringQuestion existingQuestion = springQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

        // Update the question fields with the new data
        existingQuestion.setQuestion(updatedQuestion.getQuestion());
        existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        existingQuestion.setOptions(updatedQuestion.getOptions());

        // Save the updated question
        return springQuestionRepository.save(existingQuestion);
    }
}