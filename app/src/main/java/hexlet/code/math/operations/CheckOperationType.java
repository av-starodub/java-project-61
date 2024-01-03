package hexlet.code.math.operations;

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
            var notEven = number % 2 != 0;
            var notDivisibleByThree = number % 3 != 0;
            var result = number >= 1 && notEven && notDivisibleByThree;
            if (number > 7 && result) {
                for (var divisor = 5; divisor < Math.sqrt(number); divisor += 6) {
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
