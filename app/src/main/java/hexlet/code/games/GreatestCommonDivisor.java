package hexlet.code.games;

import hexlet.code.games.base.AbstractGame;
import hexlet.code.task.Task;

import static hexlet.code.math.operations.GCD.findGCD;
import static hexlet.code.math.random.Randomizer.getRandomIntInRange;

/**
 * Game "Greatest common divisor".
 * The user is shown two random numbers, for example 25 50.
 * The user must calculate and enter the greatest common divisor of these numbers.
 */
public final class GreatestCommonDivisor extends AbstractGame {

    public GreatestCommonDivisor() {
        super(createTask());
    }

    private static Task createTask() {
        var firstRandomNumber = getRandomIntInRange(1, MAX_VALUE);
        var secondRandomNumber = getRandomIntInRange(1, MAX_VALUE);
        var question = String.format("%d %d", firstRandomNumber, secondRandomNumber);
        var answer = findGCD(firstRandomNumber, secondRandomNumber);
        return new Task(question, String.valueOf(answer));
    }

    @Override
    protected String rules() {
        return "Find the greatest common divisor of given numbers.";
    }
}
