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
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public class Calculator {
    public void play(Scanner scanner) {
        int correctAnswers = 0;

        String userName = getUserName(scanner);
        sayHello(userName);
        print("What is the result of the expression?.\n");

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
        String[] operators = {"+", "-", "*"};

        var first = getIntInRange(1, 100);
        var second = getIntInRange(1, 100);
        var randomIdx = getIntInRange(0, operators.length - 1);
        var operator = operators[randomIdx];
        var expression = String.format("%d %s %d", first, operator, second);

        askUser(expression);
        var userAnswer = getUserAnswer(scanner);
        var expected = calculate(first, second, operator);

        if (!isCorrect(expected, userAnswer)) {
            print(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, expected));
            return false;
        }
        return true;
    }

    private int calculate(int first, int second, String operator) {
        switch (operator) {
            case "+" -> {
                return first + second;
            }
            case "-" -> {
                return first - second;
            }
            case "*" -> {
                return first * second;
            }
            default -> throw new IllegalStateException();
        }
    }

    private boolean isCorrect(int expected, String userAnswer) {
        try {
            return expected == Integer.parseInt(userAnswer);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
