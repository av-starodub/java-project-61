package hexlet.code.types;

import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.Calculator;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.ParityCheck;
import hexlet.code.games.IsTheNumberPrime;
import hexlet.code.supplier.GameSupplier;

public enum GameType {
    EVEN(2, "Even", ParityCheck::new),
    CALC(3, "Calc", Calculator::new),
    GCD(4, "GCD", GreatestCommonDivisor::new),
    PROGRESSION(5, "Progression", ArithmeticProgression::new),
    PRIME(6, "Prime", IsTheNumberPrime::new);

    private final int menuNumber;
    private final String title;
    private final GameSupplier gameSupplier;

    GameType(int menuNumber, String title, GameSupplier gameSupplier) {
        this.menuNumber = menuNumber;
        this.title = title;
        this.gameSupplier = gameSupplier;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public String getTitle() {
        return title;
    }

    public GameSupplier getGameSupplier() {
        return gameSupplier;
    }
}
