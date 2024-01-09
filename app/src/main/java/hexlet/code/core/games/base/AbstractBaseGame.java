package hexlet.code.core.games.base;

import hexlet.code.App;
import hexlet.code.core.task.Task;
import hexlet.code.engine.Engine;

import java.util.ArrayList;
import java.util.List;

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

    private static List<Task> build(TaskCreator taskCreator) {
        var tasks = new ArrayList<Task>();
        for (var idx = 0; idx < Engine.ROUNDS_DEFAULT; idx++) {
            tasks.add(taskCreator.create());
        }
        return tasks;
    }

    @FunctionalInterface
    protected interface TaskCreator {
        Task create();
    }

    protected static int getRandomIntInDefaultRange() {
        return getRandomIntInRange(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
    }

    protected static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
