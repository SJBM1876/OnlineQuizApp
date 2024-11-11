package models;

public abstract class Questions {
    private String questionText;
    private int points;

    public Questions(String questionText, int points) {
        this.questionText = questionText;
        this.points = points;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getPoints() {
        return points;
    }

    public abstract boolean checkAnswer(String answer);

    public abstract void displayQuestion();
}
