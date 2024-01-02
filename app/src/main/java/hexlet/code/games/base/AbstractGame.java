package hexlet.code.games.base;

import java.util.Scanner;

import static hexlet.code.service.ConsoleGameService.askUser;
import static hexlet.code.service.ConsoleGameService.getUserAnswer;
import static hexlet.code.service.ConsoleGameService.printMessage;

public abstract class AbstractGame implements Game {
    public static final int MAX_VALUE = 100;
    @Override
    public final boolean doTask(Scanner scanner) {
        var question = createQuestion();
        askUser(question);
        var userAnswer = getUserAnswer(scanner);
        var correctAnswer = getCorrectAnswer();
        if (!correctAnswer.equals(userAnswer)) {
            printMessage(
                    String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer)
            );
            return false;
        }
        return true;
    }

    @Override
    public final String getRules() {
        return rules();
    }

    protected abstract String rules();

    protected abstract String createQuestion();

    protected abstract String getCorrectAnswer();
}
