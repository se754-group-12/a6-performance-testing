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

        if (normalisedSubmission.isEmpty()) {
            return incorrect(question);
        }

        if (normalisedSubmission.equals(normalisedCorrect)) {
            return correctExact(question);
        }

        if (FuzzyMatcher.isClose(normalisedSubmission, normalisedCorrect)) {
            return correctFuzzy(question);
        }

        Question matchedQuestion = quizStore.findByCorrectAnswer(normalisedSubmission);
        if (matchedQuestion != null
                && !matchedQuestion.getId().equals(question.getId())
                && !matchedQuestion.getConcept().equalsIgnoreCase(question.getConcept())) {
            String feedback = "That sounds like " + matchedQuestion.getConcept()
                    + ", but this question is about " + question.getConcept() + ".";
            return new SubmitAnswerResponse(false, feedback, question.getIncorrectHint());
        }

        return incorrect(question);
    }

    private SubmitAnswerResponse correctExact(Question question) {
        return new SubmitAnswerResponse(
                true,
                "Correct. Nice work on " + question.getConcept() + ".",
                question.getCorrectExplanation()
        );
    }

    private SubmitAnswerResponse correctFuzzy(Question question) {
        return new SubmitAnswerResponse(
                true,
                "Correct, with a small typo. The expected spelling is '"
                        + question.getCorrectAnswer()
                        + "'. Nice work on " + question.getConcept() + ".",
                question.getCorrectExplanation()
        );
    }

    private SubmitAnswerResponse incorrect(Question question) {
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
