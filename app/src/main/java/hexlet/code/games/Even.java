package hexlet.code.games;

import static hexlet.code.util.GameService.getRandomIntInRange;

/**
 * Game "Check for parity".
 * The essence of the game is as follows: the user is shown a random number.
 * And he needs to answer yes if the number is even, or no if it is odd.
 */
public class Even extends AbstractGame {
    private int randomNumber;

    @Override
    protected String createQuestion() {
        randomNumber = getRandomIntInRange(0, 1000);
        return String.valueOf(randomNumber);
    }

    @Override
    protected String getCorrectAnswer() {
        return isEven(randomNumber) ? "yes" : "no";
    }

    @Override
    public String getRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
