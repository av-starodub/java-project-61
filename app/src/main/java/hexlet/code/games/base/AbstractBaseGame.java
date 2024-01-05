package hexlet.code.games.base;

import hexlet.code.App;
import hexlet.code.engine.Engine;
import hexlet.code.task.Task;

import java.util.ArrayList;

/**
 * A general class for games.
 */
public abstract class AbstractBaseGame {
    public static final int MAX_VALUE = 100;

    protected static void run(TaskCreator taskCreator, String rules) {
        var tasks = new ArrayList<Task>();
        for (var idx = 0; idx < App.ROUNDS_DEFAULT; idx++) {
            tasks.add(taskCreator.create());
        }
        Engine.play(tasks, rules);
    }

    @FunctionalInterface
    protected interface TaskCreator {
        Task create();
    }
}
