package hexlet.code.core.games;

import hexlet.code.core.task.Task;
import hexlet.code.core.games.base.AbstractBaseGame;

import java.util.function.BiFunction;

/**
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public final class Calculator extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

    public static void run(String playerName) {
        AbstractBaseGame.run(Calculator::task, GAME_DESCRIPTION, playerName);
    }

    private static Task task() {
        var supportedOperations = BinaryOperationType.values();
        var firstRandomOperand = getRandomIntInDefaultRange();
        var secondRandomOperand = getRandomIntInDefaultRange();
        var randomOperationIndex = getRandomIntInRange(0, supportedOperations.length - 1);
        var operation = supportedOperations[randomOperationIndex];
        var operationSign = operation.getSign();
        var question = String.format("%d %s %d", firstRandomOperand, operationSign, secondRandomOperand);
        var answer = operation.calculate(firstRandomOperand, secondRandomOperand);
        return Task.of(question, String.valueOf(answer));
    }

    /**
     * Supported math binary operations.
     */
    private enum BinaryOperationType {
        ADDITION("+") {
            @Override
            BiFunction<Integer, Integer, Integer> getOperation() {
                return Integer::sum;
            }
        },
        SUBTRACTION("-") {
            @Override
            BiFunction<Integer, Integer, Integer> getOperation() {
                return (a, b) -> a - b;
            }
        },
        TIMES("*") {
            @Override
            BiFunction<Integer, Integer, Integer> getOperation() {
                return (a, b) -> a * b;
            }
        };

        private final String operationSign;

        BinaryOperationType(String sign) {
            operationSign = sign;
        }

        private String getSign() {
            return operationSign;
        }

        private int calculate(int firstOperand, int secondOperand) {
            return getOperation().apply(firstOperand, secondOperand);
        }

        abstract BiFunction<Integer, Integer, Integer> getOperation();
    }
}
