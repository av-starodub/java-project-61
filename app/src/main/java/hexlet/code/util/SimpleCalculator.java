package hexlet.code.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public final class SimpleCalculator {
    private final Map<String, BiFunction<Integer, Integer, Integer>> operations;

    public SimpleCalculator() {
        operations = new HashMap<>();
        operations.put("*", (a, b) -> a * b);
        operations.put("+", Integer::sum);
        operations.put("-", (a, b) -> a - b);
    }

    public int calculate(int firstNumber, int secondNumber, String operator) {
        return operations.get(operator).apply(firstNumber, secondNumber);
    }

    public List<String> getAllOperations() {
        return List.copyOf(operations.keySet());
    }
}
