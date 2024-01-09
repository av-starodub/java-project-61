package hexlet.code.games;

import hexlet.code.games.base.AbstractBaseGame;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Game "Arithmetic progression".
 * A series of numbers is presented, forming an arithmetic progression.
 * One number is replaced by two dots. The player must determine this number.
 */
public final class ArithmeticProgression extends AbstractBaseGame {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_STEP_LENGTH = 9;

    public static void run() {
        AbstractBaseGame.run(ArithmeticProgression::task, GAME_DESCRIPTION);
    }

    private static Map.Entry<String, String> task() {
        int[] progression = getRandomArithmeticProgression();
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
        return new AbstractMap.SimpleEntry<>(question, answer);
    }

    private static int[] getRandomArithmeticProgression() {
        int[] progression = new int[MAX_PROGRESSION_LENGTH];
        int step = getRandomIntInRange(1, MAX_STEP_LENGTH);
        int next = getRandomIntInDefaultRange();
        for (var idx = 0; idx < MAX_PROGRESSION_LENGTH; idx++) {
            progression[idx] = next;
            next += step;
        }
        return progression;
    }

}
