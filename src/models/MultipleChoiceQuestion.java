package models;

import java.util.List;

public class MultipleChoiceQuestion extends Questions {
    private List<String> options;
    private String correctAnswer;

    public MultipleChoiceQuestion(String questionText, List<String> options, String correctAnswer, int points) {
        super(questionText, points);
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }

    @Override
    public void displayQuestion() {
        System.out.println(getQuestionText());
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}
