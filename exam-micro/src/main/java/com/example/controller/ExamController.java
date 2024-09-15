package com.example.controller;

import com.example.model.Exam;
import com.example.model.Question;
import com.example.model.Section;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * import org.springframework.cloud.client.discovery.DiscoveryClient; <br/>
 * Debug with DiscoveryClient
 */
@RestController
@RequiredArgsConstructor
public class ExamController {
    private final RestTemplate restTemplate;

    @PostMapping("/exam")
    public Exam getExam(@RequestBody Map<String, Integer> spec) {
        List<Section> sections = spec.entrySet().stream()
                .map(this::getUrl)
                .map(url -> restTemplate.getForObject(url, Question[].class))
                .map(Arrays::asList)
                .map(Section::new)
                .toList();

        return Exam.builder().title("MATH").sections(sections).build();
    }

    private String getUrl(Map.Entry<String, Integer> entry) {
        return String.format("http://%s/api/questions?amount=%s", entry.getKey(), entry.getValue());
    }
}
