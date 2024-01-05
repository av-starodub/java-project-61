package hexlet.code.games;

import hexlet.code.games.base.AbstractGame;
import hexlet.code.math.calculator.BinaryCalculator;
import hexlet.code.task.Task;

import static hexlet.code.math.random.Randomizer.getRandomIntInRange;

/**
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public final class Calculator extends AbstractGame {

    public static void run() {
        run(Calculator::task, "What is the result of the expression?.");
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
