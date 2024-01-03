package hexlet.code.math.operations;

import java.util.stream.IntStream;

public enum CheckOperationType {
    IS_EVEN {
        @Override
        public boolean check(int number) {
            return number % 2 == 0;
        }
    },
    IS_PRIME {
        @Override
        public boolean check(int number) {
            if (number > 1) {
                return IntStream.range(2, (int) Math.sqrt(number)).noneMatch(divisor -> number % divisor == 0);
            }
            return false;
        }
    };

    public abstract boolean check(int number);
}
