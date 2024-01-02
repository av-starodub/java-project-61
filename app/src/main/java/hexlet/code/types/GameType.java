package hexlet.code.types;

import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.Calculator;
import hexlet.code.games.GreatestCommonDivisor;
import hexlet.code.games.ParityCheck;
import hexlet.code.games.IsTheNumberPrime;
import hexlet.code.supplier.GameSupplier;

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

    private final int menuNumber;
    private final String title;

    GameType(int menuNumber, String title) {
        this.menuNumber = menuNumber;
        this.title = title;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public String getTitle() {
        return title;
    }

    public abstract GameSupplier getGameSupplier();
}
