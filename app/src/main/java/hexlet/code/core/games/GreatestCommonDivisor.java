package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractBaseGame;
import hexlet.code.core.task.Task;

/**
 * Game "Greatest common divisor".
 * The user is shown two random numbers, for example 25 50.
 * The user must calculate and enter the greatest common divisor of these numbers.
 */
public final class GreatestCommonDivisor extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run(String playerName) {
        AbstractBaseGame.run(GreatestCommonDivisor::task, GAME_DESCRIPTION, playerName);
    }

    private static Task task() {
        var firstRandomNumber = getRandomIntInDefaultRange();
        var secondRandomNumber = getRandomIntInDefaultRange();
        var question = String.format("%d %d", firstRandomNumber, secondRandomNumber);
        var answer = findGCD(firstRandomNumber, secondRandomNumber);
        return Task.of(question, String.valueOf(answer));
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
