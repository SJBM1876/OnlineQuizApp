package services;

import models.Questions;
import models.MultipleChoiceQuestion;
import java.util.ArrayList;
import java.util.Collections; // Import for shuffling
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Questions> questions;
    private int totalScore;

    public Quiz() {
        questions = new ArrayList<>();
        totalScore = 0;
        loadQuestions(); // Load all 10 questions
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

        questions.add(new MultipleChoiceQuestion(
                "Which element has the chemical symbol 'O'?",
                List.of("Gold", "Oxygen", "Osmium", "Oganesson"),
                "Oxygen",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "What is the largest mammal in the world?",
                List.of("Elephant", "Blue Whale", "Giraffe", "Great White Shark"),
                "Blue Whale",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "Who wrote 'Romeo and Juliet'?",
                List.of("William Shakespeare", "Charles Dickens", "Leo Tolstoy", "Mark Twain"),
                "William Shakespeare",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "What is the square root of 64?",
                List.of("6", "7", "8", "9"),
                "8",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "Which country is known as the Land of the Rising Sun?",
                List.of("China", "Japan", "Thailand", "South Korea"),
                "Japan",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "In which year did the Titanic sink?",
                List.of("1912", "1920", "1905", "1930"),
                "1912",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "How many continents are there?",
                List.of("5", "6", "7", "8"),
                "7",
                10
        ));

        questions.add(new MultipleChoiceQuestion(
                "Which planet has the most moons?",
                List.of("Earth", "Saturn", "Jupiter", "Neptune"),
                "Saturn",
                10
        ));
    }

    public void start() {
        // Step 2: Shuffle the list of questions
        Collections.shuffle(questions);

        // Step 3: Select 5 random questions from the shuffled list
        List<Questions> selectedQuestions = questions.subList(0, Math.min(5, questions.size()));

        Scanner scanner = new Scanner(System.in);

        // Step 4: Iterate over the selected questions
        for (Questions question : selectedQuestions) {
            question.displayQuestion();
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            // Step 5: Check the answer and update the score
            if (question.checkAnswer(answer)) {
                System.out.println("Correct!");
                totalScore += question.getPoints();
            } else {
                System.out.println("Wrong answer.");
            }
        }

        // Step 6: Display the total score
        System.out.println("\nYour total score is: " + totalScore);
        scanner.close();
    }
}


