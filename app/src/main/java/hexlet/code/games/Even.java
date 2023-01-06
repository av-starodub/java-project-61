package hexlet.code.games;

import static hexlet.code.util.MathOperationService.isEven;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is even, or no if it is odd.
 */
public class Even extends AbstractSimpleGame {
    @Override
    protected boolean check(int randomNumber) {
        return isEven(randomNumber);
    }

    @Override
    protected String rules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
}
