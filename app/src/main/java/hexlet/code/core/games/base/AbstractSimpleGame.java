package hexlet.code.core.games.base;

import hexlet.code.math.operations.CheckOperationType;
import hexlet.code.core.task.Task;

import static hexlet.code.math.random.Randomizer.getRandomIntInRange;

/**
 * A general class for simple games where the player is given
 * one random number and a problem with a yes or no answer.
 */
public abstract class AbstractSimpleGame extends AbstractGame {

    protected AbstractSimpleGame(CheckOperationType checkOperation) {
        super(creatTask(checkOperation));
    }

    private static Task creatTask(CheckOperationType checkOperation) {
        var randomNumber = getRandomIntInRange(0, MAX_VALUE);
        var isTrue = checkOperation.check(randomNumber);
        var question = String.valueOf(randomNumber);
        var answer = isTrue ? "yes" : "no";
        return new Task(question, answer);
    }
}
