package hexlet.code.core.games.base;

import hexlet.code.App;
import hexlet.code.core.task.Task;
import hexlet.code.engine.Engine;

import java.util.ArrayList;

/**
 * A general class for games.
 */
public abstract class AbstractBaseGame {
    public static final int MAX_VALUE = 100;

    protected static void run(TaskCreator taskCreator, String gameDescription, String playerName) {
        var tasks = new ArrayList<Task>();
        for (var idx = 0; idx < App.ROUNDS_DEFAULT; idx++) {
            tasks.add(taskCreator.create());
        }
        Engine.play(tasks, gameDescription, playerName);
    }

    @FunctionalInterface
    protected interface TaskCreator {
        Task create();
    }

    protected static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
