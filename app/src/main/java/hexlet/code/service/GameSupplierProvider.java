package hexlet.code.service;

import hexlet.code.core.supplier.GameSupplier;
import hexlet.code.core.types.GameType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class GameSupplierProvider {
    private final Map<String, GameSupplier> gameSuppliers;

    public GameSupplierProvider() {
        gameSuppliers = new HashMap<>();
        Arrays.stream(GameType.values()).forEach(gameType ->
                gameSuppliers.put(String.valueOf(gameType.getMenuNumber()), gameType.getGameSupplier()
                )
        );
    }

    public GameSupplier getGameSupplier(String userChoice) {
        return gameSuppliers.get(userChoice);
    }
}
