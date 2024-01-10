package hexlet.code.games;

import hexlet.code.games.base.AbstractBaseGame;

/**
 * Game "Is the number prime?".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public final class IsTheNumberPrime extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_DIVISOR = 3;
    private static final int START_PRIME = 5;
    private static final int STEP = 6;

    public static void run() {
        AbstractBaseGame.run(() -> AbstractBaseGame.task(IsTheNumberPrime::isPrime), GAME_DESCRIPTION);
    }

    private static boolean isPrime(int number) {
        if (number < 1) {
            return false;
        }
        if (number % 2 == 0 || number % MIN_DIVISOR == 0) {
            return false;
        }
        var sqrt = Math.sqrt(number);
        if (sqrt != 1 && sqrt % 1 == 0) {
            return false;
        }
        if (number > START_PRIME) {
            for (var divisor = START_PRIME; divisor < sqrt; divisor += STEP) {
                if (number % divisor == 0 || number % (divisor + 2) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
