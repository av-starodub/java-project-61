package hexlet.code.games;

import hexlet.code.games.base.AbstractSimpleGame;

import static hexlet.code.math.MathOperationService.isPrime;

/**
 * Game "Is the number prime?".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public final class IsTheNumberPrime extends AbstractSimpleGame {

    @Override
    protected boolean check(int randomNumber) {
        return isPrime(randomNumber);
    }

    @Override
    protected String rules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
}
