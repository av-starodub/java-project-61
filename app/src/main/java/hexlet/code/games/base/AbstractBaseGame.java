package hexlet.code.games.base;

import hexlet.code.engine.Engine;
import hexlet.code.ulil.MathRandomUtils;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * A general class for all games.
 */
public abstract class AbstractBaseGame {
    /**
     * Default min integer value for task questions.
     */
    private static final int DEFAULT_MIN_VALUE = 1;
    /**
     * Default max integer value for task questions.
     */
    private static final int DEFAULT_MAX_VALUE = 100;

    /**
     * Template method for launching a game.
     *
     * @param taskCreator     task generator.
     * @param gameDescription game rules.
     */
    protected static void run(TaskCreator taskCreator, String gameDescription) {
        var tasks = build(taskCreator);
        Engine.play(tasks, gameDescription);
    }

    private static Map<String, String> build(TaskCreator taskCreator) {
        var tasks = new HashMap<String, String>();
        for (var idx = 0; idx < Engine.ROUNDS_DEFAULT; idx++) {
            var task = taskCreator.create();
            var question = task.getKey();
            if (tasks.containsKey(question)) {
                idx--;
                continue;
            }
            tasks.put(question, task.getValue());
        }
        return tasks;
    }


    @FunctionalInterface
    protected interface TaskCreator {
        Map.Entry<String, String> create();
    }

    /**
     * Template method for simple games where the player is given
     * one random number and a problem with a yes or no answer.
     *
     * @param check answer generator.
     * @return Map where the key is the question and the value is the correct answer.
     */
    protected static Map.Entry<String, String> task(Predicate<Integer> check) {
        var randomNumber = getRandomIntInDefaultRange();
        var isTrue = check.test(randomNumber);
        var question = String.valueOf(randomNumber);
        var answer = isTrue ? "yes" : "no";
        return new AbstractMap.SimpleEntry<>(question, answer);
    }

    protected static int getRandomIntInDefaultRange() {
        return MathRandomUtils.getRandomIntInRange(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
    }
}
