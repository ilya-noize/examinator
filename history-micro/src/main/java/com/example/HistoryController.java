package com.example;

import com.example.model.Question;
import com.example.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HistoryController {
    private final QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getQuestion(@RequestParam int amount) {
        List<Question> questions = questionRepository.findAll();
        Collections.shuffle(questions);
        return questions.stream().limit(amount).toList();
    }
}
