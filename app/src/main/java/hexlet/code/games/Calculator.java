package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.util.ConsoleService.askUser;
import static hexlet.code.util.ConsoleService.getUserAnswer;
import static hexlet.code.util.ConsoleService.print;
import static hexlet.code.util.GameService.getRandomIntInRange;

/**
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public class Calculator extends AbstractGame {
    @Override
    public boolean doTask(Scanner scanner) {
        String[] operators = {"+", "-", "*"};

        var firstOperand = getRandomIntInRange(1, 100);
        var secondOperand = getRandomIntInRange(1, 100);
        var randomOperator = operators[getRandomIntInRange(0, operators.length - 1)];
        var expression = String.format("%d %s %d", firstOperand, randomOperator, secondOperand);

        askUser(expression);
        var userAnswer = getUserAnswer(scanner);
        var correctAnswer = calculate(firstOperand, secondOperand, randomOperator);

        if (!isCorrect(correctAnswer, userAnswer)) {
            print(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer));
            return false;
        }
        return true;
    }

    @Override
    public String getRules() {
        return "What is the result of the expression?.";
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
