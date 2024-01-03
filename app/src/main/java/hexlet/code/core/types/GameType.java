package hexlet.code.core.types;

import hexlet.code.core.games.ArithmeticProgression;
import hexlet.code.core.games.Calculator;
import hexlet.code.core.games.GreatestCommonDivisor;
import hexlet.code.core.games.ParityCheck;
import hexlet.code.core.games.IsTheNumberPrime;
import hexlet.code.core.supplier.GameSupplier;

public enum GameType {
    EVEN(2, "Even") {
        @Override
        public GameSupplier getGameSupplier() {
            return ParityCheck::new;
        }
    },
    CALC(3, "Calc") {
        @Override
        public GameSupplier getGameSupplier() {
            return Calculator::new;
        }
    },
    GCD(4, "GCD") {
        @Override
        public GameSupplier getGameSupplier() {
            return GreatestCommonDivisor::new;
        }
    },
    PROGRESSION(5, "Progression") {
        @Override
        public GameSupplier getGameSupplier() {
            return ArithmeticProgression::new;
        }
    },
    PRIME(6, "Prime") {
        @Override
        public GameSupplier getGameSupplier() {
            return IsTheNumberPrime::new;
        }
    };

    private final int oderNumber;
    private final String gameName;

    GameType(int menuNumber, String menuTitle) {
        oderNumber = menuNumber;
        gameName = menuTitle;
    }

    public int getMenuNumber() {
        return oderNumber;
    }

    public String getTitle() {
        return gameName;
    }

    public abstract GameSupplier getGameSupplier();
}
