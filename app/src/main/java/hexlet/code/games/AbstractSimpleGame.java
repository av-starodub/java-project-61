package hexlet.code.games;

import static hexlet.code.util.MathOperationService.getRandomIntInRange;

/**
 * A general class for simple games where the player is given
 * one random number and a problem with a yes or no answer.
 */
public abstract class AbstractSimpleGame extends AbstractGame {
    private int randomNumber;

    @Override
    protected String createQuestion() {
        randomNumber = getRandomIntInRange(0, 100);
        return String.valueOf(randomNumber);
    }

    @Override
    protected String getCorrectAnswer() {
        return check(randomNumber) ? "yes" : "no";
    }

    protected abstract boolean check(int number);
}
