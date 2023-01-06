package hexlet.code.util;

import java.math.BigInteger;

public final class MathOperationService {
    private MathOperationService() {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
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

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int[] getRandomArithmeticProgression(int length) {
        int[] progression = new int[length];
        int step = getRandomIntInRange(1, 9);
        int next = getRandomIntInRange(1, 100);
        for (var idx = 0; idx < length; idx++) {
            progression[idx] = next;
            next += step;
        }
        return progression;
    }

    public static boolean isPrime(int number) {
        return BigInteger.valueOf(number).isProbablePrime((int) Math.log(number));
    }
}
