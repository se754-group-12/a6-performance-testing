package com.code67.quizfeedback;

import com.code67.quizfeedback.dto.SubmitAnswerResponse;
import org.springframework.stereotype.Component;

@Component
public class FeedbackService {

    public SubmitAnswerResponse evaluate(Question question, String submittedAnswer) {
        String normalisedSubmission = normalise(submittedAnswer);
        String normalisedCorrect = normalise(question.getCorrectAnswer());

        boolean correct = !normalisedSubmission.isEmpty()
                && normalisedSubmission.equals(normalisedCorrect);

        if (correct) {
            return new SubmitAnswerResponse(
                    true,
                    "Correct. Nice work on " + question.getConcept() + ".",
                    question.getCorrectExplanation()
            );
        }

        return new SubmitAnswerResponse(
                false,
                "Not quite. Here is a hint to help you think it through.",
                question.getIncorrectHint()
        );
    }

    private String normalise(String value) {
        if (value == null) {
            return "";
        }
        return value.trim().toLowerCase();
    }
}
