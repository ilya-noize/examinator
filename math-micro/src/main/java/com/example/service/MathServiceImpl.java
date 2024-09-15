package com.example.service;

import com.example.model.Question;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MathServiceImpl implements MathService {
    private final Random random = new Random();


    @Override
    public Question getRandom() {
        int max = 100;
        int a = random.nextInt(max);
        int b = random.nextInt(max);
        String question = String.format("%s + %s = ?", a, b);
        String answer = String.valueOf(a + b);
        return Question.builder()
                .question(question)
                .answer(answer).build();
    }
}
