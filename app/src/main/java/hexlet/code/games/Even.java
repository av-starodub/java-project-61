package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.util.ConsoleService.askUser;
import static hexlet.code.util.ConsoleService.getUserAnswer;
import static hexlet.code.util.ConsoleService.print;
import static hexlet.code.util.GameService.getRandomIntInRange;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is even, or no if it is odd.
 */
public class Even extends AbstractGame {
    public Even() {
    }

    @Override
    public boolean doTask(Scanner scanner) {
        var number = getRandomIntInRange(0, 1000);
        askUser(String.valueOf(number));
        var userAnswer = getUserAnswer(scanner);
        var correctAnswer = isEven(number) ? "yes" : "no";

        if (!correctAnswer.equals(userAnswer)) {
            print(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer));
            return false;
        }
        return true;
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
