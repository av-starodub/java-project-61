package hexlet.code.core.games;

import hexlet.code.core.task.Task;
import hexlet.code.core.games.base.AbstractBaseGame;
import hexlet.code.math.BinaryCalculator;

import static hexlet.code.math.Randomizer.getRandomIntInRange;

/**
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public final class Calculator extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

    public static void run(String playerName) {
        run(Calculator::task, GAME_DESCRIPTION, playerName);
    }

    private static Task task() {
        var calc = new BinaryCalculator();
        var compatibleOperations = calc.getAllOperations();
        var firstRandomOperand = getRandomIntInRange(1, MAX_VALUE);
        var secondRandomOperand = getRandomIntInRange(1, MAX_VALUE);
        var randomOperatorIndex = getRandomIntInRange(0, compatibleOperations.size() - 1);
        var randomOperator = compatibleOperations.get(randomOperatorIndex);
        var question = String.format("%d %s %d", firstRandomOperand, randomOperator, secondRandomOperand);
        var answer = calc.calculate(firstRandomOperand, secondRandomOperand, randomOperator);
        return new Task(question, String.valueOf(answer));
    }
}
