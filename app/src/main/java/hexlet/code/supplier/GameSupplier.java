package hexlet.code.supplier;

import hexlet.code.games.base.Game;

@FunctionalInterface
public interface GameSupplier {
    Game create();
}
