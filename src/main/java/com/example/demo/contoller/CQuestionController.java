package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.CQuestion;
import com.example.demo.Repository.CQuestionRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/c-questions")
public class CQuestionController {
    @Autowired
    private CQuestionRepository cQuestionRepository;

    @GetMapping
    public Iterable<CQuestion> getAllQuestions() {
        return cQuestionRepository.findAll();
    }

    @PostMapping
    public CQuestion addQuestion(@RequestBody CQuestion question) {
        return cQuestionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        cQuestionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public CQuestion editQuestion(@PathVariable Long id, @RequestBody CQuestion updatedQuestion) {
        // Find the question by ID
        CQuestion existingQuestion = cQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

        // Update the question fields with the new data
        existingQuestion.setQuestion(updatedQuestion.getQuestion());
        existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        existingQuestion.setOptions(updatedQuestion.getOptions());

        // Save the updated question
        return cQuestionRepository.save(existingQuestion);
    }
}
