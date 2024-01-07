package hexlet.code.math;

public final class Randomizer {
    private Randomizer() {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int[] getRandomArithmeticProgression(int length, int maxValue, int maxStepLength) {
        int[] progression = new int[length];
        int step = getRandomIntInRange(1, maxStepLength);
        int next = getRandomIntInRange(1, maxValue);
        for (var idx = 0; idx < length; idx++) {
            progression[idx] = next;
            next += step;
        }
        return progression;
    }
}
