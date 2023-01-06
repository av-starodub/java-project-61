package hexlet.code.games;

import static hexlet.code.util.GameService.findGCD;
import static hexlet.code.util.GameService.getRandomIntInRange;

/**
 * Game "GCD" (the greatest common divisor).
 * The user is shown two random numbers, for example 25 50.
 * The user must calculate and enter the greatest common divisor of these numbers.
 */
public class GCD extends AbstractGame {
    private int firstRandomNumber;
    private int secondRandomNumber;
    @Override
    public String getRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected String createQuestion() {
        firstRandomNumber = getRandomIntInRange(1, 100);
        secondRandomNumber = getRandomIntInRange(1, 100);
        return String.format("%d %d", firstRandomNumber, secondRandomNumber);
    }

    @Override
    protected String getCorrectAnswer() {
        return String.valueOf(findGCD(firstRandomNumber, secondRandomNumber));
    }
}
