package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractTrueFalseGame;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer 'yes' if the number is even, or 'no' if it is odd.
 */
public final class ParityCheck extends AbstractTrueFalseGame {

    public static void run(String playerName) {
        run(() -> task(number -> number % 2 == 0),
                "Answer 'yes' if the number is even, otherwise answer 'no'.",
                playerName
        );
    }
}
