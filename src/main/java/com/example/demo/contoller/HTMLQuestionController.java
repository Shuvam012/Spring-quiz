
package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.HTMLQuestion;
import com.example.demo.Repository.HTMLQuestionRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/html-questions")
public class HTMLQuestionController {
    @Autowired
    private HTMLQuestionRepository htmlQuestionRepository;

    @GetMapping
    public Iterable<HTMLQuestion> getAllQuestions() {
        return htmlQuestionRepository.findAll();
    }

    @PostMapping
    public HTMLQuestion addQuestion(@RequestBody HTMLQuestion question) {
        return htmlQuestionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        htmlQuestionRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public HTMLQuestion editQuestion(@PathVariable Long id, @RequestBody HTMLQuestion updatedQuestion) {
        // Find the question by ID
        HTMLQuestion existingQuestion = htmlQuestionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));

        // Update the question fields with the new data
        existingQuestion.setQuestion(updatedQuestion.getQuestion());
        existingQuestion.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
        existingQuestion.setOptions(updatedQuestion.getOptions());

        // Save the updated question
        return htmlQuestionRepository.save(existingQuestion);
    }
}

