package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.util.Cli.greet;
import static hexlet.code.util.ConsoleService.askUser;
import static hexlet.code.util.ConsoleService.getUserAnswer;
import static hexlet.code.util.ConsoleService.getUserName;
import static hexlet.code.util.ConsoleService.print;
import static hexlet.code.util.ConsoleService.sayToUser;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is even, or no if it is odd.
 */
public class Even {
    public Even() {
    }

    public void play(Scanner scanner) {
        int numberOfCorrect = 0;

        print(greet());
        var userName = getUserName(scanner);
        print(sayToUser("Hello", userName));
        print("Answer 'yes' if the number is even, otherwise answer 'no'.\n");

        while (numberOfCorrect < 3) {
            if (!doTask(scanner)) {
                print(sayToUser("Let's try again", userName));
                return;
            }
            print("Correct!\n");
            numberOfCorrect++;
        }
        print(sayToUser("Congratulations", userName));
    }

    private boolean doTask(Scanner scanner) {
        var number = (int) (Math.random() * 1000) + 1;
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
