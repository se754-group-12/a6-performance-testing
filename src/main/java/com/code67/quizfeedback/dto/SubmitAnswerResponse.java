package com.code67.quizfeedback.dto;

public class SubmitAnswerResponse {

    private final boolean correct;
    private final String feedback;
    private final String explanation;

    public SubmitAnswerResponse(boolean correct, String feedback, String explanation) {
        this.correct = correct;
        this.feedback = feedback;
        this.explanation = explanation;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getExplanation() {
        return explanation;
    }
}
