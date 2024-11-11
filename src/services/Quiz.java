package services;

import models.Questions;
import models.MultipleChoiceQuestion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Questions> questions;
    private int totalScore;

    public Quiz() {
        questions = new ArrayList<>();
        totalScore = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new MultipleChoiceQuestion(
                "What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"),
                "Paris",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "Which planet is known as the Red Planet?",
                List.of("Earth", "Mars", "Jupiter", "Venus"),
                "Mars",
                10
        ));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Questions question : questions) {
            question.displayQuestion();
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (question.checkAnswer(answer)) {
                System.out.println("Correct!");
                totalScore += question.getPoints();
            } else {
                System.out.println("Wrong answer.");
            }
        }
        System.out.println("\nYour total score is: " + totalScore);
        scanner.close();
    }
}

