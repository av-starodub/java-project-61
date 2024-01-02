package hexlet.code.factory;

import hexlet.code.games.base.Game;
import hexlet.code.supplier.GameSupplier;
import hexlet.code.types.GameType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class GameFactory {
    private final Map<String, GameSupplier> factory;

    public GameFactory() {
        factory = new HashMap<>();
        Arrays.stream(GameType.values())
                .forEach(gameType -> factory.put(String.valueOf(gameType.getMenuNumber()), gameType.getGameSupplier()));
    }

    public Game create(String userChoice) {
        var gs = factory.get(userChoice);
        if (Objects.nonNull(gs)) {
            return gs.create();
        }
        return null;
    }
}
