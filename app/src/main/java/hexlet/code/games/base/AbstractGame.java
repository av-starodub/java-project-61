package hexlet.code.games.base;

import hexlet.code.App;
import hexlet.code.engine.Engine;
import hexlet.code.task.Task;

import java.util.ArrayList;

/**
 * A general class for games.
 * Adding a new game:
 * after implementing this abstraction, add a new game to the GameType enum,
 * which is used by GameMenuProvider and GameSupplierProvider.
 */
public abstract class AbstractGame {
    public static final int MAX_VALUE = 100;

    protected static void run(TaskProducer taskProducer, String rules) {
        var tasks = new ArrayList<Task>();
        for (var idx = 0; idx < App.TOTAL_ROUNDS; idx++) {
            tasks.add(taskProducer.produce());
        }
        Engine.play(tasks, rules);
    }

    @FunctionalInterface
    protected interface TaskProducer {
        Task produce();
    }
}
