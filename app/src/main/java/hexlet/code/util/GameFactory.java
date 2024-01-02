package hexlet.code.util;

import hexlet.code.games.Calculator;
import hexlet.code.games.ParityCheck;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.base.Game;
import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.IsTheNumberPrime;

public final class GameFactory {
    private GameFactory() {
    }

    public static Game create(String userChoice) {
        if ("2".equals(userChoice)) {
            return new ParityCheck();
        }
        if ("3".equals(userChoice)) {
            return new Calculator();
        }
        if ("4".equals(userChoice)) {
            return new GreatestCommonDivisor();
        }
        if ("5".equals(userChoice)) {
            return new ArithmeticProgression();
        }
        if ("6".equals(userChoice)) {
            return new IsTheNumberPrime();
        }
        throw new IllegalStateException("Unable to create game. ");
    }
}
