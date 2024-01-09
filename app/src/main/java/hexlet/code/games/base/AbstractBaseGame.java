package hexlet.code.games.base;

import hexlet.code.engine.Engine;

import java.util.HashMap;
import java.util.Map;

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

    protected static int getRandomIntInDefaultRange() {
        return getRandomIntInRange(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
    }

    protected static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
