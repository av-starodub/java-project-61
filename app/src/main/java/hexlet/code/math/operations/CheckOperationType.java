package hexlet.code.math.operations;

public enum CheckOperationType {
    IS_EVEN {
        @Override
        public boolean check(int number) {
            return number % 2 == 0;
        }
    },
    IS_PRIME {
        private static final int MIN_DIVISOR = 3;
        private static final int START_PRIME = 5;
        private static final int STEP = 6;

        @Override
        public boolean check(int number) {
            var notEven = IS_EVEN.check(number);
            var notDivisibleByThree = number % MIN_DIVISOR != 0;
            var result = number >= 1 && notEven && notDivisibleByThree;
            if (number > START_PRIME && result) {
                for (var divisor = START_PRIME; divisor < Math.sqrt(number); divisor += STEP) {
                    if (number % divisor == 0 || number % (divisor + 2) == 0) {
                        result = false;
                        break;
                    }
                }
            }
            return result;
        }
    };

    public abstract boolean check(int number);
}
