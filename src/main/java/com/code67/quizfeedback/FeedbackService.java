package com.code67.quizfeedback;

import com.code67.quizfeedback.dto.SubmitAnswerResponse;
import org.springframework.stereotype.Component;

@Component
public class FeedbackService {

    private final QuizStore quizStore;

    public FeedbackService(QuizStore quizStore) {
        this.quizStore = quizStore;
    }

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

        Question matchedQuestion = quizStore.findByCorrectAnswer(normalisedSubmission);
        if (matchedQuestion != null
                && !matchedQuestion.getId().equals(question.getId())
                && !matchedQuestion.getConcept().equalsIgnoreCase(question.getConcept())) {
            String feedback = "That sounds like " + matchedQuestion.getConcept()
                    + ", but this question is about " + question.getConcept() + ".";
            return new SubmitAnswerResponse(false, feedback, question.getIncorrectHint());
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
