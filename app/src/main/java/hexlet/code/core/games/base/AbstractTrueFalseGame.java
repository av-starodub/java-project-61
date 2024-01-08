package hexlet.code.core.games.base;

import hexlet.code.core.task.Task;

import java.util.function.Predicate;

/**
 * A general class for simple games where the player is given
 * one random number and a problem with a yes or no answer.
 */
public abstract class AbstractTrueFalseGame extends AbstractBaseGame {

    protected static Task task(Predicate<Integer> check) {
        var randomNumber = getRandomIntInDefaultRange();
        var isTrue = check.test(randomNumber);
        var question = String.valueOf(randomNumber);
        var answer = isTrue ? "yes" : "no";
        return Task.of(question, answer);
    }
}
