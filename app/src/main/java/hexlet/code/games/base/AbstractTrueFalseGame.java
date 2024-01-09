package hexlet.code.games.base;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * A general class for simple games where the player is given
 * one random number and a problem with a yes or no answer.
 */
public abstract class AbstractTrueFalseGame extends AbstractBaseGame {

    protected static Map.Entry<String, String> task(Predicate<Integer> check) {
        var randomNumber = getRandomIntInDefaultRange();
        var isTrue = check.test(randomNumber);
        var question = String.valueOf(randomNumber);
        var answer = isTrue ? "yes" : "no";
        return new AbstractMap.SimpleEntry<>(question, answer);
    }
}
