package hexlet.code.games;

import hexlet.code.games.base.AbstractGame;

import static hexlet.code.math.random.Randomizer.getRandomArithmeticProgression;
import static hexlet.code.math.random.Randomizer.getRandomIntInRange;

/**
 * Game "Arithmetic progression".
 * A series of numbers is presented, forming an arithmetic progression.
 * One number is replaced by two dots. The player must determine this number.
 */
public final class ArithmeticProgression extends AbstractGame {
    private static final int MAX_PROGRESSION_LENGTH = 10;
    public static final int MAX_STEP_LENGTH = 9;
    private int missingNumber;

    @Override
    protected String createQuestion() {
        int[] progression = getRandomArithmeticProgression(
                MAX_PROGRESSION_LENGTH, AbstractGame.MAX_VALUE, MAX_STEP_LENGTH
        );
        var randomIdx = getRandomIntInRange(0, MAX_PROGRESSION_LENGTH - 1);
        missingNumber = progression[randomIdx];
        var question = new StringBuilder();
        for (int number : progression) {
            if (number == missingNumber) {
                question.append(".. ");
            } else {
                question.append(number).append(" ");
            }
        }
        return question.substring(0, question.length() - 1);
    }

    @Override
    protected String getCorrectAnswer() {
        return String.valueOf(missingNumber);
    }

    @Override
    protected String rules() {
        return "What number is missing in the progression?";
    }
}
