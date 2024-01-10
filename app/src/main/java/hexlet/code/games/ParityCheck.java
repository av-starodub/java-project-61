package hexlet.code.games;

import hexlet.code.games.base.AbstractBaseGame;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer 'yes' if the number is even, or 'no' if it is odd.
 */
public final class ParityCheck extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        AbstractBaseGame.run(() -> AbstractBaseGame.task(ParityCheck::isEven), GAME_DESCRIPTION);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
