package hexlet.code.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static hexlet.code.util.GameService.getRandomIntInRange;

/**
 * Game "Calculator".
 * The user is shown a random mathematical expression, such as 35 + 16,
 * which must be calculated and the correct answer written down.
 */
public class Calculator extends AbstractGame {
    private int firstRandomOperand;
    private int secondRandomOperand;
    private String randomOperator;
    private final Map<String, BiFunction<Integer, Integer, Integer>> mathOperations;
    private final List<String> compatibleOperators;

    public Calculator() {
        mathOperations = new HashMap<>();
        mathOperations.put("*", (a, b) -> a * b);
        mathOperations.put("+", Integer::sum);
        mathOperations.put("-", (a, b) -> a - b);
        compatibleOperators = new ArrayList<>();
        compatibleOperators.addAll(mathOperations.keySet());
    }

    @Override
    public String getRules() {
        return "What is the result of the expression?.";
    }

    @Override
    protected String createQuestion() {
        firstRandomOperand = getRandomIntInRange(1, 100);
        secondRandomOperand = getRandomIntInRange(1, 100);
        randomOperator = compatibleOperators.get(getRandomIntInRange(0, compatibleOperators.size() - 1));
        return String.format("%d %s %d", firstRandomOperand, randomOperator, secondRandomOperand);
    }

    @Override
    protected String getCorrectAnswer() {
        return String.valueOf(calculate(firstRandomOperand, secondRandomOperand, randomOperator));
    }


    private int calculate(int firstNumber, int secondNumber, String operator) {
        return mathOperations.get(operator).apply(firstNumber, secondNumber);
    }
}
