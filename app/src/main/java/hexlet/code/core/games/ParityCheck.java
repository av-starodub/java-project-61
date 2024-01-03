package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractSimpleGame;
import hexlet.code.math.operations.CheckOperationType;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer 'yes' if the number is even, or 'no' if it is odd.
 */
public final class ParityCheck extends AbstractSimpleGame {
    public ParityCheck() {
        super(CheckOperationType.IS_EVEN);
    }

    @Override
    protected String rules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
}
