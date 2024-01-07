package hexlet.code.core.games;

import hexlet.code.core.games.base.AbstractBaseGame;
import hexlet.code.core.task.Task;

import static hexlet.code.math.Randomizer.getRandomArithmeticProgression;
import static hexlet.code.math.Randomizer.getRandomIntInRange;

/**
 * Game "Arithmetic progression".
 * A series of numbers is presented, forming an arithmetic progression.
 * One number is replaced by two dots. The player must determine this number.
 */
public final class ArithmeticProgression extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_STEP_LENGTH = 9;

    public static void run(String playerName) {
        run(ArithmeticProgression::task, GAME_DESCRIPTION, playerName);
    }

    private static Task task() {
        int[] progression = getRandomArithmeticProgression(
                MAX_PROGRESSION_LENGTH, AbstractBaseGame.MAX_VALUE, MAX_STEP_LENGTH
        );
        var randomIdx = getRandomIntInRange(0, MAX_PROGRESSION_LENGTH - 1);
        var missingNumber = progression[randomIdx];
        var questionBuilder = new StringBuilder();
        for (int number : progression) {
            if (number == missingNumber) {
                questionBuilder.append(".. ");
            } else {
                questionBuilder.append(number).append(" ");
            }
        }
        var question = questionBuilder.substring(0, questionBuilder.length() - 1);
        var answer = String.valueOf(missingNumber);
        return new Task(question, answer);
    }
}
