package hexlet.code.math;

public class Prime {
    private static final int MIN_DIVISOR = 3;
    private static final int START_PRIME = 5;
    private static final int STEP = 6;

    public static boolean isPrime(int number) {
        var result = number >= 1;
        var sqrt = Math.sqrt(number);
        if (number % 2 == 0 || number % MIN_DIVISOR == 0 || sqrt % 1 == 0) {
            result = false;
        }
        if (number > START_PRIME) {
            for (var divisor = START_PRIME; divisor < sqrt; divisor += STEP) {
                if (number % divisor == 0 || number % (divisor + 2) == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
