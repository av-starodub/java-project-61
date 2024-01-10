package hexlet.code.ulil;

public final class MathRandomUtils {
    private MathRandomUtils() {
    }

    public static int getRandomIntInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
