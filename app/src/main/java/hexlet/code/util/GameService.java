package hexlet.code.util;

public final class GameService {
    private GameService() {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int findGCD(int firstNumber, int secondNumber) {
        if (secondNumber == 0 && firstNumber == 0) {
            throw new IllegalArgumentException("Both arguments are zero. ");
        }
        if (secondNumber == 0 || firstNumber == 0) {
            return Math.abs(firstNumber + secondNumber);
        }
        int reminder = firstNumber % secondNumber;
        return reminder == 0 ? secondNumber : findGCD(secondNumber, reminder);
    }
}
