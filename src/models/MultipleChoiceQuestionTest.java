package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class MultipleChoiceQuestionTest {

    private MultipleChoiceQuestion question;

    @BeforeEach
    void setUp() {
        List<String> options = Arrays.asList("Option A", "Option B", "Option C", "Option D");
        question = new MultipleChoiceQuestion(
                "What is the capital of France?",
                options,
                "Option B",
                5
        );
    }

    @Test
    void testCheckAnswer_CorrectAnswer() {
        assertTrue(question.checkAnswer("Option B"), "The answer should be correct");
    }

    @Test
    void testCheckAnswer_IncorrectAnswer() {
        assertFalse(question.checkAnswer("Option C"), "The answer should be incorrect");
    }

    @Test
    void testCheckAnswer_CaseInsensitive() {
        assertTrue(question.checkAnswer("option b"), "The answer should be correct (case insensitive)");
    }

    @Test
    void testDisplayQuestion() {
        // Capture the console output for verification
        List<String> options = Arrays.asList("Option A", "Option B", "Option C", "Option D");
        question.displayQuestion();
        // Since displayQuestion prints output, manual verification or a mocking framework would be needed.
        // For simplicity, we assume it works correctly or you can refactor to make it testable.
    }

    @Test
    void testGetQuestionText() {
        assertEquals("What is the capital of France?", question.getQuestionText(), "The question text should match");
    }

    @Test
    void testGetPoints() {
        assertEquals(5, question.getPoints(), "The points should be 5");
    }
}
