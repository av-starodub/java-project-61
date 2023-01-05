package hexlet.code.games;

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
    String[] operators = {"+", "-", "*"};

    @Override
    public String getRules() {
        return "What is the result of the expression?.";
    }

    @Override
    protected String createQuestion() {
        firstRandomOperand = getRandomIntInRange(1, 100);
        secondRandomOperand = getRandomIntInRange(1, 100);
        randomOperator = operators[getRandomIntInRange(0, operators.length - 1)];
        return String.format("%d %s %d", firstRandomOperand, randomOperator, secondRandomOperand);
    }

    @Override
    protected String getCorrectAnswer() {
        return String.valueOf(calculate(firstRandomOperand, secondRandomOperand, randomOperator));
    }


    private int calculate(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+" -> {
                return firstNumber + secondNumber;
            }
            case "-" -> {
                return firstNumber - secondNumber;
            }
            case "*" -> {
                return firstNumber * secondNumber;
            }
            default -> throw new IllegalStateException();
        }
    }
}
