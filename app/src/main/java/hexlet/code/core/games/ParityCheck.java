package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractBaseGame;
import hexlet.code.core.games.base.AbstractTrueFalseGame;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer 'yes' if the number is even, or 'no' if it is odd.
 */
public final class ParityCheck extends AbstractTrueFalseGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run(String playerName) {
        AbstractBaseGame.run(() -> AbstractTrueFalseGame.task(ParityCheck::isEven), GAME_DESCRIPTION, playerName);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
