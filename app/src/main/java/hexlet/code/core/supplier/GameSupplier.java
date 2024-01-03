package hexlet.code.core.supplier;

import hexlet.code.core.games.base.Game;

@FunctionalInterface
public interface GameSupplier {
    Game create();
}
