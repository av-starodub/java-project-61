package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.util.ConsoleService.askUser;
import static hexlet.code.util.ConsoleService.getUserAnswer;
import static hexlet.code.util.ConsoleService.print;

public abstract class AbstractGame implements Game {
    @Override
    public final boolean doTask(Scanner scanner) {
        var question = createQuestion();
        askUser(question);
        var userAnswer = getUserAnswer(scanner);
        var correctAnswer = getCorrectAnswer();
        if (!correctAnswer.equals(userAnswer)) {
            print(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer));
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
