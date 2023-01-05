package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.util.ConsoleService.askUser;
import static hexlet.code.util.ConsoleService.getUserAnswer;
import static hexlet.code.util.ConsoleService.getUserName;
import static hexlet.code.util.ConsoleService.print;
import static hexlet.code.util.ConsoleService.sayHello;
import static hexlet.code.util.ConsoleService.sayToUser;
import static hexlet.code.util.GameService.getIntInRange;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is even, or no if it is odd.
 */
public class Even {
    public Even() {
    }

    public void play(Scanner scanner) {
        int correctAnswers = 0;

        String userName = getUserName(scanner);
        sayHello(userName);
        print("Answer 'yes' if the number is even, otherwise answer 'no'.\n");

        while (correctAnswers < 3) {
            if (!doTask(scanner)) {
                sayToUser("Let's try again", userName);
                return;
            }
            print("Correct!\n");
            correctAnswers++;
        }
        sayToUser("Congratulations", userName);
    }

    private boolean doTask(Scanner scanner) {
        var number = getIntInRange(0, 1000);
        askUser(String.valueOf(number));
        var userAnswer = getUserAnswer(scanner);
        var expected = isEven(number) ? "yes" : "no";

        if (!expected.equals(userAnswer)) {
            print(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, expected));
            return false;
        }
        return true;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
