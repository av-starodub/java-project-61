package hexlet.code.games;

import hexlet.code.games.base.AbstractSimpleGame;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer 'yes' if the number is even, or 'no' if it is odd.
 */
public final class ParityCheck extends AbstractSimpleGame {

    public static void run() {
        run(() -> task(number -> number % 2 == 0), "Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
}
