package com.code67.quizfeedback;

import com.code67.quizfeedback.dto.SubmitAnswerRequest;
import com.code67.quizfeedback.dto.SubmitAnswerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizStore quizStore;
    private final FeedbackService feedbackService;

    public QuizController(QuizStore quizStore, FeedbackService feedbackService) {
        this.quizStore = quizStore;
        this.feedbackService = feedbackService;
    }

    @PostMapping("/{quizId}/submit")
    public ResponseEntity<SubmitAnswerResponse> submit(
            @PathVariable String quizId,
            @RequestBody(required = false) SubmitAnswerRequest request) {

        if (request == null || request.getAnswer() == null || request.getAnswer().isBlank()) {
            throw new ResponseStatusException(BAD_REQUEST, "answer must be present and non-blank");
        }

        Question question = quizStore.findById(quizId);
        if (question == null) {
            throw new ResponseStatusException(NOT_FOUND, "quiz not found: " + quizId);
        }

        SubmitAnswerResponse response = feedbackService.evaluate(question, request.getAnswer());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }
}
