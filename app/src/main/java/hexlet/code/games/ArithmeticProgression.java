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
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MAX_STEP_LENGTH = 9;

    public static void run() {
        AbstractBaseGame.run(ArithmeticProgression::task, GAME_DESCRIPTION);
    }

    private static Map.Entry<String, String> task() {
        var start = getRandomIntInDefaultRange();
        var step = getRandomIntInRange(1, MAX_STEP_LENGTH);
        var length = getRandomIntInRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        var progression = createArithmeticProgression(start, step, length);
        var missingNumberIdx = getRandomIntInRange(0, length - 1);
        var answer = progression[missingNumberIdx];
        progression[missingNumberIdx] = "..";
        var question = String.join(" ", progression);
        return new AbstractMap.SimpleEntry<>(question, answer);
    }

    private static String[] createArithmeticProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (var idx = 0; idx < length; idx++) {
            progression[idx] = String.valueOf(first + idx * step);
        }
        return progression;
    }
}
