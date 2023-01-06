package hexlet.code.games;

import hexlet.code.util.SimpleCalculator;

import java.util.List;

import static hexlet.code.util.MathOperationService.getRandomIntInRange;

/**
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public class Calculator extends AbstractGame {
    private int firstRandomOperand;
    private int secondRandomOperand;
    private String randomOperator;
    private final SimpleCalculator calc;
    private final List<String> compatibleOperations;

    public Calculator() {
        calc = new SimpleCalculator();
        compatibleOperations = calc.getAllOperations();
    }

    @Override
    public String getRules() {
        return "What is the result of the expression?.";
    }

    @Override
    protected String createQuestion() {
        firstRandomOperand = getRandomIntInRange(1, 100);
        secondRandomOperand = getRandomIntInRange(1, 100);
        randomOperator = compatibleOperations.get(getRandomIntInRange(0, compatibleOperations.size() - 1));
        return String.format("%d %s %d", firstRandomOperand, randomOperator, secondRandomOperand);
    }

    @Override
    protected String getCorrectAnswer() {
        return String.valueOf(calc.calculate(firstRandomOperand, secondRandomOperand, randomOperator));
    }
}
