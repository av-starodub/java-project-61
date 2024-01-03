package hexlet.code.math.operations;

import java.math.BigInteger;

public enum CheckOperationType {
    IS_EVEN {
        @Override
        public boolean check(int number) {
            return number % 2 == 0;
        }
    },
    IS_PRIME {
        @Override
        public boolean check(int number) {
            return BigInteger.valueOf(number).isProbablePrime((int) Math.log(number));
        }
    };

    public abstract boolean check(int number);
}
