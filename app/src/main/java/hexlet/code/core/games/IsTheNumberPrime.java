package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractTrueFalseGame;
import hexlet.code.math.Prime;

/**
 * Game "Is the number prime?".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public final class IsTheNumberPrime extends AbstractTrueFalseGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void run(String playerName) {
        run(() -> task(Prime::isPrime), GAME_DESCRIPTION, playerName);
    }
}
