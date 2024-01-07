package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractTrueFalseGame;
import hexlet.code.math.Prime;

/**
 * Game "Is the number prime?".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public final class IsTheNumberPrime extends AbstractTrueFalseGame {

    public static void run() {
        run(() -> task(Prime::isPrime), "Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
}
