package hexlet.code.games;

import static hexlet.code.util.MathOperationService.getRandomIntInRange;
import static hexlet.code.util.MathOperationService.isPrime;

/**
 * Game "Is it a prime number".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is prime, or no.
 */
public class Prime extends AbstractGame {
    private int randomNumber;

    @Override
    protected String createQuestion() {
        randomNumber = getRandomIntInRange(0, 100);
        return String.valueOf(randomNumber);
    }

    @Override
    protected String getCorrectAnswer() {
        return isPrime(randomNumber) ? "yes" : "no";
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
}
