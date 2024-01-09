package hexlet.code.games;

import hexlet.code.games.base.AbstractBaseGame;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Game "Greatest common divisor".
 * The user is shown two random numbers, for example 25 50.
 * The user must calculate and enter the greatest common divisor of these numbers.
 */
public final class GreatestCommonDivisor extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        AbstractBaseGame.run(GreatestCommonDivisor::task, GAME_DESCRIPTION);
    }

    private static Map.Entry<String, String> task() {
        var firstRandomNumber = getRandomIntInDefaultRange();
        var secondRandomNumber = getRandomIntInDefaultRange();
        var question = String.format("%d %d", firstRandomNumber, secondRandomNumber);
        var answer = findGCD(firstRandomNumber, secondRandomNumber);
        return new AbstractMap.SimpleEntry<>(question, String.valueOf(answer));
    }

    private static int findGCD(int firstNumber, int secondNumber) {
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
