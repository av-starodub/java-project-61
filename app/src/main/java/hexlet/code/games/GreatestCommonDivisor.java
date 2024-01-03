package hexlet.code.games;

import hexlet.code.games.base.AbstractGame;

import static hexlet.code.math.operations.GCD.findGCD;
import static hexlet.code.math.random.Randomizer.getRandomIntInRange;

/**
 * Game "Greatest common divisor".
 * The user is shown two random numbers, for example 25 50.
 * The user must calculate and enter the greatest common divisor of these numbers.
 */
public final class GreatestCommonDivisor extends AbstractGame {
    private int firstRandomNumber;
    private int secondRandomNumber;

    @Override
    protected String rules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected String createQuestion() {
        firstRandomNumber = getRandomIntInRange(1, MAX_VALUE);
        secondRandomNumber = getRandomIntInRange(1, MAX_VALUE);
        return String.format("%d %d", firstRandomNumber, secondRandomNumber);
    }

    @Override
    protected String getCorrectAnswer() {
        return String.valueOf(findGCD(firstRandomNumber, secondRandomNumber));
    }
}
