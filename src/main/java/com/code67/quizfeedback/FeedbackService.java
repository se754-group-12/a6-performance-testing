package com.code67.quizfeedback;

import com.code67.quizfeedback.dto.SubmitAnswerResponse;
import org.springframework.stereotype.Component;

@Component
public class FeedbackService {

    public SubmitAnswerResponse evaluate(Question question, String submittedAnswer) {
        // TODO: teammate implements feedback logic
        return new SubmitAnswerResponse(false, "Placeholder feedback", "Placeholder explanation");
    }
}
