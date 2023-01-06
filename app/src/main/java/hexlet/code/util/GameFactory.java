package hexlet.code.util;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Game;

public final class GameFactory {
    private GameFactory() {
    }

    public static Game create(String userChoice) {
        if ("2".equals(userChoice)) {
            return new Even();
        }
        if ("3".equals(userChoice)) {
            return new Calculator();
        }
        if ("4".equals(userChoice)) {
            return new GCD();
        }
        throw new IllegalStateException("Unable to create game. ");
    }
}
