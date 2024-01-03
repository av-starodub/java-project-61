package hexlet.code.math.calculator;

import hexlet.code.math.operations.BinaryOperationType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public final class BinaryCalculator {
    private final Map<String, BiFunction<Integer, Integer, Integer>> operations;

    public BinaryCalculator() {
        operations = new HashMap<>();
        Arrays.stream(BinaryOperationType.values())
                .forEach(type -> operations.put(type.getSign(), type.getOperation()));
    }

    public int calculate(int firstNumber, int secondNumber, String operator) {
        return operations.get(operator).apply(firstNumber, secondNumber);
    }

    public List<String> getAllOperations() {
        return List.copyOf(operations.keySet());
    }
}
