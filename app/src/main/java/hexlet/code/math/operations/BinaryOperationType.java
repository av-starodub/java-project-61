package hexlet.code.math.operations;

import java.util.function.BiFunction;

public enum BinaryOperationType {
    ADDITION("+") {
        @Override
        public BiFunction<Integer, Integer, Integer> getOperation() {
            return Integer::sum;
        }
    },
    SUBTRACTION("-") {
        @Override
        public BiFunction<Integer, Integer, Integer> getOperation() {
            return (a, b) -> a - b;
        }
    },
    TIMES("*") {
        @Override
        public BiFunction<Integer, Integer, Integer> getOperation() {
            return (a, b) -> a * b;
        }
    };

    private final String operationSign;

    BinaryOperationType(String sign) {
        operationSign = sign;
    }

    public String getSign() {
        return operationSign;
    }

    public abstract BiFunction<Integer, Integer, Integer> getOperation();
}
