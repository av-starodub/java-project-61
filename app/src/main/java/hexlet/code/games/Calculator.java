package hexlet.code.games;

import hexlet.code.games.base.AbstractBaseGame;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public final class Calculator extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";
    private static final char[] OPERATIONS = {'+', '-', '*'};

    public static void run() {
        AbstractBaseGame.run(Calculator::task, GAME_DESCRIPTION);
    }

    private static Map.Entry<String, String> task() {
        var firstRandomOperand = getRandomIntInDefaultRange();
        var secondRandomOperand = getRandomIntInDefaultRange();
        var randomOperationIndex = getRandomIntInRange(0, OPERATIONS.length - 1);
        var operation = OPERATIONS[randomOperationIndex];
        var question = String.format("%d %s %d", firstRandomOperand, operation, secondRandomOperand);
        var answer = calculate(operation, firstRandomOperand, secondRandomOperand);
        return new AbstractMap.SimpleEntry<>(question, String.valueOf(answer));
    }

    private static int calculate(char operator, int firstOperand, int secondOperand) {
        switch (operator) {
            case '+' -> {
                return firstOperand + secondOperand;
            }
            case '-' -> {
                return firstOperand - secondOperand;
            }
            case '*' -> {
                return firstOperand * secondOperand;
            }
            default -> throw new UnsupportedOperationException("Unknown operator: " + operator);
        }
    }
}
