package hexlet.code.factory;

import hexlet.code.supplier.GameSupplier;
import hexlet.code.types.GameType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class GameSupplierFactory {
    private final Map<String, GameSupplier> factory;

    public GameSupplierFactory() {
        factory = new HashMap<>();
        Arrays.stream(GameType.values())
                .forEach(gameType -> factory.put(String.valueOf(gameType.getMenuNumber()), gameType.getGameSupplier()));
    }

    public GameSupplier getGameSupplier(String userChoice) {
        return factory.get(userChoice);
    }
}
