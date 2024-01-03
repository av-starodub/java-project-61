package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractSimpleGame;
import hexlet.code.math.operations.CheckOperationType;

/**
 * Game "Is the number prime?".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public final class IsTheNumberPrime extends AbstractSimpleGame {

    public IsTheNumberPrime() {
        super(CheckOperationType.IS_PRIME);
    }

    @Override
    protected String rules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
}
