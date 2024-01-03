package hexlet.code.core.games.base;

import hexlet.code.core.task.Task;

import java.util.Scanner;

import static hexlet.code.service.ConsoleGameService.askUser;
import static hexlet.code.service.ConsoleGameService.getUserAnswer;
import static hexlet.code.service.ConsoleGameService.printMessage;

public abstract class AbstractGame implements Game {
    public static final int MAX_VALUE = 100;
    private final Task task;

    protected AbstractGame(Task task) {
        this.task = task;
    }

    @Override
    public final boolean runTask(Scanner scanner) {
        var question = task.getQuestion();
        askUser(question);
        var userAnswer = getUserAnswer(scanner);
        var correctAnswer = task.getAnswer();
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
}
