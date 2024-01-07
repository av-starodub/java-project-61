package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractBaseGame;
import hexlet.code.core.task.Task;

import static hexlet.code.math.GCD.findGCD;
import static hexlet.code.math.Randomizer.getRandomIntInRange;

/**
 * Game "Greatest common divisor".
 * The user is shown two random numbers, for example 25 50.
 * The user must calculate and enter the greatest common divisor of these numbers.
 */
public final class GreatestCommonDivisor extends AbstractBaseGame {

    public static void run(String playerName) {
        run(GreatestCommonDivisor::task, "Find the greatest common divisor of given numbers.", playerName);
    }

    private static Task task() {
        var firstRandomNumber = getRandomIntInRange(1, MAX_VALUE);
        var secondRandomNumber = getRandomIntInRange(1, MAX_VALUE);
        var question = String.format("%d %d", firstRandomNumber, secondRandomNumber);
        var answer = findGCD(firstRandomNumber, secondRandomNumber);
        return new Task(question, String.valueOf(answer));
    }
}
