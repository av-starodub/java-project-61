package hexlet.code.games;

import hexlet.code.games.base.AbstractSimpleGame;

import static hexlet.code.math.MathOperationService.isEven;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer 'yes' if the number is even, or 'no' if it is odd.
 */
public final class ParityCheck extends AbstractSimpleGame {
    @Override
    protected boolean check(int randomNumber) {
        return isEven(randomNumber);
    }

    @Override
    protected String rules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
}
