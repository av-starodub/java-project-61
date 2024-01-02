package hexlet.code.games;

import hexlet.code.games.base.AbstractSimpleGame;

import static hexlet.code.util.MathOperationService.isPrime;

/**
 * Game "Is it a prime number".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public final class Prime extends AbstractSimpleGame {

    @Override
    protected boolean check(int randomNumber) {
        return isPrime(randomNumber);
    }

    @Override
    protected String rules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
}
