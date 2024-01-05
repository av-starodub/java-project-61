package hexlet.code.games.base;

import hexlet.code.task.Task;

import java.util.function.Predicate;

import static hexlet.code.math.random.Randomizer.getRandomIntInRange;

/**
 * A general class for simple games where the player is given
 * one random number and a problem with a yes or no answer.
 */
public abstract class AbstractSimpleGame extends AbstractGame {

    protected static Task task(Predicate<Integer> check) {
        var randomNumber = getRandomIntInRange(0, MAX_VALUE);
        var isTrue = check.test(randomNumber);
        var question = String.valueOf(randomNumber);
        var answer = isTrue ? "yes" : "no";
        return new Task(question, answer);
    }

}
