package hexlet.code.games;

import hexlet.code.games.base.AbstractBaseGame;
import hexlet.code.games.base.AbstractTrueFalseGame;

/**
 * Game "Is the number prime?".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public final class IsTheNumberPrime extends AbstractTrueFalseGame {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_DIVISOR = 3;
    private static final int START_PRIME = 5;
    private static final int STEP = 6;

    public static void run() {
        AbstractBaseGame.run(() -> AbstractTrueFalseGame.task(IsTheNumberPrime::isPrime), GAME_DESCRIPTION);
    }

    private static boolean isPrime(int number) {
        var result = number >= 1;
        var sqrt = Math.sqrt(number);
        if (number % 2 == 0 || number % MIN_DIVISOR == 0 || sqrt % 1 == 0) {
            result = false;
        }
        if (number > START_PRIME) {
            for (var divisor = START_PRIME; divisor < sqrt; divisor += STEP) {
                if (number % divisor == 0 || number % (divisor + 2) == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
