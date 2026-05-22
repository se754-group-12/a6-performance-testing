package com.code67.quizfeedback;

public class Question {

    private final String id;
    private final String text;
    private final String correctAnswer;
    private final String concept;
    private final String correctExplanation;
    private final String incorrectHint;

    public Question(String id,
                    String text,
                    String correctAnswer,
                    String concept,
                    String correctExplanation,
                    String incorrectHint) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.concept = concept;
        this.correctExplanation = correctExplanation;
        this.incorrectHint = incorrectHint;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getConcept() {
        return concept;
    }

    public String getCorrectExplanation() {
        return correctExplanation;
    }

    public String getIncorrectHint() {
        return incorrectHint;
    }
}
