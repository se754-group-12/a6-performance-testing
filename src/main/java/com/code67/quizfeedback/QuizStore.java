package com.code67.quizfeedback;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuizStore {

    private final Map<String, Question> questions = new HashMap<>();

    @PostConstruct
    void seed() {
        // TODO: teammate seeds 10+ questions here
    }

    public Question findById(String id) {
        // TODO: teammate replaces with lookup from `questions` once seed() is implemented
        return new Question(
                id,
                "Placeholder question text",
                "placeholder",
                "placeholder-concept",
                "Placeholder correct explanation",
                "Placeholder incorrect hint"
        );
    }
}
