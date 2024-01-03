package hexlet.code.math;

public final class MathOperationService {
    private MathOperationService() {
    }

    public static int findGCD(int firstNumber, int secondNumber) {
        if (secondNumber == 0 && firstNumber == 0) {
            throw new IllegalArgumentException("Both arguments are zero. ");
        }
        if (secondNumber == 0) {
            return Math.abs(firstNumber);
        }
        int reminder = firstNumber % secondNumber;
        return reminder == 0 ? secondNumber : findGCD(secondNumber, reminder);
    }
}
